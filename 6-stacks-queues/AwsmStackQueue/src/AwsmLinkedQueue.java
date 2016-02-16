
public class AwsmLinkedQueue<T> implements AwsmQueue<T> {

  private AwsmLinkedList<T> list;

  public AwsmLinkedQueue() {
    list = new AwsmLinkedList<>();
  }

  @Override
  public void enqueue(T item) {
    list.addLast(item);
  }

  @Override
  public T dequeue() {
    T data = list.getFirst();
    list.removeFirst();
    return data;
  }

  @Override
  public int size() {
    return list.size();
  }
}
