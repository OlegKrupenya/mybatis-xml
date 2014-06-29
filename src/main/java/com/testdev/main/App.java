package com.testdev.main;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.testdev.dao.EmployeeDao;
import com.testdev.dao.IEmployeeDao;
import com.testdev.domain.Employee;

public class App {
    public static void main(String[] args) throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
                .build(inputStream);

        IEmployeeDao dao = new EmployeeDao(sqlSessionFactory);

        Employee employee = dao.getEmployeeById(21L);
        dao.deleteEmployee(employee);
        
        List<Employee> employees = dao.getEmployees();
        for (Employee emp : employees) {
            System.out.println(emp.getEmployeeId());
        }
    }
}
