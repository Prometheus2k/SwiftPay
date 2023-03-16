package com.stackroute.com.UserService.controller;

import java.util.List;

import com.stackroute.com.UserService.exceptions.EmailIdAlreadyExistException;
import com.stackroute.com.UserService.exceptions.EmailIdNotExistException;
import com.stackroute.com.UserService.model.User;
import com.stackroute.com.UserService.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping("/")
    public ResponseEntity<?> home(){
        ResponseEntity<?> entity = new ResponseEntity<String>("Welcome to Spring Boot",HttpStatus.OK);
        return entity;
    }

    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers(){
        List<User> userList = userServiceImpl.getAllUser();
        ResponseEntity<?> entity = new ResponseEntity<List<User>>(userList,HttpStatus.OK);
        return entity;
    }

    @PostMapping("/users")
    public ResponseEntity<?> registerUer(@RequestBody User user){
        ResponseEntity<?> entity = null;
        try {
            userServiceImpl.saveUser(user);
            entity= new ResponseEntity<String>("User Registerd Successfully..",HttpStatus.CREATED);
        } catch (EmailIdAlreadyExistException e) {
            entity= new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return entity;
    }


    @GetMapping("/users/{email}")
    public ResponseEntity<?> getUserByEmailId(@PathVariable("email") String emailId) {
        ResponseEntity<?> entity = null;
        User user = null;
        try {
            user = userServiceImpl.getUserByEmail(emailId);
        } catch (EmailIdNotExistException e) {
            throw new RuntimeException(e);
        }
        if(user==null) {
            entity = new ResponseEntity<String>("Email Id Not Exist",HttpStatus.BAD_REQUEST);
        }else {
            entity = new ResponseEntity<User>(user,HttpStatus.OK);
        }
        return entity;
    }

    @DeleteMapping("users/{email}")
    public ResponseEntity<?> deleteUserByEmail(@PathVariable("email") String emailId){
        boolean isDeleted = false;
        try {
            isDeleted = userServiceImpl.deleteUserByEmailId(emailId);
        } catch (EmailIdNotExistException e) {
            throw new RuntimeException(e);
        }
        ResponseEntity<?> entity = new ResponseEntity<String>("Something went Wrong",HttpStatus.BAD_REQUEST);
        if(isDeleted) {
            entity = new ResponseEntity<String>("User deleted Successfully",HttpStatus.OK);
        }
        return entity;
    }

    @PostMapping("/login")
    public ResponseEntity<?> validateUser(@RequestBody User user){
        boolean isValid = userServiceImpl.validateUser(user);
        ResponseEntity<?> entity = new ResponseEntity<String>("Invalid username or password",HttpStatus.UNAUTHORIZED);;
        if(isValid) {
            entity = new ResponseEntity<String>("User Logged In Successfully",HttpStatus.OK);
        }
        return entity;
    }

    //PUT for User details esditing
    @PutMapping("users/{email}")
    public ResponseEntity<?> updateUser(@PathVariable("email") String emailId, @RequestBody User user) {
        User updateUser;
        try {
            updateUser = userServiceImpl.getUserByEmail(emailId);
        } catch (EmailIdNotExistException e) {
            throw new RuntimeException(e);
        }

        updateUser.setEmailId(user.getEmailId());
        updateUser.setLocation(user.getLocation());
        updateUser.setNameOfTheUser(user.getNameOfTheUser());
        updateUser.setPassword(user.getPassword());
        updateUser.setMobileNumber(user.getMobileNumber());
        updateUser.setPanNumber(user.getPanNumber());
        updateUser.setProfilePassword(user.getProfilePassword());

        userServiceImpl.updateUser(updateUser);
        return new ResponseEntity<User>(updateUser, HttpStatus.CREATED);
    }

    @ExceptionHandler(EmailIdNotExistException.class)
    public ResponseEntity<?> exceptionHandler(Exception e){
        ResponseEntity<?> entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
        return entity;
    }
}
