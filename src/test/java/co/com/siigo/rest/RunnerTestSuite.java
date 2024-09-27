package co.com.siigo.rest;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = "src/test/resources/features/",
    glue = "co.com.siigo.rest.stepdefinitions",
    tags = "@Regresion"
)
public class RunnerTestSuite {
}
