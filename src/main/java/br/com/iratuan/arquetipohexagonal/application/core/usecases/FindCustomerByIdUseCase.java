package br.com.iratuan.arquetipohexagonal.application.core.usecases;

import br.com.iratuan.arquetipohexagonal.application.core.domain.Customer;
import br.com.iratuan.arquetipohexagonal.application.ports.input.FindCustomerByIdInputPort;
import br.com.iratuan.arquetipohexagonal.application.ports.output.FindCustomerByIdOutputPort;

public class FindCustomerByIdUseCase implements FindCustomerByIdInputPort {

    private final FindCustomerByIdOutputPort fIndCustomerByIdOutputPort;


    public FindCustomerByIdUseCase(FindCustomerByIdOutputPort findCustomerByIdOutputPort) {
        this.fIndCustomerByIdOutputPort = findCustomerByIdOutputPort;
    }

    @Override
    public Customer find(Long id){
                return fIndCustomerByIdOutputPort.find(id).orElseThrow(
                        () -> new RuntimeException("Customer not found"));
    }
}
