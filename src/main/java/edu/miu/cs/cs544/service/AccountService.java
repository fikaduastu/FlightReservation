package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.domain.Account;

import java.util.List;

public interface AccountService {

    public Account getAccount(Long id);

    public Account register(Account account);

    public void delete(Long id);

    public List<Account> getAllAccount();

    
}
