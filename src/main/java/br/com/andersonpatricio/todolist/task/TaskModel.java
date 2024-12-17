package br.com.andersonpatricio.todolist.task;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

/**
 * ID
 * Usuário (ID_USUARIO)
 * Descrição
 * Título
 * Data de Início
 * Data de término
 * Prioridade (Alta, Baixa)
 */
@Data
@Entity(name = "tb_task")
public class TaskModel {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    private String description;

    @Column(length = 50) // No máximo 50 caracteres no title
    private String title;
    private LocalDateTime startAt; // Quando vai iniciar a tarefa
    private LocalDateTime endAt; // Quando vai fechar a tarefa
    private String priority;
    private UUID idUser;

    @CreationTimestamp
    private LocalDateTime createdAt; // Quando nossa tarefa foi criada

    public void setTitle(String title) throws Exception {                                      // Passando a exceção
        if (title.length() > 50) {
            throw new Exception("O campo title deve conter no máximo 50 caracteres");   // Cria exceção 
        }
        this.title = title;
    }
}
