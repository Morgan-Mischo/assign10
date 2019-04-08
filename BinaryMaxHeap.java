package assign10;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class BinaryMaxHeap <E> implements PriorityQueue<E> {
	
	/* Keeps track of the size */
	private int size = 0; 
	
	/* Keeps track of capacity */
	private int capacity = 50;
	
	/* Array for backing */
	private E [] binaryHeap = (E []) new Object [capacity]; 
	
	/* Our comparator */
	private Comparator<? super E> cmp = null; 
	/**
	 * If this constructor is used to create an empty binary heap, it is assumed that the elements are ordered using their natural ordering 
	 * (i.e., E implements Comparable<? super E>).
	 */
	public BinaryMaxHeap ()
	{
		
	}
	
	
	/**
	 * If this constructor is used to create an empty binary heap, it is assumed that the elements are ordered using the provided Comparator object.
	 */
	public BinaryMaxHeap(Comparator<? super E> _cmp)
	{
		cmp = _cmp;
	}
	

	/**
	 * If this constructor is used, then the binary heap is constructed from the given list.  Also, it is assumed that the elements are ordered using
	 *  their natural ordering (i.e., E implements Comparable<? super E>).  RECALL: Using the buildHeap operation, we can construct a binary heap 
	 *  from these N items in O(N) time, which is more efficient than adding them to the binary heap one at a time.  This constructor use such an 
	 *  operation.
	 */
	public BinaryMaxHeap(List<? extends E> list)
	{
		capacity = list.size() + 1;
		binaryHeap = (E []) new Object[capacity];
		for (int i = 0; i < list.size(); i++)
		{
			binaryHeap[i + 1] = list.get(i);
			size++;
		}
		buildHeap();
	}
	
	/**
	 * If this constructor is used, then the binary heap is constructed from the given list (see RECALL note above).  Also, it is assumed that the 
	 * elements are ordered using the provided Comparator object.
	 */
	public BinaryMaxHeap(List<? extends E> list, Comparator<? super E> _cmp)
	{
		cmp = _cmp;
		capacity = list.size() + 1;
		binaryHeap = (E []) new Object[capacity];
		for (int i = 0; i < list.size(); i++)
		{
			binaryHeap[i + 1] = list.get(i);
			size++;
		}
		buildHeap();
	}
	
	/**
	 * Helper method for buildHeap
	 * @return 
	 */
	
	private void buildHeap()
	{
		for (int i = size / 2; i >= 1; i--)
		{
			percolateDown(i, binaryHeap[i]); 
		}
	}
	
	/**
	 * Helper method for percolateUp
	 */
	
	private void percolateUp (int index, E element)
	{
		//Element is max
		if (index == 1)
		{
			return;
		}
		
		E parent = binaryHeap[index/2];
		
		//If child is greater than parent, swap up
		if (innerCompare(element, parent) > 0)
		{
			binaryHeap[index] = parent;
			binaryHeap[index/2] = element;
			index = index/2;
			percolateUp(index, element);
		}
		
		//Child is no longer greater than parent
		else {
			return;
		}
	}
	
	/** 
	 * Helper method for percolateDown
	 */
	
	private void percolateDown (int index, E element)
	{
		E left = null; 
		E right = null;
		
		// Case if there are no left and right children
		if (index * 2 > size)
		{
			return;
		}
		
		//Case if there is only a left child
		else if (index * 2 + 1 > size)
		{
			left = binaryHeap[index * 2]; 
			if (innerCompare(element, left) > 0)
			{
				return;
			}
			else
			{
				binaryHeap[index * 2] = element;
				binaryHeap[index] = left;
				index = index * 2;
				percolateDown(index, element);
			}
		}
		
		//Case if there is both a left and right child
		else if (index * 2 + 1 < size && index * 2 < size)
		{
			left = binaryHeap[index * 2]; 
			right = binaryHeap[index * 2 + 1]; 
			
			if (innerCompare(element, left) > 0 && innerCompare(element, right) > 0)
			{
				//binaryHeap[index] = element;
				return; 
			}
			
			if (innerCompare(left, right) > 0)
			{
				binaryHeap[index * 2] = element;
				binaryHeap[index] = left;
				index = index * 2;
				percolateDown(index, element);
			}
			else
			{
				binaryHeap[index * 2 + 1] = element;
				binaryHeap[index] = right;
				index = index * 2 + 1;
				percolateDown(index, element);
			}
		}	
	}
	
	/**
	 * Helper method for innerCompare
	 */	
	private int innerCompare (E obj1, E obj2)
	{
		if (cmp != null)
		{
			return cmp.compare(obj1, obj2); 
		}

		else 
		{
			return ((Comparable<? super E>) obj1).compareTo(obj2);
		}
	}
	
	@Override
	public void add(E item) {
		//Copy old array if capacity is reached
		if (size == capacity)
		{
			capacity *= 2;
			E[] newBinaryHeap = (E []) new Object [capacity]; 
			for(int i = 1; i < size; i++)
			{
				newBinaryHeap[i] = binaryHeap[i];
			}
			binaryHeap = newBinaryHeap;
		}
		
		percolateUp(size + 1, item);
		size++;
	}

	@Override
	public E peek() throws NoSuchElementException {
		if(size == 0)
		{
			throw new NoSuchElementException();
		}
		return binaryHeap[1];
	}

	@Override
	public E extractMax() throws NoSuchElementException {
		if(size == 0)
		{
			throw new NoSuchElementException();
		}
		//Store first value for return
		E deletedVal = binaryHeap[1];
		
		percolateDown(1, binaryHeap[size]);
		binaryHeap[size] = null;

		size--;
		return deletedVal;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void clear() {
		size = 0;
		binaryHeap = (E []) new Object [50];
		cmp = null;
		return;
	}

	@Override
	public Object[] toArray() {
		Object[] arr = new Object[size];
		for(int i = 1; i < size; i++)
		{
			arr[i - 1] = binaryHeap[i];
		}
		return arr;
	}

}