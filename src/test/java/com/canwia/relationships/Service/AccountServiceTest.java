package com.canwia.relationships.Service;

import com.canwia.relationships.AccountServiceTestSupport;
import com.canwia.relationships.dto.AccountDto;
import com.canwia.relationships.dto.converter.AccountDtoConverter;
import com.canwia.relationships.dto.request.AccountCreateRequest;
import com.canwia.relationships.dto.request.AccountUpdateRequest;
import com.canwia.relationships.model.Account;
import com.canwia.relationships.repository.AccountRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Optional;


@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class AccountServiceTest extends AccountServiceTestSupport {


    private AccountService accountService;
    private AccountRepository accountRepository;
    private AccountDtoConverter accountDtoConverter;


    @BeforeEach
    void setUp() {
        accountRepository = Mockito.mock(AccountRepository.class);
        accountDtoConverter = Mockito.mock(AccountDtoConverter.class);

        accountService = new AccountService(accountRepository,accountDtoConverter);
    }


    @Test
    void whenFindAccountByIdReturnValidDto() {

        Long id = 1L;
        Account account = generateAccount();
        AccountDto accountDto = generateAccountDto();


        Mockito.when(accountRepository.findById(id)).thenReturn(Optional.of(account));
        Mockito.when(accountDtoConverter.convert(account)).thenReturn(accountDto);

        AccountDto result = accountService.findAccountById(id);
        Assertions.assertEquals(result,accountDto);

        Mockito.verify(accountRepository).findById(account.getId());
        Mockito.verify(accountDtoConverter).convert(account);

        Mockito.reset(accountDtoConverter);
        Mockito.reset(accountRepository);

    }

    @Test
    void whenFindAccountById_thenReturnValidModel() {
        Long id = 1L;

        Account account = generateAccount();


        Mockito.when(accountRepository.findById(id)).thenReturn(Optional.of(account));

        Account result = accountService.findAccount(id);
        Assertions.assertEquals(result,account);

        Mockito.verify(accountRepository).findById(id);

        Mockito.reset(accountRepository);

    }

    @Test
    void createAccount() {
        AccountCreateRequest accountCreateRequest = generateAccountCreateRequest();
        Account account = generateAccount();
        AccountDto accountDto =generateAccountDto();


        Mockito.when(accountRepository.save(account)).thenReturn(Mockito.any(Account.class));
        Mockito.when(accountDtoConverter.convert(account)).thenReturn(Mockito.any(AccountDto.class));

        AccountDto result = accountService.createAccount(accountCreateRequest);
        Assertions.assertEquals(result,accountDto);

        Mockito.verify(accountRepository).save(account);
        Mockito.verify(accountDtoConverter).convert(account);

    }

    @Test
    void whenUpdateAccountById_thenReturnDto() {

        Long id = 1L;
        Account account = generateAccount();
        AccountDto accountDto = generateAccountDto();
        AccountUpdateRequest accountUpdateRequest = generateAccountUpdateRequest();

        Mockito.when(accountRepository.findById(id)).thenReturn(Optional.of(account));
        Mockito.when(accountRepository.save(account)).thenReturn(account);
        Mockito.when(accountDtoConverter.convert(account)).thenReturn(accountDto);

        AccountDto result = accountService.updateAccountById(id,accountUpdateRequest);
        Assertions.assertEquals(result,accountDto);

        Mockito.verify(accountRepository).findById(id);
        Mockito.verify(accountRepository).save(account);
        Mockito.verify(accountDtoConverter).convert(account);

        Mockito.reset(accountDtoConverter);
        Mockito.reset(accountRepository);
    }


}