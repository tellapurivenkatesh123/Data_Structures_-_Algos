import org.venki.Heap;
import static org.junit.jupiter.api.Assertions.*;
import  org.junit.jupiter.api.Test;
public class HeapTest {
    @Test
    void  testInsert(){
        Heap h = new Heap(5);
        h.insert(10);
        h.insert(30);
        h.insert(5);
        h.insert(4);
        h.insert(10);
        assertThrows(IllegalArgumentException.class,()->h.insert(50));
        h.display();
        assertEquals(4,h.peek());
    }

    @Test
    void testBuildHeap(){
        Heap h=new Heap(5);
        int [] arr={30,5,4,10,20,10};
        h.buildHeap(arr);
        h.display();
        assertEquals(4,h.peek());

    }

    @Test
    void testIsEmpty(){
        Heap h=new Heap(10);
        assertTrue(h.isEmpty());
        h.insert(30);
        h.insert(5);
        h.insert(4);
        h.insert(10);
        assertFalse(h.isEmpty());
    }

    @Test
    void testIsFull(){
        Heap h=new Heap(5);
        assertFalse(h.isFull());
        int[] arr ={10,20,30,40,50};
        h.buildHeap(arr);
        assertTrue(h.isFull());
    }

    @Test
    void testExtractMin(){
        Heap h=new Heap(5);
        assertThrows(IllegalArgumentException.class,h::extractMin);
        h.insert(30);
        h.insert(5);
        h.insert(4);
        h.insert(10);
        h.insert(10);
        assertEquals(4,h.extractMin());
        assertEquals(5,h.extractMin());
    }

    @Test
    void testPeek(){
        Heap h=new Heap(5);
        assertThrows(IllegalArgumentException.class, h::peek);
        h.insert(30);
        h.insert(5);
        h.insert(4);
        h.insert(10);
        h.insert(10);
        assertEquals(4,h.peek());
    }

    @Test
    void testDelete(){
        Heap h=new Heap(6);
        assertThrows(IllegalArgumentException.class,()->h.delete(2));
        h.insert(30);
        h.insert(5);
        h.insert(4);
        h.insert(10);
        h.insert(20);
        h.insert(10);
        h.display();
        assertEquals(10,h.delete(1));
        h.display();
    }

}
