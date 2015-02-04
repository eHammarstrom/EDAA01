package testqueue;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import queue.FifoQueue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestAppendFifoQueue {
	private FifoQueue<Integer> myIntQueue;
	private FifoQueue<Integer> myIntQueue2;
	private FifoQueue<String> myStringQueue;
	private FifoQueue<String> myStringQueue2;
	
	@Before
	public void setUp() throws Exception {
		myIntQueue = new FifoQueue<Integer>();
		myIntQueue2 = new FifoQueue<Integer>();
		myStringQueue = new FifoQueue<String>();
		myStringQueue2 = new FifoQueue<String>();
	}
	
	@After
	public void tearDown() throws Exception {
		myIntQueue = null;
		myIntQueue2 = null;
		myStringQueue = null;
		myStringQueue2 = null;
	}
	
	@Test
	public void testTwoEmptyQueues() {
		myIntQueue.append(myIntQueue2);
		assertEquals("", null, myIntQueue.poll());
	}
	
	@Test
	public void testEmptyToNoneEmpty() {
		for (int i = 0; i < 11; i++) {
			myIntQueue.offer(i);
		}
		myIntQueue.append(myIntQueue2);
	}

	@Test
	public void testNoneEmptyToEmpty() {
		for (int i = 0; i < 11; i++) {
			myIntQueue2.offer(i);
		}
		
		myIntQueue.append(myIntQueue2);
		
		assertEquals("", 0, myIntQueue2.size());
	}
	
	@Test
	public void bottomsUp() {
		int q = 11;
		for (int i = 1; i <= 10; i++) {
			myIntQueue.offer(i);
			myIntQueue2.offer(q);
			System.out.println(i + " " + q);
			q++;
		}
		
		myIntQueue.append(myIntQueue2);
		
		Iterator<Integer> iter = myIntQueue.iterator();
		
		int i = 1;
		while (iter.hasNext()) {
			int ans = iter.next();
			System.out.println(ans);
			assertEquals("Expected loop 1..20", i, ans);
			i++;
		}
		
		myIntQueue.append(myIntQueue2);

		Iterator<Integer> iter2 = myIntQueue.iterator();
		
		int x = 1;
		while (iter2.hasNext()) {
			int ans = iter2.next();
			System.out.println(ans);
			assertEquals("Expected loop 1..20", x, ans);
			x++;
		}
	}
}
