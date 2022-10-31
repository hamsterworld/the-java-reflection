package the.java.code.reflection.ch3.reflection1;

import java.lang.reflect.Modifier;
import java.util.Arrays;

public class HowtoSpringInjection {

    /**
     *  스프링은 어떻게 DI를 할까?
     *
     *  리플렉션은 어떻게 사용할까?
     *
     *  Class라는 매서드를 사용한다.
     *  예시를 봅시다.
     *
     */

    public static void main(String[] args) throws ClassNotFoundException {
        /**
         *  class로딩(아마 classLoder쪽을 뜻하는듯?)이 끝나면,
         *  class타입의 인스턴스를 만들어서 heap에다가 넣는다.
         *  그래서 아래처럼 바로 인스턴스마냥 사용할수있다.
         */
        //첫번째 방법
        Class<Book> bookClass = Book.class;

        //두번째방법(만약에 인스턴스가 있다면 이렇게도 가능하다.)
        Book book = new Book();
        Class<? extends Book> aClass = book.getClass();

        //세번째방법(만약에 나는 문자열밖에모른다.)
        //물론 아래 문자열에 해당되는 class가없으면 classNotFoundException이 발생한다.
        Class<?> aClass1 = Class.forName("the.java.code.reflection.ch3.reflection1.Book");

        //어떤 방법이든지 위에 3가지중 아무거나 접근만하면된다.

        //아래와같은 방법은 public만 가져온다.
        Arrays.stream(bookClass.getFields()).forEach(System.out::println);
        //아래를 써야 private도 다 가져올수잇다.
        //또 private에 접근하려면 setAccess를 설정해주어야한다.
        //일단 값을가져올려면 인스턴스가 필요하다. 28번째줄
        Arrays.stream(bookClass.getDeclaredFields()).forEach(f -> {
                    try {
                        f.setAccessible(true);
                        System.out.printf("%s %s \n",f, f.get(book));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
        );

        //method도 전부 출력가능
        Arrays.stream(bookClass.getDeclaredMethods()).forEach(System.out::println);

        //constructor도 출력가능
        Arrays.stream(bookClass.getDeclaredConstructors()).forEach(System.out::println);

        //상속관계도 확인가능
        System.out.println(MyBook.class.getSuperclass());

        //interface도 확인가능
        Arrays.stream(MyBook.class.getInterfaces()).forEach(System.out::println);

        Arrays.stream(Book.class.getDeclaredFields()).forEach(f -> {
            int modifiers = f.getModifiers();
            System.out.println(modifiers);
            System.out.println(Modifier.isPrivate(modifiers));
            System.out.println(Modifier.isStatic(modifiers));
        });



    }
}
