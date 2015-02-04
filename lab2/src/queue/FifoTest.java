package queue;

public class FifoTest {
	public static void main(String[] args) {
		FifoQueue<Integer> myIntQueue = new FifoQueue<Integer>();
		
		myIntQueue.offer(1);
		myIntQueue.offer(2);
		myIntQueue.offer(3);
		
		for (int i : myIntQueue) {
			System.out.println(i);
		}
	}
}
