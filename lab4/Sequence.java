import java.util.Iterator;

public class Sequence<E> {
	private E[] list;

	public Sequence(int size) {
		list = (E[]) new Object[size];
	}

	public Iterator<E> getIterator() {
		return new Iterator<E>() {

			private int current = 0;

			@Override
			public boolean hasNext() {
				return current < list.length;
			}

			@Override
			public E next() {
				return list[current++];
			}
		};
	}
}