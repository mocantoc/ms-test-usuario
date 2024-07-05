package com.test.security;

import com.test.entity.Usuario;
import com.test.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername (String email) throws UsernameNotFoundException{

        Usuario usuario = Usuario.builder().build();
        /*        Usuario usuario = usuarioRepository.findOneByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException("user no "));*/
        usuario.setPassword("$2a$10$BXIye7fWXrsgvCJQHtHlSOpjzQAQh0P8fe3hum9goDM4F2GprZXU2");
        usuario.setEmail("ocanto@gmail.com");
        return new UserDetailImpl(usuario);
    }
}
