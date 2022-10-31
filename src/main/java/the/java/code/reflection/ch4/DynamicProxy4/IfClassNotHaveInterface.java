package the.java.code.reflection.ch4.DynamicProxy4;

/**
 *  만약에 우리가 Proxy를 넣을려고하는 Class가 Interface가 없다면?
 *  DynamicProxy를 구현할수가없다.
 *  CGLIB와 ByteBuddy로 만들수있다.
 *  ByteBuddy는 바이트코드 조작뿐만아니라 Proxy 만들때도 사용할수잇다.
 *  이부분도 Spring AOP 김영한강의 보면될듯.
 *
 */
public class IfClassNotHaveInterface {
}
