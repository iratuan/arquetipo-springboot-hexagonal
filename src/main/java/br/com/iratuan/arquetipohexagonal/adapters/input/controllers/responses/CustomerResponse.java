package br.com.iratuan.arquetipohexagonal.adapters.input.controllers.responses;


public class CustomerResponse {
    private String name;
    private AddressResponse address;
    private String cpf;

    public CustomerResponse() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddressResponse getAddress() {
        return address;
    }

    public void setAddress(AddressResponse address) {
        this.address = address;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
