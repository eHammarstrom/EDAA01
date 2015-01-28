package set;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class ArraySet<E> implements SimpleSet<E> {
	private ArrayList<E> data;

	/**
	 * Constructs a new empty set.
	 */
	public ArraySet() {
		data = new ArrayList<E>();
	}

	/** 
	 * Adds the specified element to this set, if it is not already present.
	 * post: x is added to the set if it is not already present
	 * @param  x the element to be added
	 * @return true if the specified element was added
	 */
	public boolean add(E x) {
		if(!data.contains(x))  {
			return data.add(x);
			} else {
			return false;
		}
	}
	
	/**
	 * Adds all of the elements in the specified set, for which it is
	 * possible, to this set.
	 * post: all elements, for which it is possible in the
	 * specified set are added to this set
	 * @return		true if this set changed as a result of the call
	 */
	public boolean addAll(SimpleSet<? extends E> s) {
		boolean addStatus = false;
		for (E element : s) {
//			System.out.println("we are looping and adding: " + element);
			if(add(element)) addStatus = true;
		}
//		System.out.println(addStatus);
		return addStatus;
	}

	/** 
	 * Removes the specified element from this set if it is present. 
	 * post: 	x is removed if it was present
	 * @param 	x the element to remove - if present
	 * @return true if the set contained the specified element
	 */
	public boolean remove(Object x) {	return data.remove(x);	}

	/** 
	 * Returns true if this set contains the specified element.
	 * @param 	x the element whose presence is to be tested
	 * @return	true if this set contains the specified element
	 */
	public boolean contains(Object x) {	return data.contains(x);	}

	/** 
	 * Returns true if this set contains no elements.
	 * @return true if this set contains no elements
	 */
	public boolean isEmpty() {	return data.isEmpty();	}

	/** 
	 * Returns the number of elements in this set.
	 * @return the number of elements in this set
	 */
	public int size() {	return data.size();	}
	
	/** 
	 * Returns an iterator over the elements in this set.
	 * @return an iterator over the elements in this set
	 */
	public Iterator<E> iterator() {	return data.iterator();	}
	
}







































