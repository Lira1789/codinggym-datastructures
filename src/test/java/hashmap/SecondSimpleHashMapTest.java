package hashmap;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SecondSimpleHashMapTest {

    private SecondSimpleHashMap<String> hashMap;

    @Before
    public void setUp() throws Exception {
        hashMap = getHashMap();
    }

    @Test
    public void put_whenKeyNotNull_thenPutValue() {
        hashMap.put("Martin Angela", "Dwigth Shrute, +1 610 505 508");
        String result = hashMap.get("Martin Angela");
        assertEquals("Dwigth Shrute, +1 610 505 508", result);
    }

    @Test(expected = RuntimeException.class)
    public void put_whenKeyIsNull_thenThrowsException() {
        hashMap.put(null, "anyString");
    }

    @Test
    public void get_whenKeyNotNull_thenReturnsValue() {
        String result = hashMap.get("Halpert Jim");
        assertEquals("Pam Beesly, +1 610 505 506", result);
    }

    @Test(expected = RuntimeException.class)
    public void get_whenKeyIsNull_thenThrowsException() {
        hashMap.get(null);
    }

    @Test
    public void get_whenKeyNotPresent_thenReturnsNull() {
        String result = hashMap.get("Kevin Malone");
        assertNull(result);
    }

    @Test
    public void get_whenCollision_thenReturnsValue() {
        hashMap.put("Schrute Dwigth", "Scott Michael, +1 610 505 509");
        String result = hashMap.get("Scott Michael");
        assertEquals("Holly Flax, +1 610 505 505", result);
    }


    private SecondSimpleHashMap<String> getHashMap() {
        SecondSimpleHashMap<String> hashMap = new SecondSimpleHashMap<>();
        hashMap.put("Scott Michael", "Holly Flax, +1 610 505 505");
        hashMap.put("Halpert Jim", "Pam Beesly, +1 610 505 506");
        hashMap.put("Beesly Pamela", "Helene Beesly, +1 610 505 507");
        return hashMap;
    }
}