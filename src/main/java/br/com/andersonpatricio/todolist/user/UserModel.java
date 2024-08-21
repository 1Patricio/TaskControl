package br.com.andersonpatricio.todolist.user;

import lombok.Data;

@Data //Defini os getters e setters e deixa o cógido mais limpo
public class UserModel {
    
    public String username;
    public String name;
    public String password; 
}
