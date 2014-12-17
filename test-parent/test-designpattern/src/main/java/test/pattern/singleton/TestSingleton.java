package test.pattern.singleton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;

@SuppressWarnings("unused")
public class TestSingleton {

	private static Logger logger = Logger.getLogger(TestSingleton.class);
	
	public static void main(String[] args) {
		test3();
	}
	
	private static void test(){
		Singleton1 singleton1 = Singleton1.getInstance();
		Singleton1 singleton2 = Singleton1.getInstance();
		Singleton1 singleton3 = Singleton1.getInstance();
		System.out.println(singleton1);
		System.out.println(singleton2);
		System.out.println(singleton3);
	}
	
	private static void test1(){
		 ExecutorService service =  Executors.newFixedThreadPool(100);
		 logger.info("start");
		 for (int i = 0; i < 100; i++) {
			service.submit(new Runnable() {
				
				public void run() {
					Singleton1 singleton1 = Singleton1.getInstance();
					System.out.println(singleton1);
				}
			});
			}
		 service.shutdown();
		 logger.info("end");
	}
	
	private static void test2(){
		 ExecutorService service =  Executors.newFixedThreadPool(100);
		 logger.info("start");
		 for (int i = 0; i < 100; i++) {
			service.submit(new Runnable() {
				
				public void run() {
					Singleton2 singleton2 = Singleton2.getInstance();
					System.out.println(singleton2);
				}
			});
			}
		 service.shutdown();
		 logger.info("end");
	}
	
	private static void test3(){
		 ExecutorService service =  Executors.newFixedThreadPool(100);
		 logger.info("start");
		 for (int i = 0; i < 100; i++) {
			service.submit(new Runnable() {
				
				public void run() {
					Singleton3 singleton3 = Singleton3.getInstance();
					System.out.println(singleton3);
				}
			});
			}
		 service.shutdown();
		 logger.info("end");
	}


}
