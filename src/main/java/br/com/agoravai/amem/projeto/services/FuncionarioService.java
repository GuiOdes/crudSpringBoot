package br.com.agoravai.amem.projeto.services;

import br.com.agoravai.amem.projeto.model.Funcionario;
import br.com.agoravai.amem.projeto.Repository.CargoRepository;
import br.com.agoravai.amem.projeto.Repository.FuncionarioRepository;
import br.com.agoravai.amem.projeto.Repository.FuncionarioProjecao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired private FuncionarioRepository funcionarioRepository;
    @Autowired private CargoRepository cargoRepository;

    public Funcionario cadastrar(Funcionario func) {
        return funcionarioRepository.save(func);
    }

    public Funcionario atualizar(Funcionario func) {
        return funcionarioRepository.save(func);
    }

    public boolean deletarPor(int id) {
        funcionarioRepository.deleteById(id);
        return funcionarioRepository.existsById(id);
    }

    public Iterable<Funcionario> listarTodos() {
        return funcionarioRepository.findAll();
    }

    public Optional<Funcionario> pesquisarPor(int id) {
        return funcionarioRepository.findById(id);
    }

    public Iterable<Funcionario> listarPorCargo(int id) {
        return funcionarioRepository.listByCargoId(id);
    }

    public Iterable<FuncionarioProjecao> listaFuncionarioCargo() {
        return funcionarioRepository.findFuncionarioCargo();
    }
}
