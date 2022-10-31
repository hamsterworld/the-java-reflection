package the.java.code.reflection.ch3.reflection4.test;

import the.java.code.reflection.ch3.reflection4.Inject;

public class AccountService {

    @Inject
    AccountRepository accountRepository;

    public void join(){
        System.out.println("Service.join");
        accountRepository.save();
    }

}
