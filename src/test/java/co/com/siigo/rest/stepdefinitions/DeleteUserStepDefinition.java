package co.com.siigo.rest.stepdefinitions;

import co.com.siigo.rest.tasks.CallService;
import co.com.siigo.rest.utils.Constants;
import io.cucumber.java.es.Dado;
import net.serenitybdd.screenplay.actors.OnStage;

public class DeleteUserStepDefinition {

    @Dado("^que consumo el api operacion eliminar$")
    public void consumptionElApiOperacionDelete() {
        OnStage.theActorCalled("api").attemptsTo(
                CallService.operationDelete().request(
                        Constants.BASE_URI,Constants.MANNAGEMENT_USER_URI,Constants.CONTENTTYPE
                ));
    }


}
