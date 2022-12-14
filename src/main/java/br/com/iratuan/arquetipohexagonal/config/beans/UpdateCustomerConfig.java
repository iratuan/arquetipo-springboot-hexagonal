package br.com.iratuan.arquetipohexagonal.config.beans;

import br.com.iratuan.arquetipohexagonal.adapters.output.FindAddressByZipCodeAdapter;
import br.com.iratuan.arquetipohexagonal.adapters.output.UpdateCustomerAdapter;
import br.com.iratuan.arquetipohexagonal.application.core.usecases.FindCustomerByIdUseCase;
import br.com.iratuan.arquetipohexagonal.application.core.usecases.UpdateCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {

    @Bean
    public UpdateCustomerUseCase updateCustomerUseCase(FindCustomerByIdUseCase findCustomerByIdUseCase,
                                                       FindAddressByZipCodeAdapter findAddressByZipCodeAdapter,
                                                       UpdateCustomerAdapter updateCustomerAdapter){
        return new UpdateCustomerUseCase(findCustomerByIdUseCase,findAddressByZipCodeAdapter, updateCustomerAdapter);
    }

}
