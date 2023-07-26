package com.bokafood.tbbackend.service;


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
    public User getUserByUsername(String name) {
        Optional<User> user = userRepository.findByUsername(name);
        if(user.isPresent()){
              return user.get();
        } else {
            throw new EntityNotFoundException(name, User.class);
        }
    }
}
