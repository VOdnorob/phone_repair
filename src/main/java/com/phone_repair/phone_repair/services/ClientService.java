package com.phone_repair.phone_repair.services;

import com.phone_repair.phone_repair.dtos.ClientDTORegistr;
import com.phone_repair.phone_repair.domain.Client;
import com.phone_repair.phone_repair.repositories.ClientRepository;
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
    private final EmailSender emailSender;

    public List<Client> findAll() {
        return clientRepository.findAll();
    }


    public void createClient(@Valid ClientDTORegistr client) {

        String encodedPassword = passwordEncoder.encode(client.getPassword());

        clientRepository.findByEmail(client.getEmail())
                .ifPresent(c -> {
                    throw new ResponseStatusException(
                            HttpStatus.CONFLICT,
                            "Worker with " + client.getEmail() + " already registered"
                    );
                });
        clientRepository.save(new Client(client.getName(),
                client.getSurname(),
                client.getEmail(),
                encodedPassword,
                client.getNumberPhone()
        ));
        emailSender.sendEmail(client.getEmail(), "Registration", "Вітаю вас з реєстрацією, на своєму сайті");

    }
}
