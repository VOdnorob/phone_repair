package com.phone_repair.phone_repair.Service;

import com.phone_repair.phone_repair.domain.Client;
import com.phone_repair.phone_repair.repositorys.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ClientService {


    private final ClientRepository clientRepository;

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public void createClient(Client client) {
        clientRepository.save(client);
    }


}
