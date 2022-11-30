package br.com.iratuan.arquetipohexagonal.application.core.usecases;

import br.com.iratuan.arquetipohexagonal.adapters.output.ListAllCustomersAdapter;
import br.com.iratuan.arquetipohexagonal.application.core.domain.Address;
import br.com.iratuan.arquetipohexagonal.application.core.domain.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.mockito.Mockito.when;

class ListAllCustomersUseCaseTest {
    @Mock
    ListAllCustomersAdapter listAllCustomersAdapter;
    @InjectMocks
    ListAllCustomersUseCase listAllCustomersUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testList() {
        Customer c = new Customer(Long.valueOf(1), "name", new Address("street", "city", "state", "postalCode"), "cpf");
        when(listAllCustomersAdapter.list()).thenReturn(List.of(c));
        List<Customer> result = listAllCustomersUseCase.list();
        Assertions.assertEquals(List.of(c), result);
    }
}
