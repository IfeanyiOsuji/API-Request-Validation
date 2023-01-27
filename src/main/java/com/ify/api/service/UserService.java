package com.ify.api.service;

import com.ify.api.dto.UserRequest;
import com.ify.api.entity.User;
import com.ify.api.exception.UserNotFoundException;
import com.ify.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
@Autowired
    private UserRepository repository;

    public User saveUser(UserRequest userRequest){
        User user = User.build(userRequest.getAge(),
                userRequest.getName(),
                userRequest.getEmail(),
                userRequest.getMobileNo(),
                userRequest.getAge(),
                userRequest.getNationality());
        return repository.save(user);


    }
    public List<User> getAllUsers(){
        return repository.findAll();
    }
    public User getUser(int id){
        User user = repository.findByUserId(id);
        if(user == null)
            throw new UserNotFoundException("User with id {id} not found");
        return user;
    }
}
