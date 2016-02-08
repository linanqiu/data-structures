import java.util.Iterator;

public interface AwsmList<T> {

  public void addFirst(T item);

  public void addLast(T item);

  public void add(T item, int index);

  public void removeFirst();

  public void removeLast();

  public void remove(int index);

  public T getFirst();

  public T getLast();

  public T get(int index);

  public void setFirst(T item);

  public void setLast(T item);

  public void set(T item, int index);

  public Iterator<T> iterator();
  
  public int size();
}
