package sort;

public class BubbleSort{
    public void sort(int[] a){
        int temp;
        for (int i = a.length - 1; i > 0; --i){
            /**
             * 下面的for循环每完成一遍，最大值都会冒泡到a[i]位置
             */
            for (int j = 0; j < i; ++j){
                if (a[j + 1] < a[j]){
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }
}