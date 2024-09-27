package co.com.siigo.rest.utils;

public class Constants {


    private Constants() {
        throw new IllegalStateException("Utility class");
    }

    public static final String PATH_JSON_NAME = "name";
    public static final String PATH_JSON_JOB = "job";
    public static final String PATH_JSON_ID = "data.id";
    public static final String BASE_URI = "https://reqres.in";
    public static final String MANNAGEMENT_USER_URI = "/api/users/2";
    public static final String CREATE_USER_URI = "/api/users";
    public static final String CONTENTTYPE = "application/json";
    public static final String USER_ID = "2";
}
