package test.pattern.singleton;

import org.apache.log4j.Logger;

public class Singleton3 {
	
	private static Logger logger = Logger.getLogger(Singleton3.class);
	
	private static Object obj = new Object();
	
	private Singleton3() {
		logger.warn("Singleton3.Singleton3()");
	}
	
	private volatile static Singleton3 instance;
	
	//double-check-lock
	public static Singleton3 getInstance(){
		if (instance == null) {
			synchronized (obj) {
				if (instance == null) {
					instance = new Singleton3();					
				}
			}
		}
		return instance;
	}

}
