package examen.service;

import java.util.List;

import examen.core.Repository;
import examen.entities.Client;
import examen.repository.ClientRepository;
;

public class CommandeService {
    private ClientRepository clientRepository = new ClientRepository();

    public Client chercherClientParTelephone(String telephone) {
        return clientRepository.findByTelephone(telephone);
    }
}
