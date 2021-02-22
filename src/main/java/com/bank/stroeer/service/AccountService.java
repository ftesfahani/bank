package com.bank.stroeer.service;


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

    @Autowired
    public void setAccountRepository(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

//    public ProductDto getProduct(String id) {
//        try {
//            LOG.info("Getting the product with given id:" + id);
//            Optional<Product> product = productRepository.findById(id);
//            if (product.isPresent()) {
//                return ProductMapper.toProductDto(product.get());
//            }
//        } catch (Exception e) {
//            LOG.error("An error occurred during product saving:" + e.getMessage());
//        }
//        throw new ProductNotFoundException();
//    }

//    public Account saveAccount(AccountDto accountDto) {
//        Account productToSave;
//        try {
//            LOG.info("Saving account...");
//            productToSave = accountRepository.save(AccountMapper.toAccountDto(accountDto));
//            return productToSave;
//        } catch (Exception e) {
//            LOG.error("An error occurred during product saving:" + e.getMessage());
//        }
//        return new Account();
//    }

    public List<AccountDto> loadAllUserAccounts(String userName){
        return accountRepository.findAllByUser_UserName(userName).stream()
                .map(AccountMapper::toAccountDto)
                .collect(Collectors.toList());
    }
}

