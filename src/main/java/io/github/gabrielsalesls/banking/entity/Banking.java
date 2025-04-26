package io.github.gabrielsalesls.banking.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigInteger;

@Table("user")
public class Banking {

    @Id
    private int id;

    @Column("name")
    private String name;

    @Column("balance")
    private BigInteger balance;
}