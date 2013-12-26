package ThreadDeadlock;

public class Deadlock {
	
	public static void sleepUninterruptibly(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) { }
	}
	
	public static void main(String[] args) throws InterruptedException {
		final Object lock1 = new Object();
		final Object lock2 = new Object();
		Thread t1 = new Thread("Thread1"){
			@Override
			public void run() {
				synchronized (lock1) {
					sleepUninterruptibly(1000);
					synchronized (lock2) {
						System.out.println(this.getName());
					}
				}
			}
		};
		Thread t2 = new Thread("Thread2"){
			@Override
			public void run() {
				synchronized (lock2) {
					sleepUninterruptibly(1000);
					synchronized (lock1) {
						System.out.println(this.getName());
					}
				}
			}
		};
		t1.start();
		t2.start();
		System.out.println("Started..");
		t1.join();
		t2.join();
		System.out.println("..done! never");
	}
}
