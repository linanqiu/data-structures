import java.util.Iterator;

public class TestList {
  public static void main(String[] args) {
    ALinkedList<Integer> listA = new ALinkedList<>();
    for (int i = 0; i < 10; i++) {
      listA.addFirst(i);
    }

    Iterator<Integer> ite = listA.iterator();

    while (ite.hasNext()) {
      System.out.println(ite.next());
    }
  }
}
