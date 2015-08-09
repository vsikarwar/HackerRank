package concurrency;

import java.util.ArrayList;
import java.util.List;

public class FairLock {
	private boolean isLocked = false;
	private Thread lockingThread = null;
	private List<QueueObject> waitingThreads = new ArrayList<>();
	
	public void lock() throws InterruptedException{
		QueueObject qo = new QueueObject();
		boolean isLockedForThisThread = true;
		synchronized(this){
			waitingThreads.add(qo);
		}
		while(isLockedForThisThread){
			synchronized(this){
				isLockedForThisThread = isLocked || waitingThreads.get(0) != qo;
				if(!isLockedForThisThread){
					isLocked = true;
					waitingThreads.remove(qo);
					lockingThread = Thread.currentThread();
					return;
				}
			}
			try{
				qo.doWait();
			}catch(Exception e){
				waitingThreads.remove(qo);
			}
		}
	}
	
	public void unlock(){
		isLocked = false;
		lockingThread = null;
		if(waitingThreads.size() > 0){
			waitingThreads.get(0).doNotify();
		}
	}
	
}
