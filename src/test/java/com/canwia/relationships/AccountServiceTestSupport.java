package com.canwia.relationships;

import com.canwia.relationships.dto.AccountDto;
import com.canwia.relationships.dto.request.AccountCreateRequest;
import com.canwia.relationships.dto.request.AccountUpdateRequest;
import com.canwia.relationships.model.Account;

public class AccountServiceTestSupport {

    public Account generateAccount(){
        Account account = new Account();
        account.setId(1L);
        account.setAccountName("canwia");
        account.setPassword("35asd35");
        account.setEmail("aaa@aaaa");
        account.setPhone("5554443212");
        account.setLocation("warszawa");
        return account;
    }

    public AccountDto generateAccountDto(){
        AccountDto accountDto = new AccountDto();
        accountDto.setId(1L);
        accountDto.setAccountName("canwia");
        accountDto.setPassword("35asd35");
        accountDto.setEmail("aaa@aaaa");
        accountDto.setPhone("5554443212");
        accountDto.setLocation("warszawa");
        return accountDto;
    }


    public AccountCreateRequest generateAccountCreateRequest(){
        AccountCreateRequest accountCreateRequest = new AccountCreateRequest();
        accountCreateRequest.setAccountName("canwia");
        accountCreateRequest.setPassword("35asd35");
        accountCreateRequest.setEmail("aaa@aaaa");
        accountCreateRequest.setPhone("5554443212");
        accountCreateRequest.setLocation("warszawa");
        return accountCreateRequest;
    }

    public AccountUpdateRequest generateAccountUpdateRequest(){
        AccountUpdateRequest accountUpdateRequest = new AccountUpdateRequest();
        accountUpdateRequest.setAccountName("canwia");
        accountUpdateRequest.setPassword("35asd35");
        accountUpdateRequest.setEmail("aaa@aaaa");
        accountUpdateRequest.setPhone("5554443212");
        accountUpdateRequest.setLocation("warszawa");
        return accountUpdateRequest;
    }

}
