package br.com.usacucar.securityPratic.auth;

import br.com.usacucar.securityPratic.dto.UsuarioDTO;
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
public class AutenticaUsuario {

    @Autowired
    private AuthenticationManager manager;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid UsuarioDTO usuarioDTO){
        var token = new UsernamePasswordAuthenticationToken(usuarioDTO.nome(),usuarioDTO.password());
        var autentication = manager.authenticate(token);

        return ResponseEntity.ok().build();
    }
}
