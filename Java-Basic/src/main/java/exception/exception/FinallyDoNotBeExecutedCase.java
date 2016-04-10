package exception.exception;

/**
 * 当在try块或catch块中遇到return语句时，
 * finally语句块将在方法返回之前被执行。
 * 在以下4种特殊情况下，finally块不会被执行或会部分执行：
 * 1）在finally语句块中发生了异常，finally不会被【完全】执行，发生异常之前的部分会被执行。
 * 2）在前面的代码中用了System.exit()退出程序。
 * 3）程序所在的线程死亡。
 * 4）关闭CPU。
 * @author Tom
 *
 */
public class FinallyDoNotBeExecutedCase {
	public static void main(String args []){
		
		try{
			exceptionOccur();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		try{
			systemExit();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
    /**
     * 1）在finally语句块中发生了异常，finally不会被【完全】执行，发生异常之前的部分会被执行。
     */
    public static void exceptionOccur(){
    	System.out.println("-----exceptionOccur()-----");
    	try{
    	}catch(Exception e){
    	}
    	finally{
    		System.out.println("-----/exceptionOccur()-----");
    		int a = 1/0;
    		System.out.println("finally语句块里面！");
    	}
    	System.out.println("finally语句块后面！");
    }
  
    /**
     * 2）在前面的代码中(try块或catche块中)用了System.exit()退出程序。
     */
    public static void systemExit(){
    	System.out.println("-----systemExit()-----");
    	try{
    		int a = 1/0;
    	}catch(Exception e){
    		System.out.println("-----/systemExit()-----");
    		System.exit(1);
    	}
    	finally{
    		System.out.println("finally语句块里面！");
    	}
    	System.out.println("finally语句块后面！");
    }

}
