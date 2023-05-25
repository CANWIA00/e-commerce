package com.canwia.relationships.controller;

import com.canwia.relationships.Service.AccountService;
import com.canwia.relationships.dto.AccountDto;
import com.canwia.relationships.dto.request.AccountCreateRequest;
import com.canwia.relationships.dto.request.AccountUpdateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id){
        return ResponseEntity.ok(accountService.findAccountById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<AccountDto> createAccount(@RequestBody AccountCreateRequest accountCreateRequest){
        return ResponseEntity.ok(accountService.createAccount(accountCreateRequest));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AccountDto> updateAccountById(@PathVariable Long id, @RequestBody AccountUpdateRequest accountUpdateRequest){
        return ResponseEntity.ok(accountService.updateAccountById(id,accountUpdateRequest));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAccountById(@PathVariable Long id){
        accountService.deleteAccountById(id);
        return ResponseEntity.noContent().build();
    }
}
