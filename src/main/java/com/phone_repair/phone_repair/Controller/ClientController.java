package com.phone_repair.phone_repair.Controller;

import com.phone_repair.phone_repair.DTO.ClientDTO;
import com.phone_repair.phone_repair.DTO.ClientDTORegistr;
import com.phone_repair.phone_repair.Service.ClientService;
import com.phone_repair.phone_repair.domain.Client;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController("/user")
public class ClientController {


    private final ClientService clientService;

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

    @PostMapping("/")
    public HttpStatus createClient(@RequestBody @Valid ClientDTORegistr client) {
        clientService.createClient(new Client(0, client.getName(),
                client.getSurname(),
                client.getEmail(),
                client.getNumberPhone(),
                new ArrayList<>()));
        return HttpStatus.CREATED;
    }


}
