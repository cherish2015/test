package test.java.generic;


public class GenericTest {

	public static void main(String[] args) {
		testPoint();
	}
	
	private static <T extends Object> void fun(T t){
		System.out.println(t.toString());
	}
	
	private static void testPoint(){
		Point<String> t = new Point<String>();
		t.setVar("test");
		System.out.println(t.getVar()+"--testPoint");
		testPoint2(t);
		testPoint3(t);
		
		fun("test fun");
		//Point<Object> t2 = t;
	}
	
	private static void testPoint2(Point<?> t){
		System.out.println(t.getVar()+"--testPoint2");
	}
	
	private static void testPoint3(Point<? extends Object> t){
		System.out.println(t.getVar()+"--testPoint3");
	}
	
	@SuppressWarnings("unused")
	private static void testPoint4(Point<? super Object> t){
		System.out.println(t.getVar()+"--testPoint4");
	}

}

class Point<T>{
	private T var;

	public T getVar() {
		return var;
	}

	public void setVar(T var) {
		this.var = var;
	}
	
}
