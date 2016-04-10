package sort;

import org.junit.Test;

/**
 * Created by Mark on 2016/3/17.
 */
public class BubbleSortTest {
    @Test
    public void sort(){
        BubbleSort bs = new BubbleSort();
        int[] arr = {5,3,4,6,2,5};
        bs.sort(arr);
        for(int e : arr){
            System.out.print(" "+e);
        }
    }
}
