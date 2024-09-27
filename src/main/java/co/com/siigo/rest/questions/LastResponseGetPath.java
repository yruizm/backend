package co.com.siigo.rest.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class LastResponseGetPath implements Question<String> {

    private String path;

    public LastResponseGetPath(String path) {
        this.path = path;
    }

    public static LastResponseGetPath bodyRespuesta(String path) {
        return new LastResponseGetPath(path);
    }

    @Override
    public String answeredBy(Actor actor) {
        String resultado;
        resultado=SerenityRest.lastResponse().jsonPath().getString(path);
        return resultado;
    }
}
