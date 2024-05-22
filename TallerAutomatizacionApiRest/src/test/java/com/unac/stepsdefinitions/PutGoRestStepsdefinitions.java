package com.unac.stepsdefinitions;

import com.unac.apis.GoRestApi;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PutGoRestStepsdefinitions {
    @Given("se establece la base url {string}")
    public void seEstableceLaBaseUrl(String baseUrl) {
        GoRestApi.setBaseUrl(baseUrl);
    }

    @When("se actualiza el nombre en el endpoint {string} por id {string} con el nombre {string} y el email {string}")
    public void seActualizaElNombreEnElEndpointPorIdConElNombreYElEmail(String endPoint, String idUser, String name, String email) {
        GoRestApi.executionPutToken(endPoint, idUser, name, email);
    }

    @Then("se valida que el status code {int} y que el nombre sea {string} y el email sea {string}")
    public void seValidaQueElStatusCodeYQueElNombreSeaYElEmailSea(Integer statusCode, String name, String email) {
        GoRestApi.validatePutResponse(statusCode, name, email);
    }
}
