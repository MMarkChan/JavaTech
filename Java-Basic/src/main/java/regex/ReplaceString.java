package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static utils.CommonUtils.println;

/**
 * Created by Mark on 2016/3/29.
 */
public class ReplaceString {
    public static void main(String [] args){
        Pattern regex = Pattern.compile("([ab3])");
        Matcher matcher = regex.matcher("6sabcsssfsfs33");
        // 把所有捕获的组都替换为空串
        String rs = matcher.replaceAll("");
        System.out.println(rs);
    }
}
