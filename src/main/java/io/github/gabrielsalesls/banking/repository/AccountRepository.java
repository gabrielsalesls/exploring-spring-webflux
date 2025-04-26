package io.github.gabrielsalesls.banking.repository;

import io.github.gabrielsalesls.banking.entity.Account;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends ReactiveCrudRepository<Account, Long> {
}
