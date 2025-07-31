package com.phone_repair.phone_repair.Controller;

import com.phone_repair.phone_repair.DTO.ClientDTO;
import com.phone_repair.phone_repair.DTO.ClientDTORegistr;
import com.phone_repair.phone_repair.Service.ClientService;
import com.phone_repair.phone_repair.Service.EmailSender;
import com.phone_repair.phone_repair.domain.Client;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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

    @PostMapping("/registration")
    public HttpStatus createClient(@RequestBody @Valid ClientDTORegistr client) {
        clientService.createClient(client);
        emailSender.sendEmail(client.getEmail(), "Registration", "Вітаю вас з реєстрацією, на своєму сайті");
        return HttpStatus.CREATED;
    }


}
