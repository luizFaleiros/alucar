package br.com.alucar.cucumber.steps;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.ActiveProfiles;

@AutoConfigureMockMvc
@RequiredArgsConstructor
@ActiveProfiles("test")
public class PesquisandoCarroStep {


    @Given("Dado que não informei os o filtro do carro")
    public void dado_que_não_informei_os_o_filtro_do_carro() {
    }


    @When("Eu clicar me pesquisar")
    public void eu_clicar_me_pesquisar() throws Exception {


    }

    @Then("É retornado todos os carros")
    public void é_retornado_todos_os_carros() {

    }

}
