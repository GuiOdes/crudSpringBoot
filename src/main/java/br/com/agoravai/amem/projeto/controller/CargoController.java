package br.com.agoravai.amem.projeto.controller;

import br.com.agoravai.amem.projeto.model.Cargo;
import br.com.agoravai.amem.projeto.services.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/cargo")
public class CargoController {
    @Autowired private CargoService service;

    @GetMapping(path = "/pesquisar")
    public Iterable<Cargo> pesquisar() {
        return service.pesquisar();
    }

    @PostMapping(path = "/novo")
    public Cargo novo(@RequestParam Cargo cargo) {
        return service.novo(cargo);
    }

    @DeleteMapping(path = "/apagar")
    public boolean apagar(@RequestParam int id) {
        return service.apagar(id);
    }

    @GetMapping(path = "/pesquisar/{id}")
    public ResponseEntity<Cargo> buscarPor(@PathVariable int id) {
        return service.buscarPor(id);
    }

    @GetMapping(path = "/pesquisar-nome/{nome}")
    public Cargo pesquisarPor(@PathVariable String nome) {
        return service.pesquisarPor(nome);
    }
}
