package io.github.gabrielsalesls.banking.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@Table("Account")
public record Account(

        @Id
        Long id,

        String userName,

        BigDecimal balance
) {
}
