
public class AwsmArrayQueue<T> implements AwsmQueue<T> {

  private AwsmArrayList<T> list;

  public AwsmArrayQueue() {
    list = new AwsmArrayList<>();
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
