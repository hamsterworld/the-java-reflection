package the.java.code.reflection.ch5.annotationprocessor2;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) //이렇게하면 3군데에 붙일수있다. Interface,class,Eunm
@Retention(RetentionPolicy.SOURCE) //SOURCE Level에서만 필요하다.
public @interface Magic {
}
