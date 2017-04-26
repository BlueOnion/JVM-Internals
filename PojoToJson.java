import java.util.*;
import java.lang.reflect.*;

class Auto {

	private String brand;
	private String model;
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public void getAuto() {
		System.out.println("Your car is: " + this.brand + " " + this.model);
		System.out.println("And it makes brum brum!");
	}
}

public class PojoToJson {

	public static boolean isGetter(Method method){
		
		if(!method.getName().startsWith("get"))      return false;
	
	return true;
	}

	public static boolean isSetter(Method method){
		
		if(!method.getName().startsWith("set")) return false;
		if(method.getParameterTypes().length != 1) return false;
	
	return true;
	}


	public static void main(String[] args){
	
		Auto car = new Auto();
		car.setBrand("Audi");
		car.setModel("A4");

		Class<?> myClass = car.getClass();
		Field[] fields = myClass.getDeclaredFields();
		Method[] methods = myClass.getMethods();
		
		System.out.println("{");
		
		for(Field field : fields) {
			
			Object tmpValue = null;
			
			try {
				field.setAccessible(true);
				tmpValue = (String) field.get(car);
				System.out.println("\"" + field.getName() + "\" : \"" + tmpValue + "\"");
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		
		} 
	
	/*	ArrayList <Object> list = new ArrayList<Object>();
		System.out.print("[ ");
		
		for(Method method : methods) {
			
			if(isSetter(method)) {
				list.add(method.getName());
			}
			
			if(isGetter(method)) {
				list.add(method.getName());
			}
		}
		
		for(Object obj : list) System.out.print("\"" + obj + "\", ");
			
		System.out.print("]"); */
		System.out.println("}");
	}
}