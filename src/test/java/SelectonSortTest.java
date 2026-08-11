import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.venki.SelectionSort;
public class SelectonSortTest {
    SelectionSort s=new SelectionSort();
    int arr[]={1,2,3,4,5,6};
    int arr1[]={2,4,6,1,5,3};
    @Test
    void test(){
        assertArrayEquals(arr,s.selection_sort(arr1));
    }
}
