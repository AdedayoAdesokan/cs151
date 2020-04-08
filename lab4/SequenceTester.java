import java.util.Iterator;

public class SequenceTester<E> {
	private E[] list;

	public SequenceTester(int size) {
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
	
	public void add(E object, int index)
	{
		if (index < list.length)
		{
			list[index] = object;
		}
	}

	public static void main(String[] args) {
		SequenceTester<String> list1 = new SequenceTester<String>(20);
		for (int i = 0; i < 21; i++)
		{
			String number = ""+i;
			list1.add(number, i);
		}
		Iterator<String> listIterator = list1.getIterator();
		while (listIterator.hasNext())
		{
			System.out.println(listIterator.next());
		}
	}
}

