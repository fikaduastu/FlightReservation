package edu.miu.cs.cs544.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Account")
@NoArgsConstructor
@Setter
@Getter
public class Account {

    @Id
    @Column(name ="id")
    @GeneratedValue
    private long Id;


    @Column(name ="username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToMany
    @JoinTable(name = "Account_Role")
    private List<Role> roles = new ArrayList<>();

    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
    private Person person;


}
