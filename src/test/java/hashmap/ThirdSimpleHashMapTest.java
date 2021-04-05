package hashmap;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ThirdSimpleHashMapTest {

    private ThirdSimpleHashMap<String> hashMap;

    @Before
    public void setUp() throws Exception {
        hashMap = getHashMap();
    }

    @Test
    public void put_whenKeyNotNull_thenPutValue() {
        hashMap.put("Martin Angela", "Dwigth Schrute, +1 610 505 508");
        String result = hashMap.get("Martin Angela");
        assertEquals("Dwigth Schrute, +1 610 505 508", result);
    }

    @Test
    public void get_whenKeyIsPresent_thenReturnsValue() {
        String result = hashMap.get("Halpert Jim");
        assertEquals("Pam Beesly, +1 610 505 506", result);
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

    @Test
    public void resize_whenManyEntries_thenDoubleCapacity() {
        fillMap();
        assertEquals(32, hashMap.getCapacity());
        assertEquals(14, hashMap.getSize());
    }

    private void fillMap() {
        hashMap.put("Anderson Roy", "Pam Beesly, +1 610 505 601");
        hashMap.put("Toby Flanderson", "ex wife, +1 610 505 602");
        hashMap.put("Kelly Kapoor", "Ryan Howard +1 610 505 603");
        hashMap.put("Creed Bratton", "Creed Bratton, +1 610 505 604");
        hashMap.put("Andy Bernard", "Broccoli Rob, +1 610 505 605");
        hashMap.put("Oskar Martinez", "State Senator, +1 610 505 606");
        hashMap.put("Dwigth Schrute", "Michael Scott, +1 610 505 607");
        hashMap.put("Martin Angela", "Dwigth Schrute, +1 610 505 608");
        hashMap.put("Stanley Hudson", "Terry Hudson, +1 610 505 609");
        hashMap.put("Phyllis Vans", "Bob Vance Vance Refrigeration, +1 610 505 806");
        hashMap.put("Ryan Howard", "Ms. Howard, +1 610 505 809");

    }

    private ThirdSimpleHashMap<String> getHashMap() {
        ThirdSimpleHashMap<String> hashMap = new ThirdSimpleHashMap<>();
        hashMap.put("Scott Michael", "Holly Flax, +1 610 505 505");
        hashMap.put("Halpert Jim", "Pam Beesly, +1 610 505 506");
        hashMap.put("Beesly Pamela", "Helene Beesly, +1 610 505 507");
        return hashMap;
    }
}