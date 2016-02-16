
public class AwsmNode<T> {
  public T data;
  public AwsmNode<T> next;

  public AwsmNode(T data, AwsmNode<T> next) {
    this.data = data;
    this.next = next;
  }
}
