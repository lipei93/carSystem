package com.jiker.carSystem.api.service.impl;

import com.jiker.carSystem.api.dao.CarDao;
import com.jiker.carSystem.api.pojo.Car;
import com.jiker.carSystem.api.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("carService")
public class CarServiceImpl implements CarService {

	@Autowired
	private CarDao carDao;

	@Override
	public List<Car> findAll() {
		return carDao.findAll();
	}

	@Override
	public Car findById(int id) {
		return carDao.findById(id);
	}

	@Override
	public List<Car> findByCarName(String carName) {
		return carDao.findByCarName(carName);
	}

	@Override
	public void deleteById(int id) {
		carDao.deleteById(id);
	}

	@Override
	public void updateById(Car car) {
		carDao.updateById(car);
	}

	@Override
	public void insertCar(Car car) {
		carDao.insertCar(car);
	}

	@Override
	public Boolean buyCar(String carName,String carType,String carSeries,int count){
		List<Car> cars1 = carDao.findCountByCar(carName,carType,carSeries);
		if (cars1.size()<count){
			return false;
		}else {
			for (int i = 0; i <count ; i++) {
				carDao.deleteById(cars1.get(i).getId());
			}
		}
		return true;
	}

	@Override
	public  List<Car> findByCarNamePage(String carName,int start, int end){
		return carDao.findByCarNamePage(carName,start-1,end-start+1);
	}

}
