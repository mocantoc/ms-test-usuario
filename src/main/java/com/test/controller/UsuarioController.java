package com.test.controller;


import com.test.dto.UsuarioRequestDTO;
import com.test.dto.UsuarioResponseDTO;
import com.test.service.UsuarioService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Slf4j
@RestController
@AllArgsConstructor
//@Validated
public class UsuarioController {

    private final UsuarioService usuarioService;

/*    @ApiOperation(value = "Obtiene los parámetros de simulación para ser mostrados al cliente en el simulador de crédito flexible")
    @ApiResponses({
            @ApiResponse(code = HttpServletResponse.SC_OK, message = "Respuesta exitosa al ingresar usuario"),
            @ApiResponse(code = HttpServletResponse.SC_BAD_REQUEST, message = "Ocurrió un error , verifique datos ingrasados"),
            @ApiResponse(code = HttpServletResponse.SC_INTERNAL_SERVER_ERROR, message = "Ocurrió un error interno al creando usuario”")
    })*/
    //@PreAuthorize("hasAnyRole(@environment.getRequiredProperty('usuario')")
    @PostMapping(value = "/usuario", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UsuarioResponseDTO> registarUsuario(
            @RequestBody UsuarioRequestDTO usuarioResponseRequestDTO) {
        UsuarioResponseDTO usuarioResponse = UsuarioResponseDTO.builder().build();
        try {
             usuarioResponse = usuarioService.registar(usuarioResponseRequestDTO);
        }catch (Exception e){
            throw  e;
        }
        return ResponseEntity.ok(usuarioResponse);
    }


    @GetMapping(value = "/usuario", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UsuarioResponseDTO> registarUsuario( @RequestParam String email) {
        UsuarioResponseDTO usuarioResponse = UsuarioResponseDTO.builder().build();
        try {
            usuarioResponse = usuarioService.consultar(email);
        }catch (Exception e){
            throw  e;
        }
        return ResponseEntity.ok(usuarioResponse);
    }

}
