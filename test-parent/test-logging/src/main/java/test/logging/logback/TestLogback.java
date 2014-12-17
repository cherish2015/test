package test.logging.logback;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestLogback {

	public static void main(String[] args) {
		test();
	}

	private static void test() {
		Logger logger = LoggerFactory.getLogger(TestLogback.class);
		System.err.println(ToStringBuilder.reflectionToString(logger,
				ToStringStyle.MULTI_LINE_STYLE));
		logger.trace("logger.trace");
		logger.debug("logger.debug");
	}

}
