package br.edu.infnet;

import br.edu.infnet.model.Aluno;
import br.edu.infnet.model.Email;
import br.edu.infnet.model.Endereco;
import br.edu.infnet.service.AlunoService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@RequiredArgsConstructor
@SpringBootApplication
public class InfnetApplication implements CommandLineRunner {
    private final AlunoService alunoService;

	public static void main(String[] args) {

        SpringApplication.run(InfnetApplication.class, args);
	}

    @Override
    public void run(String... args) {
        incluirAlunoEndereco();
        incluirEmails();
        consultarAlunos();
    }

    public void incluirEmails() {
        Aluno aluno = alunoService.consultarAluno(1L);
        List<Email> emails = List.of(
            new Email(null, "lp@gmail.com", aluno),
            new Email(null, "lp@infnet.br", aluno)
        );
        aluno.setEmails(emails);
        alunoService.inserirAluno(aluno);
    }

    public void incluirAlunoEndereco() {
        Aluno aluno1 = new Aluno();
        aluno1.setNome("LP");
        Endereco endereco1 = new Endereco();
        endereco1.setRua("Rua do LP");
        aluno1.setEndereco(endereco1);
        endereco1.setAluno(aluno1);
        alunoService.inserirAluno(aluno1);
    }

    public void consultarAlunos() {
        alunoService.consultarAlunos().forEach(System.out::println);
    }
}
