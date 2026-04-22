import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.venki.Graph;
class GraphsTest {
    @Test
    void insertTest(){
        Graph g=new Graph(6);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(1,5);
        g.addEdge(2,3);
        g.addEdge(2,5);
        g.addEdge(3,4);
        g.addEdge(3,5);
        g.addEdge(4,5);

        g.dfs(0);
    }
}
