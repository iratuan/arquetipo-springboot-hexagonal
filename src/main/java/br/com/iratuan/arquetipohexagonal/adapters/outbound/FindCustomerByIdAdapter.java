package br.com.iratuan.arquetipohexagonal.adapters.outbound;

import br.com.iratuan.arquetipohexagonal.adapters.outbound.repositories.CustomerRepository;
import br.com.iratuan.arquetipohexagonal.adapters.outbound.repositories.entities.CustomerEntity;
import br.com.iratuan.arquetipohexagonal.adapters.outbound.repositories.mappers.CustomerEntityMapper;
import br.com.iratuan.arquetipohexagonal.application.core.domain.Customer;
import br.com.iratuan.arquetipohexagonal.application.ports.outbounds.FindCustomerByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindCustomerByIdAdapter implements FindCustomerByIdOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;
    @Override
    public Optional<Customer> find(Long id) {
        Optional<CustomerEntity> customerEntity = customerRepository.findById(id);
        return customerEntity.map(entity -> customerEntityMapper.toCustomer(entity));
    }
}
