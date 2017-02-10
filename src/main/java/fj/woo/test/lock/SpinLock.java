package fj.woo.test.lock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁
 * @author wufj@chetong.net
 *         2016年7月5日 下午5:13:03
 */
public class SpinLock {
	private AtomicReference<Thread> sign = new AtomicReference<Thread>();
	
	public void lock(){
		Thread currentThread = Thread.currentThread();
		while (!sign.compareAndSet(null, currentThread)) {
			
		}
	}
	
	public void unlock(){
		Thread currentThread = Thread.currentThread();
		sign.compareAndSet(currentThread, null);
	}
}
