package com.test.dto;

import lombok.*;

import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UsuarioResponseDTO {

    private Long id;

    private Date fechaCreacion;

    private Date fechaModificacion;

    private Date fechaLastLogin;

    private Boolean usuarioActivo;
}
