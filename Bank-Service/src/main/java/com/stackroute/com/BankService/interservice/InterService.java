package com.stackroute.com.BankService.interservice;

import com.stackroute.com.BankService.models.User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class InterService {

    public User getUserDetails(String token) {
        RestTemplate restTemplate = new RestTemplate();
        String uri = "http://localhost:8090/user-service/test/";
        User user = restTemplate.getForObject(uri + token, User.class);
        return user;
    }

}
