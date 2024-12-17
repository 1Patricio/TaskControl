package br.com.andersonpatricio.todolist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import at.favre.lib.crypto.bcrypt.BCrypt;

@RestController
@RequestMapping ("/users")
public class UserController { //classe
    
    @Autowired
    private IUserRepository userRepository;

    @PostMapping("/") //acessar esse controller
    public ResponseEntity create(@RequestBody UserModel userModel){   // Método
        // System.out.println(userModel.getUsername());
        var user = this.userRepository.findByUsername(userModel.getUsername());

        if (user != null) {                                      // Se o usuário já existir
            System.out.println("Usuário já existe");
            // Vamos Retornar
            // Mensagem de Erro
            // Status Code
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já existe");    // Caso de erro 400, exiba
        }

        // Hash de senha  // Passa um array por conta que pede no método
        var passwordHashred = BCrypt.withDefaults().hashToString(12, userModel.getPassword().toCharArray()); 
        
        userModel.setPassword(passwordHashred); // Set senha criptografada 

        var userCreated = this.userRepository.save(userModel);
        return ResponseEntity.status(HttpStatus.OK).body(userCreated);
    }
}
