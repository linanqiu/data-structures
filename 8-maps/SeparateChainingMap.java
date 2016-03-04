import java.util.LinkedList;

public class SeparateChainingMap<K extends Comparable<? super K>, V> implements Map<K, V> {
  private LinkedList<Pair<K, V>>[] table;

  @SuppressWarnings("unchecked")
  public SeparateChainingMap() {
    table = (LinkedList<Pair<K, V>>[]) new LinkedList[8];
    for (int i = 0; i < table.length; i++) {
      table[i] = new LinkedList<Pair<K, V>>();
    }
  }

  @Override
  public void put(K key, V value) {
    int hash = key.hashCode();
    int index = hash % table.length;
    if (index < 0) {
      index += table.length;
    }
    LinkedList<Pair<K, V>> list = table[index];

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
    int hash = key.hashCode();
    int index = hash % table.length;
    if (index < 0) {
      index += table.length;
    }
    LinkedList<Pair<K, V>> list = table[index];

    for (Pair<K, V> pair : list) {
      if (pair.key.equals(key)) {
        return pair.value;
      }
    }
    return null;
  }
}
