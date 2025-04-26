package io.github.gabrielsalesls.banking.controller;

import io.github.gabrielsalesls.banking.dto.account.AccountRequestDto;
import io.github.gabrielsalesls.banking.dto.account.AccountResponseDto;
import io.github.gabrielsalesls.banking.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/account")
public class AccountController {

    final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public Mono<ResponseEntity<AccountResponseDto>> createAccount(@RequestBody AccountRequestDto accountRequest) {
        return accountService.createAccount(accountRequest)
                .map(ResponseEntity::ok);
    }
}
