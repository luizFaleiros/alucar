package br.com.alucar.cucumber.config;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features/"}, plugin = {"pretty", "html:target/cucumber"},
        glue = "br.com.alucar.cucumber.steps", strict = true, tags = "")
@ActiveProfiles("test")
public class AlucarCucumber {
}