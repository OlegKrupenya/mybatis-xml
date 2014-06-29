package com.testdev.dao;

import java.util.List;

import com.testdev.domain.Car;

public interface ICarDao {
	public List<Car> getCars();
	public Car getCarById(Long carId);
}
