package the.java.code.reflection.ch3.reflection4.test;

import the.java.code.reflection.ch3.reflection4.ContainerService;

public class App {

    public static void main(String[] args) {
        AccountService accountService = ContainerService.getObject(AccountService.class);
        accountService.join();
    }
    /**
     * 실제 spring에 IOC Container보다는 매우 효율도떨어지고 singleton도 안되지만,
     * 우리가 이런걸 만들어봄으로써,Ioc container가 reflection 기술로
     * 객체들을 만들고 주입을 해주는것을 경험해볼수있다.
     */
}
