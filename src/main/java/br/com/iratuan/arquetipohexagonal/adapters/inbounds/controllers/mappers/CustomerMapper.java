package br.com.iratuan.arquetipohexagonal.adapters.inbounds.controllers.mappers;

import br.com.iratuan.arquetipohexagonal.adapters.inbounds.controllers.requests.CustomerRequest;
import br.com.iratuan.arquetipohexagonal.adapters.inbounds.controllers.responses.CustomerResponse;
import br.com.iratuan.arquetipohexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")

public interface CustomerMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address", ignore = true)
    Customer toCustomer(CustomerRequest request);

    CustomerResponse toCustomerResponse(Customer customer);
}
