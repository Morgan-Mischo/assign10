package assign10;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinaryMaxHeapTest {

	@BeforeEach
	void setUp() throws Exception {
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
	void innerCompare() {
		List<Integer> small = integerList(4);
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
	void add() {
		List<Integer> large = integerList(10);
		
		BinaryMaxHeap<Integer> sut = new BinaryMaxHeap<Integer>();
		assertTrue(sut.isEmpty());
	}
}
