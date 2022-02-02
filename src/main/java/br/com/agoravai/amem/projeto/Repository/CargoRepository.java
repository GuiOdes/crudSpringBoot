package br.com.agoravai.amem.projeto.Repository;

import br.com.agoravai.amem.projeto.model.Cargo;
import org.springframework.data.repository.CrudRepository;

public interface CargoRepository extends CrudRepository<Cargo, Integer> {

    Cargo findByNome(String nome);
}
