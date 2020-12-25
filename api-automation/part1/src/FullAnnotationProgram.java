

//Program to demonstrate a Full annotation 

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method; 

//Create container annotation
@Retention(RetentionPolicy.RUNTIME)
@interface FullAnnotation{ 
 Word[] value(); 
}

//Make Words annotation  
@Retention(RetentionPolicy.RUNTIME) 
@interface Word { 
String word() default "Hello"; 
int value() default 0; 
} 

public class FullAnnotationProgram extends BaseAnnotationProgram {

	// Repeat Words on newMethod 
	 @Word(word = "First", value = 1) 
	 public static void newMethod(){ 
		 FullAnnotationProgram obj = new FullAnnotationProgram(); 

	     try{ 
	         Class<?> c = obj.getClass(); 

	         // Obtain the annotation for newMethod 
	         Method m = c.getMethod("newMethod"); 
	           
	         // Display the full annotation 
	         Annotation anno = m.getAnnotation(CustomRepeatAnnots.class); 
	         System.out.println(anno); 
	     }catch (NoSuchMethodException e){ 
	         System.out.println(e); 
	     } 
	 } 
	 
	 public static void main(String[] args) { 
	     newMethod(); 
	 } 
}


    
 


