package br.com.agoravai.amem.projeto;
import br.com.agoravai.amem.projeto.controller.CargoController;
import br.com.agoravai.amem.projeto.model.Cargo;
import br.com.agoravai.amem.projeto.services.CargoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CargoController.class)
public class CargoControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CargoService service;

    @Test
    public void getAllCargos() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/cargo/pesquisar"))
                .andExpect(status().isOk());
    }

    @Before
    public void setup() {

        Cargo cargo = new Cargo("Gerente");
        Cargo cargo2 = new Cargo("Vendedor");

        Iterable<Cargo> cargos = Arrays.asList(cargo, cargo2);

        Mockito.when(service.pesquisar())
                .thenReturn(cargos);
    }
}
