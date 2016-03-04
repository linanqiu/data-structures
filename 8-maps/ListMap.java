import java.util.LinkedList;

public class ListMap<K extends Comparable<? super K>, V> implements Map<K, V> {
  private LinkedList<Pair<K, V>> list;

  public ListMap() {
    list = new LinkedList<Pair<K, V>>();
  }

  @Override
  public void put(K key, V value) {
    for (Pair<K, V> pair : list) {
      if (pair.key.equals(key)) {
        pair.value = value;
        return;
      }
    }
    list.add(new Pair<K, V>(key, value));
  }

  @Override
  public V get(K key) {
    for (Pair<K, V> pair : list) {
      if (pair.key.equals(key)) {
        return pair.value;
      }
    }
    return null;
  }
}
