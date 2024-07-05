package com.test.repository;

import com.test.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    List<Usuario> findByEmail(String email);

    Optional<Usuario> findOneByEmail(String email);
}
