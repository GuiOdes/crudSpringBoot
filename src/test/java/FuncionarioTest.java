import br.com.agoravai.amem.projeto.Repository.FuncionarioRepository;
import br.com.agoravai.amem.projeto.model.Funcionario;
import br.com.agoravai.amem.projeto.services.FuncionarioService;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class) // Faz intermedio entre jUnit e Spring
public class FuncionarioTest {

    @TestConfiguration
    static class FuncionarioTestConfiguration { // Criada para que a injeção de service funcione

        @Bean
        public FuncionarioService funcionarioService() {
            return new FuncionarioService();
        }
    }

    @Autowired
    FuncionarioService service;

    @MockBean
    FuncionarioRepository repository;

    @Test
    public void test() {
        int id = 1;

        Optional<Funcionario> funcionario = service.pesquisarPor(id);

        Assertions.assertTrue(funcionario.isPresent());
    }

    @Before
    public void setup() {
        Funcionario funcionario = new Funcionario(1, "José Carlos", 1200, 21);

        Mockito.when(repository.findById(1))
                .thenReturn(Optional.of(funcionario));
    }
}
