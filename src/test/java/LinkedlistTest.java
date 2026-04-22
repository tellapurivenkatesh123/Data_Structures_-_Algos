import org.venki.Linkedlist;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class LinkedlistTest {
    @Test
    void testInsert(){
        Linkedlist ls=new Linkedlist();

        assertEquals(ls.insert(11),ls.getHead());
        assertEquals(ls.insert(10),ls.getTail());
    }
    @Test
    void multipleInsert(){
        Linkedlist ls=new Linkedlist();
        ls.insert(11);
        ls.insert(12);
        ls.insert(13);
        assertEquals(11,ls.getHead().getData());
    }

    @Test
    void testFirstInsert(){
        Linkedlist ls=new Linkedlist();
        assertEquals(ls.insertFirst(10).getData(),ls.getHead().getData());
        assertEquals(ls.insert(0).getData(),ls.getTail().getData());
    }
    @Test
    void testNull(){
        Linkedlist ls=new Linkedlist();
        assertNull(ls.getHead(),"list is empty");
    }
    @Test
    void testInsertMiddle(){
        Linkedlist ls=new Linkedlist();
        ls.insert(10);
        ls.insert(20);
        ls.insert(30);
        assertEquals(ls.insertMiddle(25).getData(),ls.middle().getData());
        assertEquals(ls.insertMiddle(0).getData(),ls.evenMiddle().getData());
        assertEquals(ls.insertMiddle(2).getData(),ls.middle().getData());
        assertEquals(ls.insertMiddle(2).getData(),ls.evenMiddle().getData());
        assertEquals(ls.insertMiddle(225).getData(),ls.middle().getData());
        assertEquals(ls.insertMiddle(103).getData(),ls.evenMiddle().getData());
    }
    @Test
    void testSize(){
        Linkedlist ls =new Linkedlist();
        ls.insert(1);
        ls.insert(2);
        ls.insert(3);
        assertEquals(3,ls.getSize());
    }
    @Test
    void testInsertPos(){
        Linkedlist ls=new Linkedlist();
        assertThrows(IllegalArgumentException.class,()-> ls.insertAt(1,10));
        ls.insert(10);
        ls.insertAt(1,0);
        ls.insertAt(12,2);
    }
    @Test
    void testDelete(){
        Linkedlist ls=new Linkedlist();
        ls.insert(1);
        ls.insert(2);
        ls.insert(3);
        ls.deleteAt(2);
        assertEquals(1,ls.getHead().getData());
        assertEquals(3,ls.getTail().getData());
        assertEquals(2,ls.getSize());
    }
    @Test
    void testDeleteFirst(){
        Linkedlist ls=new Linkedlist();
        ls.insert(1);
        ls.insert(2);
        ls.insert(3);
        ls.insert(4);
        assertEquals(ls.deleteFirst(),ls.getSize());

    }
    @Test
    void testDeleteLast(){
        Linkedlist ls=new Linkedlist();
        ls.insert(1);
        ls.insert(2);
        ls.insert(3);
        assertEquals(ls.deleteLast(),ls.getSize());
    }
    @Test
    void testDisplay(){
        Linkedlist ls=new Linkedlist();
        ls.insert(1);
        ls.insert(2);
        ls.insert(3);
        assertEquals(3,ls.getSize());
        assertEquals(1,ls.getHead().getData());
        assertEquals(3,ls.getTail().getData());
        assertEquals(3,ls.display());
    }
    @Test
    void testSearch(){
        Linkedlist ls=new Linkedlist();
        assertThrows(IllegalArgumentException.class,()->ls.search(1));
        ls.insert(0);
        ls.insert(1);
        ls.insert(3);
        assertEquals(2,ls.search(1));

    }
    @Test
    void testIsEmpty(){
        Linkedlist ls=new Linkedlist();
        assertTrue(ls.isEmpty());
        ls.insert(1);
        assertFalse(ls.isEmpty());
        ls.deleteFirst();
        assertTrue(ls.isEmpty());

    }
    @Test
    void testReverse(){
        Linkedlist ls=new Linkedlist();
        ls.insert(10);
        ls.insert(20);
        ls.insert(30);
        ls.insert(40);
        assertEquals(ls.getTail().getData(),ls.reverse().getData());
    }


    }

