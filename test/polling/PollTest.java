package polling;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PollTest {
    private Poll poll;

    @BeforeEach
    void setUp(){
        poll = new Poll();
    }

    @Test
    void calculateAverageTest(){
//        Given that
        int[] pollNumbers = {10, 20, 30, 40, 50};
//        When
        poll.calculateAverage(pollNumbers);
//        Check
        assertEquals(30, poll.getAverageRatings());
    }

    @Test
    void calculateHighestPointsTest(){
//        Given
        int[] pollNumbers = {10, 20, 30, 40, 50};
//        When
        int highestPoints = poll.getHighestPoint(pollNumbers);
//        Check
        assertEquals(50, highestPoints);
    }

    @Test
    void calculateLowestPointTest(){
//        Given
        int[] pollNumbers = {10, 20, 30, 40, 50};
//        When
        int lowestPoint = poll.getLowestPoint(pollNumbers);
//        Check
        assertEquals(10, lowestPoint);
    }

}