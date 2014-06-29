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
        SqlSession session = sqlSessionFactory.openSession();
        try {
            employees = session
                    .selectList("com.testdev.dao.EmployeeMapper.selectEmployees");
        } finally {
            session.close();
        }
        return employees;
    }

    @Override
    public Employee getEmployeeById(Long employeeId) {
        Employee employee = null;
        SqlSession session = sqlSessionFactory.openSession();
        try {
            employee = session
                    .selectOne("com.testdev.dao.EmployeeMapper.selectEmployee",
                            employeeId);
        } finally {
            session.close();
        }
        return employee;
    }

    @Override
    public Employee addEmployee(Employee employeeToAdd) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.insert("com.testdev.dao.EmployeeMapper.insertEmployee",
                    employeeToAdd);
            session.commit();
        } finally {
            session.close();
        }
        return employeeToAdd;
    }

    @Override
    public boolean updateEmployee(Employee employeeToUpdate) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.update("com.testdev.dao.EmployeeMapper.updateEmployee",
                    employeeToUpdate);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
        return true;
    }

    @Override
    public boolean deleteEmployee(Employee employeeToDelete) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.update("com.testdev.dao.EmployeeMapper.deleteEmployee",
                    employeeToDelete);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
        return true;
    }

}
