package com.unac.apis;

import com.unac.restinteractions.RestInteractions;

public class GoRestApi {

    private static final String TOKEN = "5053ac7fe120c7e2d04b48650d2d2d846b16826a03fa73bc5d0703f6d6ebb842";

    public static void setBaseUrl(String baseUrl) {
        RestInteractions.setBaseUrl(baseUrl);
    }

    public static void executionPutToken(String endPoint, String idUser, String name, String email){
        RestInteractions.executionPutToken(endPoint, idUser, TOKEN, name, email);
    }

    public static void validatePutResponse(Integer statusCode, String name, String email) {
        RestInteractions.validatecode(statusCode);
        String pathName = "name";
        String pathEmail = "email";
        RestInteractions.validateDataResponse(name, email, pathName, pathEmail);
    }
}
