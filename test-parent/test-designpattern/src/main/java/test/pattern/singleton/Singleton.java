package test.pattern.singleton;

import org.apache.log4j.Logger;

public class Singleton {
	
	private static Logger logger = Logger.getLogger(Singleton.class);
	
	private Singleton() {
		logger.warn("Singleton.Singleton()");
	}
	
	private static Singleton instance = new Singleton();
	
	public static Singleton getInstance(){
		return instance;
	}

	/**
	 * 单例模式
	 * 
	 * 单例模式就是保证在整个应用程序的生命周期中，
	 * 在任何时刻，被指定的类只有一个实例，并为客户程序提供一个获取该实例的全局访问点。
	 * 
	 * 
	 * 这种模式只适用在单线程下，并没有考虑到线程并发的问题，
	 * 在多线程中，可能出现两个线程同时获取Instance的实例，可能会出现多个实例对象。
	 * 
	 * 延迟加载
	 * sychronized  double-check-lock volatile
	 */

}
