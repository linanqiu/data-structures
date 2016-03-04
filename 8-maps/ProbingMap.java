
public class ProbingMap<K extends Comparable<? super K>, V> implements Map<K, V> {

  private Pair<K, V> table[];

  @SuppressWarnings("unchecked")
  public ProbingMap() {
    table = (Pair<K, V>[]) new Pair[7];
  }

  @Override
  public void put(K key, V value) {
    int hash = key.hashCode();
    if (hash < 0) {
      hash *= -1;
    }

    for (int i = 0; i < 100; i++) {
      int index = (hash + i) % table.length;

      if (table[index] == null) {
        table[index] = new Pair<K, V>(key, value);
        return;
      } else {
        if (table[index].key.equals(key)) {
          table[index].value = value;
          return;
        }
      }
    }

    throw new ArrayIndexOutOfBoundsException();
  }

  @Override
  public V get(K key) {
    int hash = key.hashCode();
    if (hash < 0) {
      hash *= -1;
    }

    for (int i = 0; i < 100; i++) {
      int index = (hash + i) % table.length;
      if (table[index].key.equals(key)) {
        return table[index].value;
      }
    }

    throw new ArrayIndexOutOfBoundsException();
  }

}
