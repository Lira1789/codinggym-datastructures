package hashmap;

import lombok.Data;

@Data
public class SimpleHashMap {

    private String[] array = new String[28];

    public int put(String key, String value) {
        int index = hashFunction(key);
        array[index] = value;
        return index;
    }

    public String get(String key) {
        int index = hashFunction(key);
        return array[index];
    }

    private int hashFunction(String key) {
        if (key == null || key.isEmpty()) {
            throw new RuntimeException("Key cannot be null or empty");
        }
        return Math.abs(97 - key.toLowerCase().charAt(0));
    }
}
