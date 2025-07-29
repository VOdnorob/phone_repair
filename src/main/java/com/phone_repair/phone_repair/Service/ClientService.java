package com.phone_repair.phone_repair.Service;

import com.phone_repair.phone_repair.DTO.ClientDTORegistr;
import com.phone_repair.phone_repair.domain.Client;
import com.phone_repair.phone_repair.repositorys.ClientRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ClientService {


    private final ClientRepository clientRepository;
    private final PasswordEncoder passwordEncoder;

    public List<Client> findAll() {
        return clientRepository.findAll();
    }


    public void createClient(@Valid ClientDTORegistr client) {

        String encodedPassword = passwordEncoder.encode(client.getPassword());

        clientRepository.findByEmail(client.getEmail())
                .ifPresent(c -> {
                    throw new ResponseStatusException(
                            HttpStatus.BAD_REQUEST,
                            "Worker with " + client.getEmail() + " already registered"
                    );
                });
        clientRepository.save(new Client(client.getName(),
                client.getSurname(),
                client.getEmail(),
                encodedPassword,
                client.getNumberPhone()
        ));

    }
}
