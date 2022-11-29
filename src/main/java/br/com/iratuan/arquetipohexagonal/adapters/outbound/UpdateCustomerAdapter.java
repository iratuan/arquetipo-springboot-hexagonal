package br.com.iratuan.arquetipohexagonal.adapters.outbound;

import br.com.iratuan.arquetipohexagonal.adapters.outbound.repositories.CustomerRepository;
import br.com.iratuan.arquetipohexagonal.adapters.outbound.repositories.entities.CustomerEntity;
import br.com.iratuan.arquetipohexagonal.adapters.outbound.repositories.mappers.CustomerEntityMapper;
import br.com.iratuan.arquetipohexagonal.application.core.domain.Customer;
import br.com.iratuan.arquetipohexagonal.application.ports.outbounds.UpdateCustomerOutputPort;
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
