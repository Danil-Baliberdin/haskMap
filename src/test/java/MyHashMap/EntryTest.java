package MyHashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EntryTest {
    Entry<Integer,String> myEntry;
    Entry<Integer,String> myEntry2;
    @BeforeEach
    void setUp() {
        myEntry = new Entry<>();
        myEntry2 = new Entry<>();
    }
    @Test
    void getKey() {
        myEntry.setKey(1);
        assertEquals(1,myEntry.getKey());
    }

    @Test
    void setKey() {
        myEntry.setKey(1);
        assertEquals(1,myEntry.getKey());
    }

    @Test
    void getVal() {
        myEntry.setVal("1");
        assertEquals("1",myEntry.getVal());
    }

    @Test
    void setVal() {
        myEntry.setVal("1");
        assertEquals("1",myEntry.getVal());
    }

    @Test
    void testEquals() {
        myEntry.setVal("1");
        myEntry.setKey(1);
        assertEquals(false,myEntry.equals(myEntry2));
        myEntry2.setVal("1");
        myEntry2.setKey(1);
        assertEquals(true,myEntry.equals(myEntry2));
    }
}