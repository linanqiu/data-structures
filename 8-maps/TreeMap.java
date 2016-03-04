
public class TreeMap<K extends Comparable<? super K>, V> implements Map<K, V> {
  private AvlTree<Pair<K, V>> tree;

  public TreeMap() {
    tree = new AvlTree<Pair<K, V>>();
  }

  @Override
  public void put(K key, V value) {
    tree.insert(new Pair<K, V>(key, value));
  }

  @Override
  public V get(K key) {
    Pair<K, V> found = tree.get(new Pair<K, V>(key, null));
    return found == null ? null : found.value;
  }
}
