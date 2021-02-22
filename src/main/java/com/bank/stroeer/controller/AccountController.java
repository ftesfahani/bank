package com.bank.stroeer.controller;

import com.bank.stroeer.dto.model.AccountDto;
import com.bank.stroeer.model.Account;
import com.bank.stroeer.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class AccountController {

    private AccountService accountService;

    @Autowired
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }


    @RequestMapping(path = "accounts",method = RequestMethod.POST)
    public String saveAccount(AccountDto accountDto, Authentication authentication) {
        accountService.saveAccount(accountDto, authentication.getName());
        return "redirect:/";
    }

}
