import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.venki.CircularQueue;
public class CircularQueuetest {
    @Test
    void testEnqueue(){
        CircularQueue q=new CircularQueue(3);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        assertThrows(IllegalStateException.class,()->q.enqueue(4));
    }
    @Test
    void testdequeue(){
        CircularQueue q=new CircularQueue(3);
        assertThrows(IllegalStateException.class,q::dequeue);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        assertEquals(1,q.dequeue());
    }
    @Test
    void testSearch(){
        CircularQueue q=new CircularQueue(3);
        assertThrows(IllegalStateException.class,()->q.search(1));
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        assertEquals(0,q.search(1));
    }
    @Test
    void testDisplay(){
        CircularQueue q=new CircularQueue(3);
        assertThrows(IllegalStateException.class,q::display);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.display();
    }
    @Test
    void testLength(){
        CircularQueue q=new CircularQueue(3);
        assertEquals(0,q.length());
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        assertEquals(3,q.length());
    }
    @Test
    void testPeek(){
        CircularQueue q=new CircularQueue(3);
        assertThrows(IllegalStateException.class,q::peek);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.dequeue();
        assertEquals(2,q.peek());
    }
    @Test
    void testIsEmpty(){
        CircularQueue q=new CircularQueue(3);
        assertTrue(q.isEmpty());
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        assertFalse(q.isEmpty());
    }

    @Test
    void testisFull(){
        CircularQueue q=new CircularQueue(3);
        assertFalse(q.isFull());
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        assertTrue(q.isFull());
    }

}
