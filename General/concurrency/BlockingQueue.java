package concurrency;

import java.util.LinkedList;
import java.util.List;

public class BlockingQueue {
	private List queue = new LinkedList();
	private int bound = 0;
	
	public BlockingQueue(int bound){
		this.bound = bound;
	}
	
	public synchronized void enqueue(Object item) throws InterruptedException{
		while(queue.size() == bound){
			wait();
		}
		if(queue.size() == 0){
			notifyAll();
		}
		queue.add(item);
	}
	
	public synchronized Object dequeue() throws InterruptedException{
		while(queue.size() == 0){
			wait();
		}
		if(queue.size() == bound){
			notifyAll();
		}
		return queue.remove(0);
	}
	
	
}
