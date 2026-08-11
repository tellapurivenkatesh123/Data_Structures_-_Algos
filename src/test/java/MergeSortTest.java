import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.venki.MergeSort;
public class MergeSortTest {
    MergeSort m=new MergeSort();
    int[] arr={1,2,3,4,5,6};
    int[] arr1={3,6,1,2,5,4};
    @Test
    void test(){
        assertArrayEquals(arr,m.mergesort(arr1,0,arr.length-1));
    }
}
