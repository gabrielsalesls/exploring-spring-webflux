package io.github.gabrielsalesls.banking.controller;

import io.github.gabrielsalesls.banking.dto.account.AccountRequestDto;
import io.github.gabrielsalesls.banking.dto.account.AccountResponseDto;
import io.github.gabrielsalesls.banking.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/account")
public class AccountController {

    final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<Mono<AccountResponseDto>> createAccount(@RequestBody AccountRequestDto accountRequest) {
        return ResponseEntity.ok(accountService.createAccount(accountRequest));
    }

    @GetMapping
    public ResponseEntity<Flux<AccountResponseDto>> getAllAccounts() {
        return ResponseEntity.ok(accountService.getAllAccounts());
    }
}
