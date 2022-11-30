package br.com.iratuan.arquetipohexagonal.adapters.output;

import br.com.iratuan.arquetipohexagonal.adapters.output.repositories.CustomerRepository;
import br.com.iratuan.arquetipohexagonal.adapters.output.repositories.entities.CustomerEntity;
import br.com.iratuan.arquetipohexagonal.adapters.output.repositories.mappers.CustomerEntityMapper;
import br.com.iratuan.arquetipohexagonal.application.core.domain.Customer;
import br.com.iratuan.arquetipohexagonal.application.ports.output.ListAllCustomersOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ListAllCustomersAdapter implements ListAllCustomersOutputPort {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public List<Customer> list() {

        List<Customer> customerList = new ArrayList<>();
        List<CustomerEntity> result = customerRepository.findAll();
        result.forEach(c -> {
            customerList.add(customerEntityMapper.toCustomer(c));
        });

        return  customerList;
    }
}
