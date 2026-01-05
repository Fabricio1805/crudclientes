package com.crudcliente.service;

import com.crudcliente.entity.Client;
import com.crudcliente.repository.ClientRepository;
import com.crudcliente.service.dto.ClientDTO;
import com.crudcliente.service.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Page<ClientDTO> findAll(Pageable pageable) {
        Page<Client> cLients = clientRepository.findAll(pageable);

        return  cLients.map(c -> new ClientDTO(c));
    }

    public ClientDTO create(ClientDTO clientDTO){
        Client client = Client.builder()
                .name(clientDTO.getName())
                .cpf(clientDTO.getCpf())
                .birthDate(clientDTO.getBirthDate())
                .children(clientDTO.getChildren())
                .income(clientDTO.getIncome())
                .build();

        clientRepository.save(client);

        return new ClientDTO(client);
    }

    public ClientDTO findById(Long id) {
        Client client= clientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id não encontrado"));
        return new ClientDTO(client);
    }

    public void deleteById(Long id){
        if (!clientRepository.existsById(id)) {
            throw new ResourceNotFoundException("Id não encontrado");
        }

        clientRepository.deleteById(id);
    }

    public void update(Long id, ClientDTO clientDTO){
         Client client = clientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id não encontrado"));

        client.setName(clientDTO.getName());
        client.setCpf(clientDTO.getCpf());
        client.setBirthDate(clientDTO.getBirthDate());
        client.setChildren(clientDTO.getChildren());
        client.setIncome(clientDTO.getIncome());

        clientRepository.save(client);
    }
}
