package com.stackroute.com.BankService.interservice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.com.BankService.model.TransactionModel;
import com.stackroute.com.BankService.model.User;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class InterService {


    public User getUserDetails(String token) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("token", token);
        HttpEntity<?> httpEntity = new HttpEntity<>(headers);
        String uri = "http://localhost:8090/user-service/users/verify/";
        ResponseEntity<User> entity = restTemplate.exchange(uri, HttpMethod.GET, httpEntity, User.class);
        return entity.getBody();
    }

    public TransactionModel initiateTransaction(TransactionModel model) throws JsonProcessingException {
        System.out.println("***********Inside initiate transaction 1****************");
        RestTemplate restTemplate = new RestTemplate();
        System.out.println("***********Inside initiate transaction 2****************");
        HttpHeaders headers = new HttpHeaders();
        System.out.println("***********Inside initiate transaction 3****************");
        headers.setContentType(MediaType.APPLICATION_JSON);
        System.out.println("***********Inside initiate transaction 4****************");
        //MultiValueMap<String, TransactionModel> map = new LinkedMultiValueMap<String, TransactionModel>();
        System.out.println("***********Inside initiate transaction 5****************");
        //map.add("object", model);
        HttpEntity<TransactionModel> httpEntity = new HttpEntity<TransactionModel>(model, headers);
//        ObjectMapper objectMapper = new ObjectMapper();
//        HttpEntity<?> httpEntity = new HttpEntity<Object>(objectMapper.writeValueAsString(model), headers);
        System.out.println("***********Inside initiate transaction 6****************");
        String uri = "http://localhost:8060/transaction-service/transfer";
        System.out.println("***********Inside initiate transaction 7****************");
//        ResponseEntity<TransactionModel> entity = restTemplate.exchange(uri, HttpMethod.POST, httpEntity, TransactionModel.class);
        TransactionModel entity = restTemplate.postForObject(uri, model, TransactionModel.class);
        System.out.println("***********Inside initiate transaction 8****************");
        return entity;
    }

}
