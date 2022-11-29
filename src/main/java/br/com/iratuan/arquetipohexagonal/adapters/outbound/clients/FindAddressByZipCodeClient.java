package br.com.iratuan.arquetipohexagonal.adapters.outbound.clients;

import br.com.iratuan.arquetipohexagonal.adapters.outbound.clients.responses.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "FindAddressByZipCodeClient",
        url = "${br.com.iratuan.client.address.url}"
)
public interface FindAddressByZipCodeClient {

    @GetMapping("/{zipCode}")
        AddressResponse find(@PathVariable("zipCode") String zipCode);

}
