package chapters.introduction;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;

@SuppressWarnings("unused")
public class HelloWorld1 {

	public static void main(String[] args) {
		test4();
	}
	
	private static void test4(){
		Logger logger = LoggerFactory.getLogger("chapters.introduction.HelloWorld1");
		logger.debug("test {}","haha");
		logger.debug("test {} - {}","haha","hah2a");
		logger.debug("test {} - {}- {}","haha","haha2","haha3");
		logger.debug("test {} - {}- {} -{}","haha","haha2","haha3","haha4");
		
		//LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
		//StatusPrinter.print(loggerContext);
	}
	
	private static void test3(){
		Logger logger = LoggerFactory.getLogger(org.slf4j.Logger.ROOT_LOGGER_NAME);
		logger.debug("root");
		System.err.println(ToStringBuilder.reflectionToString(logger, ToStringStyle.MULTI_LINE_STYLE));
	}
	
	private static void test2(){
		Logger logger = LoggerFactory.getLogger("chapters.introduction.HelloWorld1");
		logger.debug("Hello world");
		
		LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
		StatusPrinter.print(loggerContext);
	}
	
	private static void test1(){
		Logger logger = LoggerFactory.getLogger("chapters.introduction.HelloWorld1");
		logger.debug("Hello world");
	}

}
