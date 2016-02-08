
public class Test {
  public static void main(String[] args) {
    AwsmArrayList<Integer> listA = new AwsmArrayList<>();
    for (int i = 0; i < 100; i++) {
      listA.addLast(i);
    }
    AwsmArrayListIterator<Integer> listAIterator = new AwsmArrayListIterator<>(listA);
    while (listAIterator.hasNext()) {
      System.out.println(listAIterator.next());
    }

    AwsmArrayList<String> listB = new AwsmArrayList<>();
    listB.addLast("pikachu");
    listB.addLast("mew");
    listB.addLast("bulbasaur");
    AwsmArrayListIterator<String> listBIterator = new AwsmArrayListIterator<>(listB);
    while (listBIterator.hasNext()) {
      System.out.println(listBIterator.next());
    }
  }
}
