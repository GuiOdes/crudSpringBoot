package br.com.agoravai.amem.projeto;

import br.com.agoravai.amem.projeto.Repository.CargoRepository;
import br.com.agoravai.amem.projeto.model.Cargo;
import br.com.agoravai.amem.projeto.services.CargoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class CargoServiceTest {

    @TestConfiguration
    static class CargoServiceTestConfiguration {

        @Bean
        public CargoService service() {
            return new CargoService();
        }
    }

    @Autowired
    CargoService service;

    @MockBean
    CargoRepository repository;

    @Test
    public void buscaPorIdTeste() {

        Cargo gerente = new Cargo("Gerente");

        String nome = "Gerente";

        Assertions.assertEquals(service.pesquisarPor(nome).getNome(), gerente.getNome());
    }

    @Before
    public void setup() {

        Cargo gerente = new Cargo("Gerente");

        String nome = "Gerente";

        Mockito.when(repository.findByNome(nome))
                .thenReturn(gerente);
    }

}
