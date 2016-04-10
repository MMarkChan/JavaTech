package exception.exception;

/**
 * try、catch、finally语句块的执行顺序
 * @author Tom
 *
 */
public class TryCatchFinallyExecuteOrderTest {  
	public static void main(String args []){
		noExceptionOccur();
		try{
			noAplicableCatch();
		}catch(Exception e){
			e.printStackTrace();
		}
		hasAplicableCatch();
	}
  
    /**
     * 1)当try没有捕获到异常时,
     * try语句块中的语句逐一被执行，
     * 程序将跳过catch语句块，
     * 执行finally语句块和其后的语句；
     * 执行结果：
     * finally语句块里面！
	 * finally语句块后面！
     */
    public static void noExceptionOccur(){
    	System.out.println("-----noExceptionOccur()-----");
    	int a = 1,b=2;
    	try{
    		int c = a/b;
    	}catch(Exception e){
    		System.out.println("catch语句块里面！");
    	}
    	finally{
    		System.out.println("finally语句块里面！");
    	}
    	System.out.println("finally语句块后面！");
    	System.out.println("-----/noExceptionOccur()-----");
    }
    
    /**
     * 2)当try捕获到异常，没有处理此异常的catch语句块，
     * 当执行到某一条语句出现异常时，
     * 此异常将会抛给JVM处理，finally语句块里的语句还是会被执行，
     * 但finally语句块后的语句不会被执行；
     * 执行结果：
     * finally语句块里面！
	 * Exception in thread "main" java.lang.ArithmeticException: / by zero
     */
    public static void noAplicableCatch(){
    	System.out.println("-----noAplicableCatch()-----");
    	int a = 1,b=0;
    	try{
    		int c = a/b;
    	}finally{
    		System.out.println("finally语句块里面！");
    		System.out.println("-----/noAplicableCatch()-----");
    	}
    	System.out.println("finally语句块后面！");
    	
    }
    
    /**
     * 3)当try捕获到异常，有处理此异常的catch语句块，
     * 当执行到某一条语句出现异常时，
     * 程序将跳到catch语句块，并与catch语句块逐一匹配，
     * 找到与之对应的处理程序，
     * 其他的catch语句块将不会被执行，
     * 而try语句块中，出现异常之后的语句也不会被执行，
     * catch语句块执行完后，执行finally语句块里的语句，
     * 最后执行finally语句块后的语句；
     * 执行结果：
     * catch语句块里面！
	 * finally语句块里面！
	 * finally语句块后面！
     */
    public static void hasAplicableCatch(){
    	System.out.println("-----hasAplicableCatch()-----");
    	int a = 1,b=0;
    	try{
    		int c = a/b;
    	}catch(ArithmeticException e){
    		System.out.println("catch语句块里面！");
    	}
    	finally{
    		System.out.println("finally语句块里面！");
    	}
    	System.out.println("finally语句块后面！");
    	System.out.println("-----/hasAplicableCatch()-----");
    }
} 