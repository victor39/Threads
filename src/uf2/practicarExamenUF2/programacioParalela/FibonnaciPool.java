package uf2.practicarExamenUF2.programacioParalela;

import java.util.ArrayList;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class FibonnaciPool extends RecursiveTask<ArrayList <Integer>>{
	
	private static final int LLINDAR_SEQ = 1;
	static ArrayList <Integer> numFibonnaci = new ArrayList <Integer> ();
	static ArrayList <Integer> total = new ArrayList <Integer> ();

	private static int numFi, numInici;
	
	FibonnaciPool (ArrayList<Integer> num , int numInici ,int numFi ){
		this.numFibonnaci=num;
		this.numInici=numInici;
		this.numFi=numFi;
	}
	
	public static void main(String[] args)throws Exception {
		numFibonnaci.add(1);
		numFibonnaci.add(20);
		numFibonnaci.add(30);
		numFibonnaci.add(23);
		FibonnaciPool fibonaci = new FibonnaciPool(numFibonnaci,0,numFibonnaci.size());
		total=forkJoinPool();
		System.out.println(total);
		
	}
	public static int fibonnaci(int num) {
		if (num == 0) {
			 return 0;
		}
        else if (num == 1)
            return 1;
        else
		return fibonnaci(num -1 ) + fibonnaci(num -2);
	}
	
	public ArrayList<Integer> ferFibonnaci(ArrayList<Integer> numeros ,int numInici  , int numFi ){
		ArrayList <Integer> result = new ArrayList <Integer>();
		
		for (int i=numInici; i<numFi; i++) {
			 result.add(fibonnaci(numeros.get(i)));
		}
		return result;
		
	}
	public static ArrayList<Integer> forkJoinPool() {
		ForkJoinPool pool = new ForkJoinPool();
		FibonnaciPool fibonaci = new FibonnaciPool(numFibonnaci,0,numFi);
		return pool.invoke(fibonaci);
		
	}
	
	@Override
	protected  ArrayList<Integer> compute() {
		if (numFi - numInici < LLINDAR_SEQ) {
			
			System.out.println("fibonnaci if"+ferFibonnaci(numFibonnaci,numInici ,numFi));
			return ferFibonnaci(numFibonnaci,numInici ,numFi);
		}
		else {
			int mig = (numFibonnaci.size())/2;
			
			FibonnaciPool f1 = new FibonnaciPool(numFibonnaci,numInici, mig);
		
			FibonnaciPool f2 = new FibonnaciPool(numFibonnaci,mig+1, numFi);
	
			invokeAll(f1,f2);
			;
			
			ArrayList<Integer>resultatTotal= new ArrayList<Integer>();
			
			resultatTotal.addAll(f1.join());
			System.out.print("else " + f1.join());
			resultatTotal.addAll(f2.join());
			System.out.print(f2.join());

			System.out.println(resultatTotal);
			return resultatTotal;
		}
	}
		
}
