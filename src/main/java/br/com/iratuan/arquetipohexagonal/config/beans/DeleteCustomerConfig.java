package br.com.iratuan.arquetipohexagonal.config.beans;

import br.com.iratuan.arquetipohexagonal.adapters.DeleteCustomerAdapter;
import br.com.iratuan.arquetipohexagonal.adapters.outbound.FindAddressByZipCodeAdapter;
import br.com.iratuan.arquetipohexagonal.adapters.outbound.UpdateCustomerAdapter;
import br.com.iratuan.arquetipohexagonal.application.core.usecases.DeleteCustomerUseCase;
import br.com.iratuan.arquetipohexagonal.application.core.usecases.FindCustomerByIdUseCase;
import br.com.iratuan.arquetipohexagonal.application.core.usecases.UpdateCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerConfig {

    @Bean
    public DeleteCustomerUseCase deleteCustomerUseCase(FindCustomerByIdUseCase findCustomerByIdUseCase,
                                                       DeleteCustomerAdapter deleteCustomerAdapter){
        return new DeleteCustomerUseCase(findCustomerByIdUseCase, deleteCustomerAdapter);
    }

}
