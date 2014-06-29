package com.testdev.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.testdev.domain.Car;

public class CarDao implements ICarDao {

	private SqlSessionFactory sqlSessionFactory;

	public CarDao(SqlSessionFactory sqlSessionFactory) {
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
	public List<Car> getCars() {
		List<Car> cars = null;
        try (SqlSession session = sqlSessionFactory.openSession();) {
        	cars = session
                    .selectList("com.testdev.dao.CarMapper.selectCars");
        }
        return cars;
	}

}
