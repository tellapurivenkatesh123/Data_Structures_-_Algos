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
}
