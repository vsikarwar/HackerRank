package concurrency;

import java.util.ArrayList;
import java.util.List;

public class ThreadPool {
	private BlockingQueue taskQueue = null;
	private List<PoolThread> threads = new ArrayList<>();
	private boolean isStopped = false;
	
	public ThreadPool(int maxTasks, int maxThreads){
		taskQueue = new BlockingQueue(maxTasks);
		for(int i = 0; i<maxThreads; i++){
			threads.add(new PoolThread(taskQueue));
		}
		
		for(PoolThread thread : threads){
			thread.start();
		}
	}
	
	public synchronized void execute(Runnable task) throws IllegalStateException, InterruptedException{
		if(isStopped)
			throw new IllegalStateException();
		
		taskQueue.enqueue(task);
	}
	
	public synchronized void stop(){
		isStopped = true;
		for(PoolThread thread : threads){
			thread.doStop();
		}
	}
	
}
