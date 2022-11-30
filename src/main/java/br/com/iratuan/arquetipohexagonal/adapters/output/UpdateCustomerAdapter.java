package br.com.iratuan.arquetipohexagonal.adapters.output;

import br.com.iratuan.arquetipohexagonal.adapters.output.repositories.CustomerRepository;
import br.com.iratuan.arquetipohexagonal.adapters.output.repositories.entities.CustomerEntity;
import br.com.iratuan.arquetipohexagonal.adapters.output.repositories.mappers.CustomerEntityMapper;
import br.com.iratuan.arquetipohexagonal.application.core.domain.Customer;
import br.com.iratuan.arquetipohexagonal.application.ports.output.UpdateCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerAdapter implements UpdateCustomerOutputPort {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public void update(Customer customer) {
        CustomerEntity  customerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);
    }
}
