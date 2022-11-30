package br.com.iratuan.arquetipohexagonal.config.beans;

import br.com.iratuan.arquetipohexagonal.adapters.DeleteCustomerAdapter;
import br.com.iratuan.arquetipohexagonal.application.core.usecases.DeleteCustomerUseCase;
import br.com.iratuan.arquetipohexagonal.application.core.usecases.FindCustomerByIdUseCase;
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
