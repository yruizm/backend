package co.com.siigo.rest.stepdefinitions;

import co.com.siigo.rest.questions.LastResponseGetPath;
import co.com.siigo.rest.questions.ResponseCodeQuestion;
import co.com.siigo.rest.tasks.CallService;
import co.com.siigo.rest.utils.Constants;
import io.cucumber.java.Before;
import io.cucumber.java.ast.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class GetUserStepDefinition {
    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Dado("^que consumo el api operacion get$")
    public void consumptionElApiOperacionGet() {
        OnStage.theActorCalled("api").attemptsTo(
                CallService.operationGet().request(Constants.BASE_URI,Constants.MANNAGEMENT_USER_URI,Constants.CONTENTTYPE));
    }

    @Cuando("^valido el codigo de respuesta \"([^\"]*)\"$")
    public void validResponseCodeSuccessful(int intCodigoRespuesta) {
        theActorInTheSpotlight().should(seeThat(ResponseCodeQuestion.successful(intCodigoRespuesta)));
    }

    @Entonces("^verifico el id en la respuesta$")
    public void validIdInAnswer() {
        OnStage.theActorInTheSpotlight().should(seeThat("expected response", LastResponseGetPath.bodyRespuesta(Constants.PATH_JSON_ID), equalTo(Constants.USER_ID)));
    }



}
