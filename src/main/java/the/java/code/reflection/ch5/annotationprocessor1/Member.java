package the.java.code.reflection.ch5.annotationprocessor1;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Member {

    private String name;

    private int age;

    public boolean isSameAge(Member member){
        return this.age == member.age;
    }

    //자바빈즈 코드가 여러개 막get,set등등이 있으면 여기서 핵심로직이 뭐있는지
    //몰라서 그냥 넘어갈수도잇다.

}
