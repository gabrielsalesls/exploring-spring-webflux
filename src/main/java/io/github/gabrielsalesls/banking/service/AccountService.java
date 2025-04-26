package io.github.gabrielsalesls.banking.service;

import io.github.gabrielsalesls.banking.dto.account.AccountRequestDto;
import io.github.gabrielsalesls.banking.dto.account.AccountResponseDto;
import io.github.gabrielsalesls.banking.entity.Account;
import io.github.gabrielsalesls.banking.repository.AccountRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Mono<AccountResponseDto> createAccount(AccountRequestDto accountRequestDto) {
        Account account = Account.create(
                accountRequestDto.userName(),
                BigDecimal.valueOf(100)
        );

        return accountRepository.save(account)
                .map(savedAccount -> new AccountResponseDto(
                        savedAccount.id(),
                        savedAccount.userName(),
                        savedAccount.balance()));
    }

    public Flux<AccountResponseDto> getAllAccounts() {
        return accountRepository.findAll()
                .map(savedAccount -> new AccountResponseDto(
                        savedAccount.id(),
                        savedAccount.userName(),
                        savedAccount.balance()));
    }
}
