import java.util.Iterator;

public class ALinkedListIterator<T> implements Iterator<T> {

  private ANode<T> current;

  public ALinkedListIterator(ANode<T> head) {
    current = head.next;
  }

  @Override
  public boolean hasNext() {
    return current != null;
  }

  @Override
  public T next() {
    T data = current.data;
    current = current.next;
    return data;
  }
}
