package com.cherish.test.mybatis.testLogger;

import org.apache.log4j.Logger;
import org.junit.Test;

public class TestLoggerLog4j {
	
	@Test
	public void testLoggerLog4j(){
		Logger log = Logger.getLogger(TestLoggerLog4j.class);
		log.info("testLoggerLog4j");
	}
	
	
	@Test
	public void testLoggerNameLog4j(){
		Logger log = Logger.getLogger("testLoggerNameLog4j");
		log.info("testLoggerNameLog4j");
	}
	
	@Test
	public void testLoggerNameLog4j2(){
		Logger log = Logger.getLogger("testLogger");
		log.info("testLoggerNameLog4j2");
	}
	
	

}
