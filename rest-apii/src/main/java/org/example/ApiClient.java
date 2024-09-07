package org.example;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class ApiClient {
    private RestTemplate restTemplate = new RestTemplate();
    private String sessiondId;

    public void getAllUsers(){
        ResponseEntity<String> response=restTemplate.getForEntity("http://94.198.50.185:7081/api/users",String.class);
        this.sessiondId=response.getHeaders().getFirst(HttpHeaders.SET_COOKIE);
        System.out.println("Session"+sessiondId);
    }
    public void addUser(User user){
        HttpHeaders headers=new HttpHeaders();
        headers.set("Cookie",sessiondId);
        HttpEntity<User> request=new HttpEntity<>(user,headers);
        String result = restTemplate.postForObject("http://94.198.50.185:7081/api/users", request, String.class);
        System.out.println("First part of the code: " + result);

    }

    public void updateUser(User user){
        HttpHeaders headers=new HttpHeaders();
        headers.set("Cookie",sessiondId);
        HttpEntity<User> updateRequest = new HttpEntity<>(user, headers);
        ResponseEntity<String> updateResponse = restTemplate.exchange("http://94.198.50.185:7081/api/users", HttpMethod.PUT, updateRequest, String.class);
        System.out.println("Second part of the code: " + updateResponse.getBody());

    }

    public void deleteUser(Long userId){
        HttpHeaders headers=new HttpHeaders();
        headers.set("Cookie",sessiondId);
        ResponseEntity<String> deleteResponse=restTemplate.exchange("http://94.198.50.185:7081/api/users/" + userId, HttpMethod.DELETE, new HttpEntity<>(headers), String.class);
        System.out.println("Third part of the code: " + deleteResponse.getBody());
    }
}

