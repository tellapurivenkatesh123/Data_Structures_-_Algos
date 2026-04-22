package org.venki;

public class Queues {
    private final int size;
    private int[] arr;
    private int front=-1;
    private int rear=-1;
    public Queues(int size){
        this.size=size;
        arr=new int[size];
    }
    public void enqueue(int data){
        if(rear==size-1)throw new IllegalArgumentException("queue is full");
        arr[++rear]=data;
    }

    public  int dequeue(){
        if(front==rear)throw new IllegalArgumentException("queue is empty");
        return arr[++front];
    }

    public void display(){
        if(front==rear)throw new IllegalArgumentException("queue is empty");
        for(int i=front+1;i<=rear;i++) System.out.println(arr[i]);
    }

    public int peek(){
        if(front==rear)throw new IllegalArgumentException("Queue is Empty");
        return arr[front+1];
    }
    public int length(){
        return rear-front;
    }
    public int search(int key){
        if(front==rear)throw new IllegalArgumentException("queue is empty");
        for(int i=front+1;i<=rear;i++){
            if(arr[i]==key) return i-front;
        }
        return -1;
    }

}
