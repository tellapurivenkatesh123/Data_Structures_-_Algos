package org.venki;

public class DoubleLinkedlist {
    private class Node{
        private final int data;
        public Node next=null;
        public Node prev=null;
        Node(int data){
           this.data=data;
        }
        public int getdata(){
            return data;
        }
    }
    private Node head;
    private Node tail;
    private int length=0;

    public int insert(int data){
        Node newnode=new Node(data);
        if(head==null){
            head=newnode;
            tail=head;
            length++;
            return length;
        }
        else{
            tail.next=newnode;
            newnode.prev=tail;
            tail=newnode;
            length++;
        }
        return length;
    }
    public int insertMiddle(int data){
        Node newnode=new Node(data);
        if(head==null|| getSize()<=1 )throw new IllegalArgumentException("invalid");
        else{
            Node fast=head.next;
            Node slow=head;
            while(fast!=null && fast.next!=null){
                slow=slow.next;
                fast=fast.next.next;
            }
            newnode.next=slow.next;
            newnode.prev=slow;
            slow.next=newnode;
            newnode.next.prev=newnode;
            length++;

        }
        return length;
    }

    public int insertFirst(int data){
        Node newnode=new Node(data);
        if(head==null){head=tail=newnode;return head.data;}
        newnode.next=head;
        head.prev=newnode;
        head=newnode;
        length++;
        return head.data;
    }


    public int insertLast(int data){
        Node newnode=new Node(data);
        if(head==null){head=tail=newnode;return tail.data;}
        newnode.prev=tail;
        tail.next=newnode;
        tail=newnode;
        length++;
        return tail.data;
    }

    public int insertAt(int data,int pos){
        if(head==null||pos<=0||pos>getSize()+1)throw new IllegalArgumentException("invalid position");
        if(pos==1){insertFirst(data);return length;}
        if(pos==length+1){insertLast(data);return length;}
        Node temp=head;
        for(int i=1;i<pos-1;i++){
            temp=temp.next;
        }
        Node newnode=new Node(data);
        newnode.next=temp.next;
        newnode.prev=temp;
        temp.next=newnode;
        newnode.next.prev=newnode;
        return ++length;
    }

    public int deleteFirst(){
        if(head==null)throw new IllegalArgumentException("list is empty");

        if(head==tail){head=tail=null;}
        else{ head=head.next;
        head.prev=null;}
        length--;
        return head.data;
    }
    public int deleteLast(){
        if(head==null)throw new IllegalArgumentException("list is empty");
        if(head==tail){head=tail=null;}
        else{
            tail=tail.prev;
            tail.next=null;
        }
        length--;
        return tail.data;
    }
public int deleteAt(int pos){
        if(head==null)throw new IllegalArgumentException("list is empty");
        Node temp=head;
        if(pos==1){deleteFirst();return length;}
        if(pos==getSize()){tail=tail.prev;tail.next=null;length--;return length;}
        for(int i=1;i<pos-1;i++){
            temp=temp.next;
        }
        temp.next=temp.next.next;
        temp.next.prev=temp;
        return --length;

}
public int display(){
        if(head==null)throw new IllegalArgumentException("list is Empty");
        Node temp=head;
        int count=0;
        while(temp!=null){
            System.out.print(temp.data+",");
            temp=temp.next;
            count++;
        }
        return count;
}


    public int getSize(){
        return length;
    }
}
