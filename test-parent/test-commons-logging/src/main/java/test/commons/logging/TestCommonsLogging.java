package test.commons.logging;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.impl.LogFactoryImpl;


public class TestCommonsLogging {
	public static void main(String[] args) {
		test();
	}
	
	private static void test(){
		Log logger = LogFactoryImpl.getLog(TestCommonsLogging.class);
		logger.debug("TestCommonsLogging");
	}

}
