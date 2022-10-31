package the.java.code.reflection.ch3.reflection2;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE , ElementType.FIELD}) //타입과 필드에만 붙일수있다.
@Inherited
public @interface MyAnnotation {

    String name() default "inseok";

    int number() default 100;

    String value() default "hihi";

}
