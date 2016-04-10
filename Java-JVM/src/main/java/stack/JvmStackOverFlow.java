package stack;

/**
 * Created by Mark on 2016/3/24.
 */
public class JvmStackOverFlow {
    private int stackLength=1;
    public void stackLeak() {
        stackLength++;
        stackLeak();
    }
    public static void main(String[]args) throws Throwable{
        JvmStackOverFlow sof=new JvmStackOverFlow();
        try{
            sof.stackLeak();
        }catch(Throwable e) {
            System.out.println("stack length： "+sof.stackLength);
            throw e;
        }
    }
}
