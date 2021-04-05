package hashmap;

import lombok.Data;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Objects;

public class ThirdSimpleHashMap<V> {

    private LinkedList<Entry<V>>[] array;
    private final float loadFactor;
    private int size;


    public ThirdSimpleHashMap() {
        array = new LinkedList[16];
        loadFactor = 0.75f;
    }

    public ThirdSimpleHashMap(float loadFactor) {
        this.loadFactor = loadFactor;
    }

    public void put(String key, V value) {

        if (size / (float) array.length > loadFactor) {
            resize();
        }

        Entry<V> entry = new Entry<>(key, value);

        int index = hashFunction(key);

        if (array[index] == null) {
            array[index] = new LinkedList<>();
        }

        LinkedList<Entry<V>> entries = array[index];

        entries.add(entry);
        size++;
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

    public int getCapacity() {
        return array.length;
    }

    public int getSize() {
        return size;
    }

    private int hashFunction(String key) {
        return (key == null) ? 0 : (Math.abs(key.hashCode() % array.length));
    }


    private void resize() {

        LinkedList<Entry<V>>[] tempArray = array;

        array = new LinkedList[(tempArray.length * 2)];
        size = 0;

        Arrays.stream(tempArray)
                .filter(Objects::nonNull)
                .flatMap(Collection::stream)
                .forEach(entry -> put(entry.getKey(), entry.getValue()));

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
