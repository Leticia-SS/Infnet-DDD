package br.edu.infnet.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "enderecos")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100, nullable = false)
    private String Rua;
    // ...

    @OneToOne
    @JoinColumn(name = "id_aluno")
    @ToString.Exclude
    private Aluno aluno;
}
