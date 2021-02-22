package com.bank.stroeer.boot;

import com.bank.stroeer.model.Account;
import com.bank.stroeer.model.User;
import com.bank.stroeer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;

@Component
public class DataLoader implements CommandLineRunner {

    private UserRepository bankRepository;
    private final PasswordEncoder passwordEncoder;

    public DataLoader(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    public void setProductRepository(UserRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    @Override
    public void run(String... strings) throws Exception {

        User firstUser = new User();
        firstUser.setFirstName("Faezeh");
        firstUser.setLastName("Esfahani");
        firstUser.setUserName("ftesfahani");
        firstUser.setPassword(passwordEncoder.encode("pass"));

        Account firstAccount=new Account();
        firstAccount.setIBAN("DE12 1234 1234 1234 1234 12");
        firstAccount.setUser(firstUser);
        firstUser.setAccounts(new HashSet<>());
        firstUser.getAccounts().add(firstAccount);

        bankRepository.save(firstUser);

    }
}
