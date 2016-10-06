package jackiehou;

public class ObjectSync implements Runnable {
	private static final String TAG = "ObjectSync";

	private String name;
	private Object o;

	public ObjectSync(String name, Object o) {
		this.name = name;
		this.o = o;
	}

	@Override
	public void run() {
		print2();
	}

	public void print1() {
		int count = 3;
		while (count > 0) {
			synchronized (o) {
				System.out.println(name + " notify before");
				o.notify();
				try {
					if (--count > 0) {
						System.out.println(name + " sleep before");
						Thread.sleep(1000);
						System.out.println(name + " wait before");
						o.wait();
						System.out.println(name + " wait after");
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public void print2() {
		int count = 3;
		while (count > 0) {
			synchronized (o) {
				System.out.println(name + " notify before");
				o.notify();
				/*try {
					System.out.println(name + " sleep1 before");
					Thread.sleep(200);
					System.out.println(name + " sleep1 after");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				try {
					//System.out.println(name + " sleep2 before");
					Thread.sleep(200);
					//System.out.println(name + " sleep2 after");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
			try {
				//System.out.println(name + " sleep2 before");
				Thread.sleep(1000);
				//System.out.println(name + " sleep2 after");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
