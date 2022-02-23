package br.com.agoravai.amem.projeto.Repository;

import br.com.agoravai.amem.projeto.model.Funcionario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface FuncionarioRepository extends CrudRepository<Funcionario, Integer> {

    @Query(
            value = "SELECT * FROM funcionario, cargo WHERE cargo.id = :id AND funcionario.id = cargo.id",
            nativeQuery = true
    )
    Iterable<Funcionario> listByCargoId(int id);

    @Query(
            value = "SELECT funcionario.id, funcionario.nome, cargo.nome as nomeCargo FROM funcionario, cargo WHERE cargo.id = funcionario.cargo_id ORDER BY funcionario.id",
            nativeQuery = true
    )
    Iterable<FuncionarioProjecao> findFuncionarioCargo();

    @Query(
            value = "SELECT * FROM funcionario WHERE nome = ?",
            nativeQuery = true
    )
    Optional<Funcionario> findFuncionarioByUsername(String nome);
}
