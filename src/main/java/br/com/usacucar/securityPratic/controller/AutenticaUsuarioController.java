package br.com.usacucar.securityPratic.controller;

import br.com.usacucar.securityPratic.dto.TokenDTO;
import br.com.usacucar.securityPratic.dto.UsuarioDTO;
import br.com.usacucar.securityPratic.entidade.Usuario;
import br.com.usacucar.securityPratic.service.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AutenticaUsuarioController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid UsuarioDTO usuarioDTO){
        var token = new UsernamePasswordAuthenticationToken(usuarioDTO.nome(),usuarioDTO.password());
        var autentication = manager.authenticate(token);
         //tokenDTO = tokenService.gerarToken((Usuario) autentication.getPrincipal());
        var tokenAutenticado = tokenService.gerarToken((Usuario) autentication.getPrincipal());
        return ResponseEntity.ok(new TokenDTO(tokenAutenticado));
    }
}
