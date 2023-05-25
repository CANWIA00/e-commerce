package com.canwia.relationships.dto.converter;

import com.canwia.relationships.dto.AccountDto;
import com.canwia.relationships.model.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDtoConverter {


    public AccountDto convert(Account account){
        return new AccountDto(account.getId(), account.getAccountName(), account.getPassword(), account.getEmail(), account.getPhone(), account.getLocation());
    }



}
