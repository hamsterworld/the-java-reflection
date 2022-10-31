package the.java.code.reflection.ch3.reflection3;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 이전까지는 접근하는 방법에대해서 알아봣는데,
 * 이번시간에는 reflection을 사용해서 class값들을 변경해보자.
 */
public class test {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        Class<Book> bookClass = Book.class;
        Constructor<Book> constructor = bookClass.getConstructor();
        Constructor<Book> constructor1 = bookClass.getConstructor(String.class);
        Book book = constructor.newInstance();
        Book book1 = constructor1.newInstance("hamster");

        Field a = bookClass.getDeclaredField("A");
        a.get(null); //이 field는 static한놈이므로 instance를 넘겨주지않아도된다.
        a.set(null,"AAAAAA");//값을 세팅할땐 set을쓴다.
        System.out.println(a.get(null));

        Field b = bookClass.getDeclaredField("B");
        b.setAccessible(true); //접근지시자가 private이므로.
        b.get(book); //b는 instance가 필요하다.
        b.set(book,"BBBBBB");//값을 세팅할땐 set을쓴다.
        System.out.println(b.get(book));

        Method c = bookClass.getDeclaredMethod("c");
        c.setAccessible(true);
        c.invoke(book);

        Method d = bookClass.getDeclaredMethod("sum",int.class,int.class);
        d.setAccessible(true);
        int invoke = (int)d.invoke(book, 1, 2);
        System.out.println(invoke);

    }

}
