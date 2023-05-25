package com.canwia.relationships.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    private Long id;
    private String accountName;
    private String password;
    private String email;
    private String phone;
    private String location;
}
