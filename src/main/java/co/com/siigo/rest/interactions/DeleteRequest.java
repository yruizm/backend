package co.com.siigo.rest.interactions;

import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Delete;

@Slf4j
public class DeleteRequest implements Interaction {
    private String baseUrl;
    private final String request;
    private final String contentType;

    public DeleteRequest(String baseUrl, String request, String contentType) {
        this.baseUrl = baseUrl;
        this.request = request;
        this.contentType = contentType;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.whoCan(CallAnApi.at(baseUrl));
        actor.attemptsTo(
                Delete.from(request)
                        .with(requestSpecification -> requestSpecification
                                .accept(contentType)
                                .relaxedHTTPSValidation())
        );
    }

    public static DeleteRequest params(String baseUrl, String request, String contentType) {
        return Tasks.instrumented(DeleteRequest.class, baseUrl, request, contentType);
    }
}
