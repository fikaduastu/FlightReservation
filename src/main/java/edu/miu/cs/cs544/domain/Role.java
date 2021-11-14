package edu.miu.cs.cs544.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "Role")
public class Role {


    @Id
    @Column(name = "id")
    @GeneratedValue
    private long id;

    @Column(name = "name",nullable = false)
    private String name;

}
