package br.com.agoravai.amem.projeto;

import br.com.agoravai.amem.projeto.controller.FuncionarioController;
import br.com.agoravai.amem.projeto.model.Funcionario;
import br.com.agoravai.amem.projeto.services.FuncionarioService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@WebMvcTest(FuncionarioController.class)
public class FuncionarioTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    FuncionarioService service;

    @Test
    public void funcionarioGetAllTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/funcionario/listar-todos"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Before
    public void setup() {
        Funcionario funcionario1 = new Funcionario(1, "Fernando", 1320, 10);
        Funcionario funcionario2 = new Funcionario(2, "Marcos", 1820, 20);

        Iterable<Funcionario> listaFuncionarios = Arrays.asList(funcionario1, funcionario2);

        Mockito.when(service.listarTodos())
                .thenReturn(listaFuncionarios);
    }

}
