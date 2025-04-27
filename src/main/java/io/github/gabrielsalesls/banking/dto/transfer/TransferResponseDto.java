package io.github.gabrielsalesls.banking.dto.transfer;

import io.github.gabrielsalesls.banking.enums.TransferStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record TransferResponseDto(

        Long fromAccountId,
        Long toAccountId,
        BigDecimal amount,
        TransferStatus status,
        LocalDateTime createdAt
) {

}
