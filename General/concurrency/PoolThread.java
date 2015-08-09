package concurrency;

public class PoolThread extends Thread{
	
	private BlockingQueue queue = null;
	private boolean isStopped = false;
	
	public PoolThread(BlockingQueue q){
		this.queue = q;
	}
	
	public void run(){
		while(!isStopped){
			try {
				Runnable task = (Runnable)queue.dequeue();
				task.run();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public synchronized void doStop(){
		isStopped = true;
		this.interrupt();
	}
}
