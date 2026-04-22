import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.venki.Stackll;
public class StackllTest {
    @Test
    void testInsert(){
        Stackll sl=new Stackll();
        sl.insert(1);
        sl.insert(2);
        sl.insert(3);
        assertEquals(3,sl.size());
    }
    @Test
    void testDelete(){
        Stackll sl=new  Stackll();
        assertThrows(RuntimeException.class,sl::delete);
        sl.insert(10);
        sl.insert(20);
        sl.delete();
        assertEquals(1,sl.size());
    }

    @Test
    void testPeek(){
        Stackll sl=new Stackll();
        assertThrows(RuntimeException.class,sl::peek);
        sl.insert(1);
        sl.insert(2);
        sl.insert(3);
        assertEquals(3,sl.peek());
    }
    @Test
    void testSize(){
        Stackll sl=new Stackll();
        sl.insert(10);
        sl.insert(20);
        sl.insert(30);
        assertEquals(3,sl.size());
    }

    @Test
    void testIsEmpty(){
        Stackll sl=new Stackll();
        assertTrue(sl.isEmpty());
        sl.insert(10);
        assertFalse(sl.isEmpty());
    }
    @Test
    void testDisplay(){
        Stackll sl=new Stackll();
        assertThrows(IllegalArgumentException.class,sl::display);
        sl.insert(10);
        sl.insert(20);
        sl.display();
    }
    @Test
    void testSearch(){
        Stackll sl =new Stackll();
        sl.insert(10);
        sl.insert(2);
        sl.insert(3);
        assertEquals(-1,sl.search(1));
        assertEquals(1,sl.search(3));
    }
}
