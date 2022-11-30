package br.com.iratuan.arquetipohexagonal.adapters.inbounds.controllers;

import br.com.iratuan.arquetipohexagonal.adapters.inbounds.controllers.mappers.CustomerMapper;
import br.com.iratuan.arquetipohexagonal.adapters.inbounds.controllers.requests.CustomerRequest;
import br.com.iratuan.arquetipohexagonal.adapters.inbounds.controllers.responses.CustomerResponse;
import br.com.iratuan.arquetipohexagonal.application.core.domain.Customer;
import br.com.iratuan.arquetipohexagonal.application.ports.input.FindCustomerByIdInputPort;
import br.com.iratuan.arquetipohexagonal.application.ports.input.InsertCustomerInputPort;
import br.com.iratuan.arquetipohexagonal.application.ports.input.ListAllCustomersInputPort;
import br.com.iratuan.arquetipohexagonal.application.ports.input.UpdateCustomerInputPort;
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
        return ResponseEntity.ok().build();
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
}
