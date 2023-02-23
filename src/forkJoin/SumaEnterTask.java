package forkJoin;

import java.util.concurrent.RecursiveTask;

public class SumaEnterTask extends RecursiveTask<Long> {

	private static final long serialVersionUID = 1L;
	private static final int LLINDAR_SEQ = 25000000;
	private int numInici;
	private int numFi;

	public SumaEnterTask(int numInici, int numFi) {
		this.numInici = numInici;
		this.numFi = numFi;
	}

	public SumaEnterTask(int numFi) {
		this.numInici = 1;
		this.numFi = numFi;
	}

	private long getSumaParcial() {
		long result = 0;
		for (int n=numInici; n<=numFi; n++)
			result += n;
		return result;
	}

	@Override
	protected Long compute() {
		if (numFi - numInici < LLINDAR_SEQ)
			return getSumaParcial();
		else {
			int mig = (numInici + numFi)/2;
			SumaEnterTask pf1 = new SumaEnterTask(numInici, mig);
			pf1.fork();
			SumaEnterTask pf2 = new SumaEnterTask(mig+1, numFi);
			pf2.fork();
			return pf1.join() + pf2.join();
		}
	}
}
