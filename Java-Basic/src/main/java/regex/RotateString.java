package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Mark on 2016/3/29.
 */
public class RotateString {
    public static void main(String [] args){
        String s = rotateString("ABCDEFGH",8,4);
        System.out.println(s);
    }
    static String rotateString(String A, int n, int p) {
        char pchar = A.charAt(p);
        Pattern pattern = Pattern.compile("(?<p1>.+E)(?<p2>.+)");
        Matcher matcher = pattern.matcher(A);
        return matcher.group("p2");
    }
}
