package br.com.iratuan.arquetipohexagonal.application.core.usecases;

import br.com.iratuan.arquetipohexagonal.application.core.domain.Customer;
import br.com.iratuan.arquetipohexagonal.application.ports.input.ListAllCustomersInputPort;
import br.com.iratuan.arquetipohexagonal.application.ports.output.ListAllCustomersOutputPort;

import java.util.List;

public class ListAllCustomersUseCase implements ListAllCustomersInputPort{

    private final ListAllCustomersOutputPort listAllCustomersOutputPort;

    public ListAllCustomersUseCase(ListAllCustomersOutputPort listAllCustomersOutputPort) {
        this.listAllCustomersOutputPort = listAllCustomersOutputPort;
    }

    @Override
    public List<Customer> list() {
        return listAllCustomersOutputPort.list();
    }
}
