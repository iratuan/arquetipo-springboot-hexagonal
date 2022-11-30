package br.com.iratuan.arquetipohexagonal.adapters.inbounds.controllers;

import br.com.iratuan.arquetipohexagonal.adapters.inbounds.controllers.responses.AddressResponse;
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
