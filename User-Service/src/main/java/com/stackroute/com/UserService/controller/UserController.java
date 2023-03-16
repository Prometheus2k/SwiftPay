package com.stackroute.com.UserService.controller;

import java.util.List;

import com.stackroute.com.UserService.exceptions.EmailIdAlreadyExistException;
import com.stackroute.com.UserService.exceptions.EmailIdNotExistException;
import com.stackroute.com.UserService.model.User;
import com.stackroute.com.UserService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ResponseEntity<?> home(){
        ResponseEntity<?> entity = new ResponseEntity<String>("Welcome to Spring Boot",HttpStatus.OK);
        return entity;
    }

    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers(){
        List<User> userList = userService.getAllUser();
        ResponseEntity<?> entity = new ResponseEntity<List<User>>(userList,HttpStatus.OK);
        return entity;
    }

    @PostMapping("/users")
    public ResponseEntity<?> registerUer(@RequestBody User user){
        ResponseEntity<?> entity = null;
        try {
            userService.saveUser(user);
            entity= new ResponseEntity<String>("User Registerd Successfully..",HttpStatus.CREATED);
        } catch (EmailIdAlreadyExistException e) {
            entity= new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
        return entity;
    }


    @GetMapping("/users/{email}")
    public ResponseEntity<?> getUserByEmailId(@PathVariable("email") String emailId){
        ResponseEntity<?> entity = null;
        User user = userService.getUserByEmail(emailId);
        if(user==null) {
            entity = new ResponseEntity<String>("Email Id Not Exist",HttpStatus.BAD_REQUEST);
        }else {
            entity = new ResponseEntity<User>(user,HttpStatus.OK);
        }
        return entity;
    }

    @DeleteMapping("users/{email}")
    public ResponseEntity<?> deleteUserByEmail(@PathVariable("email") String emailId) throws EmailIdNotExistException {
        boolean isDeleted = userService.deleteUserByEmailId(emailId);
        ResponseEntity<?> entity = new ResponseEntity<String>("Something went Wrong",HttpStatus.BAD_REQUEST);
        if(isDeleted) {
            entity = new ResponseEntity<String>("User deleted Successfully",HttpStatus.OK);
        }
        return entity;
    }

    @PostMapping("/login")
    public ResponseEntity<?> validateUser(@RequestBody User user){
        boolean isValid = userService.validateUser(user);
        ResponseEntity<?> entity = new ResponseEntity<String>("Invalid username or password",HttpStatus.OK);;
        if(isValid) {
            entity = new ResponseEntity<String>("User Logged In Successfully",HttpStatus.OK);
        }
        return entity;
    }

    @ExceptionHandler(EmailIdNotExistException.class)
    public ResponseEntity<?> exceptionHander(Exception e){
        ResponseEntity<?> entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
        return entity;
    }
}
