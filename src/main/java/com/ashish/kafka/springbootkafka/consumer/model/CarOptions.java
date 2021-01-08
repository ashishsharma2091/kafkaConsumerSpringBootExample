package com.ashish.kafka.springbootkafka.consumer.model;

import java.util.ArrayList;
import java.util.List;

public class CarOptions {
List<Car> caroptionList=new ArrayList<Car>();

public CarOptions() {};


@Override
public String toString() {
	return "CarOptions [caroptionList=" + caroptionList + "]";
}

public List<Car> getCaroptionList() {
	return caroptionList;
}

public void setCaroptionList(List<Car> caroptionList) {
	this.caroptionList = caroptionList;
}
}
