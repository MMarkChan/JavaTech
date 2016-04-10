package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Mark on 2016/3/29.
 */
public class NammingGroup {
    public static void main(String [] args){
        // 为组起名为mygroup
        Pattern regex = Pattern.compile("(?<mygroup>[ab3])");
        Matcher matcher = regex.matcher("6sabcsssfsfs33");
        String rs = matcher.replaceAll("${mygroup}9999,");
        System.out.println(rs);
    }
}
