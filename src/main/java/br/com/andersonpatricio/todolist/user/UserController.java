package br.com.andersonpatricio.todolist.user;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/users")
public class UserController { //classe
    
    /**
     * String (texto)
     * Integer (int) numeros inteiros
     * Double (double) Números com casa decimais
     * Float (float) parecido com double 
     * char 
     * void quando não temos retorno do nosso método
     */
    /**
     * Body
     */

    @PostMapping("/") //acessar esse controller
    public void create(@RequestBody UserModel userModel){ //método
        System.out.println(userModel.getUsername());
    }
}
