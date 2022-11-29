package br.com.iratuan.arquetipohexagonal.adapters.inbounds.controllers;

import br.com.iratuan.arquetipohexagonal.adapters.inbounds.controllers.mappers.CustomerMapper;
import br.com.iratuan.arquetipohexagonal.adapters.inbounds.controllers.requests.CustomerRequest;
import br.com.iratuan.arquetipohexagonal.adapters.inbounds.controllers.responses.CustomerResponse;
import br.com.iratuan.arquetipohexagonal.application.core.domain.Customer;
import br.com.iratuan.arquetipohexagonal.application.ports.inbound.FindCustomerByIdInputPort;
import br.com.iratuan.arquetipohexagonal.application.ports.inbound.InsertCustomerInputPort;
import br.com.iratuan.arquetipohexagonal.application.ports.inbound.UpdateCustomerInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private InsertCustomerInputPort insertCustomerInputPort;

    @Autowired
    private FindCustomerByIdInputPort findCustomerByIdInputPort;

    @Autowired
    private UpdateCustomerInputPort updateCustomerInputPort;

    @Autowired
    private CustomerMapper customerMapper;

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody CustomerRequest customerRequest){
        Customer customer = customerMapper.toCustomer(customerRequest);
        insertCustomerInputPort.insert(customer, customerRequest.getZipCode());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable("id") final Long id){
        Customer customer = findCustomerByIdInputPort.find(id);
        CustomerResponse customerResponse = customerMapper.toCustomerResponse(customer);
        return ResponseEntity.ok().body(customerResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponse> update(@PathVariable("id") final Long id, @RequestBody CustomerRequest customerRequest){
        Customer customer = customerMapper.toCustomer(customerRequest);
        customer.setId(id);
        updateCustomerInputPort.update(customer, customerRequest.getZipCode());
        return ResponseEntity.noContent().build();
    }
}
