package br.com.iratuan.arquetipohexagonal.application.ports.outbounds;

import br.com.iratuan.arquetipohexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {
    Address find(String zipCode);
}
