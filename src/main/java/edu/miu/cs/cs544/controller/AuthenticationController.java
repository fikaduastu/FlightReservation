package edu.miu.cs.cs544.controller;


import edu.miu.cs.cs544.dto.Login;
import edu.miu.cs.cs544.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody Login login) {
        Authentication authentication = authenticationManager.
                authenticate(new UsernamePasswordAuthenticationToken(login.getUsername(),
                        login.getPassword(), new ArrayList<>()));
        if (authentication != null) {
            return ResponseEntity.ok(jwtUtil.generateToken(authentication));
        }
        return ResponseEntity.badRequest().body("Invalid Username/password");
    }
}