package concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Synchronize the entire method
class ExplicitPairManager1 extends PairManager{
	private Lock lock=new ReentrantLock();
	
	@Override
	public synchronized void increment() {
		// TODO Auto-generated method stub
		lock.lock();
		try{
			p.incrementX();
			p.incrementY();
			store(getPair());
		}finally{
			lock.unlock();
		}
	}
}

// Use a critical section
class ExplicitPairManager2 extends PairManager{
	private Lock lock=new ReentrantLock();
	@Override
	public synchronized void increment() {
		// TODO Auto-generated method stub
		Pair temp;
		lock.lock();
		try{
			p.incrementX();
			p.incrementY();
			temp=getPair();
		}finally{
			lock.unlock();
		}
		store(temp);
	}
}



public class ExplicitCriticalSection {
	public static void main(String[] args) {
		PairManager pman1=new ExplicitPairManager1();
		PairManager pman2=new ExplicitPairManager2();
		CriticalSection.testApproaches(pman1, pman2);
	}
}
