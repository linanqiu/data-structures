import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class AwsmBST<T extends Comparable<? super T>> implements AwsmSearchTree<T>, Iterable<T> {

  private AwsmNode<T> root;
  private int size;

  public AwsmBST() {
    root = null;
    size = 0;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    toString(root, sb, 0);
    return sb.toString();
  }

  private void toString(AwsmNode<T> node, StringBuilder sb, int level) {
    if (node != null) {
      if (node.left != null) {
        toString(node.left, sb, level + 1);
      }

      for (int i = 0; i < level; i++) {
        sb.append("  ");
      }
      sb.append(node);
      sb.append("\n");

      if (node.right != null) {
        toString(node.right, sb, level + 1);
      }
    }
  }

  @Override
  public void add(T item) {
    root = add(root, item);
  }

  private AwsmNode<T> add(AwsmNode<T> node, T item) {
    if (node == null) {
      size++;
      return new AwsmNode<>(item, null, null);
    }

    if (item.compareTo(node.data) < 0) {
      node.left = add(node.left, item);
    } else if (item.compareTo(node.data) > 0) {
      node.right = add(node.right, item);
    } else {
      node.data = item;
    }

    return node;
  }

  @Override
  public T get(T item) {
    AwsmNode<T> getNode = get(root, item);
    return getNode != null ? getNode.data : null;
  }

  private AwsmNode<T> get(AwsmNode<T> node, T item) {
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

  @Override
  public boolean contains(T item) {
    return get(root, item) != null;
  }

  @Override
  public T remove(T item) {
    AwsmNode<T> removedNode = remove(root, item);
    return removedNode != null ? removedNode.data : null;
  }

  private AwsmNode<T> remove(AwsmNode<T> node, T item) {
    if (node == null) {
      return null;
    }

    if (item.compareTo(node.data) < 0) {
      node.left = remove(node.left, item);
    } else if (item.compareTo(node.data) > 0) {
      node.right = remove(node.right, item);
    } else {
      // removal
      if (node.left != null && node.right != null) {
        // two children
        node.data = findMin(node.right).data;
        node.right = remove(node.right, node.data);
      } else if (node.left != null) {
        // only left child
        node = node.left;
      } else if (node.right != null) {
        // only right child
        node = node.right;
      } else {
        // no child. remove this element itself.
        // allow null to be propagated to parent's child reference
        // setting that to null
        node = null;
      }
      size--;
    }
    return node;
  }

  private AwsmNode<T> findMin(AwsmNode<T> node) {
    if (node == null) {
      throw new NoSuchElementException();
    }
    while (node.left != null) {
      node = node.left;
    }
    return node;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public int height() {
    return height(root, 0);
  }

  private int height(AwsmNode<T> node, int height) {
    if (node == null) {
      return height;
    }

    int leftHeight = height(node.left, height) + 1;
    int rightHeight = height(node.right, height) + 1;

    return leftHeight > rightHeight ? leftHeight : rightHeight;
  }

  @Override
  public Iterator<T> iterator() {
    return new AwsmBSTIterator<T>(root);
  }

  public class AwsmNode<Q extends Comparable<? super Q>> {
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

  public class AwsmBSTIterator<Q extends Comparable<? super Q>> implements Iterator<Q> {

    private LinkedList<AwsmNode<Q>> list;

    public AwsmBSTIterator(AwsmNode<Q> root) {
      list = new LinkedList<>();
      infixTraverse(root);
    }

    public void infixTraverse(AwsmNode<Q> node) {
      if (node.left != null) {
        infixTraverse(node.left);
      }

      list.add(node);

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
}
