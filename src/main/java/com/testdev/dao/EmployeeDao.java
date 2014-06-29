package com.testdev.dao;

import java.util.List;

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
            employees = session
                    .selectList("com.testdev.dao.EmployeeMapper.selectEmployeesWithCars");
        }
        return employees;
    }

    @Override
    public Employee getEmployeeById(Long employeeId) {
        Employee employee = null;
        try (SqlSession session = sqlSessionFactory.openSession();) {
            employee = session
                    .selectOne("com.testdev.dao.EmployeeMapper.selectEmployee",
                            employeeId);
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
