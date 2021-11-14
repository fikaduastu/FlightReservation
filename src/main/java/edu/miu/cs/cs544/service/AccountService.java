package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.domain.Account;

public interface AccountService {

    public Account get(long id);

    public Account register(Account account);

    public void delete(long id);


    
}
