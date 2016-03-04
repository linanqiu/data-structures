import java.util.Iterator;
import java.util.LinkedList;

public class AwsmTree<T> implements Iterable<T> {
  private AwsmNode<T> parent;

  public AwsmTree(AwsmNode<T> parent) {
    this.parent = parent;
  }

  public String prefix() {
    StringBuilder sb = new StringBuilder();
    prefix(parent, sb);
    return sb.toString().trim();
  }

  private void prefix(AwsmNode<T> node, StringBuilder sb) {
    sb.append(node);
    sb.append(" ");

    if (node.left != null) {
      prefix(node.left, sb);
    }

    if (node.right != null) {
      prefix(node.right, sb);
    }
  }

  public String infix() {
    StringBuilder sb = new StringBuilder();
    infix(parent, sb);
    return sb.toString().trim();
  }

  private void infix(AwsmNode<T> node, StringBuilder sb) {
    if (node.left != null) {
      infix(node.left, sb);
    }

    sb.append(node);
    sb.append(" ");

    if (node.right != null) {
      infix(node.right, sb);
    }
  }

  public String postfix() {
    StringBuilder sb = new StringBuilder();
    postfix(parent, sb);
    return sb.toString().trim();
  }

  private void postfix(AwsmNode<T> node, StringBuilder sb) {
    if (node.left != null) {
      postfix(node.left, sb);
    }

    if (node.right != null) {
      postfix(node.right, sb);
    }

    sb.append(node);
    sb.append(" ");
  }

  public String prefixStack() {
    StringBuilder sb = new StringBuilder();

    LinkedList<AwsmNode<T>> stack = new LinkedList<>();
    stack.push(parent);

    while (!stack.isEmpty()) {
      AwsmNode<T> current = stack.pop();
      sb.append(current);
      sb.append(" ");

      if (current.left != null) {
        stack.push(current.left);
      }

      if (current.right != null) {
        stack.push(current.right);
      }
    }

    return sb.toString().trim();
  }

  public String breadthFirst() {
    StringBuilder sb = new StringBuilder();

    LinkedList<AwsmNode<T>> queue = new LinkedList<>();
    queue.addFirst(parent);

    while (!queue.isEmpty()) {
      AwsmNode<T> current = queue.removeLast();
      sb.append(current);
      sb.append(" ");

      if (current.left != null) {
        queue.addFirst(current.left);
      }

      if (current.right != null) {
        queue.addFirst(current.right);
      }
    }

    return sb.toString().trim();
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    toString(parent, sb, 0);
    return sb.toString().trim();
  }

  private void toString(AwsmNode<T> node, StringBuilder sb, int level) {
    for (int i = 0; i < level; i++) {
      sb.append("  ");
    }
    sb.append(node);
    sb.append("\n");

    if (node.left != null) {
      toString(node.left, sb, level + 1);
    }

    if (node.right != null) {
      toString(node.right, sb, level + 1);
    }
  }

  @Override
  public Iterator<T> iterator() {
    return new AwsmTreeIterator<T>(parent);
  }

  public class AwsmTreeIterator<Q> implements Iterator<Q> {

    private LinkedList<AwsmNode<Q>> list;

    public AwsmTreeIterator(AwsmNode<Q> parent) {
      list = new LinkedList<>();
      prefixTraverse(parent);
    }

    public void prefixTraverse(AwsmNode<Q> node) {
      list.add(node);
      if (node.left != null) {
        prefixTraverse(node.left);
      }
      if (node.right != null) {
        prefixTraverse(node.right);
      }
    }

    @Override
    public boolean hasNext() {
      return !list.isEmpty();
    }

    @Override
    public Q next() {
      return list.removeFirst().data;
    }
  }

  public static class AwsmNode<Q> {
    public Q data;
    public AwsmNode<Q> left;
    public AwsmNode<Q> right;

    public AwsmNode(Q data, AwsmNode<Q> left, AwsmNode<Q> right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }

    public String toString() {
      return data.toString();
    }
  }

  public static void main(String[] args) {
    // let's make grandchildren!
    AwsmNode<String> grandChild1 = new AwsmNode<>("g1", null, null);
    AwsmNode<String> grandChild2 = new AwsmNode<>("g2", null, null);
    AwsmNode<String> grandChild3 = new AwsmNode<>("g3", null, null);
    AwsmNode<String> grandChild4 = new AwsmNode<>("g4", null, null);

    // let's make children, and assign them their children
    AwsmNode<String> child1 = new AwsmNode<>("c1", grandChild1, grandChild2);
    AwsmNode<String> child2 = new AwsmNode<>("c2", grandChild3, grandChild4);

    // let's make the parent, and assign it its children
    AwsmNode<String> parent = new AwsmNode<>("p1", child1, child2);

    AwsmTree<String> tree = new AwsmTree<>(parent);
    System.out.println(tree.prefix());
    System.out.println(tree.infix());
    System.out.println(tree.postfix());
    System.out.println(tree);

    System.out.println(tree.breadthFirst());

    for (String element : tree) {
      System.out.println(element);
    }
  }
}
