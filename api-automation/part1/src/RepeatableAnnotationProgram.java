

//Program to demonstrate a repeatable annotation 

import java.lang.annotation.Annotation; 
import java.lang.annotation.Repeatable; 
import java.lang.annotation.Retention; 
import java.lang.annotation.RetentionPolicy; 
import java.lang.reflect.Method; 

//Create container annotation
@Retention(RetentionPolicy.RUNTIME)
@interface CustomRepeatAnnots { 
 Words[] value(); 
}

//Make Words annotation repeatable 
@Retention(RetentionPolicy.RUNTIME) 
@Repeatable(CustomRepeatAnnots.class) 
@interface Words { 
String word() default "Hello"; 
int value() default 0; 
} 

public class RepeatableAnnotationProgram extends BaseAnnotationProgram {

	// Repeat Words on newMethod 
	 @Words(word = "First", value = 1) 
	 @Words(word = "Second", value = 2)
	 public static void newMethod(){ 
		 RepeatableAnnotationProgram obj = new RepeatableAnnotationProgram(); 

	     try{ 
	         Class<?> c = obj.getClass(); 

	         // Obtain the annotation for newMethod 
	         Method m = c.getMethod("newMethod"); 
	           
	         // Display the repeated annotation 
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


    
 

