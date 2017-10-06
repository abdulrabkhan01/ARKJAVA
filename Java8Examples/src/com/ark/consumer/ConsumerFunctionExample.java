package com.ark.consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerFunctionExample {
	public static void main(String args[]) {
		Consumer<Integer> consumer = i -> System.out.print(" " + i);
		List<Integer> integerList = Arrays.asList(new Integer(1), new Integer(10), new Integer(200), new Integer(101),
				new Integer(-10), new Integer(0));
		printList(integerList, consumer);
		
		List<MyInt> aList = Arrays.asList(new MyInt(1),new MyInt(2), new MyInt(3));
		Consumer<MyInt> consumer1 = i -> i.setI(i.getI() *2);
		System.out.println(aList);
		modifyState(aList, consumer1);
		System.out.println(aList);
		
	}

	private static void modifyState(List<MyInt> aList, Consumer<MyInt> consumer1) {
		for (MyInt myInt : aList) {
			consumer1.accept(myInt);
		}
		
	}

	public static void printList(List<Integer> listOfIntegers, Consumer<Integer> consumer) {
		for (Integer integer : listOfIntegers) {
			consumer.accept(integer);
		}
	}

}

class MyInt {
	private int i;

	public MyInt(int i) {
		this.i = i;
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	@Override
	public String toString() {
		return "[i=" + i + "]";
	}
	
	
}