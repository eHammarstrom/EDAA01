import java.util.NoSuchElementException;

public class SingleLinkedListNonIter<E> {
	private ListNode<E> first;
	
	/** Creates an empty list. */
	public SingleLinkedListNonIter() {
		first = null;
	}
	
	/*
	 * Nested class. Represents a node which contains an element of type E.
	 */
	private static class ListNode<E> {
		private ListNode<E> next;
		private E element;
		
		private ListNode(E e) {
			element = e;
			next = null;
		}
	}
	
	/**
	 * Inserts the specified element at the beginning of this list.
	 * @param x the element to be inserted
	 */
	public void addFirst(E x) {
		ListNode<E> n = new ListNode<E>(x);
		n.next = first;
		first = n;
	}
	
	/**
	 * Removes the element at the beginning of this list.
	 * @return the removed element
	 * @throws NoSuchElementException if this list is empty
	 */
	public E removeFirst() {
		if (first == null) {
			throw new NoSuchElementException();
		}
		ListNode<E> temp = first;
		first = first.next;
		return temp.element;
	}
	
	/** Prints all elements in the list on standard output. */
	public void print() {
		ListNode<E> n = first;
		while (n != null) {
			System.out.print(n.element);
			n = n.next;
		}
	}
	
	/**  
	 * Returns a String representation of the list.
	 * @return a String representation of the list
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("[");
		ListNode<E> n = first;
		while (n != null) {
			s.append(n.element.toString());
			if (n.next != null) {
				s.append(", ");
			}
			n = n.next;
		}
		s.append("]");
		return s.toString();		
	}

	/**
	 * Inserts the specified element at the end of this list.
	 * @param x the element to be inserted
	 */
	public void addLast(E x) {
		ListNode<E> n = new ListNode<E>(x);
		if (first == null) {
			first = n;
		} else {
			ListNode<E> p = first;
			while (p.next != null) {
				p = p.next;
			}
			p.next = n;
		}
	}

	/**
	 * Removes the element at the end of this list.
	 * @return the removed element
	 * @throws NoSuchElementException if this list is empty
	 */
	public E removeLast() {
		if (first == null) {		// tom lista
			throw new NoSuchElementException();
		}
		
		if (first.next == null) {	// ett element
			ListNode<E> temp = first;
			first = null;
			return temp.element;
		}
		ListNode<E> p = first;		// minst tv� element
		ListNode<E> pre = null;
		while (p.next != null) {
			pre = p;
			p = p.next;
		}
		pre.next = null;	
		return p.element;
	}
}