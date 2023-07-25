package com.bokafood.tbbackend.repository;


import com.bokafood.tbbackend.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;


/**
 * User repository class used for CRUD operations on the User entity.
 * Uses hibernate to access the database.
 *
 * @author Yanik Lange
 * @date 25.07.2023
 * @version 1.0
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    /**
     * Method to find a user by its username.
     * @param name The username of the user to be found.
     * @return Optional with the user if found.
     */
    Optional<User> findByUsername(String name);
}
