package io.github.gabrielsalesls.banking.entity;

import io.github.gabrielsalesls.banking.enums.TransferStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table("Transfer")
public record Transfer(
        @Id Long id,
        Long fromAccountId,
        Long toAccountId,
        BigDecimal amount,
        TransferStatus status,
        LocalDateTime createdAt
) {
    public Transfer {
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
    }
}