package concurrency;

public class QueueObject {
	
	private boolean isNotified = false;
	
	public synchronized void doWait() throws InterruptedException{
		while(!isNotified){
			wait();
		}
		isNotified = false;
	}
	
	public synchronized void doNotify(){
		isNotified = true;
		notify();
		
	}

}
