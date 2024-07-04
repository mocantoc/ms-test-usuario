package com.test.service;

import ch.qos.logback.core.status.ErrorStatus;
import com.test.dto.UsuarioResponseDTO;
import com.test.dto.UsuarioRequestDTO;
import com.test.entity.Usuario;
import com.test.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {


    private static final String REGEX_EMAIL = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";

    @Autowired
    UsuarioRepository usuarioRepository;


    @Override
    public UsuarioResponseDTO registar(UsuarioRequestDTO usuarioResponseRequestDTO) {

        List<Usuario> usuarios = consultarEmail(usuarioResponseRequestDTO.getEmail());

        if (!esEmailValido(usuarioResponseRequestDTO.getEmail())){
            throw new ResponseStatusException( HttpStatus.BAD_REQUEST, "Email no valido");
        }

        if (!usuarios.isEmpty()){
            throw new ResponseStatusException( HttpStatus.CONFLICT, "El correo ya registrado");
        }

        usuarioRepository.save(Usuario.builder()
                .name(usuarioResponseRequestDTO.getName())
                .email(usuarioResponseRequestDTO.getEmail())
                .password(usuarioResponseRequestDTO.getPassword())
                .fechaCreacion(new Date())
                .fechaModificacion(new Date())
                .usuarioActivo(true)
                .fechaLastLogin(new Date())
                .build());

        usuarios = consultarEmail(usuarioResponseRequestDTO.getEmail());

        return UsuarioResponseDTO.builder()
                .id(usuarios.get(0).getId())
                .fechaCreacion(usuarios.get(0).getFechaCreacion())
                .fechaLastLogin(usuarios.get(0).getFechaLastLogin())
                .fechaModificacion(usuarios.get(0).getFechaModificacion())
                .usuarioActivo(usuarios.get(0).getUsuarioActivo())
                .build();
    }



    private List<Usuario> consultarEmail(String email)  {
        List<Usuario> usuarios =  usuarioRepository.findByEmail(email);

            return usuarios;

    }

    public boolean esEmailValido(String email) {
            return email.matches(REGEX_EMAIL);
        }
}
