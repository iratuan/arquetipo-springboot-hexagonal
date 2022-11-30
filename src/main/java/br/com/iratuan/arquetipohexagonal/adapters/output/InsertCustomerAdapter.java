package br.com.iratuan.arquetipohexagonal.adapters.output;

import br.com.iratuan.arquetipohexagonal.adapters.output.repositories.CustomerRepository;
import br.com.iratuan.arquetipohexagonal.adapters.output.repositories.entities.CustomerEntity;
import br.com.iratuan.arquetipohexagonal.adapters.output.repositories.mappers.CustomerEntityMapper;
import br.com.iratuan.arquetipohexagonal.application.core.domain.Customer;
import br.com.iratuan.arquetipohexagonal.application.ports.output.InsertCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertCustomerAdapter implements InsertCustomerOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public void insert(Customer customer) {
        CustomerEntity entity = customerEntityMapper.toCustomerEntity(customer);
        this.customerRepository.save(entity);
    }
}
