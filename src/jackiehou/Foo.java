package jackiehou;

public class Foo {
	
	private static final String LOCK = "a";
	
	public void lockmethod(String name){
		System.out.println(name+" lockmethod synchronized before");
		synchronized (LOCK) {
			System.out.println(name+" lockmethod synchronized inside");
			try {
				Thread.sleep(1000*10);
			} catch (InterruptedException e) {
//<<<<<<< HEAD
				// TODO Auto-generated catch block
				System.out.println(e);
//=======
				
//>>>>>>> d7473ec... fix debug by branche thread1.0
				e.printStackTrace();
			}
			System.out.println(name+" lockmethod sleep after");
		}
	}
	
	public void unlockmethod(String name){
		synchronized (LOCK) {
			System.out.println(name+" unlockmethod synchronized inside");
		}
	}
	
	
	public void lockmethod1(String name){
		System.out.println(name+" lockmethod1 synchronized before");
		synchronized (this) {
			System.out.println(name+" lockmethod1 synchronized inside");
			try {
				Thread.sleep(1000*10);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			System.out.println(name+" lockmethod1 sleep after");
		}
	}
	
	
	public void unlockmethod2(String name){
		synchronized (this) {
			System.out.println(name+" unlockmethod2 synchronized inside");
		}
	}
	
	public void lockmethod3(String name){
		System.out.println(name+" lockmethod3 synchronized before");
		synchronized (Foo.class) {
			System.out.println(name+" lockmethod3 synchronized inside");
			try {
				Thread.sleep(1000*10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(name+" lockmethod3 sleep after");
		}
	}
	
	public void unlockmethod3(String name){
		synchronized (Foo.class) {
			System.out.println(name+" unlockmethod3 synchronized inside");
		}
	}
	
	
	
	
	public void othermethod(String name){
			System.out.println(name+" othermethod");
	}
	

}

