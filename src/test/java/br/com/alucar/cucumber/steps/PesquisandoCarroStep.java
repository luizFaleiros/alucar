package br.com.alucar.cucumber.steps;


import br.com.alucar.config.WebConfig;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@AutoConfigureMockMvc
@WebAppConfiguration
@ContextConfiguration(classes = WebConfig.class)
public class PesquisandoCarroStep {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webAppContext;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();
    }

    @Given("Dado que não informei os o filtro do carro")
    public void dado_que_não_informei_os_o_filtro_do_carro() throws Exception {
        var a = mockMvc.perform(MockMvcRequestBuilders.post("/car"));
    }


    @When("Eu clicar me pesquisar")
    public void eu_clicar_me_pesquisar() throws Exception {


    }

    @Then("É retornado todos os carros")
    public void é_retornado_todos_os_carros() {

    }

}
