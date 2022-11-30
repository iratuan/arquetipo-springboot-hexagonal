package br.com.iratuan.arquetipohexagonal.application.ports.input;

import br.com.iratuan.arquetipohexagonal.application.core.domain.Customer;

public interface UpdateCustomerInputPort {

    void update(Customer customer, String zipCode);
}
