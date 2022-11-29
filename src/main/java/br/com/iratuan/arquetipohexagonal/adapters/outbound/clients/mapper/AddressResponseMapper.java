package br.com.iratuan.arquetipohexagonal.adapters.outbound.clients.mapper;

import br.com.iratuan.arquetipohexagonal.adapters.outbound.clients.responses.AddressResponse;
import br.com.iratuan.arquetipohexagonal.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {
    Address toAddress(AddressResponse addressResponse);
}
