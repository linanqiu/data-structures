import java.util.Iterator;

public class ALinkedList<T> implements AList<T>, Iterable<T> {

  private ANode<T> head;
  private int size;

  public ALinkedList() {
    head = new ANode<>(null, null);
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
      throw new ArrayIndexOutOfBoundsException();
    } else {
      ANode<T> current = head;
      for (int i = 0; i < index; i++) {
        current = current.next;
      }

      ANode<T> newNode = new ANode<>(current.next, item);
      current.next = newNode;

      size++;
    }
  }

  @Override
  public T removeFirst() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public T removeLast() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public T remove(int index) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public T get(int index) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void set(T item, int index) {
    // TODO Auto-generated method stub

  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public Iterator<T> iterator() {
    return new ALinkedListIterator<>(head);
  }

}
