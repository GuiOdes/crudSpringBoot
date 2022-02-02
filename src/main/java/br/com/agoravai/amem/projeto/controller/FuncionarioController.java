package br.com.agoravai.amem.projeto.controller;

import br.com.agoravai.amem.projeto.model.Funcionario;
import br.com.agoravai.amem.projeto.Repository.FuncionarioProjecao;
import br.com.agoravai.amem.projeto.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/funcionario")
@RestController
public class FuncionarioController {

    @Autowired private FuncionarioService service;

    @PostMapping(path = "/novo")
    public Funcionario cadastrar(@RequestBody Funcionario funcionario) {
        return service.cadastrar(funcionario);
    }

    @PutMapping(path = "/atualizar")
    public Funcionario atualizar(@RequestBody Funcionario funcionario) {
        return service.atualizar(funcionario);
    }

    @DeleteMapping(path = "/apagar")
    public boolean deletarPor(@RequestParam int id) {
        return service.deletarPor(id);
    }

    @GetMapping(path = "/listar-todos")
    public Iterable<Funcionario> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping(path = "/pesquisar/{id}")
    public Optional<Funcionario> pesquisarPor(@PathVariable int id) {
        return service.pesquisarPor(id);
    }

    @GetMapping(path = "/pesquisar/cargo/{id}")
    public Iterable<Funcionario> listarPorCargo(@PathVariable int id) {
        return service.listarPorCargo(id);
    }

    @GetMapping(path = "/listar-funcionarios-cargos")
    public Iterable<FuncionarioProjecao> listaFuncionarioCargo() {
        return service.listaFuncionarioCargo();
    }
}
