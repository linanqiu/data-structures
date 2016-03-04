
public class Pair<K extends Comparable<? super K>, V> implements Comparable<Pair<K, V>> {
  public K key;
  public V value;

  public Pair(K key, V value) {
    this.key = key;
    this.value = value;
  }

  @Override
  public int compareTo(Pair<K, V> o) {
    return key.compareTo(o.key);
  }
}
