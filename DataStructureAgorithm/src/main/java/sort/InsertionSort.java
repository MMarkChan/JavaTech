package sort;

import java.util.Objects;

public class InsertionSort {
    public void sort(int [] arr){
        if(Objects.isNull(arr)){
            throw new IllegalArgumentException("参数不合法！");
        }
        if(arr.length==1){
            return;
        }
        // 认为第0个元素是已经排好序的数组，所以从第二个元素开始对比
        for (int i=1;i<arr.length;i++){
            for (int k=i;k>0&&arr[k]<arr[k-1];k--){
                int temp = arr[k];
                arr[k]=arr[k-1];
                arr[k-1]=temp;
            }
        }
    }

    public static void main(String[] args){
        int [] arr = {3,2,5,6,1,6,8,9};
        InsertionSort sort = new InsertionSort();
        sort.sort(arr);
        for(int i : arr){
            System.out.print(i);
        }
    }
}
