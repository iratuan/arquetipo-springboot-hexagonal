package br.com.iratuan.arquetipohexagonal.application.ports.outbounds;

import br.com.iratuan.arquetipohexagonal.application.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerByIdOutputPort {
    Optional<Customer> find(Long id);
}
