package br.edu.infnet.service;

import br.edu.infnet.model.Disciplina;
import br.edu.infnet.repository.DisciplinaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequiredArgsConstructor
public class DisciplinaService {
    private final DisciplinaRepository disciplinaRepository;

    public  void incluirDisciplina(Disciplina disciplina) {
        disciplinaRepository.save(disciplina);
    }
}
