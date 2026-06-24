package api.endpoints;

public class UserEndpoint {

    public static final String BASE_URL =
            "https://dummyapi.io/data/v1/user";

    public static final String LIST_USER =
            BASE_URL + "?limit=10";

    public static final String GET_USER =
            BASE_URL + "/60d0fe4f5311236168a10a0d";

    public static final String CREATE_USER =
            BASE_URL + "/create";

    public static final String UPDATE_USER =
            BASE_URL + "/60d0fe4f5311236168a10a0d";

    public static final String DELETE_USER =
            BASE_URL + "/60d0fe4f5311236168a109ca";
}