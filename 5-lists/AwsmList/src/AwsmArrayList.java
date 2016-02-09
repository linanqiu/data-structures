import java.util.Iterator;

public class AwsmArrayList<T> implements AwsmList<T>, Iterable<T> {

  private T[] data;
  private int size;

  public static final int INITIAL_SIZE = 8;
  public static final int GROWTH_FACTOR = 2;

  @SuppressWarnings("unchecked")
  public AwsmArrayList(int length) {
    data = (T[]) new Object[length];
    size = 0;
  }

  public AwsmArrayList() {
    this(INITIAL_SIZE);
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
      throw new IndexOutOfBoundsException();
    } else {
      if (size == data.length) {
        // list is currently full. will need to expand.
        expand();
      }

      // move everything after and at index up by 1
      for (int i = size; i > index; i--) {
        data[i] = data[i - 1];
      }

      data[index] = item;
      size++;
    }
  }

  @Override
  public void removeFirst() {
    remove(0);
  }

  @Override
  public void removeLast() {
    remove(size - 1);
  }

  @Override
  public void remove(int index) {
    if (index < 0 || index > size - 1) {
      throw new IndexOutOfBoundsException();
    } else {
      // cannot remove beyond the last element
      if (index > size - 1) {
        index = size - 1;
      }

      // move everything after and at index down by 1
      for (int i = index; i < size; i++) {
        data[i] = data[i + 1];
      }

      data[size - 1] = null;
      size--;
    }
  }

  @Override
  public T getFirst() {
    return get(0);
  }

  @Override
  public T getLast() {
    return get(size - 1);
  }

  @Override
  public T get(int index) {
    if (index < 0 || index > size - 1) {
      throw new IndexOutOfBoundsException();
    } else {
      return data[index];
    }
  }

  @Override
  public void setFirst(T item) {
    set(item, 0);
  }

  @Override
  public void setLast(T item) {
    set(item, size - 1);
  }

  @Override
  public void set(T item, int index) {
    if (index < 0 || index > size - 1) {
      throw new IndexOutOfBoundsException();
    } else {
      data[index] = item;
    }
  }

  @SuppressWarnings("unchecked")
  private void expand() {
    T[] newData = (T[]) new Object[data.length * GROWTH_FACTOR];
    for (int i = 0; i < size; i++) {
      newData[i] = data[i];
    }
    data = newData;
    System.out.println("Array has expanded to length " + data.length);
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public Iterator<T> iterator() {
    // AwsmArrayList<T> currentList = this;
    return new AwsmArrayListIterator<T>(this);
  }

  public class AwsmArrayListIterator<T> implements Iterator<T> {

    private int index;
    private AwsmArrayList<T> list;

    public AwsmArrayListIterator(AwsmArrayList<T> list) {
      this.list = list;
      index = 0;
    }

    @Override
    public boolean hasNext() {
      return index < list.size();
    }

    @Override
    public T next() {
      if (index >= list.size()) {
        throw new IndexOutOfBoundsException();
      }
      T item = list.get(index);
      index++;
      return item;
    }
  }

  public static void main(String[] args) {
    AwsmArrayList<String> list = new AwsmArrayList<>();
    list.addFirst("pikachu");
    list.addLast("bulbasaur");
    list.addLast("mew");

    System.out.println(list.getFirst()); // pikachu
    System.out.println(list.get(1)); // bulbasaur
    list.remove(1);
    System.out.println(list.get(1)); // mew
    System.out.println(list.getLast()); // mew
    list.removeLast();
    System.out.println(list.getFirst()); // pikachu

    // let's break it
    AwsmArrayList<Integer> oops = new AwsmArrayList<>();
    for (int i = 0; i < 8; i++) {
      oops.addLast(i);
    }
    oops.addLast(8);
    System.out.println(oops.get(8));
  }
}
