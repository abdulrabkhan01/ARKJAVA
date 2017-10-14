package com.ark.streams;

import java.util.ArrayList;
import java.util.List;

public class ParallelStreamTest {

	private static List<Integer> listInteger = new ArrayList<>();
	static {
		for (int i = 1; i < 100000; i++) {
			listInteger.add(i);
		}
	}
	
	public static void main(String[] args) {
		int sumUsingSingleStream = getIntSumSingleStream();
		int sumUsingParallelStream = getIntSumParallelStream();
		System.out.println(sumUsingParallelStream + "  "+sumUsingSingleStream);
	}

	private static int getIntSumParallelStream() {
		long t1 = System.currentTimeMillis();
		int sum= listInteger.parallelStream().mapToInt(i->i.intValue()).sum();
		long t2 = System.currentTimeMillis()-t1;
		System.out.println("Parellel   "+t2);
		return sum;
	}

	private static int getIntSumSingleStream() {
		long t1 = System.currentTimeMillis();
		int sum= listInteger.stream().mapToInt(i->i.intValue()).sum();
		long t2 = System.currentTimeMillis()-t1;
		System.out.println("Serial "+t2);
		return sum;
	}
}
