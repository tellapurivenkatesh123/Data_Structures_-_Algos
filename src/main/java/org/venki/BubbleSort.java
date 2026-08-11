package org.venki;

public class BubbleSort {

    public int[] bubble_sort(int[] arr){
        for(int i=0;i<arr.length;++i){
            for(int j=i+1;j<arr.length;++j){
                if(arr[j]<arr[i]){
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        return arr;
    }
}
