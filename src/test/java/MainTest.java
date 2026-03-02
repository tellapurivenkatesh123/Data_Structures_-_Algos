import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.venki.Main;
public class MainTest {
    @Test
    void testadd(){
    assertEquals(5, Main.add(4,1));
    assertEquals(-3,Main.add(-1,-2));
}

}
