package test.pattern.singleton;

import org.apache.log4j.Logger;


public class Singleton1 {
	
	private static Logger logger = Logger.getLogger(Singleton1.class);
	
	private Singleton1() {
		logger.warn("Singleton1.Singleton1()");
	}
	
	private static Singleton1 instance;
	
	public static Singleton1 getInstance(){
		if (instance == null) {
			instance = new Singleton1();
		}
		return instance;
	}

}
