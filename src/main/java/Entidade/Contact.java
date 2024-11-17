package Entidade;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor // cria automaticamente um construtor com todas os atributos da classe como argumento.
@NoArgsConstructor// cria automaticamente um construtor vazio (sem argumentos).
@Data // cria automaticamente os métodos toString, equals, hashCode, getters e setters.
@Entity // do tipo entidade, ou seja, qualquer coisa que eu queira armazenar no banco de dados.
public class Contact {
    // ATRIBUTOS DA CLASSE
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //diz ao JPA que o banco de dados deve gerar automaticamente um valor para o id
    private Long id; // long para numeros grandes e garantir a compatibilidade

    @Column(name="contact_name")
    private String name;
    private String email;
    private String phone;
}
