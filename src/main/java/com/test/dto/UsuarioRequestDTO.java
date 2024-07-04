package com.test.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRequestDTO {

    private String name;

    private String email;

    private String password;

    private String phones;
}
