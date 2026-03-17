package br.edu.infnet.service;

import br.edu.infnet.model.Aluno;
import br.edu.infnet.repository.AlunoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AlunoService {
    private final AlunoRepository alunoRepository;

    public void inserirAluno(Aluno aluno) {
        alunoRepository.save(aluno);
    }

    public Aluno consultarAluno(Long id) {
        return alunoRepository.findById(id).orElse(null);
    }

    public List<Aluno> consultarAlunos() {
        return alunoRepository.findAll();
    }
}
