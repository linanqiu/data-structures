import java.util.Iterator;

public class AwsmLinkedList<T> implements AwsmList<T>, Iterable<T> {

  private AwsmNode<T> head;
  private int size;

  public AwsmLinkedList() {
    head = new AwsmNode<>(null, null);
    size = 0;
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
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int size() {
    return size;
  }

  public static void main(String[] args) {
    AwsmLinkedList<Integer> list = new AwsmLinkedList<>();
    list.add(1, 0);
    list.add(2, 1);
    list.add(3, 1);
    System.out.println(list);
  }
}
