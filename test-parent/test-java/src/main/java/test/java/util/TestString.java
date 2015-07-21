package test.java.util;


public class TestString {
	public static void main(String[] args) {
		test();
	}

	private static void test() {
		try {
			org.apache.commons.lang3.StringUtils.isBlank("test");
			throw new Exception("test" + null + "test");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
