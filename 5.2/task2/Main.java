import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

class SafeList {

	private final List<String> list  = new ArrayList<>();
	private final ReentrantLock lock = new ReentrantLock();

	public void add(String str) {

		lock.lock();
		try {
			list.add(str);
		} finally {
			lock.unlock();
		}
	}
	
	public void delete(String str) {

		lock.lock();
		try {
			list.remove(str);
		} finally {
			lock.unlock();
		}
	}

	public int size() {

		lock.lock();
		try {
			return list.size();
		} finally {
			lock.unlock();
		}
	}
}


class Main {

	public static void main (String[] args) throws InterruptedException {
		
		SafeList list = new SafeList();

		Runnable task = () -> {
			for(int i = 0; i < 1000; i++){
				list.add(Thread.currentThread().getName() + "-" + i);
			}
		};

		Thread t1 = new Thread(task);
		Thread t2 = new Thread(task);

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}

		for(int i = 0; i < 128; i++){
			list.add("Test String " + i);
		}

		for(int i = 0; i < 128; i += 2){
			list.delete("Test String " + i);
		}	

		System.out.printf("Final list size: %n");
		System.out.printf("Expected: %3s 2064%n", "");
		System.out.printf("Actual: %5s %d%n", "", list.size());
	}
}
