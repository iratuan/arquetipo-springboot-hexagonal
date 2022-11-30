package br.com.iratuan.arquetipohexagonal.config.beans;

import br.com.iratuan.arquetipohexagonal.adapters.outbound.ListAllCustomersAdapter;
import br.com.iratuan.arquetipohexagonal.application.core.usecases.ListAllCustomersUseCase;
import br.com.iratuan.arquetipohexagonal.application.ports.outbounds.FindCustomerByIdOutputPort;
import br.com.iratuan.arquetipohexagonal.application.ports.outbounds.ListAllCustomersOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ListAllCustomersConfig {

    @Bean
    public ListAllCustomersUseCase listAllCustomersUseCase(ListAllCustomersAdapter listAllCustomersAdapter){
        return new ListAllCustomersUseCase(listAllCustomersAdapter);
    }
}