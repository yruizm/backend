package co.com.siigo.rest.stepdefinitions;

import co.com.siigo.rest.tasks.CallService;
import co.com.siigo.rest.utils.Constants;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.ast.Cuando;
import net.serenitybdd.screenplay.actors.OnStage;

public class UpdateUserStepDefinition {

    @Cuando("^que ingreso la data para la actualizacion de un ususario$")
    public void consumptionElApiOperacionPut(DataTable dataUserCreate) {
        OnStage.theActorCalled("api").attemptsTo(
                CallService.operationPut().request(Constants.BASE_URI,Constants.MANNAGEMENT_USER_URI,dataUserCreate.transpose().asList(String.class),Constants.CONTENTTYPE)
        );
    }


}
