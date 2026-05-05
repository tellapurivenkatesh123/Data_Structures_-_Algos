package org.venki;

public class Tries {
    private class Node{
        private char[] arr;
        private char data;
        Node(char data){
            arr=new char[26];
            this.data=data;
        }
    }
}
