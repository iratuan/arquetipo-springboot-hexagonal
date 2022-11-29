package br.com.iratuan.arquetipohexagonal.application.core.domain;

public class Customer {
    private Long id;
    private String name;
    private Address address;
    private String cpf;

    public Customer() {
    }

    public Customer(Long id, String name, Address address, String cpf) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.cpf = cpf;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
