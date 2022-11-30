package br.com.iratuan.arquetipohexagonal.adapters.input.controllers.mappers;

import br.com.iratuan.arquetipohexagonal.adapters.input.controllers.requests.CustomerRequest;
import br.com.iratuan.arquetipohexagonal.adapters.input.controllers.responses.CustomerResponse;
import br.com.iratuan.arquetipohexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")

public interface CustomerMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address", ignore = true)
    Customer toCustomer(CustomerRequest request);

    CustomerResponse toCustomerResponse(Customer customer);
}
