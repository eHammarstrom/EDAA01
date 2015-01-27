import java.util.Iterator;

public class Main {
	public static void main(String[] args) {
		SingleLinkedListNonIter<Integer> list = new SingleLinkedListNonIter<Integer>();
		list.addFirst(2);
		list.addFirst(1);
		list.addLast(3);
		
		Iterator<Integer> itr = list.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

		for (int i : list) {
			System.out.println(i);
		}
	}
}
