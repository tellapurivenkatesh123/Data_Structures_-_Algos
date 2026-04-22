package org.venki;

public class Stackll {
    private class Node{
        private final int data;
        private Node next=null;
        Node(int data){
            this.data=data;
        }
    }
    private Node head;
    private Node tail;
    private int length;

    public void insert(int data){
        Node newnode=new Node(data);
        if(head==null){
            head=tail=newnode;
            length++;
            return;
        }
        newnode.next=head;
        head=newnode;
        length++;
    }

    public void delete(){
        if(head==null)throw new RuntimeException("stack is underflow");
        if(head==tail){head=tail=null;length--;return;}
        Node temp=head;
        while(temp.next!=tail){
            temp=temp.next;
        }
        temp.next=null;
        tail=temp;
        length--;
    }
    public int peek(){
        if(head==null)throw new RuntimeException("stack underflow");
        return head.data;
    }
    public int size(){
        return length;
    }

    public boolean isEmpty(){
        return head==null;
    }
    public int search(int key){
        int pos =0;
        if(head==null)throw new RuntimeException("stack is empty");
        Node temp=head;
        while(temp!=null){
            if(temp.data==key){
                return ++pos;
            }
            temp=temp.next;
            pos++;
        }
        return -1;
    }

    public void display(){
        if(head==null)throw new IllegalArgumentException("dtack is underflow");
        Node temp=head;
        while(temp!=null){
            System.out.println(temp.data);
            temp=temp.next;
        }
    }


}
