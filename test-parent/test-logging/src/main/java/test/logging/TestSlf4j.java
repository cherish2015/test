package test.logging;



import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestSlf4j {

	public static void main(String[] args) {
		helloWorld();
	}
	
	private static void helloWorld(){
		Logger log = LoggerFactory.getLogger(TestSlf4j.class);
		System.err.println(ToStringBuilder.reflectionToString(log, ToStringStyle.MULTI_LINE_STYLE));
		log.debug("log.debug");
		log.info("log.info");
		log.info("using slf4j logging..,now is {}.", new Date());
		
		
	}

}
