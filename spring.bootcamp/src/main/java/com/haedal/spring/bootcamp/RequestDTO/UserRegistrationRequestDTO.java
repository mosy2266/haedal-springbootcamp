package com.haedal.spring.bootcamp.RequestDTO;

import lombok.Getter;

@Getter
public class UserRegistrationRequestDTO {
    private String username;
    private String password;
    private String name;
}