package org.venki;

public class CircularQueue {
    private final int size;
    private int[] arr;
    private int front=-1;
    private  int rear=-1;

   public CircularQueue(int size){
        this.size=size;
        arr=new int[size];
    }
    public boolean isFull(){
        return (rear+1) % size==front;
    }
    public boolean isEmpty(){
        return front==-1;
    }

    public void enqueue(int data){
        if(isFull()){
            throw new IllegalStateException("queue is full");
        }
        if(isEmpty()){
            front=rear=0;
        }
        else {
            rear = (rear + 1) % size;
        }
        arr[rear]=data;
    }

    public int dequeue(){
        if(isEmpty()){
            throw new IllegalStateException("queue is empty");
        }
        int value=arr[front];
        if(front==rear){
            front=rear=-1;
        }else{
            front=(front+1)%size;
        }
        return value;
    }

    public int search(int key){
        if(isEmpty())throw new IllegalStateException("queue is Empty");
        int i=front;
        while(true){
            if(arr[i]==key)return i;
            if(i==rear)break;
            i=(i+1)%size;
        }
        return -1;
    }

    public void display(){
       if(isEmpty())throw new IllegalStateException("is empty");
       int i=front;
       while(true){
           System.out.println(arr[i]);
           if(i==rear)break;
           i=(i+1)%size;
       }
    }

    public int length(){
        if(isEmpty())return 0;
        return ((rear-front+size) % size + 1) ;
    }
    public int peek(){
       if(front==-1)throw new IllegalStateException("is empty");
       return arr[front];
    }
}
