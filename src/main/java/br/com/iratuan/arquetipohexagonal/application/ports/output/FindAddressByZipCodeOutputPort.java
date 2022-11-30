package br.com.iratuan.arquetipohexagonal.application.ports.output;

import br.com.iratuan.arquetipohexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {
    Address find(String zipCode);
}
