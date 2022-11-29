package br.com.iratuan.arquetipohexagonal.application.ports.outbounds;

import br.com.iratuan.arquetipohexagonal.application.core.domain.Customer;

public interface UpdateCustomerOutputPort {
    void update(Customer customer);
}
