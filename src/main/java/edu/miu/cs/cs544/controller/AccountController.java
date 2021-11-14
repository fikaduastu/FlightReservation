package edu.miu.cs.cs544.controller;

import edu.miu.cs.cs544.domain.Account;
import edu.miu.cs.cs544.service.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountServiceImpl accountService;

    @GetMapping("/test")
    public String test(){
        return "Account controller test!";
    }

    @PostMapping("/testpost")
    public ResponseEntity<Account> testPost(@RequestBody Account request){
        Account entity = new Account();
        entity.setUsername(request.getUsername());
        entity.setPassword(request.getPassword());
        return ResponseEntity.ok(entity);
    }

    @PostMapping("/registration")
    public ResponseEntity<Account> register(@RequestBody Account request) {
        Account response = accountService.register(request);
        return ResponseEntity.ok(response);
    }



}
