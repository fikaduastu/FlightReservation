package edu.miu.cs.cs544.controller;
import edu.miu.cs.cs544.domain.Person;
import edu.miu.cs.cs544.service.AccountServiceImpl;
import edu.miu.cs.cs544.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private AccountServiceImpl accountService;

    //List of all persons
    @GetMapping("/getAll")
    public ResponseEntity<List<Person>> getAllPersons(){
        List<Person> personList = personService.getAll();
        if (personList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(personList);
    }

    // Passenger CRUD
    @GetMapping("/passengers")
    public ResponseEntity<List<Person>> getAllPassengers() {
        List<Person> passengerList =  personService.getAllPassenger();

        if (passengerList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(passengerList);
    }

    @GetMapping("/passengers/{id}")
    public ResponseEntity<Person> getOnePassenger(@PathVariable long id) {
        Person passenger = personService.findByPassengerId(id);
        if (passenger == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(passenger);
    }

    @PostMapping("/passengers")
    public ResponseEntity<Person> addPassenger(@RequestBody Person person) {
        Person passenger =  personService.add(person);
        return ResponseEntity.ok(passenger);
    }

    @PutMapping("passengers/{id}")
    public ResponseEntity<Person> updatePassenger(@PathVariable Long id, @RequestBody Person passenger) {
        Person updatedPassenger = null;
        Person tobeUpdatePassenger =  personService.findByPassengerId(id);
        if (tobeUpdatePassenger == null) {
            updatedPassenger = personService.add(passenger);
        } else {
            passenger.setId(tobeUpdatePassenger.getId());
            updatedPassenger = personService.update(passenger);
        }
        return ResponseEntity.ok(updatedPassenger);
    }

    @DeleteMapping("passengers/{id}")
    public ResponseEntity<Object> deletePassenger(@PathVariable long id) {
        personService.delete(id);
        return ResponseEntity.noContent().build();
    }

    //Admin CRUD
    @GetMapping("/admins")
    public ResponseEntity<List<Person>> findAllAdmins() {
        List<Person> adminList =  personService.getAllAdmin();
        if (adminList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(adminList);
    }

    @GetMapping("/admins/{id}")
    public ResponseEntity<Person> getOneAdmin(@PathVariable long id) {
        Person admin =  personService.findByAdminId(id);
        if (admin == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(admin);
    }

    @PostMapping("/admins")
    public ResponseEntity<Person> addadmin(@RequestBody Person admin) {
        Person addedAdmin =  personService.add(admin);
        return ResponseEntity.ok(addedAdmin);
    }

    @PutMapping("admins/{id}")
    public ResponseEntity<Person> updateAdmin(@PathVariable long id, @RequestBody Person admin) {
        Person updatedAdmin = null;
        Person tobeUpdateAdmin = personService.findByAdminId(id);
        if (tobeUpdateAdmin == null) {
            updatedAdmin =  personService.add(admin);
        } else {
            admin.setId(tobeUpdateAdmin.getId());
            updatedAdmin = personService.update(admin);
        }
        return ResponseEntity.ok(updatedAdmin);
    }

    @DeleteMapping("admins/{id}")
    public ResponseEntity<Object> deleteAdmin(@PathVariable long id) {
       personService.delete(id);
        return ResponseEntity.noContent().build();
    }

    //Agent CRUD
    @GetMapping("/agents")
    public ResponseEntity<List<Person>> findAllAgents() {
        List<Person> agentList = personService.getAllAgent();
        if (agentList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(agentList);
    }

    @GetMapping("/agents/{id}")
    public ResponseEntity<Person> getOneAgent(@PathVariable long id) {
        Person agent =  personService.findByAgentId(id);
        if (agent == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(agent);
    }

    @PostMapping("/agents")
    public ResponseEntity<Person> addAgent(@RequestBody Person agent) {

        Person addedAgent =  personService.add(agent);
        return ResponseEntity.ok(addedAgent);
    }

    @PutMapping("agents/{id}")
    public ResponseEntity<Person> updateAgent(@PathVariable long id, @RequestBody Person agent) {
        Person updatedAgent = null;
        Person tobeUpdateAgent =  personService.findByAgentId(id);
        if (tobeUpdateAgent == null) {
            updatedAgent =  personService.add(agent);
        } else {
            agent.setId(tobeUpdateAgent.getId());
            updatedAgent =  personService.update(agent);
        }
        return ResponseEntity.ok(updatedAgent);
    }

    @DeleteMapping("agents/{id}")
    public ResponseEntity<Object> deleteAgent(@PathVariable long id) {
        personService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
