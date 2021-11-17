package edu.miu.cs.cs544.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class AccountDTO {
    private String username;
    private String password;
    private List<RoleDTO> roles = new ArrayList<>();
    private PersonDTO person;
}
