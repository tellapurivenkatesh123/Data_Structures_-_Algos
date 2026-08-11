package org.venki;

public class Trie {
    private class Node{
         private Node link[];
         private int  cntEndwith;
         private int cntPrefix;

         public Node(){
             link=new Node[26];
             cntEndwith=0;
             cntPrefix=0;
         }
          void putChar(char ch,Node node){
             link[ch-'a']=node;
          }
          boolean containsKey(char ch){
             return link[ch-'a']!=null;
          }
          Node getChar(char ch){
             return link[ch-'a'];
          }
          void increaseEnd(){
             cntEndwith++;
          }
          void increasePrefix(){
             cntPrefix++;
          }

          void deleteEnd(){
             cntEndwith--;
          }
          void reducePrefix(){
             cntPrefix--;
          }
          int getEnd(){
             return cntEndwith;
          }
          int getPrefix(){
             return cntPrefix;
          }
    }
    public static Node root;
    public Trie(){
        root=new Node();
    }

    public void insert(String str){
        Node curr= root;
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(!curr.containsKey(ch)) {
                curr.putChar(ch, new Node());
            }
            curr=curr.getChar(ch);
            curr.increasePrefix();
        }
        curr.increaseEnd();
    }
    public int countWordsEqualTo(String str){
        Node curr=root;
        for(int i=0;i<str.length();i++){
            char ch =str.charAt(i);
            if(curr.containsKey(ch)){
                curr=curr.getChar(ch);
            }
            else{
                return 0;
            }
        }
        return curr.getEnd();
    }

    public int countPrefixEqualTo(String str){
        Node curr=root;
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(curr.containsKey(ch)){
                curr=curr.getChar(ch);
            }
            else{
                return 0;
            }
        }
        return curr.getPrefix();
    }
    public int delete(String str){
        Node curr=root;
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(curr.containsKey(ch)){
                curr=curr.getChar(ch);
            }
            else{
                return -1;
            }
        }
        curr=root;
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(curr.containsKey(ch)){
                curr=curr.getChar(ch);
                curr.reducePrefix();
            }
        }
        curr.deleteEnd();
        return curr.getEnd();
    }


    public static void main(String[] args){
        Trie obj=new Trie();
        obj.insert("hello");
        obj.insert("hello");
        obj.insert("hell");
        System.out.println(obj.countWordsEqualTo("hello"));
        System.out.println(obj.countPrefixEqualTo("hel"));
        System.out.println(obj.delete("hello"));
    }
}
