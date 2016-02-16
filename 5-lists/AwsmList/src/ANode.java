
public class ANode<T> {
  public ANode<T> next;
  public T data;

  public ANode(ANode<T> next, T data) {
    this.next = next;
    this.data = data;
  }
}
