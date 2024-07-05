package com.test.controller;


import com.test.dto.UsuarioRequestDTO;
import com.test.dto.UsuarioResponseDTO;
import com.test.security.UserDetailsServiceImpl;
import com.test.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;

@RestController
@AllArgsConstructor
public class TokenController {

    private final UserDetailsService userDetailsService;

    @PostMapping(value = "/token")
    public ResponseEntity<TokenResponseDTO> registarToken(
            @RequestBody TokenRequestDTO tokenRequestDTO) {

        UserDetails userDetails =  userDetailsService.loadUserByUsername(tokenRequestDTO.getEmail());
        TokenResponseDTO tokenResponseDTO = TokenResponseDTO.builder().token(userDetails.getPassword()).build();
        return ResponseEntity.ok(tokenResponseDTO);
    }
}
