package test.commons.io;

import org.apache.commons.io.ThreadMonitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestThreadMonitor {

	static Logger logger = LoggerFactory.getLogger(TestThreadMonitor.class);

	public static void main(String[] args) {
		testThreadMonitor();
	}
	
	private static void testThreadMonitor2(){
		
	}
	

	private static void testThreadMonitor() {
		long timeout = 1000;
		try {
			logger.debug("a");
			Thread monitor = ThreadMonitor.start(timeout);
			logger.debug("b");
			Thread.sleep(2000);
			logger.debug("c");
			ThreadMonitor.stop(monitor);
			logger.debug("d");
		} catch (InterruptedException e) {
			logger.debug("e");
			logger.debug("", e);
		}
	}

	@SuppressWarnings("unused")
	private static void testThread() {
		Runnable runnable = new SimpleThread(1);
		Thread thread = new Thread(runnable);
		thread.start();

	}

	static class SimpleThread implements Runnable {
		private long seconds = 0;

		public SimpleThread(long seconds) {
			this.seconds = seconds;
		}

		public void run() {
			logger.debug("start SimpleThread.run");
			try {
				Thread.sleep(seconds * 1000);
			} catch (InterruptedException e) {
				logger.error("SimpleThread.InterruptedException", e);
			}
			logger.debug("end   SimpleThread.run");
		}

	}
}
