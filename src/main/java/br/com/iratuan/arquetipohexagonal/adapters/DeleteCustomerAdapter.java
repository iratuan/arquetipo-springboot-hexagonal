package br.com.iratuan.arquetipohexagonal.adapters;

import br.com.iratuan.arquetipohexagonal.adapters.outbound.repositories.CustomerRepository;
import br.com.iratuan.arquetipohexagonal.adapters.outbound.repositories.entities.CustomerEntity;
import br.com.iratuan.arquetipohexagonal.adapters.outbound.repositories.mappers.CustomerEntityMapper;
import br.com.iratuan.arquetipohexagonal.application.core.domain.Customer;
import br.com.iratuan.arquetipohexagonal.application.ports.output.DeleteCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerAdapter implements DeleteCustomerOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public void delete(Customer customer) {
        CustomerEntity entity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.delete(entity);
    }
}
