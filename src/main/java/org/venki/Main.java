package org.venki;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static int add(int a,int b){
        return a+b;
    }
    public static Long factorial(int n){
        if(n==0||n==1)return 1L;
        return n * factorial(n-1);
    }
}