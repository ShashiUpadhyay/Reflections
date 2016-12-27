package reflection;

import java.lang.Class;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import util.genericDeserTokens;

public class Reflections {	
	
	public static Class<?> getInstanceOfClass(String className) {
		Class<?> classs = null;
		try {
			if(className != null){
				classs = Class.forName(className);
			}
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return classs;
	}

	public static Class<?> getNewInstanceOfClass(String className) {
		Class<?> classs = null;
		try {
			if(className != null){
				classs = Class.forName(className);
			}
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return classs;
	}

	public static Method[] getDeclaredMethodsOfClass(Class<?> className) {
		Method m[] = null;
		try {
			m = className.getDeclaredMethods();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return m;
	}

	public static Field[] getDeclaredFieldsOfClass(Class<?> className) {
		Field fieldlist[] = null;
		try {
			fieldlist = className.getDeclaredFields();
			for (int i = 0; i < fieldlist.length; i++) { 
				Field fld = fieldlist[i];
				System.out.println("name = " + fld.getName());
		        System.out.println("type = " + fld.getType());
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return fieldlist;
	}
	
	public static Method getMethodNameBasedOnDataType(String methodname, Class[] cArg, Class<?> className){
		Method lMethod = null;
		try {
			if(methodname != null && !methodname.isEmpty()){
				lMethod = className.getMethod(methodname, cArg);
				System.out.println("method = " + lMethod.toString());
			}
			
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return lMethod;
	}
	
	public static Method[] getAllMethodsName(Class<?> className){
		Method[] lMethod = null;
		try {
			if(className != null){
				lMethod = className.getMethods();
				for (Method method:lMethod)
				System.out.println("method ======= " + method.getName().toString());
			}
			
		}catch (Exception ex) {
			ex.printStackTrace();
		}
		return lMethod;
	}
	

	public static void main(String[] args) {
		String classname = "util.First";
		Class<?> classinstance = Reflections.getInstanceOfClass(classname);
		Method methods[] = Reflections.getDeclaredMethodsOfClass(classinstance);
		for (int i = 0; i < methods.length; i++) {
			System.out.println(methods[i].toString());
		}
		Reflections.getDeclaredFieldsOfClass(classinstance);
		Class[] cArg = new Class[1];
		cArg[0] = int.class;
		Reflections.getMethodNameBasedOnDataType(genericDeserTokens.SET.getValue().concat("IntValue"), cArg, classinstance);
		
		Reflections.getAllMethodsName(classinstance);
		
		
	}
}
