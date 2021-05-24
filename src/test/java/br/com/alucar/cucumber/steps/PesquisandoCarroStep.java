package br.com.alucar.cucumber.steps;


import br.com.alucar.controllers.CarController;
import br.com.alucar.services.CarService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RequiredArgsConstructor
@ActiveProfiles("test")
@WebMvcTest(controllers = CarController.class)
public class PesquisandoCarroStep {

    private final MockMvc mockMvc;
    private final ObjectMapper objectMapper;
    private Object response;

    @Given("Dado que não informei os o filtro do carro")
    public void dado_que_não_informei_os_o_filtro_do_carro() {
    }


    @When("Eu clicar me pesquisar")
    public void eu_clicar_me_pesquisar() throws Exception {
        response =  mockMvc.perform(MockMvcRequestBuilders.get("/cars"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn()
                .getAsyncResult();

    }

    @Then("É retornado todos os carros")
    public void é_retornado_todos_os_carros() {

    }

}
