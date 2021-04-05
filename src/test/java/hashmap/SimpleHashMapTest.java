package hashmap;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleHashMapTest {

    private SimpleHashMap simpleHashMap;

    @Before
    public void setUp() throws Exception {
        simpleHashMap = getSimpleHashMap();
    }

    @Test
    public void put_whenKeyNotNull_thenReturnsIndex() {
        int resultIndex = simpleHashMap.put("Martin Angela", "Dwigth Schrute, +1 610 505 508");
        assertEquals(12, resultIndex);
    }

    @Test(expected = RuntimeException.class)
    public void put_whenKeyIsNull_thenThrowsException() {
        simpleHashMap.put(null, "anyString");
    }

    @Test
    public void get_whenKeyNotNull_thenReturnsValue() {
        String result = simpleHashMap.get("Halpert Jim");
        assertEquals("Pam Beesly, +1 610 505 506", result);
    }

    @Test(expected = RuntimeException.class)
    public void get_whenKeyIsNull_thenThrowsException() {
        simpleHashMap.get(null);
    }

    private SimpleHashMap getSimpleHashMap() {
        SimpleHashMap hashMap = new SimpleHashMap();
        hashMap.put("Scott Michael", "Holly Flax, +1 610 505 505");
        hashMap.put("Halpert Jim", "Pam Beesly, +1 610 505 506");
        hashMap.put("Beesly Pamela", "Helene Beesly, +1 610 505 507");
        return hashMap;
    }
}