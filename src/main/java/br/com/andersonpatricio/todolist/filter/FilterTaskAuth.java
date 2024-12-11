package br.com.andersonpatricio.todolist.filter;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import at.favre.lib.crypto.bcrypt.BCrypt;
import br.com.andersonpatricio.todolist.user.IUserRepository;
import jakarta.servlet.Filter; //servlet é a base para frameworks web do java
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class FilterTaskAuth extends OncePerRequestFilter {

    @Autowired
    private IUserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        var servletPath = request.getServletPath();

        if (servletPath.startsWith("/tasks/")) {
            // Pegar a autenticação (usuário e senha)
            var authorization = request.getHeader("Authorization");

            var authEncoded = authorization.substring("Basic".length()).trim(); // Pegar a palavrar Basic e calcular
                                                                                // tamanho
                                                                                // dela "5". Remova os espaços

            byte[] authDecode = Base64.getDecoder().decode(authEncoded); // Devolve ainda criptografado

            var authString = new String(authDecode); // Devolver USUARIO:SENHA

            String[] credentials = authString.split(":");
            String username = credentials[0];
            String password = credentials[1];

            // * Validar Usuário
            var user = this.userRepository.findByUsername(username);
            if (user == null) {
                response.sendError(401);
            } else {
                // * Validar senha
                var passowrdVerify = BCrypt.verifyer().verify(password.toCharArray(), user.getPassword());
                if (passowrdVerify.verified) {
                    request.setAttribute("idUser", user.getId());
                    filterChain.doFilter(request, response);                // Request, vem da requisição  // Response envia ao usuário
                } else {
                    response.sendError(401);
                }
            }
        } else {
            filterChain.doFilter(request, response);
        }
    }
}