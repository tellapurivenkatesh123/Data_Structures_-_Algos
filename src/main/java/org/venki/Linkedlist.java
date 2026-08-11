package org.venki;

public class Linkedlist {

    public class Node{
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

    public Node insert(int data){
        Node newnode= new Node(data);
        if(head==null){
            head=tail=newnode;
            length=1;
        }
        else{
        tail.next=newnode;
        tail=tail.next;
        length++;
        }
        return tail;
    }
    public Node insertFirst(int data){
        Node newnode=new Node(data);
        if(head==null){
            head=tail=newnode;
            length=1;
        }
        else{
            newnode.next=head;
            head=newnode;
            length++;

        }
        return head;
    }
    public Node getHead(){
        return head;
    }
    public Node getTail(){
        return tail;
    }

    public Node insertMiddle(int data){
        Node newnode=new Node(data);
        if(head==null){
            head=tail=newnode;
            length=1;
        }
        else{
            if(head.next==null){
                head.next=newnode;
                tail=newnode;
                length++;
                return newnode;
            }
            Node slow=head;
            Node fast=head.next;

            while(fast!=null && fast.next!=null){
                slow=slow.next;
                fast=fast.next.next;

            }
            newnode.next=slow.next;
            slow.next =newnode;
            length++;

        }
        return newnode;
    }
    public Node middle(){

        if(head==null){
            return head;
        }
        else{
            if(head.next==null){
                return head;
            }
            Node fast=head.next;
            Node slow=head;
            while(fast!=null && fast.next!=null){
                slow=slow.next;
                fast=fast.next.next;
            }
            return slow.next;
        }
    }
    public Node evenMiddle(){

        if(head==null){
            return head;
        }
        else{
            if(head.next==null){
                return head;
            }
            Node fast=head;
            Node slow=head;
            while(fast!=null && fast.next!=null){
                slow=slow.next;
                fast=fast.next.next;
            }
            return slow;
        }
    }
    public int getSize(){
        return length;
    }
    public void insertAt(int data,int pos){
        Node newnode=new Node(data);
        if(head==null || pos<0 || pos>getSize()+1)  throw new IllegalArgumentException("Invalid position");

        Node temp=head;

            if(pos==0){
                insertFirst(data);
                return;

            }
            if(pos==length+1){insert(data);return;}
            else{

                for(int i=1;i<pos-1;i++){
                    temp=temp.next;
                }
                newnode.next=temp.next;
                temp.next=newnode;
                length++;
            }


    }
    public void deleteAt(int pos){
        if(head==null || pos<=0 || pos>getSize()) throw new IllegalArgumentException("invalid position");
        Node temp=head;
        if(pos==1){
            head=head.next;
            length--;
            if(head==null){tail=null;}
            return;
        }

        int count=1;
        while(count<pos-1){
            temp=temp.next;
            count++;
        }
        if(pos==length){temp.next=null;tail=temp;}
        else
        temp.next=temp.next.next;
        length--;
    }

    public int deleteFirst(){
        if(head==null)throw new IllegalArgumentException("list is  empty");
        head=head.next;
        length--;
        if(head==null){tail=null;}
        return length;
    }
    public int deleteLast(){
        if(head==null)throw new IllegalArgumentException("list is empty");
        if(head.next==null){
            head=tail=null;
            return --length;
        }
        Node temp=head;
        while(temp.next!=tail){
            temp=temp.next;
        }
        temp.next=null;
        tail=temp;
        return --length;
    }
    public int display(){
        if(head==null)throw new IllegalArgumentException("list is empty");
        Node temp=head;
        int count=0;
        while(temp!=null){
            System.out.printf(temp.data+",");
            count++;
            temp=temp.next;
        }
        return count;
    }
    public int search(int key){
        if(head==null)throw new IllegalArgumentException("list is empty");
        Node temp=head;

        while(temp!=null){
            int pos=+1;
            if(temp.data==key)return ++pos;
            temp=temp.next;
        }
        return -1;
    }

    public boolean isEmpty(){
        return length == 0;
    }

    public Node reverse(){
        if(head==null)throw new IllegalArgumentException("list is Empty");
        Node fast=null;
        Node current=head;
        Node prev=null;
        while(current!=null){
            fast=current.next;
            current.next=prev;
            prev=current;
            current=fast;
        }
        tail=head;
        head=prev;
        return head;
    }
    public Node sort(){
        if(head==null||head.next==null)return head;

        int count=0;
        Node curr=head;
        while(curr!=null){
            count++;
            curr=curr.next;
        }
        //sentinal node
        Node dummy=new Node(0);
        dummy.next=head;

        // bottom up merge
        for(int step=1;step<count;step *=2){
          Node prev=dummy;
          curr=dummy.next;
          while(curr!=null){
              Node head1=curr;
              Node head2=split(head1,step);

              curr=split(head2,step);

              prev.next=merge(head1,head2);

              while(prev.next!=null){
                  prev=prev.next;
              }
          }
        }

        return dummy.next;
    }
    private Node split(Node head,int size){
        if(head==null)return null;
        Node curr=head;
        for(int i=1;i<size && curr.next!=null;i++){
            curr=curr.next;
        }
        Node nextpart=curr.next;
        curr.next=null;
        return nextpart;
    }

    private Node merge(Node l1,Node l2){
        Node dummy=new Node(0);
        Node curr=dummy;
        while(l1!=null && l2!=null){
            if(l1.data<l2.data){
                curr.next=l1;
                l1=l1.next;
            }else{
                curr.next=l2;
                l2=l2.next;
            }
            curr=curr.next;
        }
        curr.next=(l1!=null)? l1:l2;
        return dummy.next;
    }

}
