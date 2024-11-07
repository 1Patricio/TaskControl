package br.com.andersonpatricio.todolist.user;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
//persistence = camada de banco de dados
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data                                       //Defini os getters e setters e deixa o cógido mais limpo
@Entity(name = "tb_users")                //@Entity(name = "") // tabela
public class UserModel {
    
    @Id
    @GeneratedValue(generator = "UUID")  //Gerador do UUID que é um código bem grande
    private UUID id;                     //Chave primária

    @Column(unique = true)               //Meu Username agora é um atributo unico, se já existir vai dar erro
    public String username;
    public String name;
    public String password; 

    @CreationTimestamp                   //Banco de dados
    private LocalDateTime createdAt;
}
