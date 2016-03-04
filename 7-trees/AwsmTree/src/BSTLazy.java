import java.util.Iterator;
import java.util.LinkedList;

public class BSTLazy<T extends Comparable<? super T>> implements Iterable<T> {

  private NodeLazy<T> root;
  private int size;

  public BSTLazy() {
    root = null;
    size = 0;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    toString(root, sb, 0);
    return sb.toString();
  }

  private void toString(NodeLazy<T> node, StringBuilder sb, int level) {
    if (node != null) {
      if (node.right != null) {
        toString(node.right, sb, level + 1);
      }

      for (int i = 0; i < level; i++) {
        sb.append("  ");
      }

      sb.append(node.deleted ? "d" : node);
      sb.append("\n");

      if (node.left != null) {
        toString(node.left, sb, level + 1);
      }
    }
  }

  public void add(T item) {
    root = add(root, item);
  }

  private NodeLazy<T> add(NodeLazy<T> node, T item) {
    if (node == null) {
      size++;
      return new NodeLazy<>(item, null, null);
    }

    if (item.compareTo(node.data) < 0) {
      node.left = add(node.left, item);
    } else if (item.compareTo(node.data) > 0) {
      node.right = add(node.right, item);
    } else {
      node.data = item;
      node.deleted = false;
    }

    return node;
  }

  public T get(T item) {
    NodeLazy<T> getNode = get(root, item);
    // found node and not deleted
    return getNode != null && !getNode.deleted ? getNode.data : null;
  }

  private NodeLazy<T> get(NodeLazy<T> node, T item) {
    // we retrieve the node regardless of whether its deleted or not
    if (node == null) {
      return null;
    }

    if (item.compareTo(node.data) < 0) {
      return get(node.left, item);
    } else if (item.compareTo(node.data) > 0) {
      return get(node.right, item);
    } else {
      return node;
    }
  }

  public boolean contains(T item) {
    NodeLazy<T> getNode = get(root, item);
    // found node and not deleted
    return getNode != null && !getNode.deleted;
  }

  public T remove(T item) {
    NodeLazy<T> removedNode = remove(root, item);
    return removedNode != null ? removedNode.data : null;
  }

  private NodeLazy<T> remove(NodeLazy<T> node, T item) {
    if (node == null) {
      return null;
    }

    if (item.compareTo(node.data) < 0) {
      node.left = remove(node.left, item);
    } else if (item.compareTo(node.data) > 0) {
      node.right = remove(node.right, item);
    } else {
      // removal
      node.deleted = true;
      size--;
    }
    return node;
  }

  public T findMin() {
    NodeLazy<T> node = findMin(root);
    return node != null ? node.data : null;
  }

  private NodeLazy<T> findMin(NodeLazy<T> node) {
    if (node == null) {
      return null;
    }

    NodeLazy<T> leftMin = findMin(node.left);

    if (leftMin != null) {
      // left minimum node exists
      return leftMin;
    }
    // now the left minimum node is null
    // we check if current node is deleted.
    // if it is, we need to search right subtree
    // if not, we are at the minimum
    if (node.deleted) {
      return findMin(node.right);
    } else {
      return node;
    }
  }

  public int size() {
    return size;
  }

  @Override
  public Iterator<T> iterator() {
    return new AwsmBSTIterator<T>(root);
  }

  public class NodeLazy<Q extends Comparable<? super Q>> {
    public Q data;
    public NodeLazy<Q> left;
    public NodeLazy<Q> right;
    public boolean deleted = false;

    public NodeLazy(Q data, NodeLazy<Q> left, NodeLazy<Q> right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }

    public String toString() {
      return data.toString();
    }
  }

  public class AwsmBSTIterator<Q extends Comparable<? super Q>> implements Iterator<Q> {

    private LinkedList<NodeLazy<Q>> list;

    public AwsmBSTIterator(NodeLazy<Q> root) {
      list = new LinkedList<>();
      infixTraverse(root);
    }

    public void infixTraverse(NodeLazy<Q> node) {
      if (node.left != null) {
        infixTraverse(node.left);
      }

      if (!node.deleted) {
        list.add(node);
      }

      if (node.right != null) {
        infixTraverse(node.right);
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

  public static void main(String[] args) {
    BSTLazy<Integer> lazy = new BSTLazy<>();
    lazy.add(3);
    lazy.add(1);
    lazy.add(4);
    lazy.add(6);
    lazy.add(9);
    lazy.add(2);
    lazy.add(5);
    lazy.add(7);

    System.out.println(lazy);

    lazy.remove(4);

    System.out.println(lazy);
    System.out.println(lazy.contains(4));
    System.out.println(lazy.get(4));

    lazy.remove(1);

    System.out.println(lazy);
    System.out.println(lazy.findMin());
  }
}
