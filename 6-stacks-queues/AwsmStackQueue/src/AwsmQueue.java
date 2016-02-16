
public interface AwsmQueue<T> {

  public void enqueue(T item);

  public T dequeue();

  public int size();

}
