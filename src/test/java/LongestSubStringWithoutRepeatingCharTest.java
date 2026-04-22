import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.venki.LongestSubStringWithoutRepeatingChar;
public class LongestSubStringWithoutRepeatingCharTest {
    @Test
    void testlst(){
        LongestSubStringWithoutRepeatingChar l=new LongestSubStringWithoutRepeatingChar();
        int[] arr={0,2};
        assertArrayEquals(arr,l.lst("abcaad"));
    }
}
