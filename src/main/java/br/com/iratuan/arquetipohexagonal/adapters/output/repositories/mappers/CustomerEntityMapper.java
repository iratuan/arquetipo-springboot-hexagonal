package br.com.iratuan.arquetipohexagonal.adapters.output.repositories.mappers;

import br.com.iratuan.arquetipohexagonal.adapters.output.repositories.entities.CustomerEntity;
import br.com.iratuan.arquetipohexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {
    CustomerEntity toCustomerEntity(Customer customer);
    Customer toCustomer(CustomerEntity customerEntity);
}
