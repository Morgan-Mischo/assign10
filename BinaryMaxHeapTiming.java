package assign10;

import java.util.Collections;

public class BinaryMaxHeapTiming {

	private int TIMES_TO_LOOP = 1000;
	private int problemSize = 20000;
	
	public static<E> void main (String[] args) {
		
		experiment3();
		//experiment5();
		//experiment6();
	}

	/**
	 * Assess the efficiency of add, peek, and extractMax from
	 * the BinaryMaxHeap class.
	 */
	private static void experiment3() {
		for (int i = 1000; i < problemSize + 1; i+=1000)
		{
			myBST.clear();
			long startTime, midpointTime, midpointTime2, stopTime = System.nanoTime();

			// First, spin computing stuff until one second has gone by.
			// This allows this thread to stabilize.
			startTime = System.nanoTime();
			while (System.nanoTime() - startTime < 1000000000) { 
				// empty block
			}


			int p = 0;
			// Now, run the test.
			startTime = System.nanoTime();

			while (p < 10)
			{
				iList1.clear();
				for (int j = 0; j < i; j++)
				{
					iList1.add(j);
				}
				Collections.shuffle(iList1);
				for (int j = 0; j <= TIMES_TO_LOOP; j++)
				{
						myBST.addAll(iList1);
						myBST.clear();
				}
				p++;
			}

			midpointTime = System.nanoTime();
			myBST.clear();
			midpointTime2 = System.nanoTime();
			// Run a loop to capture the cost of running the "timesToLoop" loop and
			// generating a random ISBN.
			while (p < 10)
			{
				iList1.clear();
				for (int j = 0; j < i; j++)
				{
					iList1.add(j);
				}
				Collections.shuffle(iList1);
				for (int j = 0; j <= TIMES_TO_LOOP; j++)
				{
						myBST.clear();
				}
				p++;
			}
			stopTime = System.nanoTime();

			// Compute the time, subtract the cost of running the loop
			// from the cost of running the loop and doing the lookups.
			// Average it over the number of runs.
			double averageTime = (double) ((midpointTime - startTime) - (stopTime - midpointTime2))
					/ (TIMES_TO_LOOP * p);
			System.out.println(i + "\t" + averageTime);
		}

	}

	private static void experiment5() {
		// TODO Auto-generated method stub
		
	}
	
	private static void experiment6() {
		// TODO Auto-generated method stub
		
	}
}
