package io.github.gabrielsalesls.banking.repository;

import io.github.gabrielsalesls.banking.entity.Transfer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferRepository extends ReactiveCrudRepository<Transfer, Long> {
}
