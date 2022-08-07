// Avoiding deadlock in Java

public class AvoidDeadLock {
	public static void main(String[] args) {
		MyObj1 obj1 = new MyObj1();
		MyObj2 obj2 = new MyObj2();

		Runnable run1 = new Runnable() {
			public void run () {
				synchronized (obj1) {
					System.out.println("run1 locks obj1.");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException ex) {}

					System.out.println("run1 about to lock obj2.");
					synchronized (obj2) {
						System.out.println("run1 locks obj2.");
					}
					System.out.println("run1 about to exit both locks.");
				}
			}
		};

		Runnable run2 = new Runnable() {
			public void run () {
				// if run2 locks obj2 first, deadlock will occur
				synchronized (obj1) {
					System.out.println("run2 locks obj1.");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException ex) {}

					System.out.println("run2 about to lock obj2.");
					synchronized (obj2) {
						System.out.println("run2 locks obj2.");
					}
					System.out.println("run2 about to exit both locks.");
				}
			}
		};

		new Thread (run1).start();
		new Thread (run2).start();

		System.out.println("main finishes.");
	}

	static class MyObj1 {
		public MyObj1 () {
		}
	}

	static class MyObj2 {
		public MyObj2 () {
		}
	}

}

