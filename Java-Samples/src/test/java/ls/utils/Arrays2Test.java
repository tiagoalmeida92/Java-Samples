package ls.utils;

import java.util.Arrays;
import java.util.Random;
import org.junit.Test;
import static org.junit.Assert.*;

public class Arrays2Test {

    private static int[] getRandomInts(int len) {
        Random r = new Random();
        int[] res = new int[len];
        for(int i = 0 ; i<len ; ++i) {
            res[i] = r.nextInt();
        }
        return res;
    }
    
    private static int[] concat(int[] v1, int l1, int[] v2, int l2) {
        int[] res = new int[l1+l2];
        int ri = 0;
        for(int i = 0 ; i<l1 ; ++i) {
            res[ri++] = v1[i];
        }
        for(int i = 0 ; i<l2 ; ++i) {
            res[ri++] = v2[i];
        }
        return res;        
    }    
    
    @Test
    public void merge_output_is_sorted() {
        final int len = 10;
        
        // Arrange
        int[] v1 = getRandomInts(len);
        Arrays.sort(v1);
        int[] v2 = getRandomInts(len);
        Arrays.sort(v2);
                
        // Act
        int[] res1 = Arrays2.merge(v1, len, v2, len);
        
        // Assert
        int[] res2 = concat(v1, len, v2, len);
        Arrays.sort(res2);
        assertArrayEquals(res1, res2);        
    }    
}
