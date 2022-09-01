package TddArray;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.lang.Math.random;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class TddArrayListTest {
    private TddArrayList list;

    @BeforeEach
    void setUp(){
        list = new TddArrayList();
    }

    @Test
    void implementsList() {
        List<String> list = new TddArrayList<>();
    }

    @Test
    void emptyListHasSizeZeroTest(){
        TddArrayList<Object> list = new TddArrayList<>();
        assertTrue(list.isEmpty());
    }

    @Test
    void listWithOneElementHasSizeOneTest(){
        list.add(10);
        assertEquals(1, list.size());
    }

    @Test
    void canGetElementFromListTest(){
        list.add(8);
        list.add(9);
        list.add(7);
        assertEquals(9, list.get(1));
    }

    @Test
    void canAddElementAtTheBeginningOfListTest(){
        list.add(5);
        list.add(0, 4);
        assertEquals(4, list.get(0));
    }


}
