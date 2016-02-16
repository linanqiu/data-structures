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
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public T next() {
    // TODO Auto-generated method stub
    return null;
  }
}