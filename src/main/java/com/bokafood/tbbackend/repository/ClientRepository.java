package com.bokafood.tbbackend.repository;

import com.bokafood.tbbackend.entity.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {


}
