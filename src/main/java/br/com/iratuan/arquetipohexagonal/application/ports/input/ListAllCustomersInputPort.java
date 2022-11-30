package br.com.iratuan.arquetipohexagonal.application.ports.input;

import br.com.iratuan.arquetipohexagonal.application.core.domain.Customer;

import java.util.List;

public interface ListAllCustomersInputPort {
    List<Customer> list();
}
