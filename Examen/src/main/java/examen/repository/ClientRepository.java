package examen.repository.implementation;

import examen.core.Repository;
import examen.entities.Client;
import examen.entities.User;

public interface  RepositoryClient extends Repository<Client>{
    Client getByTel(String telephone);
    Client getClientByUser(User user);
}
