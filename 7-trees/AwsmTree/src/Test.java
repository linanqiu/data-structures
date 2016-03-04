public class Test {
  public static void main(String[] args) {
    BSTLazy<Integer> bst = new BSTLazy<>();
    System.out.println(bst);
    bst.add(10);
    bst.add(5);
    bst.add(16);
    bst.add(2);
    bst.add(7);
    bst.add(14);
    bst.add(19);

    System.out.println(bst);
    System.out.println(bst.contains(10));
    System.out.println(bst.contains(14));
    System.out.println(bst.contains(15));
    
    for(Integer i : bst) {
      System.out.print(i + ", ");
    }

    System.out.println(bst.remove(7));
    System.out.println(bst);
    System.out.println(bst.size());

    System.out.println(bst.height());

    bst.remove(2);
    bst.remove(14);
    bst.remove(19);
    System.out.println(bst);
    System.out.println(bst.size());
    System.out.println(bst.height());
  }
}
