package br.com.andersonpatricio.todolist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/users")
public class UserController { //classe
    
    @Autowired
    private IUserRepository userRepository;

    @PostMapping("/") //acessar esse controller
    public UserModel create(@RequestBody UserModel userModel){   // Método
        // System.out.println(userModel.getUsername());
        var user = this.userRepository.findByUsername(userModel.getUsername());
        if (user != null) {                                      // Se o usuário já existir
            System.out.println("Usuário já existe");
            return null;
        }
        var userCreated = this.userRepository.save(userModel);
        return userCreated;
    }
}
