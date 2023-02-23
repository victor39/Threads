package FactorialForkJoin;

import java.util.concurrent.RecursiveTask;

public class FactorialTask extends RecursiveTask<Long> {

	private static final long serialVersionUID = 1L;
	private static final int LLINDAR_SEQ = 10;
	private int numInici;
	private int numFi;

	public FactorialTask(int numInici, int numFi) {
		this.numInici = numInici;
		this.numFi = numFi;
	}

	public FactorialTask(int numFi) {
		this.numInici = 1;
		this.numFi = numFi;
	}

	private long getPartialFactorial() {
		long result = 1;
		for (int n=numInici; n<=numFi; n++)
			result *= n;
		return result;
	}

	@Override
	protected Long compute() {
		if (numFi - numInici < LLINDAR_SEQ)
			return getPartialFactorial();
		else {
			int mig = (numInici + numFi)/2;
			FactorialTask pf1 = new FactorialTask(numInici, mig);
			pf1.fork();
			FactorialTask pf2 = new FactorialTask(mig+1, numFi);
			return pf2.compute() * pf1.join();
		}
	}
}