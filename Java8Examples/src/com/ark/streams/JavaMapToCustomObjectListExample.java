package com.ark.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JavaMapToCustomObjectListExample {
	public static void main(String[] args) {
		List<Car> cars = CarFactory.getNCars(100);
		// Now I want to create Map using carName as Key and Engine as the value
		Map<String, Engine> map = cars.stream().collect(Collectors.toMap(Car::getCarName, Car::getEngine));
		// Get List of Engines from the cars
		List<Engine> engines = cars.stream().map(c -> c.getEngine()).collect(Collectors.toList());
		// To get sum of price of all cars in the list
		double sum = cars.stream().mapToDouble(Car::getPrice).sum();
		// How to convert map to List
		List<String> carNames = new ArrayList<>(map.keySet()); // Prior to Java 8
		List<Engine> carEngines = new ArrayList<>(map.values()); // Prior to Java 8
		// To convert list fo specific Engines
		List<Engine> hifiEngines = map.values().stream().filter(e -> e.getEngineName().equals("Hifi"))
				.collect(Collectors.toList());
		//Use of limit, suppose you want only first 3 records
		List<Car> first3Engines = cars.stream().limit(3).collect(Collectors.toList());
		//To get the count of particular cars
		long totalMarutiCars = cars.stream().filter(c -> c.getCarName().equals("Maruti")).count();
				
		
	}
}

class CarFactory {
	private static Engine[] engines = { new Engine("Hifi", "0.1"), new Engine("wifi", "0.1"), new Engine("Hifi", "0.1"),
			new Engine("tifi", "0.1"), new Engine("hifi", "0.2"), new Engine("hifi", "0.3") };

	public static List<Car> getNCars(int n) {
		List<Car> cars = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (i % 2 == 0) {
				cars.add(new Car("Mercedez" + i, 2.5f, engines[2]));
			} else if (i % 5 == 0) {
				cars.add(new Car("Mercedez" + i, 2.9f, engines[5]));
			} else if (i % 5 == 0) {
				cars.add(new Car("Toyota" + i, 3.6f, engines[1]));
			} else {
				cars.add(new Car("Maruti" + i, 3.6f, engines[0]));
			}
		}
		return cars;
	}
}

class Car {
	private String carName;
	private double price;
	private Engine engine;

	public Car(String carName, double price, Engine engine) {
		super();
		this.carName = carName;
		this.price = price;
		this.engine = engine;
	}

	public String getCarName() {
		return carName;
	}

	public double getPrice() {
		return price;
	}

	public Engine getEngine() {
		return engine;
	}

}

class Engine {
	private String engineName;
	private String engineVersion;

	public Engine(String engineName, String engineVersion) {
		super();
		this.engineName = engineName;
		this.engineVersion = engineVersion;
	}

	public String getEngineName() {
		return engineName;
	}

	public String getEngineVersion() {
		return engineVersion;
	}

}