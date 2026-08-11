import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.venki.BubbleSort;
public class BubbleSortTest {
    BubbleSort b=new BubbleSort();
    int arr[]={1,2,3,4,5,6};
    int arr1[]={2,5,4,1,3,6};
    @Test
    void testbubblesort(){
        assertArrayEquals(arr,b.bubble_sort(arr1));
    }
}
