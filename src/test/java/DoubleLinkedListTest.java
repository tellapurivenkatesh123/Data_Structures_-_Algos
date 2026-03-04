import org.venki.DoubleLinkedlist;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class DoubleLinkedListTest {
    @Test
    void testInsert(){
        DoubleLinkedlist dl=new DoubleLinkedlist();
        assertEquals(dl.insert(10),dl.getSize());
        assertEquals(dl.insert(11),dl.getSize());
        assertEquals(dl.insert(12),dl.getSize());

    }
    @Test
    void testInsertFirst(){
        DoubleLinkedlist dl=new DoubleLinkedlist();
        assertEquals(5,dl.insertFirst(5));
        assertEquals(6,dl.insertFirst(6));
        assertEquals(7,dl.insertFirst(7));

    }
    @Test
    void testInsertLast(){
        DoubleLinkedlist dl=new DoubleLinkedlist();
        assertEquals(5,dl.insertLast(5));
        assertEquals(6,dl.insertLast(6));
        assertEquals(7,dl.insertLast(7));
    }
    @Test
    void testInsertMiddle(){
        DoubleLinkedlist dl=new DoubleLinkedlist();
        assertThrows(IllegalArgumentException.class,()->dl.insertMiddle(1));
        dl.insert(1);
        dl.insert(2);
        assertEquals(dl.insertMiddle(100),dl.getSize());
    }
}
