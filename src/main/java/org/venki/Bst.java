package org.venki;
import java.util.Queue;
import java.util.LinkedList;
public class Bst {
    public class Node{
        private int data;
        private Node left,right=null;
        Node(int data){
            this.data=data;
        }
    }
    private Node root;
    public void insert(int data){
        Node newnode=new Node(data);
        if(root==null) {root=newnode;return;}
        Node temp=root;
        Node parent=null;
        while(temp!=null){
            parent=temp;
            if(data<temp.data)temp=temp.left;
            else{
                temp=temp.right;
            }
        }
        if(data<parent.data){
            parent.left=newnode;
        }
        else{
            parent.right=newnode;
        }
    }
    public boolean search(int key){
        if(root==null)throw new IllegalArgumentException("tree is empty");
        Node temp=root;
        while(temp!=null){
            if(temp.data==key)return true;
            if(temp.data>key)temp=temp.left;
            else{
                temp=temp.right;
            }
        }
        return false;
    }

    public  int delete(int key) {
        if(root==null)throw new IllegalArgumentException("tree is empty");
        root=deleteRec(root,key);
        //if(node==null)return -1;
        //if(node.data!=key)return -1;
        return root.data;
    }
    public Node deleteRec(Node node,int key){
        if(node==null)return null;
        if(key<node.data){node.left=deleteRec(node.left,key);
        }
        else if(key>node.data)
        {node.right=deleteRec(node.right,key);
        }
        else{
            if(node.left==null && node.right==null){
                return null;
            }
            if(node.left==null){
                return node.right;
            }
            if(node.right==null){
                return node.left;
            }

            Node successor=findmin(node.right);
            node.data=successor.data;
            node.right=deleteRec(node.right,successor.data);

        }
        return node;
    }
    public int findmin(){
        if(root==null)throw new IllegalArgumentException("tree is empty");
        Node node=findmin(root);
        return node.data;
    }
    public Node findmin(Node node){
        while(node.left!=null){
            node=node.left;
        }
        return node;
    }
    public int findmax(){
        if(root==null)throw new IllegalArgumentException("tree is Empty");
        Node node=findmax(root);
        return node.data;
    }

    public Node findmax(Node node){
        while(node.right!=null){
            node=node.right;
        }
        return node;
    }
    public void inorder(){
        if(root==null)throw new IllegalArgumentException("tree is empty");
        inorderRec(root);

    }
    public void inorderRec(Node node){
        if(node==null)return;
        inorderRec(node.left);
        System.out.print(node.data+" ");
        inorderRec(node.right);
    }
    public void preorder(){
        if(root==null)throw new IllegalArgumentException("tree is empty");
        preorderRec(root);
    }
    public void preorderRec(Node node){
        if(node==null)return;
        System.out.print(node.data+" ");
        preorderRec(node.left);
        preorderRec(node.right);
    }
    public void postorder(){
        if(root==null)throw new IllegalArgumentException("tree is Empty ");
        postorderRec(root);
    }
    public void postorderRec(Node node){
        if(node==null)return;
        postorderRec(node.left);
        postorderRec(node.right);
        System.out.print(node.data+" ");
    }
    public int height(){
        if(root==null) return 0;
        return height(root);
    }

    public int height(Node node){
    if(node==null)return 0;
    int left=height(node.left);
    int right=height(node.right);
    return 1+Math.max(left,right);
    }

    public int countNodes(){
        if(root==null)return 0;
        return countNodes(root);
    }
    public int countNodes(Node node){
        if(node==null)return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    public int countLeaves(){
        if(root==null)throw new IllegalArgumentException("tree is Empty");
        return countLeafNodes(root);

    }

    public int countLeafNodes(Node node){
        if(node==null) return 0;
        if(node.left==null && node.right==null)
            return 1;
        return countLeafNodes(node.left)+countLeafNodes(node.right);
    }
    public int inorderSuccessor(int key){
        if(root==null)throw new IllegalArgumentException("tree is empty");
        Node curn=root;
        Node succ=null;
        while(curn!=null){
            if(key<curn.data){
                succ=curn;
                curn=curn.left;
            }
            else if(key>curn.data){
                curn=curn.right;
            }
            else{
                if(curn.right!=null){
                    Node temp=curn.right;
                    while(temp.left!=null)
                        temp=temp.left;
                    succ=temp;
                }
                break;
            }
        }
        if(succ==null) return -1;
    return succ.data;
    }

    public int predecessor(int key) {
        if (root == null) throw new IllegalArgumentException("tree is empty");
        Node curn = root;
        Node pred = null;
        while (curn != null) {
            if (key > curn.data) {
                pred = curn;
                curn = curn.right;
            } else if (key < curn.data) {
                curn = curn.left;
            } else {
                if (curn.left != null) {
                    Node temp= curn.left;
                    while (temp.right != null) {
                        temp=temp.right;
                    }
                    pred=temp;
                }
                break;
            }
        }
        if (pred==null)return -1;
        return pred.data;
    }

    public boolean isBst(){
        if(root==null)throw new IllegalArgumentException("tree is Empty");
        return isBst(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    public boolean isBst(Node node,int min,int max){
        if(node==null)return true;
        if(node.data<=min || node.data>=max)return false;

        return isBst(node.left,min,node.data) && isBst(node.right,node.data,max);
    }
    public void levelOrder(){
        if(root==null)throw new IllegalArgumentException("tree is empty");
        Queue <Node> q= new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node node=q.poll();
            System.out.print(node.data+" ");
            if(node.left!=null)q.add(node.left);
            if(node.right!=null)q.add(node.right);
        }
    }

    public int lca(int n1,int n2){//least common ancestor;
        if(root==null)throw new IllegalArgumentException("tree  is Empty");
        Node node= Lca(root,n1,n2);
        return node.data;
    }

    public Node Lca(Node node,int n1,int n2){
        while(node!=null){
            if(n1<node.data && n2<node.data)node=node.left;
            else if(n1>node.data && n2>node.data)node=node.right;
            else return node;
        }
        return null;
    }



}




