package Assignment.Array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Question1Test {
    @Test
    public void testThatArrayReturnLargestElement(){
        int [] array = {3,6,8,9,4};
        assertEquals(9,Question.LargestElement(array));
    }
    @Test
    public void testThatArrayDoesnotReturnElementThatIsNotTheLargest(){
        int [] array = {2,56,78,35,24,9};
        assertNotEquals(2,Question.LargestElement(array));
    }
    @Test
    public void testThatArrayElementArePrintedInReverse(){
        int [] array ={6,7,8,9,10};
        assertEquals("[10, 9, 8, 7, 6]",Question.arrayReverse(array));
    }
    @Test
    public void testThatAnArrayContainsAnElement(){
        int [] array = {1,2,3,4,5};
        assertTrue(Question.iscontains(array,5));
    }
    @Test
    public void testThatArrayDoesnotContainsElement(){
        int [] array = {1,2,3,4,5};
        assertFalse(Question.iscontains(array,10));
    }
    @Test
    public void testThatOddPositionArePrinted(){
        int [] array = {1,2,3,4,5};
        assertEquals("24",Question.oddPositionNumbers(array));
    }
    @Test
    public void testThatEvenPositionArePrinted(){
        int [] array = {1,2,3,4,5};
        assertEquals("135",Question.evenPosition(array));
    }
    @Test
    public void testThatStringIsPalindrome(){
        String value = "mom";
        assertTrue(Question.isPalindrome(value));
    }
    @Test
    public void testThatStringIsNotAPalindrome(){
        String value ="mango";
        assertFalse(Question.isPalindrome(value));

    }



}