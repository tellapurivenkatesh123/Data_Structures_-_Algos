package org.venki;

public class CircularLinkedlist {
    private class Node{
        private final int data;
        Node next=null;
        Node(int data){
            this.data=data;
        }
        public int getData(){
            return data;
        }
    }
    private Node head;
    private Node tail;
    private int length;

    public int insert(int data){
        Node newnode=new Node(data);
        if(head==null){
            head=tail=newnode;

        }
        else{
            tail.next=newnode;
            tail=newnode;

        }
        tail.next=head;
        length++;
        return length;
    }
    public int delete(){
        if(head==null)throw new IllegalArgumentException("list is empty");
        Node temp=head;
        if(head==tail){head=tail=null;return --length;}
        while(temp.next!=tail){
            temp=temp.next;
        }
        temp.next=head;
        tail=temp;
        length--;
        return length;
    }
    public void display(){
        if(head==null)throw new IllegalArgumentException("list is empty");
        Node temp=head;
        do{
            System.out.println(temp.data);
            temp=temp.next;
        }
        while(temp!=head);

    }

    public boolean search(int key) {
        if (head == null) throw new IllegalArgumentException("list is empty");
        Node temp=head;
        do{
            if(temp.data==key)return true;
            temp=temp.next;
        }while(temp!=head);
        return false;
    }
    public int getSize(){
   return length;
}

}
