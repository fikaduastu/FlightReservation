package edu.miu.cs.cs544.service;

import edu.miu.cs.cs544.domain.Person;
import edu.miu.cs.cs544.domain.Reservation;
import edu.miu.cs.cs544.domain.Role;
import edu.miu.cs.cs544.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PersonServiceImpl implements PersonService{

    @Autowired
    private PersonRepository personRepository;




    @Override
    public List<Person> getAll() {
        Boolean hasPassenger = false;
        List<Person> personList = personRepository.findAll();
        List<Person> passengerList = new ArrayList<>();
        for(Person person: personList){
           for(Role role:person.getAccount().getRoles()){
               if (role.equals("PASSENGER"))
                   hasPassenger = true;
           }
           if(hasPassenger)
               passengerList.add(person);
                hasPassenger = false;
        }
        return passengerList;


    }


    @Override
    public Person add(Person person) {return personRepository.save(person);}

    @Override
    public Person update(Person person) {
        return personRepository.save(person);
    }

    @Override
    public void delete(Long id) {personRepository.deleteById(id);}

    @Override
    public List<Person> getAllPassenger() {
        return personRepository.findAll();
    }

    @Override
    public Person findByPassengerId(Long id) {return personRepository.findById(id).get();}

    @Override
    public List<Person> getAllAdmin() {
        return personRepository.findAll();
    }

    @Override
    public Person findByAdminId(Long id) {
        return personRepository.findById(id).get();
    }

    @Override
    public List<Person> getAllAgent() {
        return personRepository.findAll();
    }

    @Override
    public Person findByAgentId(Long id) {
        return personRepository.findById(id).get();
    }


}
