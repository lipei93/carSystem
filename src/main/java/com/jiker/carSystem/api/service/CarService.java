package com.jiker.carSystem.api.service;

import com.jiker.carSystem.api.pojo.Car;

import java.util.List;

public interface CarService {

	List<Car> findAll();

	Car findById(int id);

	List<Car> findByCarName(String carName);

	void deleteById(int id);

	void updateById(Car car);

	void insertCar(Car car);

	Boolean buyCar(String carName,String carType,String carSeries,int count);

	List<Car> findByCarNamePage(String carName, int begin, int end);

}
