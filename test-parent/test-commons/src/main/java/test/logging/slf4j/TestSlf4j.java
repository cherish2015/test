package test.logging.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestSlf4j {

	public static void main(String[] args) {
		test1();
	}
	
	private static void test1(){
		Logger log = LoggerFactory.getLogger(TestSlf4j.class);
		log.debug("Logger log = LoggerFactory.getLogger(TestSlf4j.class);");
	}

}
