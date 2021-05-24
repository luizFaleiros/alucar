package br.com.alucar.cucumber.config;

import br.com.alucar.AlucarApplication;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@RunWith(Cucumber.class)
@AutoConfigureMockMvc
@CucumberOptions(features = {"src/test/resources/features/"}, plugin = {"pretty", "html:target/cucumber"},
        glue = "br.com.alucar.cucumber.steps", strict = true, tags = {""})
public class AlucarCucumber {
}