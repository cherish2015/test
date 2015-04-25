package test.java.threadpool;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestThreadPool {

	private static Logger logger = LoggerFactory
			.getLogger(TestThreadPool.class);

	public static void main(String[] args) {
		testThread();
		testThreadPool();
	}

	private static void testThread() {
		long startTime = System.currentTimeMillis();
		final List<Integer> list = new LinkedList<Integer>();
		final Random random = new Random();
		long count = 10000L;
		for (int i = 0; i < count; i++) {
			Thread thread = new Thread(new Runnable() {

				public void run() {
					list.add(random.nextInt());
				}
			});
			thread.start();
			try {
				thread.join();
			} catch (InterruptedException e) {
				logger.error(e.getMessage(), e);
			}
		}
		logger.info("testThread cost time {}ms.", System.currentTimeMillis() - startTime);
		logger.info("testThread list size {}", list.size());
	}

	private static void testThreadPool() {
		long startTime = System.currentTimeMillis();
		//final List<Integer> list = new LinkedList<Integer>();
		final List<Integer> list = Collections.synchronizedList(new LinkedList<Integer>());
		final Random random = new Random();
		long count = 10000L;

		int corePoolSize = 10;
		int maximumPoolSize = 10;
		long keepAliveTime = 5;
		BlockingQueue<Runnable> workQueue = new LinkedBlockingDeque<Runnable>(10000);
		ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(corePoolSize,
				maximumPoolSize, keepAliveTime, TimeUnit.MINUTES, workQueue);
		
		for (int i = 0; i < count; i++) {
			poolExecutor.execute(new Runnable() {
				
				public void run() {
					list.add(random.nextInt());
				}
			});
		}
		poolExecutor.shutdown();
		try {
			poolExecutor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.info("testThreadPool cost time {}ms.", System.currentTimeMillis() - startTime);
		logger.info("testThreadPool list size {}", list.size());
	}

}
