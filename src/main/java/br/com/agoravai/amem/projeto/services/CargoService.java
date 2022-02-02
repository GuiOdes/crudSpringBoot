package br.com.agoravai.amem.projeto.services;

import br.com.agoravai.amem.projeto.model.Cargo;
import br.com.agoravai.amem.projeto.Repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CargoService {

    @Autowired CargoRepository repository;

    public Iterable<Cargo> pesquisar() {
        return repository.findAll();
    }

    public Cargo pesquisarPor(String nome) {
        return repository.findByNome(nome);
    }

    public Cargo novo(Cargo cargo) {
        return repository.save(cargo);
    }

    public boolean apagar(int id) {
        repository.deleteById(id);
        return repository.existsById(id);
    }

    public ResponseEntity<Cargo> buscarPor(int id) {
        return repository.findById(id)
                .map(cargo -> ResponseEntity.ok().body(cargo))
                .orElse(ResponseEntity.notFound().build());
    }
}
