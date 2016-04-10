package exception.exception;

/**
 * 注意由于捕获异常而产生的无限死循环
 * @author Tom
 *
 */
public class ExceptionCauseInfiniteLoop {
	public static void main(String [] args){
		String[] greeting = {"hello!","hello!!","hello!!!"};
		int i = 0;
		while(i<4){
			try{
				System.out.println(greeting[i]); // 当i=3时，发生数组下标越界异常，执行流程跳到catch块中，
												// i++这一语句永远得不到执行，
												// 导致while中的条件判断永远为true
				i++;
			}catch(ArrayIndexOutOfBoundsException e){
				e.printStackTrace();
			}
		}
	}
}
