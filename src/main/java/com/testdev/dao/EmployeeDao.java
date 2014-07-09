package com.testdev.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.testdev.domain.Employee;

public class EmployeeDao implements IEmployeeDao {

    private SqlSessionFactory sqlSessionFactory;

    public EmployeeDao(SqlSessionFactory sqlSessionFactory) {
        super();
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public List<Employee> getEmployees() {
        List<Employee> employees = null;
        try (SqlSession session = sqlSessionFactory.openSession();) {
            Map<String, Object> params = new HashMap<>();
            RowBounds rowBounds = new RowBounds(0, 1000);
            employees = session
                    .selectList(
                            "com.testdev.dao.EmployeeMapper.selectEmployeesWithCarsAndCompanies",
                            params, rowBounds);
        }
        return employees;
    }

    @Override
    public Employee getEmployeeById(Long employeeId) {
        Employee employee = null;
        try (SqlSession session = sqlSessionFactory.openSession();) {
            Map<String, Object> params = new HashMap<>();
            params.put("id", employeeId);
            employee = session.selectOne(
                    "com.testdev.dao.EmployeeMapper.selectEmployee", params);
        }
        return employee;
    }

    @Override
    public Employee addEmployee(Employee employeeToAdd) {
        try (SqlSession session = sqlSessionFactory.openSession();) {
            session.insert("com.testdev.dao.EmployeeMapper.insertEmployee",
                    employeeToAdd);
            session.commit();
        }
        return employeeToAdd;
    }

    @Override
    public boolean updateEmployee(Employee employeeToUpdate) {
        try (SqlSession session = sqlSessionFactory.openSession();) {
            session.update("com.testdev.dao.EmployeeMapper.updateEmployee",
                    employeeToUpdate);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteEmployee(Employee employeeToDelete) {
        try (SqlSession session = sqlSessionFactory.openSession();) {
            session.update("com.testdev.dao.EmployeeMapper.deleteEmployee",
                    employeeToDelete);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
