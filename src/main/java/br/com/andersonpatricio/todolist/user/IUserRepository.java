package br.com.andersonpatricio.todolist.user;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;


public interface IUserRepository extends JpaRepository<UserModel, UUID>{
    //tipo que ele vai retornar  (aonde buscar)
    UserModel findByUsername(String username);
}
    

