package com.phone_repair.phone_repair.repositorys;

import com.phone_repair.phone_repair.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client>    findByEmail(String email);
}
