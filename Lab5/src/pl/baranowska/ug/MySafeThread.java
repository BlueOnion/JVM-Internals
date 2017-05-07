package pl.baranowska.ug;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class MySafeThread {

	private static final ThreadLocal<SimpleDateFormat> dateFormatHolder = new ThreadLocal<SimpleDateFormat>() {

		@Override
	    protected SimpleDateFormat initialValue() {
	    System.out.println("Tworzy SimpleDateFormat dla watku : " + Thread.currentThread().getName());
	    return new SimpleDateFormat("dd/MM/yyyy");
	    }
	};
	
	public static DateFormat getDateFormatter() {
        return dateFormatHolder.get();
    }
}