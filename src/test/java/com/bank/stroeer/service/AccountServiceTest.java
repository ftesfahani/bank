package com.bank.stroeer.service;

import com.bank.stroeer.dto.model.AccountDto;
import com.bank.stroeer.model.Account;
import com.bank.stroeer.repository.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;


public class AccountServiceTest {

    @Mock
    AccountRepository accountRepository;

    AccountService accountService;

    private AccountDto defaultAccountDto;

    private String defaultUserName;

    @BeforeEach
    private void createDefaultAccountDTO() {
        defaultAccountDto = new AccountDto("4028208177c91dbb0177c91dc0040000","DE12 1234 1234 1234 1234 12","ftesfahani");
        defaultUserName="ftesfahani";
    }

    @Test
    void saveAccount_WHEN_successful_THEN_returnAccount() {

        doNothing().when(accountRepository.save(any(Account.class)));

        accountService.saveAccount(defaultAccountDto,defaultUserName);
        ArgumentCaptor<Account> accountCapture = ArgumentCaptor.forClass(Account.class);

        verify(accountRepository, times(1)).save(accountCapture.capture());
        verifyNoMoreInteractions(accountRepository);

        Account accountResult = accountCapture.getValue();
        assertAccountEqualsToDTO(accountResult, defaultAccountDto);

    }

    private void assertAccountEqualsToDTO(Account account, AccountDto dto) {
        assertThat(account)
                .usingRecursiveComparison()
                .isEqualTo(dto);
    }
}
