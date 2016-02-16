import java.util.Iterator;

public class AArrayList<T> implements AList<T>, Iterable<T> {

  private T[] data;
  private int size;

  public static final int INITIAL_SIZE = 8;

  public AArrayList() {
    this(INITIAL_SIZE);
  }

  @SuppressWarnings("unchecked")
  public AArrayList(int size) {
    data = (T[]) new Object[size];
    this.size = 0;
  }

  @Override
  public void addFirst(T item) {
    add(item, 0);
  }

  @Override
  public void addLast(T item) {
    add(item, size);
  }

  @Override
  public void add(T item, int index) {
    if (index < 0 || index > size) {
      throw new ArrayIndexOutOfBoundsException();
    } else {
      if (size == data.length) {
        expand();
      }

      for (int i = size; i > index; i--) {
        data[i] = data[i - 1];
      }
      data[index] = item;
      size++;
    }
  }

  @Override
  public T removeFirst() {
    return remove(0);
  }

  @Override
  public T removeLast() {
    return remove(size - 1);
  }

  @Override
  public T remove(int index) {
    if (index < 0 || index > size - 1) {
      throw new ArrayIndexOutOfBoundsException();
    } else {
      T toReturn = data[index];

      for (int i = index; i < size; i++) {
        data[i] = data[i + 1];
      }
      size--;

      return toReturn;
    }
  }

  @Override
  public T get(int index) {
    if (index < 0 || index > size - 1) {
      throw new ArrayIndexOutOfBoundsException();
    } else {
      return data[index];
    }
  }

  @Override
  public void set(T item, int index) {
    if (index < 0 || index > size - 1) {
      throw new ArrayIndexOutOfBoundsException();
    } else {
      data[index] = item;
    }
  }

  @SuppressWarnings("unchecked")
  private void expand() {
    T[] newData = (T[]) new Object[data.length * 2];
    for (int i = 0; i < data.length; i++) {
      newData[i] = data[i];
    }
    data = newData;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public Iterator<T> iterator() {
    return new AArrayListIterator<T>(this);
  }

  public static void main(String[] args) {
    AArrayList<Integer> listA = new AArrayList<>();
    listA.addLast(1);
    listA.addLast(2);
    listA.addLast(3);

    AArrayList<Integer> listB = new AArrayList<>();
    listB.addLast(4);
    listB.addLast(5);
    listB.addLast(6);
  }
}
