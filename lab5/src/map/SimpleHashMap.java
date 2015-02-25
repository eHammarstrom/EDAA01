package map;

public class SimpleHashMap<K, V> implements Map<K, V> {
	private int size;
	private int capacity;
	private float loadFactor;
	Entry<K,V>[] table;
	
	@SuppressWarnings("unchecked")
	public SimpleHashMap() {
		size = 0;
		capacity = 16;
		loadFactor = 0.75f;
		table = (Entry<K,V>[]) new Entry[capacity];
	}
	
	@SuppressWarnings("unchecked")
	public SimpleHashMap(int capacity) {
		size = 0;
		this.capacity = capacity;
		loadFactor = 0.75f;
		table = (Entry<K,V>[]) new Entry[this.capacity];
	}

	public V get(Object arg0) {
		return null;
	}

	public boolean isEmpty() {
		return (size == 0);
	}

	/*
	 * 1. Platsen i vektorn tom och d� l�gger du bara till den. 
	 * 2. Platsen i vektorn �r inte tom och du f�r l�gga till den f�rst/sist p� kedjan. 
	 * 3. Key finns redan i Hash-tabellen och d� ska du skriva �ver den och returnera det gamla v�rdet. i
	 * 
	 * Medans detta sker skall loadFactor ej �verstiga 0.75, d� m�ste vektorn expanderas.:W
	 * 
	 */
	public V put(K arg0, V arg1) {
		return null;
	}

	public V remove(Object arg0) {
		return null;
	}

	public int size() {
		return size;
	}
	
	public String show() {
		StringBuilder sb = new StringBuilder();
		int index = 0;
		
		for (Entry<K,V> e : table) {
			sb.append(index + "\t" + e.toString() + "\n");
			index++;
		}
		
		return sb.toString();
	}
	
	private int index(K key) {
		int index = 0;
		
		for (Entry<K,V> e : table) {
			if (e.key.equals(key)) return index;
			index++;
		}
		
		return -1;
	}

	private Entry<K,V> find(int index, K key) {
		for (Entry<K,V> e : table) {
			if (e.key.equals(key) && index(e.key) == index)
				return e;
		}
		
		return null;
	}
	
	private static class Entry<K,V> implements Map.Entry<K,V> {
		private K key;
		private V value;
		private Entry<K,V> next;
		
		public K getKey() {
			return key;
		}
		
		public V getValue() {
			return value;
		}
		
		public V setValue(V newValue) {
			V oldValue = this.value;
			value = newValue;
			return oldValue;
		}
		
		public String toString() {
			return key + "=" + value;
		}
		
	}
}