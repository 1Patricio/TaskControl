package br.com.andersonpatricio.todolist.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/primeiraRota")
//http://localhost:8080/primeiraRota -----
public class MinhaPrimeiraController {
    /**
     * MÉTODOS DE ACESSO DO HTTP
     * GET - buscar uma informação
     * POST - Adicionar um dado / informação
     * PUT - Alterar um dado/info
     * DELETE - Remover um dado
     * PATCH - Alterar somente uma parte da info / dado
     * 
     */

     //MÉTODO (FUNCIONALIDADE) DE UMA CLASSE
    @GetMapping("/primeiroMetodo")
    public String primeiraMensagem(){
        return "Funcionou";
    }
}
