package co.com.siigo.rest.interactions;

import co.com.siigo.rest.models.ReqResModel;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Post;
import java.util.HashMap;
import java.util.Map;


@Slf4j
public class PostRequest implements Interaction{

    private String baseUrl;
    private final String requestUri;
    private final String contentType;
    private final Map<String, String> Body = new HashMap<>();
    public static ReqResModel reqResModel = new ReqResModel();
    public PostRequest(String baseUrl, String requestUri, String contentType) {
        this.baseUrl = baseUrl;
        this.requestUri = requestUri;
        this.contentType = contentType;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        reqResModel.setName("Yefri");
        reqResModel.setJob("Qa Automatión");
        Body.put("name", reqResModel.getName());
        Body.put("job", reqResModel.getJob());
        actor.whoCan(CallAnApi.at(baseUrl));
        actor.attemptsTo(
                Post.to(requestUri)
                        .with(request -> request
                                .contentType(contentType)
                                .body(Body).relaxedHTTPSValidation()
                                )
        );
    }

    public static PostRequest params(String baseUrl, String requestUri, String contentType) {
        return Tasks.instrumented(PostRequest.class, baseUrl,requestUri, contentType);
    }
}
