package test.java.thread;

public class TestThread {

	public static void main(String[] args) throws Exception {
		testJoin();
	}
	
	public static void test1(){
		Thread.dumpStack();
	}
	
	public static void testJoin() throws Exception{
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.err.println("test join");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.err.println("test join end");
			}
		});
		t.start();
		t.interrupt();
		System.err.println(t.isInterrupted());
		t.join();
		System.err.println(t.isInterrupted());
		for (int i = 0; i < 15; i++) {
			System.err.println(i);
			Thread.sleep(1000);
		}
	}

}
