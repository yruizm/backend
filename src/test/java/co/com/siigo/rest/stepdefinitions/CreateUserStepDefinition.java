package co.com.siigo.rest.stepdefinitions;

import co.com.siigo.rest.questions.LastResponseGetPath;
import co.com.siigo.rest.questions.PostQuestion;
import co.com.siigo.rest.tasks.CallService;
import co.com.siigo.rest.utils.Constants;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.ast.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import static co.com.siigo.rest.interactions.PostRequest.reqResModel;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;


public class CreateUserStepDefinition {

    @Cuando("^que ingreso la data para el almacenamiento un ususario nuevo$")
    public void consumptionElApiOperacionPost() {
        OnStage.theActorCalled("api").attemptsTo(
                CallService.operationPost().request(
                        Constants.BASE_URI,Constants.CREATE_USER_URI,Constants.CONTENTTYPE));
    }

    @Entonces("^verifico la respuestas con los datos creados$")
    public void ICheckTheAnswersWithCreatedData(DataTable dataUserCreate) {
        theActorInTheSpotlight().should(seeThat(PostQuestion.registerSuccess(dataUserCreate.transpose().asList(String.class))));
        OnStage.theActorInTheSpotlight().should(seeThat("expected response", LastResponseGetPath.bodyRespuesta(Constants.PATH_JSON_NAME), equalTo(reqResModel.name)));
        OnStage.theActorInTheSpotlight().should(seeThat("expected response", LastResponseGetPath.bodyRespuesta(Constants.PATH_JSON_JOB), equalTo(reqResModel.job)));
    }

}
