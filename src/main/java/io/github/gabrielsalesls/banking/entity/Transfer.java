package io.github.gabrielsalesls.banking.entity;

import io.github.gabrielsalesls.banking.enums.TransferStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table("Transfer")
public record Transfer(
        @Id Long id,
        @Column("fromAccountid")
        Long fromAccountId,
        @Column("toAccountid")
        Long toAccountId,
        @Column("amount")
        BigDecimal amount,
        @Column("status")
        TransferStatus status,
        @Column("created_at")
        LocalDateTime createdAt
) {

    public static Transfer create(Long fromAccountId, Long toAccountId, BigDecimal amount, TransferStatus status) {
        return new Transfer(null, fromAccountId, toAccountId, amount, status, LocalDateTime.now());
    }
}