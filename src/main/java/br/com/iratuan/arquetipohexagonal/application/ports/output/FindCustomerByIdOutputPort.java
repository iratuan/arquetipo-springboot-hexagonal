package br.com.iratuan.arquetipohexagonal.application.ports.output;

import br.com.iratuan.arquetipohexagonal.application.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerByIdOutputPort {
    Optional<Customer> find(Long id);
}
