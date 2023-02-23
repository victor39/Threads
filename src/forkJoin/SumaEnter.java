package forkJoin;
import java.util.concurrent.ForkJoinPool;

public class SumaEnter {

	public static void main(String[] args) {
		int num = 1000000000;
		int rep = 100;
		long t1, t2, t3;

		System.out.println(sumaIteratiu(num));
		System.out.println(sumaForkJoin(num));

		t1 = System.currentTimeMillis();
		for (int n=0; n<rep; n++) sumaIteratiu(num);
		t2 = System.currentTimeMillis();

		for (int n=0; n<rep; n++) sumaForkJoin(num);
		t3 = System.currentTimeMillis();

		System.out.println(t2-t1);
		System.out.println(t3-t2);
	}

	public static long sumaIteratiu(int num) {
		long res = 0;
		for (int n=1; n<=num; n++) {
			res+=n;
		}
		return res;
	}

	public static long sumaForkJoin(int num) {
		ForkJoinPool pool = new ForkJoinPool();
		SumaEnterTask suma = new SumaEnterTask(num);
		return pool.invoke(suma);
	}

}
