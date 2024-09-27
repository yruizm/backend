package co.com.siigo.rest.tasks;


import co.com.siigo.rest.interactions.PostRequest;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
public class ConsumeServicePost {

    public Performable request(String baseUrl, String request, String contentType) {
        return Task.where("{0} call the service Reqres request POST",
                PostRequest.params(baseUrl,request,contentType));
    }
}
