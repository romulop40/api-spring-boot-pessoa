package br.com.pessoa.apipessoa.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.pessoa.apipessoa.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa,Long> {
    
}
