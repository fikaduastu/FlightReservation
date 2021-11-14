package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.domain.Account;
import edu.miu.cs.cs544.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account get(long id) {
        return accountRepository.findById(id).get();
    }



    @Override
    public Account register(Account account) {

        return accountRepository.save(account);
    }

    @Override
    public void delete(long id) {
            accountRepository.deleteById(id);
    }
}
