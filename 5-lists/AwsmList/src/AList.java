
public interface AList<T> {
  public void addFirst(T item);

  public void addLast(T item);

  public void add(T item, int index);

  public T removeFirst();

  public T removeLast();

  public T remove(int index);

  public T get(int index);

  public void set(T item, int index);

  public int size();
}
