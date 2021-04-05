package hashmap;

import lombok.Data;

import java.util.LinkedList;

public class SecondSimpleHashMap<V> {

    private final LinkedList<Entry<V>>[] array;

    public SecondSimpleHashMap() {
        array = new LinkedList[28];
    }


    public void put(String key, V value) {

        Entry<V> entry = new Entry<>(key, value);

        int index = hashFunction(key);


        if (array[index] == null) {
            array[index] = new LinkedList<>();
        }

        LinkedList<Entry<V>> entries = array[index];

        entries.add(entry);
    }

    public V get(String key) {

        int index = hashFunction(key);

        LinkedList<Entry<V>> entries = array[index];

        if (entries != null) {

            for (Entry<V> entry : entries) {
                if (entry.getKey().equals(key)) {
                    return entry.getValue();
                }

            }
        }

        return null;
    }

    private int hashFunction(String key) {

        if (key == null || key.isEmpty()) {
            throw new RuntimeException("Key cannot be null or empty");
        }
        return Math.abs(97 - key.toLowerCase().charAt(0));
    }

    @Data
    private static class Entry<V> {
        private String key;
        private V value;

        public Entry(String key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
