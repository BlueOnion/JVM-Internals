package pl.baranowska.ug;

import java.util.Date;

public class Task implements Runnable {
	
	@Override
    public void run() {
		
        for(int i = 0; i < 2; i++) {
            System.out.println("Watek : " + Thread.currentThread().getName() + "  Sformatowana data : " + Main.threadSafeFormat(new Date()));
        }      
    }
}
