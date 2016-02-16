import java.util.Iterator;

public class AArrayListIterator<T> implements Iterator<T> {

  private AArrayList<T> list;
  private int currentPosition;

  public AArrayListIterator(AArrayList<T> list) {
    this.list = list;
    currentPosition = 0;
  }

  @Override
  public boolean hasNext() {
    return currentPosition < list.size();
  }

  @Override
  public T next() {
    T data = list.get(currentPosition);
    currentPosition++;
    return data;
  }

}
