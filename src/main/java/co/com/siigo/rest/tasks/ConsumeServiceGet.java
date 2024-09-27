package co.com.siigo.rest.tasks;

import co.com.siigo.rest.interactions.GetRequest;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
public class ConsumeServiceGet {
    public Performable request(String baseUrl, String request, String contentType) {
        return Task.where("{0} call the service Reqres request GET",
                GetRequest.params(baseUrl, request, contentType)
        );
    }
}
