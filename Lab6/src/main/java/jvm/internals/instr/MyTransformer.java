package jvm.internals.instr;

import java.lang.instrument.ClassFileTransformer;
import java.security.ProtectionDomain;

public class MyTransformer implements ClassFileTransformer {

	public byte[] transform(ClassLoader loader, String className,
		Class<?> classBeingRedefined, ProtectionDomain protectionDomain,
		byte[] classfileBuffer) {

		System.out.println("Class To Transform: " + className);
		return null;
		}
}
