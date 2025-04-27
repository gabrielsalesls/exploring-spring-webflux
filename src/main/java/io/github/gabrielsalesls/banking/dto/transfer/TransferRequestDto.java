package io.github.gabrielsalesls.banking.dto.transfer;

import java.math.BigDecimal;

public record TransferRequestDto(

        Long fromAccountId,
        Long toAccountId,
        BigDecimal amount
) {
}
