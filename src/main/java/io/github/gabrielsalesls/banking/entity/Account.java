package io.github.gabrielsalesls.banking.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@Table("Account")
public record Account(
        @Id
        Long id,
        @Column("username")
        String userName,
        @Column("balance")
        BigDecimal balance
) {
        public static Account create(String userName, BigDecimal balance) {
                return new Account(null, userName, balance);
        }
}