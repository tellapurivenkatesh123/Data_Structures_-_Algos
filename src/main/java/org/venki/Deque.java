package org.venki;
public class Deque<venki> {
    private final int size;
    private venki[] arr;
    private int front,rear=-1;
    private int count=0;

    public Deque(int size){
        this.size=size;
        arr= (venki[]) new Object[size];
    }

    public int insertAtFront(venki data){
        if(isFull())throw new RuntimeException("can't insert at front deque is overflow");
        if(isEmpty()){
            front=rear=0;
        }
        else {
            front = (front - 1 + size) % size;
        }
        arr[front]=data;
        return ++count;
    }

    public int insertAtRear(venki data){
        if(isFull())throw new RuntimeException("overflow");
        if(isEmpty()){
            front=rear=0;
        }
        else {
            rear = (rear + 1) % size;
        }
        arr[rear]=data;
        return ++count;
    }

    public boolean isFull(){
        return count==size;
    }

    public boolean isEmpty(){
        return count==0;
    }

    public venki deleteFront(){
        if(isEmpty())throw new RuntimeException("underflow");

        venki value=arr[front];
        if(front==rear){
            front=rear=-1;
        }
        else {
            front = (front + 1) % size;
        }
        count--;
        return value;
    }

    public venki deleteRear(){
        if(isEmpty())throw new RuntimeException("underflow");
        venki value=arr[rear];
        if(front==rear){
            front=rear=-1;
        }
        else {
            rear = (rear - 1 + size) % size;
        }
        count--;
        return value;
    }

    public int search(venki key){
        if(isEmpty())throw new RuntimeException("underflow");
        int i=front;
        int pos=0;
        while(true){
            if(arr[i]==key)return ++pos;
            if(i==rear)break;
            i=(i+1)%size;
            pos++;
        }
        return -1;
    }
    public void display(){
        if(isEmpty())throw new IllegalArgumentException("underflow");
        int i=front;
        while(true){
            System.out.println(arr[i]);
            if(i==rear)break;
            i=(i+1)%size;
        }
    }
    public venki getData(int pos){
        if(isEmpty()|| pos<0||pos>=count)throw new ArrayIndexOutOfBoundsException("array index out of bounds");
        return arr[(front+pos)%size];
    }

    public venki rearPeek(){
        if(isEmpty())throw new IllegalArgumentException("underflow");
        return arr[rear];
    }
    public venki frontPeek(){
        if(isEmpty())throw new IllegalArgumentException("underflow");
        return arr[front];
    }
    public int length(){
        return count;
    }

}