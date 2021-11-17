package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.domain.Account;
import edu.miu.cs.cs544.domain.Address;
import edu.miu.cs.cs544.domain.Person;
import edu.miu.cs.cs544.domain.Role;
import edu.miu.cs.cs544.repository.AccountRepository;
import edu.miu.cs.cs544.repository.AddressRepository;
import edu.miu.cs.cs544.repository.PersonRepository;
import edu.miu.cs.cs544.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Account getAccount(Long id) {
        return accountRepository.findById(id).get();
    }


//    @Override
//    public Account update(Long id,Account account){
//        Account account1 = getAccount(id);
//        account1.getPerson(account.getPerson());
//    }


    @Override
    public Account register(Account account) {

        List<Role> roles =  account.getRoles();
        List<Role> roleEntity = new ArrayList<>();
        for (Role role:roles){
            roleEntity.add(roleRepository.save(role));
        }

        Address address = account.getPerson().getAddress();
        Address addressEntity = addressRepository.save(address);
        Person person = account.getPerson();
        person.setAddress(addressEntity);



        account.setRoles(roleEntity);
        Account acc = accountRepository.save(account);
        person.setAccount(acc);
        Person personEntity = personRepository.save(person);
        acc.setPerson(personEntity);
        accountRepository.flush();

        return acc;
    }

    @Override
    public void delete(Long id) {
            accountRepository.deleteById(id);
    }

    @Override
    public List<Account> getAllAccount() {
        return accountRepository.findAll();
    }
}
