package the.java.code.DynamicProxy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import the.java.code.reflection.ch4.DynamicProxy2.Book;
import the.java.code.reflection.ch4.DynamicProxy2.BookService;
import the.java.code.reflection.ch4.DynamicProxy2.BookServiceProxy;
import the.java.code.reflection.ch4.DynamicProxy2.DefaultBookService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@RunWith(SpringRunner.class)
public class BookServiceTest {

    //BookService bookService = new DefaultBookService();
    BookService bookService = new BookServiceProxy();
    //이렇게 proxy가 대신등록된다.
    BookService bookServiceproxytest = (BookService) Proxy.newProxyInstance(BookService.class.getClassLoader(), new Class[]{
            BookService.class}, new InvocationHandler() {

         BookService bookService = new DefaultBookService();

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if(method.getName().equals("rent")){
                System.out.println("안녕");
                Object invoke = method.invoke(bookService, args);
                System.out.println("잘가");
                return invoke;
            }
            return method.invoke(bookService,args);
        }
    });
    //이제 proxy를 그만만들어도되지만. 적용되는 method가 많아질수록
    //handler에 적용되는 logic이 점점더 길어질것이다.
    //그래서 springAOP가 다 뜯어고쳣다.


    @Test
    public void di(){
        Book book = new Book();
        bookServiceproxytest.rent(book);
    }


}
