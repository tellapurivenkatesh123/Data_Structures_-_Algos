import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.venki.QuickSort;

public class QuickSortTest {
    QuickSort q=new QuickSort();
    int[] arr={1,2,3,4,5,6,7};
    int[] arr1={7,4,5,3,6,1,2};
    @Test
    void test(){
        assertArrayEquals(arr,q.quicksort(arr1,0,arr.length-1));
    }
}
