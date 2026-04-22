package org.venki;

public class Heap{
    int[] heap;
    int size;
    int capacity;
     public Heap(int capacity){
        this.capacity=capacity;
        heap=new int[capacity];
        size=0;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public  boolean isFull(){
        return size==capacity;
    }

    public int size(){
            return size;
    }

    public int left(int i){
        return 2*i+1;
    }

    public  int right(int i){
        return 2*i+2;
    }

    public void insert(int value){
        if(size==capacity)throw new IllegalArgumentException("overflow");
        heap[size]=value;
        int i=size;
        size++;
        heapifyUp(i);

    }
    private void heapifyUp(int i){
        while(i>0 && heap[(i-1)/2]>heap[i]){
            swap(i,(i-1)/2);
            i=(i-1)/2;
        }
    }
    private void swap(int i,int j){
        int temp=heap[i];
        heap[i]=heap[j];
        heap[j]=temp;
    }

    public void display() {
        for (int i=0;i<size;i++)
            System.out.println(heap[i] + ": "+ i);
        System.out.println();
    }

    public int peek(){
        if(isEmpty())throw new IllegalArgumentException("tree is empty");
        return heap[0];
    }
    public int extractMin(){
        if(isEmpty())throw new IllegalArgumentException("tree is Empty");
        int min=heap[0];
        heap[0]=heap[size-1];
        size--;
        heapifyDown(0);
        return min;
    }

    private void heapifyDown(int i){
        int small=i;
        int left=left(i);
        int right=right(i);
        if(left<size && heap[left]<heap[small])
            small=left;
        if(right<size && heap[right]<heap[small])
            small=right;

        if(small!=i){
            swap(i,small);
            heapifyDown(small);
        }

    }

    public void buildHeap(int[] arr){
         heap=arr;
         size=arr.length;
         for(int i=(size/2)-1;i>=0;i--){
             heapifyDown(i);
         }

    }


    public void sort(){
        int originalSize=size;
        for(int i=size-1;i>0;i--){
            swap(0,i);
            size--;
            heapifyDown(0);
        }
        size=originalSize;
    }

    public void decreaseKey(int i,int newValue){
         if(newValue>heap[i])throw new IllegalArgumentException("new value is greater");
         heap[i]=newValue;
         heapifyUp(i);
    }

    public void increaseKey(int i,int newValue){
         if(newValue<heap[i])throw new IllegalArgumentException("new value is smaller");
         heap[i]=newValue;
         heapifyDown(i);
    }

    public int delete(int i){
        if(i>=size||i<0){
            throw new IllegalArgumentException("invalid index");
        }
        int res=heap[i];
        heap[i]=heap[size-1];
        size--;
        heapifyDown(i);
        heapifyUp(i);
        return res;
    }
}