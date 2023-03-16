package com.stackroute.com.UserService.service;

import java.util.List;
import java.util.Optional;

import com.stackroute.com.UserService.exceptions.EmailIdAlreadyExistException;
import com.stackroute.com.UserService.exceptions.EmailIdNotExistException;
import com.stackroute.com.UserService.model.User;
import com.stackroute.com.UserService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    //	registration of user
    //  business validation and business logic
    //  mobile number contains only numeric, name of the user valid etc
    public User saveUser(User user) throws EmailIdAlreadyExistException {
        Optional<User> optionalUser =  userRepository.findById(user.getEmailId());
        if(optionalUser.isPresent()) {
            throw new EmailIdAlreadyExistException("Invalid Email Id. Email Id Already Exist.");
        }
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    public User getUserByEmail(String email) {
        Optional<User> optionalUser = userRepository.findById(email);
        User user = optionalUser.isEmpty()?null:optionalUser.get();
        return user;
    }

    public boolean deleteUserByEmailId(String email) throws EmailIdNotExistException {
        Optional<User> optionalUser = userRepository.findById(email);
        User user = optionalUser.isEmpty()?null:optionalUser.get();
        if(user==null) {
            throw new EmailIdNotExistException("Email Id Not Exit");
        }
        userRepository.deleteById(email);
        return true;
    }

    public boolean validateUser(User user) {
        Optional<User> optionalUser =  userRepository.findById(user.getEmailId());
        User userObj = optionalUser.isEmpty()?null:optionalUser.get();
        boolean isValid = false;
        if(userObj!=null && user.getPassword().equals(userObj.getPassword())) {
            isValid=true;
        }
        return isValid;
    }
}
