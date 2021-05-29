package br.com.alucar.cucumber.config;

import br.com.alucar.config.WebConfig;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features/"}, plugin = {"pretty", "html:target/cucumber"},
        glue = "br.com.alucar.cucumber.steps", strict = true, tags = "")
public class AlucarCucumber {
}