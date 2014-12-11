package com.cherish.test.mybatis.testLogger;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestLoggerSLF {
	
	@Test
	public void testLogger(){
		Logger log = LoggerFactory.getLogger(TestLoggerSLF.class);
		log.info("testLogger");
	}
	
	@Test
	public void testLoggerName(){
		Logger log = LoggerFactory.getLogger("testLoggerName");
		log.info("testLoggerName");
	}
	
}
