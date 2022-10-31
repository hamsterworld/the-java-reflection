package the.java.code.reflection.ch3.reflection2;

import java.lang.reflect.Modifier;
import java.util.Arrays;

public class HowtoSpringInjection {



    public static void main(String[] args) throws ClassNotFoundException {

        //아래처럼하면 조회가안된다 왜안될까?
        Arrays.stream(Book.class.getAnnotations()).forEach(System.out::println);

        /**
         * 일단 annotation은 근본적으로는
         * 주석이나 마찬가지이다 지금쓰는 /**,//나 비슷하다는것이다.
         * 그래서 class에 남는데 bytecode를 로딩했을때 메모리상에는 남지않는다.
         * 그래서 빼고읽어온다 근데 annotation까지 같이 읽어오고싶다?
         * @Retention(RetentionPolicy.RUNTIME)을 주자
         * 그럼이제 조회가 될것이다.
         */

        /**
         *
         * annotation을 사용할수잇는 위치를 지정할수도있다.
         * @Target
         *
         */

        /**
         * annotation은 값들을 가질수있다.
         * String,Integer등등..
         * default로 기본값을 안주면 컴파일 에러가난다.
         * 참고로 value()로 주면 name = "inseok"과같은 값을줄때
         * "value"이렇게만 주면된다. 근데 여러가지 속성을 설정할때는
         *  value = "value"이런거써야된다.
         */

        /**
         * @Inherited를 붙이면 annotation도 상속이된다.
         * 참고로 annotation이 같은거면 하나만 나온다.
         */

        //@Inherited를 붙여서 하면 상속된 annotation이 나온다.
        Arrays.stream(MyBook.class.getAnnotations()).forEach(System.out::println);

        //아래처럼 하면 해당 annotation만 된다.
        Arrays.stream(MyBook.class.getDeclaredAnnotations()).forEach(System.out::println);

        //annotation은 field에도 붙을수있고 method에서도 붙을수있다.
        //method에붙은 annotation도 조회할수가있다. (당연히 field도 가능)
        Arrays.stream(MyBook.class.getDeclaredFields()).forEach(f -> {
            f.getAnnotations();
        });

    }
}
