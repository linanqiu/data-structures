
public class AwsmLinkedStack<T> implements AwsmStack<T> {
  private AwsmLinkedList<T> list;

  public AwsmLinkedStack() {
    list = new AwsmLinkedList<>();
  }

  @Override
  public void push(T item) {
    list.addFirst(item);
  }

  @Override
  public T pop() {
    T data = list.getFirst();
    list.removeFirst();
    return data;
  }

  @Override
  public int size() {
    return list.size();
  }
}
