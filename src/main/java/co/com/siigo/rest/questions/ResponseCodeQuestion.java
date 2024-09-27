package co.com.siigo.rest.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class ResponseCodeQuestion implements Question<Boolean> {

    private int statusCode;

    public ResponseCodeQuestion(int statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.should(seeThatResponse("validate status code response", response -> response.statusCode(statusCode)));
        return true;
    }

    public static ResponseCodeQuestion successful(int statusCode) {
        return new ResponseCodeQuestion(statusCode);
    }
}
