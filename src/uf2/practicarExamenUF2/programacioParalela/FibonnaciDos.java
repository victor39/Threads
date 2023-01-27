package uf2.practicarExamenUF2.programacioParalela;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class FibonnaciDos {
	

	public static void main(String[] args) {
		Long n = 10L;
		Long res;
		long t1 = System.currentTimeMillis();
		res = fibonacci(n);
		long t2 = System.currentTimeMillis();
		System.out.println("Time in sequential = " + (t2- t1)+" ms. Result: " + res);

		{
			t1 = System.currentTimeMillis();
			ForkJoinPool pool = new ForkJoinPool();
			Fibonacci fb = new Fibonacci(n);
			pool.invoke(fb);
			res = fb.getRawResult();
			t2 = System.currentTimeMillis();
			System.out.println("Time in fork join= " + (t2- t1)+" ms. Result: " + res);
		}
		
		{
			int processors = Runtime.getRuntime().availableProcessors();
			t1 = System.currentTimeMillis();
//			processors *= 100;
			ForkJoinPool pool = new ForkJoinPool(processors);
			Fibonacci fb = new Fibonacci(n);
			pool.invoke(fb);
			res = fb.getRawResult();
			t2 = System.currentTimeMillis();
			System.out.println("Time in fork join= " + (t2- t1)+" ms. In "+processors+ " processor. Result: " + res);
		}
	}

	@SuppressWarnings("serial")
	static class Fibonacci extends RecursiveTask<Long> {
		   final Long n;
		   Fibonacci(Long n) { this.n = n; }
		   public Long compute() {
		     if (n <= 1)
		        return n;
		     Fibonacci f1 = new Fibonacci(n - 1);
		     f1.fork();
		     Fibonacci f2 = new Fibonacci(n - 2);
		     return f2.compute() + f1.join();
		   }
		 }
	 
	 private static Long fibonacci(Long n){
		 if (n <= 1){
			 return n;
		 }else{
			 return fibonacci(n-2) + fibonacci(n-1);
		 }
	 }

}
