import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.venki.Queues;
public class Queuestest {
    @Test
    void testEnqueue(){
        Queues q= new Queues(5);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        assertEquals(1,q.peek());
        q.enqueue(5);
        assertThrows(IllegalArgumentException.class,()->q.enqueue(5));
    }
    @Test
    void testDequeue(){
        Queues q=new Queues(3);
        assertThrows(IllegalArgumentException.class,q::dequeue);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        assertEquals(1,q.dequeue());
        assertEquals(2,q.peek());
    }
    @Test
    void testDisplay(){
        Queues q=new Queues(5);
        assertThrows(IllegalArgumentException.class,q::display);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.display();
        q.dequeue();
        assertEquals(2,q.length());
    }
    @Test
    void testPeek(){
        Queues q=new Queues(3);
        assertThrows(IllegalArgumentException.class,q::peek);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        assertEquals(1,q.peek());
    }
    @Test
    void testLength(){
        Queues q =new  Queues(3);
        assertEquals(0,q.length());
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        assertEquals(3,q.length());

    }
    @Test
    void testSearch(){
        Queues q= new Queues(3);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        assertEquals(2,2);
    }
}

