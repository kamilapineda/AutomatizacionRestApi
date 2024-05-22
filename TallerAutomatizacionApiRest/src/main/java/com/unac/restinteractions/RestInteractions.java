package com.unac.restinteractions;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

public class RestInteractions {

    private static String baseUrl;

    public static void setBaseUrl(String baseUrl) {
        RestInteractions.baseUrl = baseUrl;
    }

    public static void executionPutToken(String endPoint, String idUser, String token, String name, String email) {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("name", name);
        requestBody.put("email", email);

        SerenityRest.given().auth().oauth2(token)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .put(baseUrl.concat(endPoint).concat(idUser));

        SerenityRest.lastResponse().prettyPeek();
    }

    public static void validatecode(Integer statusCode) {
        Integer statusActual = SerenityRest.lastResponse().statusCode();
        assertEquals(statusActual.intValue(), statusCode.intValue());
    }

    public static void validateDataResponse(String name, String email, String pathName, String pathEmail) {
        String nombreActual = SerenityRest.lastResponse()
                .jsonPath().getString(pathName);
        String emailActual = SerenityRest.lastResponse()
                .jsonPath().getString(pathEmail);
        assertEquals(nombreActual, name);
        assertEquals(emailActual, email);
    }
}
