import java.util.Iterator;

public class AwsmArrayListIterator<T> implements Iterator<T> {

  private int index;
  private AwsmArrayList<T> list;

  public AwsmArrayListIterator(AwsmArrayList<T> list) {
    this.list = list;
    index = 0;
  }

  @Override
  public boolean hasNext() {
    return index < list.size();
  }

  @Override
  public T next() {
    if (index >= list.size()) {
      throw new IndexOutOfBoundsException();
    }
    T item = list.get(index);
    index++;
    return item;
  }
}
