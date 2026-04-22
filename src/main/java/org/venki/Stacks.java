package org.venki;

public class Stacks {
    private final int size;
    private int[] arr;
    private int top=-1;

   public Stacks(int size){
        this.size=size;
        arr=new int[size];
    }


    public void  insert(int data){
        if(top==size-1)throw new RuntimeException("Stacks overflow");
        arr[++top]=data;

    }
    public int pop(){
        if(top==-1)throw new RuntimeException("Stacks underflow");
        return arr[top--];
    }
    public int peek(){
        if(top==-1)throw new RuntimeException("Stacks unnderflow");
        return arr[top];
    }
    public void display(){
        if(top==-1)throw new RuntimeException("Stackss is Empty");
        for(int i=top;i>=0;i--) System.out.println(arr[i]);
    }
    public int size(){
        return top+1;
    }
    public boolean isEmpty(){
        return top==-1;
    }
    public boolean isFull(){
        return top==size-1;
    }
}
