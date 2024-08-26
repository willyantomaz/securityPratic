package br.com.usacucar.securityPratic.entidade;

import br.com.usacucar.securityPratic.enums.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "usuario")
public class Usuario {

    @Id
    private ObjectId id;

    private String nome;

    private String password;


}

