package test.java.lang;


/**
 * Java中finally的执行时机
 * http://blog.csdn.net/imzoer/article/details/8037970
 */
public class TestTryCatchReturn {

	public static void main(String[] args) {
		test();
	}
	
	private static void test(){
		int result = example();
		System.out.println("result="+result);
	}
	
	private static int example(){
		int i = 9;
		try {
			i++;
			i = i/(i -10);
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			i=20;
			return i;
		} finally {
			i = 40;
			System.out.println("finally");
			//return i; result=40
		}
	}

}
