package com.ark.function;

import java.util.function.Function;

public class FunctionExample {

	public static void main(String[] args) {

		// Example of Custom Function
		MyFunction<MyInt, String> intAsString = (MyInt i) -> String.valueOf(i.getI()) + "*";
		MyInt value = new MyInt(100);
		String s = intAsString.apply(value);
		System.out.println(s);
		MyFunction<MyInt, String> intAsDollarSymbol = (MyInt i) -> String.valueOf(i.getI()) + "$";
		s = intAsDollarSymbol.apply(value);
		System.out.println(s);

		// Example of Java 8 Functions
		Function<MyInt, String> intAsPoundSymbol = (MyInt i) -> String.valueOf(i.getI()) + "#";
		s = intAsPoundSymbol.apply(value);
		System.out.println(s);

		// Example using Method reference
		Function<MyInt, String> intToStringUsingMethodRef = (String::valueOf);
		s = intToStringUsingMethodRef.apply(value);
		System.out.println(s);

		// And Then in Functions f(g(x))
		Function<Integer, Integer> f = x -> x + 1;
		Function<Integer, Integer> h = x -> x * 2;
		int result = f.apply(2);
		System.out.println(result);
		Function<Integer, Integer> k = f.andThen(h); // this will first apply fucntion f then h
		// if param =2 , 2 +1 = 3 function f applied, then 3* 2 = 6, function h applied
		result = k.apply(2);
		System.out.println(result);
		// Compose function g(f(x))
		Function<Integer, Integer> ff = x -> x + 1;
		Function<Integer, Integer> hh = x -> x * 2;
		Function<Integer, Integer> kk = ff.compose(hh);// this will first apply fucntion kk then ff
		result = kk.apply(2);
		// 2*2 = 4, then 4+1 = 5
		System.out.println(result);
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

interface MyFunction<T, R> {
	R apply(T t);
}