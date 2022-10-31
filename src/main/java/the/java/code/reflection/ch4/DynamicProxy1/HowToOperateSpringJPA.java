package the.java.code.reflection.ch4.DynamicProxy1;

/**
 *  SpringJPA는 How Operate합니까?
 *  이번시간에는 DynamicProxy를 사용하는데 이것도 결국 reflection기능에 일부이다.
 *  DynamicProxy를 여러군데 사용되는데, 그중에서 가장신기한 부분이 바로 SpringJPA부분이다.
 *
 *  실제로 SpringDataJPA를 사용하면 interface에 extends해서 사용하게되는데.
 *  재밋는건 이 interface를 실행해보면 null이 아니다.
 *  How? 이게 가능한것일까?
 *
 *  도대체 누가 이것을 만들어준것인가?
 *  이것의 핵심이 바로 proxy이다.
 *  이것의 시작은 java.lang.reflection에 있다.
 *
 *  또 SpringAOP에서 ProxyFactory라는것을 제공한다.
 *  SpringJPA도 ProxyFactory를 사용한다.
 *  즉,SpringAOP기반으로 동작하여, RepositoryFactorySupport에서 프록시를 생성한다.
 *  그 안에서
 *  ProxyFactory result = new ProxyFactory();
 *  result.setTarget(target);
 *  result.setInterfaces(repositoryInterface,Repository.class,TransactionalProxy.class);
 *  요부분에서 interface의 proxy instance를 만들어서 Inject해준다.
 *
 */
public class HowToOperateSpringJPA {

}
