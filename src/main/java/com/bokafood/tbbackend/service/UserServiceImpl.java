package com.bokafood.tbbackend.service;


import com.bokafood.tbbackend.dto.users.UserDTO;
import com.bokafood.tbbackend.entity.User;
import com.bokafood.tbbackend.exception.EntityNotFoundException;
import com.bokafood.tbbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO getUserById(Long id) {
        return null;
    }

    @Override
    public User getUserByUsername(String name) {
        Optional<User> user = userRepository.findByUsername(name);
        if(user.isPresent()){
           // return UserMapper.toDTO(user.get());
              return user.get();
        } else {
            throw new EntityNotFoundException(name, User.class);
        }
    }
}
