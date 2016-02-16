
public interface AwsmStack<T> {

  public void push(T item);

  public T pop();

  public int size();

}
