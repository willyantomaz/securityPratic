package br.com.usacucar.securityPratic.service;

import br.com.usacucar.securityPratic.dto.UsuarioDTO;
import br.com.usacucar.securityPratic.entidade.Usuario;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {


    public Usuario creatUsuario(UsuarioDTO usuarioDTO) {

        Usuario usuario = new Usuario();
        usuario.setNome(usuarioDTO.nome());
        usuario.setPassword(usuarioDTO.password());
        //usuario.setRole(usuarioDTO.roleEnum());

        return usuario;
    }
}
