package co.com.siigo.rest.interactions;

import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Put;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static co.com.siigo.rest.interactions.PostRequest.reqResModel;

@Slf4j
public class PutRequest implements Interaction{

    private String baseUrl;
    private List<String> dataUserUpdate;
    private final String requestUri;
    private final String contentType;
    private final Map<String, String> headersBody = new HashMap<>();
    public PutRequest(String baseUrl, String requestUri,List<String> dataUserUpdate, String contentType) {
        this.baseUrl = baseUrl;
        this.dataUserUpdate = dataUserUpdate;
        this.requestUri = requestUri;
        this.contentType = contentType;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {
        reqResModel.setName(dataUserUpdate.get(0));
        reqResModel.setJob(dataUserUpdate.get(1));
        headersBody.put("name", dataUserUpdate.get(0));
        headersBody.put("job", dataUserUpdate.get(1));
        actor.whoCan(CallAnApi.at(baseUrl));
        actor.attemptsTo(
                Put.to(requestUri)
                        .with(request -> request
                                .contentType(contentType)
                                .body(headersBody)
                                .relaxedHTTPSValidation())
        );
    }

    public static PutRequest params(String baseUrl,  String requestUri, List<String> dataUserUpdate, String contentType) {
        return Tasks.instrumented(PutRequest.class, baseUrl,requestUri, dataUserUpdate, contentType);
    }
}
