package br.com.iratuan.arquetipohexagonal.adapters.output;

import br.com.iratuan.arquetipohexagonal.adapters.output.clients.FindAddressByZipCodeClient;
import br.com.iratuan.arquetipohexagonal.adapters.output.clients.mapper.AddressResponseMapper;
import br.com.iratuan.arquetipohexagonal.adapters.output.clients.responses.AddressResponse;
import br.com.iratuan.arquetipohexagonal.application.core.domain.Address;
import br.com.iratuan.arquetipohexagonal.application.ports.output.FindAddressByZipCodeOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutputPort {

    @Autowired
    private FindAddressByZipCodeClient findAddressByZipCodeClient;

    @Autowired
    private AddressResponseMapper addressResponseMapper;

    @Override
    public Address find(String zipCode) {
        AddressResponse addressResponse = findAddressByZipCodeClient.find(zipCode);
        return addressResponseMapper.toAddress(addressResponse);
    }
}
