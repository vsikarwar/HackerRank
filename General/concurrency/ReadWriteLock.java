package concurrency;

import java.util.HashMap;
import java.util.Map;

public class ReadWriteLock {
	
	private Map<Thread, Integer> readerThreads = new HashMap<>();
	private int writerAccesses = 0;
	private int writerRequests = 0;
	private Thread writerThread = null;
	
	public synchronized void lockRead() throws InterruptedException{
		Thread callingThread = Thread.currentThread();
		
		while(!canGrantReadAccess(callingThread)){
			wait();
		}
		readerThreads.put(callingThread, getReadAccessCount(callingThread));
	}
	
	public synchronized void unlockRead() throws IllegalMonitorStateException{
		Thread callingThread = Thread.currentThread();
		if(readerThreads.get(callingThread) == null)
			throw new IllegalMonitorStateException("Lock is not held by calling thread");
		
		int count = getReadAccessCount(callingThread);
		if(count == 1) readerThreads.remove(callingThread);
		else readerThreads.put(callingThread, count -1);
		
		notifyAll();
	}
	
	public synchronized void lockWrite() throws InterruptedException{
		writerRequests++;
		Thread callingThread = Thread.currentThread();
		while(!canGrantWriteAccess(callingThread)){
			wait();
		}
		writerRequests--;
		writerAccesses++;
		writerThread = callingThread;
	}
	
	public synchronized void unlockWrite() throws IllegalMonitorStateException{
		Thread callingThread = Thread.currentThread();
		if(writerThread != callingThread)
			throw new IllegalMonitorStateException("Lock is not held by calling thread");
		
		writerAccesses--;
		if(writerAccesses == 0) writerThread = null;
		
		notifyAll();
	}
	
	private boolean canGrantWriteAccess(Thread thread){
		if(readerThreads.size() ==1 && readerThreads.get(thread)!= null) return true;
		if(readerThreads.size() > 0) return false;
		if(writerThread == null) return true;
		if(writerThread != thread) return false;
		return true;
	}
	
	private int getReadAccessCount(Thread thread){
		Integer accessCount = readerThreads.get(thread);
		if(accessCount == null) return 0;
		return accessCount.intValue();
	}
	
	private boolean canGrantReadAccess(Thread thread){
		if(thread == writerThread) return false;
		if(writerThread != null) return false;
		if(readerThreads.get(thread) != null) return true;
		if(writerRequests > 0) return false;
		return true;
	}
	
}
