package br.com.iratuan.arquetipohexagonal.adapters.inbounds.controllers;

import br.com.iratuan.arquetipohexagonal.adapters.inbounds.controllers.mappers.CustomerMapper;
import br.com.iratuan.arquetipohexagonal.adapters.inbounds.controllers.requests.CustomerRequest;
import br.com.iratuan.arquetipohexagonal.adapters.inbounds.controllers.responses.AddressResponse;
import br.com.iratuan.arquetipohexagonal.adapters.inbounds.controllers.responses.CustomerResponse;
import br.com.iratuan.arquetipohexagonal.application.core.domain.Customer;
import br.com.iratuan.arquetipohexagonal.application.ports.inbound.FindCustomerByIdInputPort;
import br.com.iratuan.arquetipohexagonal.application.ports.inbound.InsertCustomerInputPort;
import br.com.iratuan.arquetipohexagonal.application.ports.inbound.UpdateCustomerInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/addresses")
public class AddressesController {


    @GetMapping("/{zipCode}")
    public ResponseEntity<AddressResponse> list(@PathVariable String zipCode){

        AddressResponse addressResponse = new AddressResponse();
        addressResponse.setCity("Fortaleza");
        addressResponse.setState("CE");
        addressResponse.setPostalCode("60751380");
        addressResponse.setStreet("RUA P");
        return ResponseEntity.ok().body(addressResponse);
    }


}
