package the.java.code.reflection.ch4.DynamicProxy2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class BookServiceProxy implements BookService{

    @Autowired @Qualifier("DefaultBookService")
    BookService bookService = new DefaultBookService();
    //지금은 mvc가 없으니까 일단은 강제로 주입해주자.

    @Override
    public void rent(Book book) {
        System.out.println("책을 빌리기 시작합니다.");
        bookService.rent(book);
        System.out.println("책 빌리기가 종료되었습니다.");
    }

}
