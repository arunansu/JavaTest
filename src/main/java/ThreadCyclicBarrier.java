import java.util.concurrent.CyclicBarrier;

public class ThreadCyclicBarrier {
	
	public class ServiceOne implements Runnable {
		private final CyclicBarrier barrier;
		
		ServiceOne(CyclicBarrier barrier) {
			this.barrier = barrier;
		}
		
		public void run() {
			System.out.println("Stsrting Service One");
			try {
				Thread.sleep(3000);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Servicve One has finished work");
			try {
				barrier.await();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Service One has finished");
		}
	}

	public static void main(String[] args) {
		final CyclicBarrier barrier = new CyclicBarrier(3);
		//Thread serviceOPneThread = new Thread(new ServiceOne(barrier));
	}

}
