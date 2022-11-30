package br.com.iratuan.arquetipohexagonal.application.ports.input;

import br.com.iratuan.arquetipohexagonal.application.core.domain.Customer;

public interface InsertCustomerInputPort {
    void insert(Customer customer, String zipCode);
}
