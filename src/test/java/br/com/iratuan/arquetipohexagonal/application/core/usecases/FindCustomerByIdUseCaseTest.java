package br.com.iratuan.arquetipohexagonal.application.core.usecases;

import br.com.iratuan.arquetipohexagonal.adapters.output.FindCustomerByIdAdapter;
import br.com.iratuan.arquetipohexagonal.application.core.domain.Address;
import br.com.iratuan.arquetipohexagonal.application.core.domain.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.when;

class FindCustomerByIdUseCaseTest {
    @Mock
    FindCustomerByIdAdapter findCustomerByIdAdapter;
    @InjectMocks
    FindCustomerByIdUseCase findCustomerByIdUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFind() {
        Customer c = new Customer(Long.valueOf(1), "name", new Address("street", "city", "state", "postalCode"), "cpf");
        Optional<Customer> optional = Optional.of(c);

        when(findCustomerByIdAdapter.find(anyLong())).thenReturn(optional);
        Customer result = findCustomerByIdUseCase.find(Long.valueOf(1));
        Assertions.assertEquals(c , result);
    }
}
