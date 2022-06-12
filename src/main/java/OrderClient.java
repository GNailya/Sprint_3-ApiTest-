import static io.restassured.RestAssured.given;

public class OrderClient extends RestAssuredClient{
    private final String ORDER = "/api/v1/orders";
    int order;

    public int orderCreate(String color) {
        return order = given()
                .spec(getSpec())
                .body("{"+"\"firstName\":\"Anna\","+
                        "\"lastName\":\"Sogrina\","+
                        "\"address\":\"msk\"," +
                        "\"metroStation\":\"2\"," +
                        "\"phone\":\"+8 000 000 00 07\"," +
                        "\"rentTime\":\"1\"," +
                        "\"deliveryDate\":\"2022-06-31\"," +
                        "\"comment\":\"Saske, come back to Konoha\"," +
                        "\"color\":"+"["+color+"]}")
                .when()
                .post(ORDER)
                .then().extract().body().path("track");
    }
}
