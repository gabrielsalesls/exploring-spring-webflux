package io.github.gabrielsalesls.banking.service;

import io.github.gabrielsalesls.banking.dto.transfer.TransferRequestDto;
import io.github.gabrielsalesls.banking.dto.transfer.TransferResponseDto;
import io.github.gabrielsalesls.banking.entity.Account;
import io.github.gabrielsalesls.banking.entity.Transfer;
import io.github.gabrielsalesls.banking.enums.TransferStatus;
import io.github.gabrielsalesls.banking.repository.AccountRepository;
import io.github.gabrielsalesls.banking.repository.TransferRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class TransferService {

    final AccountRepository accountRepository;
    final TransferRepository transferRepository;

    public TransferService(AccountRepository accountRepository, TransferRepository transferRepository) {
        this.accountRepository = accountRepository;
        this.transferRepository = transferRepository;
    }

    public Mono<TransferResponseDto> transferMoney(TransferRequestDto request) {

        return accountRepository.findById(request.fromAccountId())
                .zipWith(accountRepository.findById(request.toAccountId()))
                .flatMap(accounts -> {
                    Account fromAccount = accounts.getT1();
                    Account toAccount = accounts.getT2();

                    if (fromAccount.balance().compareTo(request.amount()) >= 0) {

                        return Mono.when(
                                accountRepository.save(fromAccount.debit(request.amount())),
                                accountRepository.save(toAccount.credit(request.amount()))
                        ).then(
                                transferRepository.save(Transfer.create(
                                        fromAccount.id(),
                                        toAccount.id(),
                                        request.amount(),
                                        TransferStatus.APPROVED))
                        ).map(this::toDto);
                    } else {
                        return transferRepository.save(Transfer.create(
                                        fromAccount.id(),
                                        toAccount.id(),
                                        request.amount(),
                                        TransferStatus.INSUFFICIENT_FUNDS))
                                .map(this::toDto);
                    }
                });
    }

    private TransferResponseDto toDto(Transfer savedTransfer) {
        return new TransferResponseDto(
                savedTransfer.fromAccountId(),
                savedTransfer.toAccountId(),
                savedTransfer.amount(),
                savedTransfer.status(),
                savedTransfer.createdAt());
    }
}
