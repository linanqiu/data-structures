
public class AwsmCircularQueue<T> implements AwsmQueue<T> {

  private T[] array;
  private int back;
  private int front;
  private int size;
  public static final int INITIAL_SIZE = 8;

  @SuppressWarnings("unchecked")
  public AwsmCircularQueue() {
    array = (T[]) new Object[INITIAL_SIZE];
    back = 0;
    front = 0;
    size = 0;
  }

  @Override
  public void enqueue(T item) {
    expand();
    array[back] = item;
    back = (back + 1) % array.length;
    size++;
  }

  @Override
  public T dequeue() {
    if (size == 0) {
      throw new IndexOutOfBoundsException();
    }
    T data = array[front];
    front = (front + 1) % array.length;
    size--;
    return data;
  }

  @SuppressWarnings("unchecked")
  private void expand() {
    if (size == array.length) {
      T[] newArray = (T[]) new Object[array.length * 2];
      for (int i = 0; i < size; i++) {
        newArray[i] = array[(front + i) % array.length];
      }
      array = newArray;
      front = 0;
      back = front + size;
    }
  }

  @Override
  public int size() {
    return size;
  }

  public static void main(String[] args) {
    AwsmCircularQueue<Integer> queue = new AwsmCircularQueue<>();

    for (int i = 0; i < 100; i++) {
      queue.enqueue(i);
    }

    for (int i = 0; i < 50; i++) {
      System.out.println(queue.dequeue());
    }

    for (int i = 0; i < 100; i++) {
      queue.enqueue(i);
    }

    while (queue.size() > 0) {
      System.out.println(queue.dequeue());
    }
  }
}
