package org.venki;

public class Linkedlist {

    public static class Node{
        private int data;
        private Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }

        public int getData(){
            return data;
        }
    }
    public Node head;
    public Node tail;

    public Node insert(int data){
        Node newnode= new Node(data);
        if(head==null){
            head=tail=newnode;
        }
        else{
        tail.next=newnode;
        tail=tail.next;
        }
        return tail;
    }
    public Node insertFirst(int data){
        Node newnode=new Node(data);
        if(head==null){
            head=tail=newnode;
        }
        else{
            newnode.next=head;
            head=newnode;

        }
        return head;
    }
    public Node getHead(){
        return head;
    }
    public Node getTail(){
        return tail;
    }

}
