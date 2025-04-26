package io.github.gabrielsalesls.banking.dto.account;

import java.math.BigDecimal;

public record AccountResponseDto(

        Long id,
        String name,
        BigDecimal balance
) {
}
