package br.com.iratuan.arquetipohexagonal.adapters.input.controllers;

import br.com.iratuan.arquetipohexagonal.adapters.input.controllers.mappers.CustomerMapper;
import br.com.iratuan.arquetipohexagonal.adapters.input.controllers.requests.CustomerRequest;
import br.com.iratuan.arquetipohexagonal.adapters.input.controllers.responses.CustomerResponse;
import br.com.iratuan.arquetipohexagonal.application.core.domain.Customer;
import br.com.iratuan.arquetipohexagonal.application.ports.input.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
    private ListAllCustomersInputPort listAllCustomersInputPort;

    @Autowired
    private DeleteCustomerInputPort deleteCustomerInputPort;
    
    @Autowired
    private CustomerMapper customerMapper;
    
    @GetMapping
    public ResponseEntity<List<CustomerResponse>> list(){
        List<Customer> result = listAllCustomersInputPort.list();
       if(result.isEmpty()){
           return ResponseEntity.noContent().build();
       }
        List<CustomerResponse> customerResponseList = new ArrayList<>();
        result.forEach(c -> customerResponseList.add(customerMapper.toCustomerResponse(c)));
        return ResponseEntity.ok().body(customerResponseList);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody CustomerRequest customerRequest){
        Customer customer = customerMapper.toCustomer(customerRequest);
        insertCustomerInputPort.insert(customer, customerRequest.getZipCode());
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable("id") final Long id){
       try {
           Customer customer = findCustomerByIdInputPort.find(id);
           CustomerResponse customerResponse = customerMapper.toCustomerResponse(customer);
           return ResponseEntity.ok().body(customerResponse);
       }catch (RuntimeException e){
           return ResponseEntity.notFound().build();
       }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponse> update(@PathVariable("id") final Long id, @RequestBody CustomerRequest customerRequest){

        try{
            findCustomerByIdInputPort.find(id);
            Customer customer = customerMapper.toCustomer(customerRequest);
            customer.setId(id);
            updateCustomerInputPort.update(customer, customerRequest.getZipCode());
            return ResponseEntity.noContent().build();
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        try{
            Customer customer = findCustomerByIdInputPort.find(id);
            deleteCustomerInputPort.delete(customer);
            return ResponseEntity.noContent().build();
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }
}
