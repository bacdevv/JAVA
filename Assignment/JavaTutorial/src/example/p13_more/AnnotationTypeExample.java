package example.p13_more;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/*********************************/

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface AnnotationClass {
	String text();
	int[] numbers();
	double value() default 1.0;
}

/*********************************/

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface AnnotationParameter {
	String[] values();
}

/*********************************/

@AnnotationClass(text="WORD", numbers = {1, 2, 3})
class ClassDemo {
	
	@AnnotationParameter(values = {"Hello", "World"})
	static void printValues(String value) {
		System.out.println("Test: " + value);
	}
	
}

public class AnnotationTypeExample {
	
	public static void main(String[] args) {
		Annotation[] annotations = ClassDemo.class.getAnnotations();
		for (Annotation annotation : annotations) {
			System.out.println(annotation);
		}
		
		AnnotationClass annotationClass = ClassDemo.class.getAnnotation(AnnotationClass.class);
		if(annotationClass != null) {
			System.out.printf("%s | %s | %s\n",
					annotationClass.text(),
					Arrays.toString(annotationClass.numbers()),
					annotationClass.value());
		}
		
		ClassDemo instance = new ClassDemo();
		
		for (Method method: ClassDemo.class.getDeclaredMethods()) {
			AnnotationParameter ap = method.getAnnotation(AnnotationParameter.class);
			if(ap != null) {
				String[] values = ap.values();
				for (String v : values) {
					try {
						method.invoke(instance, v);
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		
		
	}

}
