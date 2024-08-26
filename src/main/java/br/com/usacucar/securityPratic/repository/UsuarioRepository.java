package br.com.usacucar.securityPratic.repository;

import br.com.usacucar.securityPratic.entidade.Usuario;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, ObjectId> {

    Usuario findByNomeAndPassword(String nome, String password);

    UserDetails findByNome(String nome);
}
