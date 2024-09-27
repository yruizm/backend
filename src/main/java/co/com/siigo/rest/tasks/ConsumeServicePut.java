package co.com.siigo.rest.tasks;

import co.com.siigo.rest.interactions.PutRequest;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import java.util.List;

public class ConsumeServicePut {

    public Performable request(String baseUrl, String request, List<String> dataUserUpdate, String contentType) {
        return Task.where("{0} call the service Reqres request PUT",
                PutRequest.params(baseUrl, request, dataUserUpdate, contentType));
    }
}
