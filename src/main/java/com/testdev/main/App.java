package com.testdev.main;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.testdev.dao.CarDao;
import com.testdev.dao.EmployeeDao;
import com.testdev.dao.ICarDao;
import com.testdev.dao.IEmployeeDao;
import com.testdev.domain.Car;
import com.testdev.domain.Employee;

public class App {
	public static void main(String[] args) throws Exception {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
				.build(inputStream);

		IEmployeeDao employeeDao = new EmployeeDao(sqlSessionFactory);
		ICarDao carDao = new CarDao(sqlSessionFactory);

		Employee employee = employeeDao.getEmployeeById(21L);
		employeeDao.deleteEmployee(employee);

		List<Employee> employees = employeeDao.getEmployees();
		for (Employee emp : employees) {
			System.out.println(emp.getEmployeeId());
		}

		System.out.println("Cars:");
		List<Car> cars = carDao.getCars();
		for (Car car : cars) {
			System.out.println("car: " + car.getBrandName() + " "
					+ car.getModel() + " of "
					+ car.getEmployee().getFirstName() + " "
					+ car.getEmployee().getLastName());
		}
	}
}
