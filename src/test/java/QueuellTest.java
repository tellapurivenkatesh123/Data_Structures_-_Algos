import org.venki.Queuell;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class QueuellTest {
    @Test
    void testEnqueue(){
        Queuell q=new Queuell(3);
        q.enqueue(10);
        q.enqueue(20);
        assertEquals(q.enqueue(30),q.length());
        assertThrows(RuntimeException.class,()->q.enqueue(40));

    }
    @Test
    void testDeueue(){
        Queuell q=new Queuell(3);
        assertThrows(RuntimeException.class,q::dequeue);
        q.enqueue(1);
        q.enqueue(1);
        q.enqueue(2);
        assertEquals(1,q.dequeue());
    }

    @Test
    void testDisplay(){
        Queuell q=new Queuell(3);
        assertThrows(IllegalArgumentException.class,q::display);
        q.enqueue(1);
        q.enqueue(1);
        q.enqueue(2);
        q.display();
    }

    @Test
    void testSearch(){
        Queuell q=new Queuell(3);
        assertThrows(RuntimeException.class,()->q.search(3));
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        assertEquals(-1,q.search(10));
        assertEquals(2,q.search(2));
    }

    @Test
    void testpeek(){
        Queuell q=new Queuell(3);
        assertThrows(IllegalArgumentException.class,q::peek);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        assertEquals(1,q.peek());

    }
    @Test
    void testLength(){
        Queuell q=new Queuell(3);
        assertEquals(0,q.length());
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        assertEquals(3,q.length());
    }
    @Test
    void testIsEmpty(){
        Queuell q=new Queuell(3);
        assertTrue(q.isEmpty());
        q.enqueue(1);
        assertFalse(q.isEmpty());
    }

    @Test
    void testIsFull(){
        Queuell q=new Queuell(3);
        assertFalse(q.isFull());
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        assertTrue(q.isFull());
    }

}
