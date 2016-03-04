
public interface AwsmSearchTree<T> {
  public void add(T item);

  public boolean contains(T item);

  public T remove(T item);

  public T get(T item);

  public int size();

  public int height();
}
