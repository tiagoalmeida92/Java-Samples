package ThreadLock;

public class RecursiveLockAcquisition {
	public static void main(String[] args) throws InterruptedException {
		final Object lock1 = new Object();
		Thread t1 = new Thread("Thread1"){
			@Override
			public void run() {
				synchronized (lock1) {
					synchronized (lock1) {
						System.out.println(this.getName());
					}
				}
			}
		};
		
		t1.start();
		t1.join();
	}
}
