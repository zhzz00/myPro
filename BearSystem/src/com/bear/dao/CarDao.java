package com.bear.dao;

import java.util.List;
import java.util.Map;

import com.bear.entity.CarStock;

public interface CarDao {

	List<CarStock> queryCarList(Map<String, Object> qm);

	int queryCarListCount(Map<String, Object> qm);

	void insertCar(CarStock car);

	int queryCarNoExists(String carNo);

	CarStock queryCarDetail(Integer id);


}
