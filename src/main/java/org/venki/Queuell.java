package org.venki;

public class Queuell {
    private final int size;
    private Node rear,front;
    private int length;
    public Queuell(int size){
        this.size=size;
    }
    private class Node{
    private final int data;
    private Node next=null;
        Node(int data){
            this.data=data;
        }
    }

    public int enqueue(int data){
        if(length==size)throw new RuntimeException("full");
        Node newnode=new Node(data);
        if(rear==null || length==0){
            front=rear=newnode;

        }
        else{
            rear.next=newnode;
            rear=newnode;
        }

        return ++length;
    }

    public int  dequeue(){
        if(front==null)throw new IllegalArgumentException("empty");
        int res=front.data;
        front=front.next;
        if(front==null)rear=null;
        length--;
        return res;
    }

    public void display(){
        Node temp=front;
        if(front==null) throw new IllegalArgumentException("empty");
        while(temp!=null){
            System.out.println(temp.data);
            temp=temp.next;
        }
    }

    public int length(){
        return length;
    }
    public int peek(){
        if(front==null)throw new IllegalArgumentException("empty");
        return front.data;
    }
    public boolean isFull(){
        return length==size;
    }


    public boolean isEmpty(){
        return length==0;
    }

    public int search(int key){
        if(front==null)throw new RuntimeException("queue is empty");
        int pos=0;
        Node temp=front;
        while(temp!=null){
            pos++;
            if(temp.data==key){
                return pos;
            }
            temp=temp.next;
        }
        return -1;
    }

}
