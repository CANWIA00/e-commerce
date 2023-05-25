package com.canwia.relationships.dto.request;

import lombok.Data;

@Data
public class AccountCreateRequest {

    private String accountName;
    private String password;
    private String email;
    private String phone;

    private String location;
}
