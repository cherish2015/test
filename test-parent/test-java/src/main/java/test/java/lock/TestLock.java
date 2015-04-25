package test.java.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestLock {
	
	private static Logger logger = LoggerFactory.getLogger(TestLock.class);

	public static void main(String[] args) {
		try {
			testLock();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void testLock() throws Exception{
		final SimpleLockTest lockTest = new SimpleLockTest();
		Runnable task = new Runnable() {
			public void run() {
				lockTest.addValue(111.11);
			}
		};
		
		Runnable task2 = new Runnable() {
			public void run() {
				logger.info("value: {}",lockTest.getValue());
			}
		};
		
		ExecutorService executorService = Executors.newCachedThreadPool();
		Future<?> future = null;
		for (int i = 0; i < 10; i++) {
			future = executorService.submit(task);
		}
		future.get();
		future = executorService.submit(task2);
		future.get();
		executorService.shutdown();
	}

}

/**
 *  ReadWriteLock内置两个Lock，一个是读的Lock，一个是写的Lock。 
 *  多个线程可同时得到读的Lock，但只有一个线程能得到写的Lock， 
 *  而且写的Lock被锁定后，任何线程都不能得到Lock。ReadWriteLock提供的方法有： 
 *  readLock(): 返回一个读的lock  
 *  writeLock(): 返回一个写的lock, 此lock是排他的。 
 *  ReadWriteLockTest很适合处理类似文件的读写操作。  
 *  读的时候可以同时读，但不能写；写的时候既不能同时写也不能读。 
 */
class SimpleReadWriteLockTest{
	private static Logger logger = LoggerFactory.getLogger(SimpleReadWriteLockTest.class);
	ReadWriteLock lock = new ReentrantReadWriteLock();
	double value = 0d;
	int addTimes = 0;
	
	public void addValue(double v){
		Lock writeLock = lock.writeLock();
		writeLock.lock();
		logger.info("addValue  writeLock.lock()");
		this.value += v;
		this.addTimes++;
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		} finally {
			writeLock.unlock();
		}
	}
	
	public double getValue(){
		Lock readLock = lock.readLock();
		readLock.lock();
		try {
			return this.value;
		} finally {
			readLock.unlock();
		}
	}
}

class SimpleLockTest{
	
	private static Logger logger = LoggerFactory.getLogger(SimpleLockTest.class);
	
	Lock lock = new ReentrantLock();
	double value = 0d;
	int addTimes = 0;
	
	public void addValue(double v){
		logger.info("\n{}",ToStringBuilder.reflectionToString(lock, ToStringStyle.MULTI_LINE_STYLE));
		lock.lock();
		logger.info("addValue");
		this.value += v;
		this.addTimes++;
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		} finally {
			lock.unlock();
		}
	}
	
	public double getValue(){
		return this.value;
	}
}
