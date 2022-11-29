package br.com.iratuan.arquetipohexagonal.config.beans;

import br.com.iratuan.arquetipohexagonal.adapters.outbound.FindCustomerByIdAdapter;
import br.com.iratuan.arquetipohexagonal.application.core.usecases.FindCustomerByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCustomerByIdConfig {

    @Bean
    public FindCustomerByIdUseCase findCustomerByIdUseCase(FindCustomerByIdAdapter findCustomerByIdAdapter){

        return new FindCustomerByIdUseCase(findCustomerByIdAdapter);
    }
}
