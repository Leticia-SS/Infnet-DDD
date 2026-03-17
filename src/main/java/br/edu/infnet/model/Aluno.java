package br.edu.infnet.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor@AllArgsConstructor
@Entity
@Table(name = "alunos")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 100, nullable = false)
    private String nome;

    @OneToOne(mappedBy = "aluno", cascade = CascadeType.ALL)
    private Endereco endereco;

    @OneToMany(mappedBy = "aluno",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private List<Email> emails;
}
