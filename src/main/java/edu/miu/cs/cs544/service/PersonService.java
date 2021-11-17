package edu.miu.cs.cs544.service;


import edu.miu.cs.cs544.domain.Person;

import java.util.List;

public interface PersonService {

    public List<Person> getAll();
    public Person add(Person person);
    public Person update(Person person);
    public void delete(Long id);

    public List<Person> getAllPassenger();
    public Person findByPassengerId(Long id);

    public List<Person> getAllAdmin();
    public Person findByAdminId(Long id);

    public List<Person> getAllAgent();
    public Person findByAgentId(Long id);

}
