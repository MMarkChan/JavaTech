package sort;

public class QuickSort {

    public void sort(int arr[],int low,int high) {
        int l=low;
        int h=high;
        int pivot=arr[low];

        // 完成pivot一轮排序的条件，也就是pivot被移动到最终位置时，即pivot的左边全是小于它的值，右边全是大于它的值
        // l从左向右，h从右向左
        while(l<h){
            // 从数组右边向左遍历，直到找到比pivot小的元素为止
            while(l<h&&arr[h]>=pivot){
                // 跳过大于pivot的元素，并改变位置
                h--;
            }
            if(l<h){
                //如果当前h索引小于l索引，则交换元素
                int temp = arr[h];
                arr[h] = arr[l];
                arr[l] = temp;
            }

            // 数组从左边向右边遍历，直到找到比pivot大的元素为止
            while(l<h&&arr[l]<=pivot){
                l++;
            }
            if(l<h){
                int temp = arr[h];
                arr[h] = arr[l];
                arr[l] = temp;
            }
        }

        if(l>low)sort(arr,low,l);
        if(h<high)sort(arr,l+1,high);
    }

    public static void main(String [] args){
        int [] arr = {5,3,6,1,88,9,2,8,9};
        QuickSort qs = new QuickSort();
        qs.sort(arr,0,arr.length-1);
        for(int i : arr)
        System.out.print(" " + i);
    }

}


/**
 L  		   H
 ↓			   ↓
 5,3,6,1,9,2,8,9

 L		   H
 ↓		   ↓
 5,3,6,1,9,2,8,9    从右向左找到H处的值比L处值小

 L		   H
 ↓		   ↓
 2,3,6,1,9,5,8,9    交换值

     L	   H
     ↓	   ↓
 2,3,6,1,9,5,8,9    从左向右找到L处的值比H处值大

     L	   H
     ↓	   ↓
 2,3,5,1,9,6,8,9    交换值

     L H
     ↓ ↓
 2,3,5,1,9,6,8,9    从右向左找到H处的值比L处值小

     L H
     ↓ ↓
 2,3,1,5,9,6,8,9    交换值
 */


