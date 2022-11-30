package br.com.iratuan.arquetipohexagonal.application.ports.output;

import br.com.iratuan.arquetipohexagonal.application.core.domain.Customer;

public interface DeleteCustomerOutputPort {
    void delete(Customer customer);
}
