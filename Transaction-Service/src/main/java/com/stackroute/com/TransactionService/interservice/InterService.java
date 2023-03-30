package com.stackroute.com.TransactionService.interservice;


import com.stackroute.com.TransactionService.model.User;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class InterService {

    public User getUserDetails(String token) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("token", token);
        HttpEntity<?> httpEntity = new HttpEntity<>(headers);
        String uri = "https://swiftpay.stackroute.io/user-service/users/verify/";
        ResponseEntity<User> entity = restTemplate.exchange(uri, HttpMethod.GET, httpEntity, User.class);
        return entity.getBody();
    }

    public void executeCredit(String message) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> httpEntity = new HttpEntity<String>(message, headers);
        String uri = "https://swiftpay.stackroute.io/bank-service/credit";
        restTemplate.exchange(uri, HttpMethod.POST, httpEntity, String.class);
    }

}
