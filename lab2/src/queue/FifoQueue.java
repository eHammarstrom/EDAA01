package queue;
import java.util.*;

public class FifoQueue<E> extends AbstractQueue<E> implements Queue<E> {
	private QueueNode<E> last;
	private int size;

	public FifoQueue() {
		size = 0;
	}

	/**	
	 * Returns an iterator over the elements in this queue
	 * @return an iterator over the elements in this queue
	 */	
	public Iterator<E> iterator() {
		return new QueueIterator();
	}
	
	private class QueueIterator implements Iterator<E> {
		private QueueNode<E> pos;
		
		private QueueIterator() {
			if (last == null)
				pos = null;
			else
				pos = last.next;
		}
		
		public boolean hasNext() {
			return (pos != null);
		}
		
		public E next() {
			if (hasNext()) {
				QueueNode<E> previous = pos;
				pos = pos.next;
				if (pos == last.next)
					pos = null;
				return previous.element;
			}
			
			throw new NoSuchElementException();
		}
		
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	/**	
	 * Returns the number of elements in this queue
	 * @return the number of elements in this queue
	 */
	public int size() {
		return size;
	}

	/**	
	 * Inserts the specified element into this queue, if possible
	 * post:	The specified element is added to the rear of this queue
	 * @param	x the element to insert
	 * @return	true if it was possible to add the element 
	 * 			to this queue, else false
	 */
	public boolean offer(E x) {
		QueueNode<E> newLast = new QueueNode<E>(x);
		
		if (this.size() == 0) {
			last = newLast;
			newLast.next = newLast;
//			newLast.element = x;
		} else {
			newLast.next = last.next;
			last.next = newLast;
			last = newLast;
		}
		
		size++;
		
		return true;
	}

	/**	
	 * Retrieves and removes the head of this queue, 
	 * or null if this queue is empty.
	 * post:	the head of the queue is removed if it was not empty
	 * @return 	the head of this queue, or null if the queue is empty 
	 */
	public E poll() {
		if (this.size() == 0)
			return null;
		else {
			QueueNode<E> removed = last.next;
			if (this.size() == 1)
				last = null;
			else {
//				last.next = null;
				last.next = removed.next;
			}
			size--;
			return removed.element;
		}
	}

	/**	
	 * Retrieves, but does not remove, the head of this queue, 
	 * returning null if this queue is empty
	 * @return 	the head element of this queue, or null 
	 * 			if this queue is empty
	 */
	public E peek() {
		if (this.size() > 0)
			return last.next.element;
		else
			return null;
	}

	/**
	 * Appends the specified queue to this queue
	 * post: all elements from the specified queue are appended
	 * 			to this queue. The specified queue (q) is empty
	 * @param q the queue to append
	 */
	public void append(FifoQueue<E> q) {
		if (q.size() > 0 && last != null) {
			/**
			 * (q.last.next) - x - x - x - x - x - (q.last) <- q1
			 * (last.next) - x - x - x - x - (last) <- q2
			 */
			
			QueueNode<E> qLast = q.last;
//			QueueNode<E> qFirst = q.last.next;
//			QueueNode<E> thisLast = last;
			QueueNode<E> thisFirst = last.next;
			
			last.next = q.last.next;
			q.last.next = thisFirst;
//			thisLast = q.last;
//			q.last.next = last;
			last = qLast;
		} else if(q.size() > 0) {
			last = q.last;
			last.next = q.last.next;
		}
		q.last = null;
		q.size = 0;
	}

	private static class QueueNode<E> {
		E element;
		QueueNode<E> next;

		private QueueNode(E x) {
			element = x;
			next = null;
		}
	}

}
