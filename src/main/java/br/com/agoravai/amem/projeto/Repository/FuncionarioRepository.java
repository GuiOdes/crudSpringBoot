package br.com.agoravai.amem.projeto.Repository;

import br.com.agoravai.amem.projeto.model.Funcionario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

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
}
