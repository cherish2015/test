package test.logging.log4j;

import org.apache.log4j.Logger;
import org.junit.Test;

public class TestLog4j {

	public static void main(String[] args) {
	}
	
	/**
	 * 测试日志文件分离
	 */
	@Test
	public void testLogger1(){
		Logger log = Logger.getLogger("testFilelogger");
		log.debug("testLogger1");
	}
	
	/**
	 * 测试日志文件分离
	 */
	@Test
	public void testLogger2(){
		Logger log = Logger.getLogger("testFilelogger");
		log.debug("testLogger2");
	}
	
	/**
	 * 测试log4j target 
	 */
	@Test
	public void testLog4j(){
		Logger log = Logger.getLogger(TestLog4j.class);
		log.info("Logger log = Logger.getLogger(TestLog4j.class);");
	}

}
