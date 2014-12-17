package test.pattern.singleton;

import org.apache.log4j.Logger;

public class Singleton2 {
	
	private static Logger logger = Logger.getLogger(Singleton2.class);
	
	private Singleton2() {
		logger.warn("Singleton2.Singleton2()");
	}
	
	private static Singleton2 instance;
	
	public synchronized static Singleton2 getInstance(){
		if (instance == null) {
			instance = new Singleton2();
		}
		return instance;
	}

}
