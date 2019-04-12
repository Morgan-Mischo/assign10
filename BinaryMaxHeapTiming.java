public class BinaryMaxHeapTiming {
	
	final static int TIMES_TO_LOOP = 1000;
	final static int problemSize = 100000;
	
	public static<E> void main (String[] args) {
		
		experiment3();
		//experiment5and6 ();
	}

	/**
	 * Assess the efficiency of add, peek, and extractMax from
	 * the BinaryMaxHeap class.
	 */
	private static void experiment3() {
		
		System.out.println("N" + "\t" + "add" + "\t" + "peek" + "\t" + "extractMax");
		
		for (int i = 10000; i < problemSize + 1; i+=10000)
		{
			System.out.println(i + "\t" + testAdd(i) + "\t" + testPeek(i) + "\t" + testExtractMax(i));			
		}
	}
	
	private static void experiment5and6 ()
	{
		System.out.println("N" + "\t" + "Heap" + "\t" + "Sort");
		
		for (int i = 10000; i < problemSize + 1; i+=10000)
		{
			System.out.println(i + "\t" + experiment5(i) + "\t" + experiment6(i) + "\n");
					
		}
	}
	
	private static String testAdd(int i)
	{
		BinaryMaxHeap<Integer> myHeap = new BinaryMaxHeap<Integer>();
		List<Integer> sList = new ArrayList<Integer>();
		Random rng = new Random(3);
		for(int k = 0; k < i; k++)
		{
			sList.add(rng.nextInt(10*i));
		}
		
		long startTime, midpointTime, stopTime = System.nanoTime();

		// First, spin computing stuff until one second has gone by.
		// This allows this thread to stabilize.
		startTime = System.nanoTime();
		while (System.nanoTime() - startTime < 1000000000) { 
			// empty block
		}

		// Now, run the test.
		startTime = System.nanoTime();

		for(int j = 0; j < TIMES_TO_LOOP; j++)
		{
			myHeap = new BinaryMaxHeap<Integer>(sList);
			
			myHeap.add(rng.nextInt(10*i));
			
			myHeap.clear();
		}

		midpointTime = System.nanoTime();

		// Run a loop to capture the cost of running the "timesToLoop" loop and
		// generating a random ISBN.
		
		for(int j = 0; j < TIMES_TO_LOOP; j++)
		{
			myHeap = new BinaryMaxHeap<Integer>(sList);
			
			rng.nextInt(10*i);
			
			myHeap.clear();
		}
		stopTime = System.nanoTime();

		// Compute the time, subtract the cost of running the loop
		// from the cost of running the loop and doing the lookups.
		// Average it over the number of runs.
		double averageTime = (double) ((midpointTime - startTime) - (stopTime - midpointTime))
				/ (TIMES_TO_LOOP);
		return averageTime + "";
	}
	
	private static String testPeek(int i)
	{
		BinaryMaxHeap<Integer> myHeap = new BinaryMaxHeap<Integer>();
		List<Integer> sList = new ArrayList<Integer>();
		Random rng = new Random(3);
		for(int k = 0; k < i; k++)
		{
			sList.add(rng.nextInt(10*i));
		}
		
		long startTime, midpointTime, stopTime = System.nanoTime();

		// First, spin computing stuff until one second has gone by.
		// This allows this thread to stabilize.
		startTime = System.nanoTime();
		while (System.nanoTime() - startTime < 1000000000) { 
			// empty block
		}

		// Now, run the test.
		startTime = System.nanoTime();

		for(int j = 0; j < TIMES_TO_LOOP; j++)
		{
			myHeap = new BinaryMaxHeap<Integer>(sList);
			
			myHeap.peek();

			myHeap.clear();
		}

		midpointTime = System.nanoTime();

		// Run a loop to capture the cost of running the "timesToLoop" loop and
		// generating a random ISBN.

		for(int j = 0; j < TIMES_TO_LOOP; j++)
		{
			myHeap = new BinaryMaxHeap<Integer>(sList);
			
			myHeap.clear();
		}

		stopTime = System.nanoTime();

		// Compute the time, subtract the cost of running the loop
		// from the cost of running the loop and doing the lookups.
		// Average it over the number of runs.
		double averageTime = (double) ((midpointTime - startTime) - (stopTime - midpointTime))
				/ (TIMES_TO_LOOP);
		return averageTime + "";
		
	}
	
	private static String testExtractMax(int i)
	{
		BinaryMaxHeap<Integer> myHeap = new BinaryMaxHeap<Integer>();
		List<Integer> sList = new ArrayList<Integer>();
		Random rng = new Random(3);
		for(int k = 0; k < i; k++)
		{
			sList.add(rng.nextInt(10*i));
		}
		
		long startTime, midpointTime, stopTime = System.nanoTime();
		
		// First, spin computing stuff until one second has gone by.
		// This allows this thread to stabilize.
		startTime = System.nanoTime();
		while (System.nanoTime() - startTime < 1000000000) { 
			// empty block
		}

		// Now, run the test.
		startTime = System.nanoTime();

		for(int j = 0; j < TIMES_TO_LOOP; j++)
		{
			for(int k = 0; k < i; k++)
			{
				myHeap.add(k);	
			}
			myHeap.extractMax(); 
			myHeap.clear();
		}

		midpointTime = System.nanoTime();

		// Run a loop to capture the cost of running the "timesToLoop" loop and
		// generating a random ISBN.
		
		for(int j = 0; j < TIMES_TO_LOOP; j++)
		{
			myHeap = new BinaryMaxHeap<Integer>(sList);
			myHeap.clear();
		}
		stopTime = System.nanoTime();

		// Compute the time, subtract the cost of running the loop
		// from the cost of running the loop and doing the lookups.
		// Average it over the number of runs.
		double averageTime = (double) ((midpointTime - startTime) - (stopTime - midpointTime))
				/ (TIMES_TO_LOOP);
		return averageTime + "";
		
	}

	private static String experiment5(int i) {
		ArrayList<Integer> myList = new ArrayList<Integer>(); 
		long startTime, midpointTime, stopTime = System.nanoTime();

		// First, spin computing stuff until one second has gone by.
		// This allows this thread to stabilize.
		startTime = System.nanoTime();
		while (System.nanoTime() - startTime < 1000000000) { 
			// empty block
		}

		// Now, run the test.
		startTime = System.nanoTime();

		for(int j = 1; j < 10; j++)
		{
			for(int k = 0; k < i; k++)
			{
				myList.add(k);  
			}
			FindKLargest.findKLargestHeap(myList, j); 
		}

		midpointTime = System.nanoTime();

		// Run a loop to capture the cost of running the "timesToLoop" loop and
		// generating a random ISBN.
		
		for(int j = 1; j < 10; j++)
		{ 
			for(int k = 0; k < i; k++)
			{
				myList.add(k);
			}
		}
		stopTime = System.nanoTime();

		// Compute the time, subtract the cost of running the loop
		// from the cost of running the loop and doing the lookups.
		// Average it over the number of runs.
		double averageTime = (double) ((midpointTime - startTime) - (stopTime - midpointTime))
				/ (TIMES_TO_LOOP);
		return averageTime + "";
		
	}
	
	private static String experiment6(int i) {
		ArrayList<Integer> myList = new ArrayList<Integer>(); 
		long startTime, midpointTime, stopTime = System.nanoTime();

		// First, spin computing stuff until one second has gone by.
		// This allows this thread to stabilize.
		startTime = System.nanoTime();
		while (System.nanoTime() - startTime < 1000000000) { 
			// empty block
		}

		// Now, run the test.
		startTime = System.nanoTime();

		for(int j = 1; j < 10; j++)
		{
			for(int k = 0; k < i; k++)
			{
				myList.add(k); 
			}
			FindKLargest.findKLargestSort(myList, j); 
		}

		midpointTime = System.nanoTime();

		// Run a loop to capture the cost of running the "timesToLoop" loop and
		// generating a random ISBN.
		
		for(int j = 1; j < 10; j++)
		{
			
			for(int k = 0; k < i; k++)
			{
				myList.add(k); 
			}
		}
		stopTime = System.nanoTime();

		// Compute the time, subtract the cost of running the loop
		// from the cost of running the loop and doing the lookups.
		// Average it over the number of runs.
		double averageTime = (double) ((midpointTime - startTime) - (stopTime - midpointTime))
				/ (TIMES_TO_LOOP);
		return averageTime + "";
		
	}
}
