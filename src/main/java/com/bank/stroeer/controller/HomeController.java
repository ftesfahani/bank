package com.bank.stroeer.controller;

import com.bank.stroeer.dto.model.AccountDto;
import com.bank.stroeer.model.Account;
import com.bank.stroeer.repository.AccountRepository;
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
public class HomeController {

    private AccountService accountService;

    @Autowired
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }


    @RequestMapping(path = "/")
    public String index(Model model, Authentication authentication) {
        List<AccountDto> accountDtoList = accountService.loadAllUserAccounts(authentication.getName());
        model.addAttribute("accounts", accountDtoList);
        return "accounts";
    }

    @RequestMapping(path = "/accounts/add", method = RequestMethod.GET)
    public String createAccount(Model model) {
        model.addAttribute("account", new AccountDto());
        return "edit";
    }


}
