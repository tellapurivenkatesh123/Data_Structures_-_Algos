import org.venki.DoubleLinkedlist;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class DoubleLinkedListTest {
    @Test
    void testInsert() {
        DoubleLinkedlist dl = new DoubleLinkedlist();
        assertEquals(dl.insert(10), dl.getSize());
        assertEquals(dl.insert(11), dl.getSize());
        assertEquals(dl.insert(12), dl.getSize());

    }

    @Test
    void testInsertFirst() {
        DoubleLinkedlist dl = new DoubleLinkedlist();
        assertEquals(5, dl.insertFirst(5));
        assertEquals(6, dl.insertFirst(6));
        assertEquals(7, dl.insertFirst(7));

    }

    @Test
    void testInsertLast() {
        DoubleLinkedlist dl = new DoubleLinkedlist();
        assertEquals(5, dl.insertLast(5));
        assertEquals(6, dl.insertLast(6));
        assertEquals(7, dl.insertLast(7));
    }

    @Test
    void testInsertMiddle() {
        DoubleLinkedlist dl = new DoubleLinkedlist();
        assertThrows(IllegalArgumentException.class, () -> dl.insertMiddle(1));
        dl.insert(1);
        dl.insert(2);
        assertEquals(dl.insertMiddle(100), dl.getSize());
    }

    @Test
    void testInsertAt() {
        DoubleLinkedlist dl = new DoubleLinkedlist();
        assertThrows(IllegalArgumentException.class,()->dl.insertAt(-1,-1));
        dl.insert(1);
        dl.insert(2);
        assertEquals(dl.insertAt(3,2),dl.getSize());

    }
    @Test
    void testDeleteFirst(){
        DoubleLinkedlist dl=new DoubleLinkedlist();
        assertThrows(IllegalArgumentException.class, dl::deleteFirst);
        dl.insert(10);
        dl.insert(20);
        dl.insert(30);
        assertEquals(20,dl.deleteFirst());

    }
    @Test
    void testDeleteLast(){
        DoubleLinkedlist dl =new DoubleLinkedlist();
        assertThrows(IllegalArgumentException.class,dl::deleteLast);
        dl.insert(10);
        dl.insert(20);
        dl.insert(30);
        assertEquals(20,dl.deleteLast());
    }
    @Test
    void testDeleteAt(){
        DoubleLinkedlist dl=new DoubleLinkedlist();
        assertThrows(IllegalArgumentException.class,()->dl.deleteAt(-1));
        dl.insert(10);
        dl.insert(20);
        dl.insert(30);
        assertEquals(dl.deleteAt(2),dl.getSize());
    }
    @Test
    void testDisplay(){
        DoubleLinkedlist dl=new DoubleLinkedlist();
        assertThrows(IllegalArgumentException.class,dl::display);
        dl.insert(10);
        dl.insert(20);
        dl.insert(30);
        assertEquals(dl.display(),dl.getSize());
    }
}