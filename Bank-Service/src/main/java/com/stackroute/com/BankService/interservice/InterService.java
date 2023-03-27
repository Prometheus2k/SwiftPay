package com.stackroute.com.BankService.interservice;

import com.stackroute.com.BankService.model.User;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;


import java.net.http.HttpHeaders;

@Service
public class InterService {

    public User getUserDetails(String token) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("token", token);
        HttpEntity<?> httpEntity = new HttpEntity<>(headers);
        String uri = "http://localhost:8090/user-service/interservice/get/user";
        ResponseEntity<User> entity = restTemplate.exchange(uri, HttpMethod.GET, httpEntity, User.class);
        return entity.getBody();
    }

    public boolean verifyUser(String token) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("token", token);
        HttpEntity<?> httpEntity = new HttpEntity<>(headers);
        String uri = "http://localhost:8090/user-service/interservice/verify/";
        ResponseEntity<Boolean> entity = restTemplate.exchange(uri, HttpMethod.GET, httpEntity, Boolean.class);
        boolean check = entity.getBody();
        return check;
    }

    public boolean initiateTransaction(String MT101) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("MT101", MT101);
        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<MultiValueMap<String, String>>(map, headers);
        String uri = "http://localhost:8060/transaction-service/transfer";
        ResponseEntity<Boolean> entity = restTemplate.exchange(uri, HttpMethod.GET, httpEntity, Boolean.class);
        return entity.getBody();
    }


}
