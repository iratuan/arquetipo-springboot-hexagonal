package br.com.iratuan.arquetipohexagonal.adapters.output.repositories;

import br.com.iratuan.arquetipohexagonal.adapters.output.repositories.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
}
