package assign10;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinaryMaxHeapTest {
	
	List<String> sList = new ArrayList<String>();

	@BeforeEach
	void setUp() throws Exception {
		sList.add("a");
		sList.add("b");
		sList.add("c");
		sList.add("ef");
		sList.add("giraffe");
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	/**
	 * This method constructs integer lists to test with.
	 * @param size
	 * @return result integer ArrayList
	 */
	public List<Integer> integerList(int size)
	{
		Random rng = new Random(5);
		List<Integer> result = new ArrayList<Integer>();
		
		for(int i = 0; i < size; i++)
		{
			result.add(rng.nextInt(100));
		}
		return result;		
	}

	@Test
	void smallList() {
		ArrayList<Integer> myList = new ArrayList<Integer>();
		myList.add(5);
		myList.add(10);
		myList.add(1);
		
		BinaryMaxHeap<Integer> sut = new BinaryMaxHeap<Integer>(myList);
		assertEquals(10, sut.extractMax());
		assertEquals(5, sut.peek());
	}
	
	@Test
	void innerCompare() {
		List<Integer> small = integerList(4);
		@SuppressWarnings("unused")
		BinaryMaxHeap<Integer> sut = new BinaryMaxHeap<Integer>(small);
	}
	
	@Test
	void peek() {
		List<Integer> large = integerList(10);
		System.out.println(large);
		BinaryMaxHeap<Integer> sut = new BinaryMaxHeap<Integer>(large);
		assertEquals(92, sut.peek());
	}
	
	@Test
	void extractMax() {
		List<Integer> large = integerList(10);
		System.out.println(large);
		BinaryMaxHeap<Integer> sut = new BinaryMaxHeap<Integer>(large);
		assertEquals(92, sut.extractMax());
		
		assertEquals(91, sut.extractMax());
		sut.toArray();
	}
	
	@Test
	void clear() {
		List<Integer> large = integerList(10);
		BinaryMaxHeap<Integer> sut = new BinaryMaxHeap<Integer>();
		assertTrue(sut.size() == 0);
		sut = new BinaryMaxHeap<Integer>(large);
		sut.clear();
		
		assertTrue(sut.size() == 0);
	}
	
	@Test
	void isEmpty() {
		List<Integer> large = integerList(10);
		
		BinaryMaxHeap<Integer> sut = new BinaryMaxHeap<Integer>();
		assertTrue(sut.isEmpty());
		
		sut = new BinaryMaxHeap<Integer>(large);
		assertFalse(sut.isEmpty());
		
		sut.clear();
		assertTrue(sut.isEmpty());
	}
	
	@Test
	void add_MaxChanges() {
		List<Integer> large = integerList(10);
		
		BinaryMaxHeap<Integer> sut = new BinaryMaxHeap<Integer>(large);
		assertTrue(sut.peek() == 92);
		
		sut.add(145);
		assertTrue(sut.peek() == 145);
		
		sut.add(97);
		assertTrue(sut.peek() == 145);
	}
	
	@Test
	void stringList() {
		BinaryMaxHeap<String> sut = new BinaryMaxHeap<String>(sList);
		assertFalse(sut.isEmpty());
		
		sut.add("turkey");
		assertEquals("turkey", sut.extractMax());
	}
	
	@Test
	void fromEmpty() {
		BinaryMaxHeap<Integer> sut = new BinaryMaxHeap<Integer>();
		sut.add(15);
		assertEquals(15, sut.extractMax());
	}
}
