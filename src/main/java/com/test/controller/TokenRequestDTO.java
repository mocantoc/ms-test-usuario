package com.test.controller;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenRequestDTO {

    private String email;

    private String password;
}
