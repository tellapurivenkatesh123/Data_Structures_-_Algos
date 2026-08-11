package org.venki;

public class Tries {
   public class Node{
       Node link[];
       boolean flag;

       public Node(){
           this.link=new Node[26];
           this.flag=false;
       }

       boolean containsKey(char ch){
            return link[ch-'a']!=null;
       }
       void put(char ch,Node node){
           link[ch-'a']=node;
       }
       Node get(char ch){
           return link[ch-'a'];
       }

       void setEnd(){
           flag=true;
       }

       boolean isEnd(){
           return flag;
       }

   }
   public static Node root;
    Tries(){
        root=new Node();

   }


   public void insert(String str){
        Node curr=root;
       for(int i=0;i<str.length();i++){
           char ch=str.charAt(i);
           if(!curr.containsKey(ch)){
               // Node node=new  Node();
                curr.put(ch,new Node());
           }
            curr=curr.get(ch);
       }
       curr.setEnd();

   }
   public boolean search(String str){
        Node curr=root;
        for(int i=0;i<str.length();i++){
            char ch =str.charAt(i);
            if(!curr.containsKey(ch))return false;

            curr=curr.get(ch);
        }
        return curr.isEnd();
   }

    public boolean startWith(String str){
        Node curr=root;
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(!curr.containsKey(ch)){
                return false;
            }
            curr=curr.get(ch);

        }
        return true;
    }

   public static void main(String []args){
        Tries obj=new Tries();
        obj.insert("hello");
        obj.insert("hell");
       System.out.println(obj.search("hel"));
       System.out.println(obj.startWith("hell"));
   }

}
