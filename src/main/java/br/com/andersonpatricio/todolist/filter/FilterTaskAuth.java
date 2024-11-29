package br.com.andersonpatricio.todolist.filter;

import java.io.IOException;

import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;   //servlet é a base para frameworks web do java
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

@Component
public class FilterTaskAuth implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        //Executar alguma ação
        // Podemos barrar ou continuar
        System.out.println("Chegou no filtro");
        chain.doFilter(request, response);   // Queremos que ele continue
    }

    
}
