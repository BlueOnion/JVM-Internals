package pl.baranowska.ug;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

public class Main {

	    public static void main(String args[]) throws IOException {
	        Thread t1 = new Thread(new Task());  
	        Thread t2 = new Thread(new Task());
	        Thread t3 = new Thread(new Task());
	     
	        t1.start();
	        t2.start();      
	        t3.start();
	    }
	    
	    public static String threadSafeFormat(Date date) {
	        DateFormat formatter = MySafeThread.getDateFormatter();
	        return formatter.format(date);
	    }
}
