package thread.thunder;

import java.util.HashMap;
import java.util.Map;

/**
 * 思路：
 *
 */
public class DeleteChars {
    public static void main(String [] args){
        String str = "6sabcsssfsfs33";

        //method1(str);

        //method2(str);

        System.out.println((char)57);

    }

    private static void method1(){
        String str = "6sabcsssfsfs33";
        char [] arr = str.toCharArray();
        boolean []delChars = new boolean[256];
        delChars['a']=true;
        delChars['b']=true;
        delChars['3']=true;
        StringBuffer sb = new StringBuffer();
        for(char ch : arr){
            if(!delChars[ch]) sb.append(ch);
        }
        System.out.println(sb.toString());
    }

    private static void method2(String str){
        char [] arr = str.toCharArray();
        Map<Character,Boolean> delCharsMap = new HashMap<>();
        delCharsMap.put('a',true);
        delCharsMap.put('b',true);
        delCharsMap.put('3',true);
        StringBuffer sb = new StringBuffer();
        for(char ch : arr){
            if(!delCharsMap.get(ch).booleanValue()&&delCharsMap.get(ch)) sb.append(ch);
        }
        System.out.println(sb.toString());
    }
}
