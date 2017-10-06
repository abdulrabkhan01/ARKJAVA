package com.ark.predicate;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.*;

public class PredicateExample {
public static void main(String[] args) {
	List<Apple> apples = AppleHelper.getAllApples(10);
	List<Apple> redApples = apples.stream().filter(a -> a.getColor().equalsIgnoreCase("Red")).collect(Collectors.toList());
	double totalPriceOfApples = apples.stream().mapToDouble(a -> a.getPrice()).sum();
	
}
}
class AppleHelper {
	public static List<Apple> getAllApples(int n) {
		List<Apple> apples = new ArrayList<>(n);
		for(int i=0;i<n;i++) {
			Random r = new Random();
			double price = r.nextDouble();
			double weight = r.nextInt(100);
			String color ="Red";
			if ( i%2==0) {
				color ="Green";
			}
			apples.add(new Apple(color, weight, price));
		}
		return apples;
	}
}
class Apple {
	
	private String color;
	private double weight;
	private double price;
	public Apple(String color, double weight, double price) {
		super();
		this.color = color;
		this.weight = weight;
		this.price = price;
	}
	public String getColor() {
		return color;
	}
	public double getWeight() {
		return weight;
	}
	public double getPrice() {
		return price;
	}
	
	
}