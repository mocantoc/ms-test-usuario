package com.test.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private String email;

    private String password;

    private String phones;

    private Date fechaCreacion;

    private Date fechaModificacion;

    private Date fechaLastLogin;

    private Boolean usuarioActivo;
}
