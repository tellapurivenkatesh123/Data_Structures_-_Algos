import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.venki.Deque;
public class DequeTest {
    @Test
    void testInsertAtFront(){
        Deque<Integer> q=new Deque<>(4);
        //"<>" diamond operator
        //Left side: Integer tells Java the type.
        // Right side: <> lets the compiler infer it.
        assertEquals(1,q.insertAtFront(10));
        assertEquals(2,q.insertAtFront(20));
        assertEquals(3,q.insertAtFront(30));
        assertEquals(4,q.insertAtFront(40));
        assertThrows(RuntimeException.class,()->q.insertAtFront(10));
    }

    @Test
    void testInsertAtRear(){
        Deque<Integer> q=new Deque<>(4);
        assertEquals(1,q.insertAtFront(10));
        assertEquals(2,q.insertAtFront(20));
        assertEquals(3,q.insertAtFront(30));
        assertEquals(4,q.insertAtFront(40));
        assertThrows(RuntimeException.class,()->q.insertAtFront(10));
    }
    @Test
    void testDeleteFront(){
        Deque<Integer> q=new Deque<>(4);
        assertThrows(RuntimeException.class,q::deleteFront);
        q.insertAtFront(10);
        q.insertAtFront(2);
        q.insertAtRear(5);
        q.insertAtFront(1);
        assertEquals(1,q.deleteFront());
        assertEquals(2,q.deleteFront());
        assertEquals(10,q.deleteFront());
        assertEquals(5,q.deleteFront());
    }

    @Test
    void testDeleteRear(){
        Deque<Integer> q=new Deque<>(4);
        assertThrows(RuntimeException.class,q::deleteRear);
        q.insertAtFront(10);
        q.insertAtFront(2);
        q.insertAtRear(5);
        q.insertAtFront(1);
        assertEquals(5,q.deleteRear());
        assertEquals(10,q.deleteRear());
        assertEquals(2,q.deleteRear());
        assertEquals(1,q.deleteRear());
    }
    @Test
    void testRearPeek(){
        Deque<Integer> q=new Deque<>(4);
        assertThrows(IllegalArgumentException.class,q::rearPeek);
        q.insertAtFront(10);
        q.insertAtFront(2);
        q.insertAtRear(5);
        q.insertAtFront(1);
        assertEquals(5,q.rearPeek());
    }

    @Test
    void testFrontPeek(){
        Deque<Integer> q=new Deque<>(4);
        assertThrows(IllegalArgumentException.class,q::frontPeek);
        q.insertAtFront(10);
        q.insertAtFront(2);
        q.insertAtRear(5);
        q.insertAtFront(1);
        assertEquals(1,q.frontPeek());
    }
    @Test
    void testSearch(){
        Deque<Integer> q=new Deque<>(4);
        assertThrows(RuntimeException.class,()->q.search(10));
        q.insertAtFront(10);
        q.insertAtFront(100);
        q.insertAtRear(1000);
        assertEquals(2,q.search(10));
        assertEquals(-1,q.search(20));
    }
    @Test
    void testGetData(){
        Deque<Integer> q=new Deque<>(4);
        assertThrows(ArrayIndexOutOfBoundsException.class,()->q.getData(-1));
        q.insertAtFront(10);
        q.insertAtFront(100);
        q.insertAtRear(1000);
        assertEquals(1000,q.getData(2));
    }

    @Test
    void testLength() {
        Deque<Integer> q = new Deque<>(3);
        assertEquals(0,q.length());
        q.insertAtFront(1);
        q.insertAtFront(2);
        q.insertAtRear(10);
        assertEquals(3,q.length());
    }
    @Test
    void testDisplay(){
        Deque<Integer> q=new Deque<>(3);
        assertThrows(IllegalArgumentException.class,q::display);
        q.insertAtFront(10);
        q.insertAtFront(8);
        q.insertAtRear(4);
        q.display();
    }

}
