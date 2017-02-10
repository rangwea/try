package fj.woo.test;

public class Wait {
	private volatile  boolean run = true;
	private Object object = new Object();
	
	public static void main(String[] args) {
		final Wait wait = new Wait();
		Thread thread = new Thread(new Runnable() {
					
					public void run() {
						try {
							Thread.sleep(10000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println("closing…");
						wait.stop();
					}
				});
		thread.start();
		wait.start();
	}
	
	public void start(){
		while (run){
			try {
				System.out.println("start...");
				synchronized (object) {
					object.wait();
				}
				System.out.println("closed...");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void stop(){
		System.out.println("dfd");
		if(run){
			synchronized (object) {
				System.out.println("closing...");
				run = false;
				object.notify();
			}
		}
	}
	
}
