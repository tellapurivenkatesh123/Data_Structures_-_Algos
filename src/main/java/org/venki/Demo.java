package org.venki;
import java.util.*;
public class Demo {
    public void demo(){
        List<Integer> list=new ArrayList<>();
        list.add(0);
        list.add(10);
        list.add(2,200);
        list.add(3000);
        list.add(40000);
        System.out.println("list"+ " :"+ list);
        List<Integer> ls=new ArrayList<>();
        ls.addAll(list);
        System.out.println("ls :"+ ls);
        ls.addAll(5,list);
        System.out.println(ls);

        System.out.println("1 "+ls.contains(200));
        System.out.println("2 "+ls.containsAll(list));
        System.out.println("3 "+ new HashSet<>(ls).containsAll(list));
        System.out.println("4 "+list.equals(list));
        System.out.println("5 "+list.equals(list));
        list.forEach(x-> System.out.println(x));
        list.forEach(System.out::println);
        System.out.println("9 "+ls.getClass());
        System.out.println(ls.hashCode());
        System.out.println(list.hashCode());
        System.out.println(ls.isEmpty());
        //System.out.println(list.iterator());
        System.out.println(ls.indexOf(200));
        System.out.println(list.lastIndexOf(200));
        System.out.println(list.size());

    }
}
