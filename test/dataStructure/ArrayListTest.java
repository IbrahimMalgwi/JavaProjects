package dataStructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest {
    List list;

    @BeforeEach
    public void setup(){
        list = new ArrayList();
    }

    @Test
    public void newListIsEmptyTest(){
        List list = new ArrayList();
        assertTrue(list.isEmpty());
    }

    @Test
    public void addItemListIsNotEmptyTest(){
        List list = new ArrayList();
        list.add("G-String");
        assertFalse(list.isEmpty());
    }

    @Test
    public void addItemListIsNotEmpty_SizeIsOneTest(){
        List list = new ArrayList();
        list.add("G-String");
        assertFalse(list.isEmpty());
        assertEquals(1, list.size());
    }

    @Test
    public void addItemGetItemByIndex(){
        list.add("A-String");
        String savedItem = list.get(0);
        assertEquals("A-String", savedItem);
    }

    @Test
    public void addXYGetXYByIndexTest(){
        list.add("A-String");
        list.add("G-String");
        assertEquals("A-String", list.get(0));
        assertEquals("G-String", list.get(1));

    }

    @Test
    public void addTwoItemRemoveOneSizeIsOneTest(){
        list.add("A-String");
        list.add("G-String");
        list.remove(1);
        assertEquals(1, list.size());
        String deleteItem = list.get(1);
        assertNull(deleteItem);
    }

    @Test
    public void addTwoRemoveOneFineByIndexIsNullTest(){
        list.add("A-String");
        list.add("G-String");
        list.remove(1);
        assertEquals(1, list.size());
        String deleteItem = list.get(1);
        assertNull(deleteItem);
    }

    @Test
    public void addXContainsXrReturnTrueTest(){
        list.add("G-String");
        assertTrue(list.contains("G-String"));
    }




}