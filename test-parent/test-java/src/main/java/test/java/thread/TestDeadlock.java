package test.java.thread;

public class TestDeadlock {
	
	Object a = new Object();
	Object b = new Object();

	public static void main(String[] args) {
		new TestDeadlock().accessA();
		new TestDeadlock().accessB();
	}
	
	public void accessA(){
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				synchronized (a) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.err.println("---a");
					synchronized (b) {
						System.err.println("---b");
					}
				}
			}
		}).start();
	}
	
	public void accessB(){
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				synchronized (b) {
					System.err.println("***b");
					synchronized (a) {
						try {
							Thread.sleep(900);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.err.println("***a");
					}
				}
			}
		}).start();
	}
	
}
