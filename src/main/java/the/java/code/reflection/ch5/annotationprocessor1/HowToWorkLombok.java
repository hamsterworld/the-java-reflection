package the.java.code.reflection.ch5.annotationprocessor1;

/**
 * LomBok은 대표적인 Annotation Processor중 하나이다.
 * java가 제공하는 annotationprocessor의 기능을 기반으로 만들어진것이다.
 * annotationprocessor는 컴파일할때 끼어든다.
 * 특정한 annotation이 붙어잇는 source코드를 참조한다음,
 * 또다른 source코드를 만들어내는 기능이다.
 *
 * annotationprocessor는
 * annotation이 붙어있는 class정보를 트리구조로 참고할수있다.
 * AST(abstract syntax tree)라고도 한다.
 * source의 구조를 트리로 보여준다.
 * processor가 제공하는 api로는 이 트리를 참조만 가능하다.
 * 그리고 수정하지못한다.
 * 즉,annotation이 붙어잇는 class의 정보만 알수있지 수정은 못한다.
 * 근데 lombok은 마치 수정이 된것마냥 사용한다.
 * lombok이 근데 타입캐스팅을 통해서 하위클래스로 만든다음,
 * 변경한다. 그래서 lombok을 해킹이다라고 말하기도한다. 정상적인 사용법이 아니다.
 * 근데 lombok에 대한이 크게없어서...
 */
public class HowToWorkLombok {


}
