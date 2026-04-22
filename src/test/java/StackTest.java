import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.venki.Stacks;

public class StackTest {
    @Test
    void testInsert(){
        Stacks st= new Stacks(3);
        st.insert(10);
        st.insert(20);
        st.insert(40);
        assertEquals(3,st.size());
        assertThrows(RuntimeException.class,()->st.insert(50));

    }
    @Test
    void testPop(){
        Stacks st=new Stacks(3);
        assertThrows(RuntimeException.class,st::pop);
        st.insert(1);
        st.insert(2);
        st.insert(3);
        assertEquals(3,st.pop());
    }

    @Test
    void testPeek(){
        Stacks st=new Stacks(2);
        assertThrows(RuntimeException.class,st::peek);
        st.insert(1);
        st.insert(2);
        assertEquals(2,st.peek());
    }
    @Test
    void testDisplay(){
        Stacks st=new Stacks(4);
        assertThrows(RuntimeException.class,st::display);
        st.insert(10);
        st.insert(20);
        st.insert(30);
        st.insert(40);
        st.display();
        assertEquals(4,st.size());
    }

}
