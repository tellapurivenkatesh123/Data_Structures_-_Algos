package org.venki;
import java.util.HashMap;
public class LongestSubStringWithoutRepeatingChar {

    public int[] lst(String str){
        HashMap<Character,Integer> map=new HashMap<>();
        int[] arr={0,0};
        int s=0;
        int max=0;
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);

            if(map.containsKey(str.charAt(i))){
                 s=Math.max(s,map.get(ch)+1);
            }
            map.put(ch,i);

            if(max<(i-s+1)){
                arr[0]=s;
                arr[1]=i;
                max=i-s+1;
            }

        }
        return arr ;
    }

}
