import java.util.*;
import java.lang.reflect.*;

class Test {

	public String t1;
	public String t2;
	public int t3;
}

public class PojoToJson {

	public static void main(String[] args){
	
		Test test = new Test();
		test.t1 = "value1";
		test.t2 = "value2";
		test.t3 = 100;

		Class<?> myClass = test.getClass();
		Field[] fields = myClass.getDeclaredFields();
		
		System.out.println("{");
		
		for(Field field : fields) {
			
			try {
				
				System.out.println("\"" + field.getName() + "\" : \"" + field.get(test) + "\"");
			
			} catch (IllegalAccessException e) {
				
				e.printStackTrace();
			}
		}
		
		System.out.println("}");
	}
}