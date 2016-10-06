package jackiehou;

public class Test1 {

	public static void main(String[] args) {

		t1();
		//Object o = new Object();
		//Thread thread1 = new Thread(new ObjectSync("a", o));
		//Thread thread2 = new Thread(new ObjectSync("b", o));
		//thread1.start();
		//thread2.start();
	}

	public static void t1() {
		final Foo foo = new Foo();
		new Thread() {
			public void run() {
				foo.lockmethod3("thread1");
			};

		}.start();
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		final Foo foo1 = new Foo();
		new Thread() {
			public void run() {
				foo1.othermethod("thread2");
				foo1.unlockmethod3("thread2");
			};

		}.start();
	}

}
