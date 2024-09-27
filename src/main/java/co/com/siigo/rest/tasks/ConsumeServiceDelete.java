package co.com.siigo.rest.tasks;

import co.com.siigo.rest.interactions.DeleteRequest;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
public class ConsumeServiceDelete {

    public Performable request(String baseUrl, String request, String contentType) {
        return Task.where("{0} call the service Reqres request DELETE",
                DeleteRequest.params(baseUrl, request, contentType)
        );
    }
}
