package the.java.code.reflection.ch4.DynamicProxy2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultBookService implements BookService{

    @Autowired
    BookRepository bookRepository;

    public void rent(Book book){
        System.out.println("rent : " + book.getTitle("Dynamic Proxy"));
    }
    //만약에 책을 빌릴때 추가적인 logging이 필요하다고 해보자.
    //이때 비즈니스로직은 건들이지않고, 추가적인 로직을 구현하느게 proxyPattern에서는 가능하다.

    public void delete(Book book){
        System.out.println("책을 부셔버렷다." + book.getTitle("Dynamic Proxy"));
    }

}
