import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.venki.InsertionSort;

public class InsertionSortTest {

    InsertionSort i=new InsertionSort();
     int arr[]={1,2,3,4,5,6};
     int arr1[]={2,5,3,6,1,4};

     @Test
     void test(){
         assertArrayEquals(arr,i.insertion_sort(arr1));
     }

}
