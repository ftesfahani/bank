package com.bank.stroeer.util;

import com.bank.stroeer.dto.model.AccountDto;
import com.bank.stroeer.model.Account;
import com.bank.stroeer.model.User;

/**
 * Created by Faezeh Esfahani
 */
public class AccountMapper {
    public static AccountDto toAccountDto(Account account) {
        return new AccountDto()
                .setIBAN(account.getIBAN())
                .setId(account.getId())
                .setUserName(account.getUser().getUserName());
    }

    public static Account fromAccountDto(AccountDto accountDto, User user){
        return new Account()
                .setIBAN(accountDto.getIBAN())
                .setId(accountDto.getId())
                .setUser(user);
    }

}
