package com.bank.stroeer.service;


import com.bank.stroeer.model.Account;
import com.bank.stroeer.model.User;
import com.bank.stroeer.repository.UserRepository;
import com.bank.stroeer.util.AccountMapper;
import com.bank.stroeer.dto.model.AccountDto;
import com.bank.stroeer.repository.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Faezeh Esfahani.
 */

@Service
public class AccountService {

    private Logger LOG = LoggerFactory.getLogger(AccountService.class);

    private AccountRepository accountRepository;
    private final UserRepository userRepository;

    public AccountService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setAccountRepository(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account saveAccount(AccountDto accountDto, String userName) {
        Account accountToSave;
        try {
            LOG.info("Saving account...");
            User user = userRepository.findUserByUserName(userName).orElseThrow(() -> new RuntimeException("User not found"));
            accountToSave = accountRepository.save(AccountMapper.fromAccountDto(accountDto, user));
            return accountToSave;
        } catch (Exception e) {
            throw new RuntimeException("Exception Saving account");
        }
    }

    public List<AccountDto> loadAllUserAccounts(String userName){
        return accountRepository.findAllByUser_UserName(userName).stream()
                .map(AccountMapper::toAccountDto)
                .collect(Collectors.toList());
    }
}

