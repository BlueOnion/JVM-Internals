import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.Random;

public class GC_test {

	public static void main(String args[]){
		
		Random temp = new Random();
		int thread1 = 1;
		int thread2 = Integer.parseInt(args[0]);
		int size1 = temp.nextInt(1000000) + 1;
		int size2 = 1000000;
		
		System.out.println("");
		System.out.print("1 thread fixed object size,");
		countTime(size2, thread1);
		System.out.print("n threads fixed object size,");
		countTime(size2, thread2);
		System.out.print("1 thread random object size,");
		countTime(size1, thread1);
		System.out.print("n threads random object size,");
		countTime(size1, thread2);
	}
	
	private static void countTime(int size, int thread) {
		
		ExecutorService executorService = Executors.newFixedThreadPool(thread);
		long start = System.nanoTime();
		
		for(int i = 0; i < thread; i++){
			
			executorService.submit(new Runnable(){
				
				public void run(){
					
					int[] tab = new int[size];
					for(int i = 0; i < size; i++){
						tab[i] = i;
					}
				}
			});
		}
		
		executorService.shutdown();
		long time = System.nanoTime() - start;

		System.out.print((double)time/1000000);
		System.out.println("");
	}
}