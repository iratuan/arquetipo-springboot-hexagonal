package br.com.iratuan.arquetipohexagonal.config.beans;

import br.com.iratuan.arquetipohexagonal.adapters.output.FindAddressByZipCodeAdapter;
import br.com.iratuan.arquetipohexagonal.adapters.output.InsertCustomerAdapter;
import br.com.iratuan.arquetipohexagonal.application.core.usecases.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustomerUseCase insertCustomerUseCase(
            FindAddressByZipCodeAdapter findAddressByZipCodeAdapter, InsertCustomerAdapter insertCustomerAdapter
    ){
        return new InsertCustomerUseCase(findAddressByZipCodeAdapter,insertCustomerAdapter);
    }
}
