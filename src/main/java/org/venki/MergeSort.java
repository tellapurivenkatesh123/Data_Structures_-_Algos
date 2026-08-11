package org.venki;
import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    public int[] mergesort(int[] arr,int low,int high){
        if(low>=high) return new int[]{};
        int mid =(low+high)/2;
        mergesort(arr,low,mid);
        mergesort(arr,mid+1,high);

        return merge(arr,low,mid,high);
    }

    public int[] merge(int[] arr,int low,int mid,int high){
        List<Integer> list=new ArrayList<>();
        int left=low;
        int right=mid+1;

        while(left<=mid && right<=high){
            if(arr[left]<arr[right])
                list.add(arr[left++]);
            else
                list.add(arr[right++]);

        }
        while(left<=mid){
            list.add(arr[left++]);
        }

        while(right<=high){
            list.add(arr[right++]);
        }

        for(int i=low;i<=high;++i){
            arr[i]=list.get(i-low);
        }
        return arr;
    }

}
