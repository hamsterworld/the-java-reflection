package the.java.code.annotationprocessor;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import the.java.code.reflection.ch5.annotationprocessor1.Member;

@SpringBootTest
public class MemberTest {

    @Test
    public void gettersetter(){
        Member member = new Member();
        member.setName("오인석");
        member.setAge(30);
        Assert.assertEquals(member.getName(),"오인석");
    }

}
