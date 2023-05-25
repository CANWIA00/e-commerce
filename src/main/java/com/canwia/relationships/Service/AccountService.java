package com.canwia.relationships.Service;

import com.canwia.relationships.dto.AccountDto;
import com.canwia.relationships.dto.converter.AccountDtoConverter;
import com.canwia.relationships.dto.request.AccountCreateRequest;
import com.canwia.relationships.dto.request.AccountUpdateRequest;
import com.canwia.relationships.exception.ApiRequestException;
import com.canwia.relationships.model.Account;
import com.canwia.relationships.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final AccountDtoConverter accountDtoConverter;

    public AccountService(AccountRepository accountRepository, AccountDtoConverter accountDtoConverter) {
        this.accountRepository = accountRepository;
        this.accountDtoConverter = accountDtoConverter;
    }

    public AccountDto findAccountById(Long id){
        Account account = accountRepository.findById(id).orElseThrow(()-> {
            throw new ApiRequestException("Account is not fount whit " + id + " number!");
        });
        return accountDtoConverter.convert(account);
    }

    public Account findAccount(Long id){
        return accountRepository.findById(id).orElseThrow(()-> {
            throw new ApiRequestException("Account is not fount whit " + id+ " number!");
        });
    }

    public AccountDto createAccount(AccountCreateRequest accountCreateRequest) {
        Account account = new Account();
        account.setAccountName(accountCreateRequest.getAccountName());
        account.setPassword(accountCreateRequest.getPassword());
        account.setEmail(accountCreateRequest.getEmail());
        account.setPhone(accountCreateRequest.getPhone());
        account.setLocation(accountCreateRequest.getLocation());

        return accountDtoConverter.convert(accountRepository.save(account));
    }


    public AccountDto updateAccountById(Long id, AccountUpdateRequest accountUpdateRequest) {
        Account account = accountRepository.findById(id).orElseThrow(()->{
           throw new ApiRequestException("Account is not fount with " + id +" number!");
        });

        account.setAccountName(accountUpdateRequest.getAccountName());
        account.setPassword(accountUpdateRequest.getPassword());
        account.setEmail(accountUpdateRequest.getEmail());
        account.setLocation(accountUpdateRequest.getLocation());
        account.setPhone(accountUpdateRequest.getPhone());
        accountRepository.save(account);

        return accountDtoConverter.convert(account);
    }

    public void deleteAccountById(Long id) {
        Optional<Account> account = accountRepository.findById(id);
        if (account.isEmpty()){
            throw new ApiRequestException("Account is not fount with " + id +" number!");
        }
        accountRepository.deleteById(id);
    }
}
