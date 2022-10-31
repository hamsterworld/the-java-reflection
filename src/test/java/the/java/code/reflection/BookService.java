package the.java.code.reflection;

import the.java.code.reflection.ch3.reflection4.Inject;

public class BookService {

    @Inject
    BookRepository bookRepository;
    //물론 여러가지로 주입할수있지만. ex)field주입이라던지 @Autowired지
    //그러나, 우리는 field주입을 사용한다.


}
