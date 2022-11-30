package br.com.iratuan.arquetipohexagonal.application.ports.output;

import br.com.iratuan.arquetipohexagonal.application.core.domain.Customer;

import java.util.List;

public interface ListAllCustomersOutputPort {
    List<Customer> list();
}
