package br.com.andersonpatricio.todolist.filter;

import java.io.IOException;
import java.util.Base64;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.Filter;   //servlet é a base para frameworks web do java
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class FilterTaskAuth extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
                // Pegar a autenticação (usuário e senha)
                var authorization = request.getHeader("Authorization");

                var authEncoded = authorization.substring("Basic".length()).trim();   // Pegar a palavrar Basic e calcular tamanho dela "5". Remova os espaços
                
                byte[] authDecode = Base64.getDecoder().decode(authEncoded);          // Devolve ainda criptografado

                var authString = new String(authDecode);                              // Devolver USUARIO:SENHA

                String[] credentials = authString.split(":");
                String username = credentials[0];
                String password = credentials[1];

                System.out.println("Usuário :" + username);
                System.out.println("Senha :" + password);


                //  * Validar Usuário
                //  * Validar senha
                //  * Segue

                filterChain.doFilter(request, response);
    }


    
}
