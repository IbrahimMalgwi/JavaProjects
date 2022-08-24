package unicornwimps.arrays.turtle;
import com.uncornWimps.arrays.turtle.PenPosition;
import com.uncornWimps.arrays.turtle.Turtle;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class TurtleTest {
    private Turtle ijapa;

    @BeforeEach
    public void setUp(){
        ijapa = new Turtle();
    }

    @Test
    public void turtleHasPen(){
        assertNotNull(ijapa);
        assertEquals(0, ijapa.getxCoordinate());
        assertEquals(0, ijapa.getyCoordinate());
        assertNotNull(ijapa.getTurtlePen());
    }

    @Test
    public void turtlePenIsUp(){
        turtleHasPen();
        assertNotNull(ijapa.getTurtlePen().getPosition());
        assertEquals(PenPosition.UP, ijapa.getTurtlePen().getPosition());
    }

    @Test
    public void moveForward(){
        turtlePenIsUp();
        ijapa.moveForward(9);
        assertEquals(0, ijapa.getyCoordinate());
        assertEquals(8, ijapa.getxCoordinate());
    }
}
