package co.com.siigo.rest.tasks;

public class CallService {
    private CallService(){}

    public static ConsumeServiceGet operationGet(){
        return new ConsumeServiceGet();
    }

    public static ConsumeServicePost operationPost(){return new ConsumeServicePost(); }

    public static ConsumeServiceDelete operationDelete() {
        return new ConsumeServiceDelete();
    }

    public static ConsumeServicePut operationPut(){
        return new ConsumeServicePut();
    }



}
