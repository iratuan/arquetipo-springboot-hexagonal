package br.com.iratuan.arquetipohexagonal.application.ports.input;

import br.com.iratuan.arquetipohexagonal.application.core.domain.Customer;

public interface DeleteCustomerInputPort {
    void delete(Customer customer);
}
