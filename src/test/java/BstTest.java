import org.venki.Bst;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class BstTest{
    @Test
    void testInsert(){
        Bst b=new Bst();
        b.insert(50);
        b.insert(20);
        b.insert(40);
        b.insert(10);
        b.insert(5);
        b.insert(60);
        b.insert(70);
        b.insert(80);
    }

    @Test
    void testSearch(){
        Bst b=new Bst();
        assertThrows(IllegalArgumentException.class,()->b.search(100));
        b.insert(50);
        b.insert(20);
        b.insert(40);
        b.insert(10);
        assertFalse(b.search(5));
        b.insert(5);
        b.insert(60);
        b.insert(70);
        b.insert(80);
        assertTrue(b.search(5));
    }

    @Test
    void testDelete(){
        Bst b=new Bst();
        assertThrows(IllegalArgumentException.class,()->b.delete(10));
        b.insert(50);
        b.insert(20);
        b.insert(40);
        b.insert(10);
        b.insert(30);
        b.insert(5);
        b.insert(60);
        b.insert(70);
        b.insert(80);
        assertEquals(60,b.delete(50));
    }

    @Test
    void testFindMin(){
        Bst b=new Bst();
        assertThrows(IllegalArgumentException.class,b::findmin);
        b.insert(50);
        b.insert(20);
        b.insert(40);
        b.insert(10);
        b.insert(5);
        b.insert(60);
        b.insert(70);
        b.insert(80);
        assertEquals(5,b.findmin());
    }

    @Test
    void testFindMax(){
        Bst b=new Bst();
        assertThrows(IllegalArgumentException.class,b::findmax);
        b.insert(50);
        b.insert(20);
        b.insert(40);
        b.insert(10);
        b.insert(5);
        b.insert(60);
        b.insert(70);
        b.insert(80);
        assertEquals(80,b.findmax());
    }

    @Test
    void testInorder(){
        Bst b=new Bst();
        assertThrows(IllegalArgumentException.class,b::inorder);
        b.insert(50);
        b.insert(20);
        b.insert(40);
        b.insert(10);
        b.insert(5);
        b.insert(60);
        b.insert(70);
        b.insert(80);
        b.inorder();
    }

    @Test
    void testPreorder(){
        Bst b=new Bst();
        assertThrows(IllegalArgumentException.class,b::preorder);
        b.insert(50);
        b.insert(20);
        b.insert(40);
        b.insert(10);
        b.insert(5);
        b.insert(60);
        b.insert(70);
        b.insert(80);
        b.preorder();
    }

    @Test
    void testPostorder(){
        Bst b=new Bst();
        assertThrows(IllegalArgumentException.class,b::postorder);
        b.insert(50);
        b.insert(20);
        b.insert(40);
        b.insert(10);
        b.insert(5);
        b.insert(60);
        b.insert(70);
        b.insert(80);
        b.postorder();
    }

    @Test
    void testHeight(){
        Bst b=new Bst();
        assertEquals(0,b.height());
        b.insert(50);
        b.insert(60);
        b.insert(70);
        b.insert(80);
        b.insert(40);
        b.insert(30);
        b.insert(20);
        b.insert(10);

        assertEquals(5,b.height());
        b.inorder();
    }
    @Test
    void testCountNodes(){
        Bst b=new Bst();
        assertEquals(0,b.countNodes());
        b.insert(50);
        b.insert(20);
        b.insert(40);
        b.insert(10);
        b.insert(5);
        b.insert(60);
        b.insert(70);
        b.insert(80);
        assertEquals(8,b.countNodes());
    }

    @Test
    void testLeafNodes(){
        Bst b=new Bst();
        assertThrows(IllegalArgumentException.class,b::countLeaves);
        b.insert(50);
        b.insert(40);
        b.insert(60);
        assertEquals(2,b.countLeaves());
    }

    @Test
    void testInorderSuccessor(){
        Bst b=new Bst();
        assertThrows(IllegalArgumentException.class,()->b.inorderSuccessor(50));
        b.insert(50);
        b.insert(60);
        b.insert(70);
        b.insert(55);
        assertEquals(55,b.inorderSuccessor(50));
    }
    @Test
    void testPredecessor(){
        Bst b=new Bst();
        assertThrows(IllegalArgumentException.class,()->b.predecessor(50));
        b.insert(50);
        b.insert(60);
        b.insert(70);
        assertEquals(-1,b.predecessor(50));
        b.insert(40);
        assertEquals(40,b.predecessor(50));
    }

    @Test
    void testIsBst(){
        Bst b=new Bst();
        assertThrows(IllegalArgumentException.class,b::isBst);
        b.insert(50);
        b.insert(40);
        b.insert(60);
        assertTrue(b.isBst());
        b.insert(70);
        assertTrue(b.isBst());
    }

    @Test
    void testLevelOrder(){
        Bst b=new Bst();
        assertThrows(IllegalArgumentException.class,()->b.lca(10,20));
        b.insert(50);
        b.insert(40);
        b.insert(30);
        b.insert(20);
        b.insert(10);
        b.insert(60);
        b.insert(70);
        b.insert(80);
        assertEquals(20,b.lca(10,20));
        assertEquals(50,b.lca(50,60));
    }

}