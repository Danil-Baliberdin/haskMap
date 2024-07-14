package MyHashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashMapImplTest {

    HashMapImpl<Integer,String> myMap;
    @BeforeEach
    void setUp() {
        myMap = new HashMapImpl<>();
    }

    @Test
    void size() {
        assertEquals(0, myMap.size());
        myMap.put(1,"1 value");
        assertEquals(1, myMap.size());
    }

    @Test
    void isEmpty() {
        assertEquals(true, myMap.isEmpty());
        myMap.put(1,"1 value");
        assertEquals(false, myMap.isEmpty());
    }

    @Test
    void containsKey() {
        myMap.put(1,"1 value");
        assertEquals(true, myMap.containsKey(1));
    }

    @Test
    void containsValue() {
        myMap.put(1,"1 value");
        assertEquals(true, myMap.containsValue("1 value"));
    }

    @Test
    void get() {
        myMap.put(1,"1 value");
        assertEquals("1 value", myMap.get(1));
    }

    @Test
    void put() {
        myMap.put(1,"1 value");
        assertEquals(true, myMap.containsKey(1));
        assertEquals(true, myMap.containsValue("1 value"));
        assertEquals("1 value", myMap.get(1));
    }

    @Test
    void remove() {
        myMap.put(1,"1 value");
        myMap.remove(1);
        assertEquals(false,myMap.containsKey(1));
    }
}