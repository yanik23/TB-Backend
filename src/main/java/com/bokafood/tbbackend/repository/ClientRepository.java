package com.bokafood.tbbackend.repository;

import com.bokafood.tbbackend.entity.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

/**
 * Client repository class used for CRUD operations on the Client entity.
 * Uses hibernate to access the database.
 *
 * @author Yanik Lange
 * @date 25.07.2023
 * @version 1.0
 */
@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {

    /**
     * Method to find a client by its name.
     * @param name The name of the client to be found.
     * @return Optional with the client if found.
     */
    Optional<Client> findByName(String name);
}
