package br.com.usacucar.securityPratic.service;

import br.com.usacucar.securityPratic.entidade.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.*;


@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String chave;

    public String gerarToken(Usuario usuario){
        try {
            Algorithm algoritimo = Algorithm.HMAC256(chave);
            return JWT.create()
                    .withIssuer("API pratica")
                    .withSubject(usuario.getNome())
                    .withExpiresAt(expiraToken())
                    .sign(algoritimo);
        } catch (JWTCreationException exception){
        throw new RuntimeException("Erro ao gerar token",exception);
        }
    }

    private Instant expiraToken() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
