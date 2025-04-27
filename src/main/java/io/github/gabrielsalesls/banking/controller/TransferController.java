package io.github.gabrielsalesls.banking.controller;

import io.github.gabrielsalesls.banking.dto.transfer.TransferRequestDto;
import io.github.gabrielsalesls.banking.dto.transfer.TransferResponseDto;
import io.github.gabrielsalesls.banking.repository.TransferRepository;
import io.github.gabrielsalesls.banking.service.TransferService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/transfer")
public class TransferController {

    final TransferService transferService;
    final TransferRepository transferRepository;

    public TransferController(TransferService transferService, TransferRepository transferRepository) {
        this.transferService = transferService;
        this.transferRepository = transferRepository;
    }

    @PostMapping
    public ResponseEntity<Mono<TransferResponseDto>> transfer(@RequestBody TransferRequestDto request) {
        return ResponseEntity.ok(transferService.transferMoney(request));
    }
}
