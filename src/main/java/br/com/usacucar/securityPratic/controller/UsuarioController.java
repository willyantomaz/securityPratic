package br.com.usacucar.securityPratic.controller;

import br.com.usacucar.securityPratic.dto.UsuarioDTO;
import br.com.usacucar.securityPratic.entidade.Usuario;
import br.com.usacucar.securityPratic.repository.UsuarioRepository;
import br.com.usacucar.securityPratic.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService usuarioService;

    private Usuario usuario;

    @PostMapping("/create")
    public ResponseEntity<Usuario> create(@RequestBody UsuarioDTO usuarioDTO){

        usuario = usuarioService.creatUsuario(usuarioDTO);
        return ResponseEntity.ok(usuarioRepository.save(usuario));

    }

    @PostMapping("/login")
    public ResponseEntity<Usuario> login(@RequestBody UsuarioDTO usuarioDTO){

        usuario = usuarioRepository.findByNomeAndPassword(usuarioDTO.nome(), usuarioDTO.password());
        return ResponseEntity.ok(usuario);

    }

    @GetMapping("/listar")
    public ResponseEntity<List<Usuario>> getUsuarios(){
        List<Usuario> usuarios = usuarioRepository.findAll();
        return ResponseEntity.ok(usuarios);
    }
}
