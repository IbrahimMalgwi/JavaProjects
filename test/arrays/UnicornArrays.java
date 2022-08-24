package unicornwimps.arrays;
import org.junit.jupiter.api.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class UnicornArrays {

    @Test
    void arrayTest(){
        int[] a = {11, 21, 3, 7, 60, 8, 10, 19, 18, 34, 57};
        int b[] = new int[34];
        for(int i = 0; i < 11; i++){
            assertTrue(b[i] == 0);
        }

       // int[] b = Arrays.copyOfRange(a, 0, 10);
        System.arraycopy(a, 0, b, 0, 11);
        for(int i = 0; i < a.length; i++){
            assertEquals(a[i], b[i]);
        }

    }
}
