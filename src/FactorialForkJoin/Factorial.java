package FactorialForkJoin;

import java.util.concurrent.ForkJoinPool;

public class Factorial {

	public static void main(String[] args) {
		int num = 20;
		int rep = 600;
		long t1, t2, t3,t4;
		
		System.out.println(factorialIteratiu(num));
		System.out.println(factorialRecursiu(num));
		System.out.println(factorialForkJoin(num));
		
		t1 = System.currentTimeMillis();
		for (int n=0; n<rep; n++) factorialIteratiu(num);
		t2 = System.currentTimeMillis();
		
		for (int n=0; n<rep; n++) factorialRecursiu(num);
		t3 = System.currentTimeMillis();
		
		for (int n=0; n<rep; n++) factorialForkJoin(num);
		t4 = System.currentTimeMillis();
		
		System.out.println(t2-t1);
		System.out.println(t3-t2);
		System.out.println(t4-t3);
	}
	
	public static long factorialIteratiu(int num) {
		long res = 1;
		for (int n=2; n<=num; n++) {
			res*=n;
		}
		return res;
	}
	
	public static long factorialRecursiu(int num) {
		if (num <= 1) return 1;
		else return num*factorialRecursiu(num-1);
	}
	
	public static long factorialForkJoin(int num) {
		ForkJoinPool pool = new ForkJoinPool();
		FactorialTask fact = new FactorialTask(num);
		return pool.invoke(fact);
	}

}