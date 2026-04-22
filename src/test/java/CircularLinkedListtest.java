import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.venki.CircularLinkedlist;
public class CircularLinkedListtest {
    @Test
    public void testInsert(){
        CircularLinkedlist cl=new CircularLinkedlist();
        assertEquals(cl.insert(10),cl.getSize());
        cl.insert(20);
        cl.insert(30);
        cl.insert(40);
        assertEquals(cl.insert(50),cl.getSize());
    }
    @Test
    public void testDelete(){
        CircularLinkedlist cl=new CircularLinkedlist();
        assertThrows(IllegalArgumentException.class,cl::delete);
        cl.insert(10);
        cl.insert(20);
        cl.insert(30);
        assertEquals(cl.delete(),cl.getSize());
    }
    @Test
    public void testDisplay(){
        CircularLinkedlist cl=new CircularLinkedlist();
        assertThrows(IllegalArgumentException.class,cl::display);
        cl.insert(10);
        cl.insert(20);
        cl.insert(30);
        cl.display();
    }

    @Test
    public void testSearch(){
        CircularLinkedlist cl=new CircularLinkedlist();
        assertThrows(IllegalArgumentException.class,()->cl.search(10));
        cl.insert(10);
        cl.insert(20);
        cl.insert(30);
        cl.insert(40);
        assertFalse(cl.search(50));
        assertTrue(cl.search(30));
    }

    @Test
    public void testLength(){
        CircularLinkedlist cl=new CircularLinkedlist();
        assertEquals(0,cl.getSize());
        cl.insert(10);
        cl.insert(20);
        assertEquals(2,cl.getSize());
    }


}
