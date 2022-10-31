package the.java.code.reflection;


import org.junit.jupiter.api.Test;
import the.java.code.reflection.ch3.reflection4.ContainerService;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ContainerServiceTest {

    @Test
    public void getObject_BookRepository(){
        BookRepository bookRepository = ContainerService.getObject(BookRepository.class);
        assertNotNull(bookRepository);
    }

    @Test
    public void getObject_BookService(){
        BookService bookRepository = ContainerService.getObject(BookService.class);
        assertNotNull(bookRepository);
        assertNotNull(bookRepository.bookRepository);
    }

}
