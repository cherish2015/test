package test.log4j;

import org.apache.log4j.Logger;

public class TestLog4j {

	public static void main(String[] args) {
		test();
	}
	
	private static void test(){
		Logger logger = Logger.getLogger(TestLog4j.class);
		logger.debug("log4j test");
	}

}
