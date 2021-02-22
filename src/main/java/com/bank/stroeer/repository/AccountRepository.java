package com.bank.stroeer.repository;

import com.bank.stroeer.model.Account;
import com.bank.stroeer.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

    List<Account> findAllByUser_UserName(String userName);

    boolean existsByIBAN(String iban);

    boolean existsByIBANAndIdNot(String iban, String id);

}

