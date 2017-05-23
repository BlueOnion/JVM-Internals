package pl.abaranowska.ug;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

public class MyTransformer implements ClassFileTransformer {
	
	public byte[] transform(ClassLoader loader, String className,
					Class <?> classToChange, ProtectionDomain protectionDomain,
					byte[] bytes) throws IllegalClassFormatException {
						
		byte[] result = bytes;
		
		if(className.contains("RequestHandler")) {
			
			System.out.println("Starts changing");
			
			try {
				
				String newClassName = className.replace('/', '.');
				
				ClassPool cp = ClassPool.getDefault();
				CtClass ct = cp.get(newClassName);
				
				CtMethod method = ct.getDeclaredMethod("takeTheTime");
				
				method.addLocalVariable("elapsedTime", CtClass.longType);
				
				method.insertBefore("elapsedTime = System.currentTimeMillis();");
				method.insertAfter(" { elapsedTime = System.currentTimeMillis() - elapsedTime; "
				+ "System.out.println(\" Method elapsedTime = \" + elapsedTime);}");
				
				result = ct.toBytecode();
			} catch (Throwable e) {
				
				e.printStackTrace();
			}
		}		
		
		return result;
	}

}