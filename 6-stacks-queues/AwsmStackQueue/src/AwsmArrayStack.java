
public class AwsmArrayStack<T> implements AwsmStack<T> {

  private AwsmArrayList<T> list;

  public AwsmArrayStack() {
    list = new AwsmArrayList<>();
  }

  @Override
  public void push(T item) {
    list.addLast(item);
  }

  @Override
  public T pop() {
    T data = list.getFirst();
    list.removeLast();
    return data;
  }

  @Override
  public int size() {
    return list.size();
  }
}
