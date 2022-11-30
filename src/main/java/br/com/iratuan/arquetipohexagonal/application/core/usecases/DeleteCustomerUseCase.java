package br.com.iratuan.arquetipohexagonal.application.core.usecases;

import br.com.iratuan.arquetipohexagonal.application.core.domain.Customer;
import br.com.iratuan.arquetipohexagonal.application.ports.input.DeleteCustomerInputPort;
import br.com.iratuan.arquetipohexagonal.application.ports.input.FindCustomerByIdInputPort;
import br.com.iratuan.arquetipohexagonal.application.ports.output.DeleteCustomerOutputPort;

public class DeleteCustomerUseCase implements DeleteCustomerInputPort {
    private final DeleteCustomerOutputPort deleteCustomerOutputPort;

    private final FindCustomerByIdInputPort findCustomerByIdInputPort;

    public DeleteCustomerUseCase( FindCustomerByIdInputPort findCustomerByIdInputPort, DeleteCustomerOutputPort deleteCustomerOutputPort) {
        this.deleteCustomerOutputPort = deleteCustomerOutputPort;
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
    }

    public void delete(Customer customer) {
        findCustomerByIdInputPort.find(customer.getId());
        deleteCustomerOutputPort.delete(customer);
    }
}
