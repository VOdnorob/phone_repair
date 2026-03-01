package com.phone_repair.phone_repair.controllers;

import com.phone_repair.phone_repair.dtos.ClientDTO;
import com.phone_repair.phone_repair.dtos.ClientDTORegistr;
import com.phone_repair.phone_repair.services.ClientService;
import com.phone_repair.phone_repair.services.EmailSender;
import com.phone_repair.phone_repair.domain.Client;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class ClientController {


    private final ClientService clientService;
    private final EmailSender emailSender;

    @GetMapping("/")
    public List<ClientDTO> getAllClients() {
        var clients = clientService.findAll();
        return clients.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private ClientDTO convertToDto(Client client) {
        return new ClientDTO(client.getId(),
                client.getName(),
                client.getSurname(),
                client.getEmail(),
                client.getNumberPhone());
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/registration")
    public void createClient(@RequestBody @Valid ClientDTORegistr client) {
        clientService.createClient(client);
        
    }


}
