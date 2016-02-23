import java.util.Iterator;

public class AwsmLinkedList<T> implements AwsmList<T>, Iterable<T> {

  private AwsmNode<T> head;
  private AwsmNode<T> tail;
  private int size;

  public AwsmLinkedList() {
    tail = new AwsmNode<>(null, null);
    head = new AwsmNode<>(null, tail);
    size = 0;
  }

  @Override
  public void addFirst(T item) {
    add(item, 0);
  }

  @Override
  public void addLast(T item) {
    tail.data = item;
    AwsmNode<T> newTail = new AwsmNode<>(null, null);
    tail.next = newTail;
    tail = newTail;
  }

  @Override
  public void add(T item, int index) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException();
    } else {
      AwsmNode<T> current = head;
      for (int i = 0; i < index; i++) {
        current = current.next;
      }
      AwsmNode<T> node = new AwsmNode<>(item, current.next);
      current.next = node;
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
      AwsmNode<T> current = head;
      for (int i = 0; i < index - 1; i++) {
        current = current.next;
      }
      // remove current.next
      current.next = current.next.next;
      size--;
    }
  }

  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    AwsmNode<T> current = head.next;
    while (current != null) {
      stringBuilder.append(current.data);
      stringBuilder.append(" ");
      current = current.next;
    }
    return stringBuilder.toString().trim();
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
      AwsmNode<T> current = head;
      for (int i = 0; i < index; i++) {
        current = current.next;
      }
      return current.data;
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
      AwsmNode<T> current = head;
      for (int i = 0; i < index; i++) {
        current = current.next;
      }
      current.data = item;
    }
  }

  @Override
  public Iterator<T> iterator() {
    return new AwsmLinkedListIterator<T>(head);
  }

  @Override
  public int size() {
    return size;
  }

  public class AwsmLinkedListIterator<AnotherT> implements Iterator<T> {
    public AwsmNode<T> current;

    public AwsmLinkedListIterator(AwsmNode<T> head) {
      current = head;
    }

    @Override
    public boolean hasNext() {
      // ie. you're beyond the last car
      return current == null;
    }

    @Override
    public T next() {
      T data = current.data;
      // go to the next car
      current = current.next;
      return data;
    }
  }

  public class AwsmNode<YetAnotherT> {
    public YetAnotherT data;
    public AwsmNode<YetAnotherT> next;

    public AwsmNode(YetAnotherT data, AwsmNode<YetAnotherT> next) {
      this.data = data;
      this.next = next;
    }
  }

  public static void main(String[] args) {
    AwsmLinkedList<Integer> list = new AwsmLinkedList<>();
    list.add(1, 0);
    list.add(2, 1);
    list.add(3, 1);
    System.out.println(list);
  }
}
