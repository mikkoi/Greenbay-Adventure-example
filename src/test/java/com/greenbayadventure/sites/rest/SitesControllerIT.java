package com.greenbayadventure.sites.rest;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public final class SitesControllerIT {
    private static final String SITES_RESOURCE_GET = "/api/1/sites";
    private static final String SITE_RESOURCE_GET = "/api/1/sites/";
    private static final String SITE_RESOURCE_POST = "/api/1/sites/new.json";
    @Value("${local.server.port}")
    private int serverPort;

    @Before
    public void setUp() {
        RestAssured.port = serverPort;
    }

    @Test
    public void getSitesResult() {
        given()
            .log().ifValidationFails()
            .contentType("application/json")
            .param("page", 1)
            .param("per_page", 50)
        .when()
            .get(SITES_RESOURCE_GET)
        .then()
            .log().ifValidationFails()
            .statusCode(HttpStatus.SC_OK)
            //.body("sites", hasItems())
            ;
    }

    @Test
    public void getSiteGETResult() {
        given()
                .log().ifValidationFails()
                .contentType("application/json")
        .when()
                .get(SITE_RESOURCE_GET + "1.json")
        .then()
                .statusCode(HttpStatus.SC_NOT_FOUND)
        ;
    }

    @Test
    public void getSitePOSTResult() {
        final int newSiteId =
        given()
                .log().ifValidationFails()
                .contentType("application/json")
//            .body("{\n" +
//                    "            \"site\": {\n" +
//                    "              \"id\": 0,\n" +
//                    "              \"name\": \"Drottningholms GK\"\n" +
//                    "              \"geo\": {\n" +
//                    "                \"latitude\": 17.8588090,\n" +
//                    "                \"longitude\": 59.3191080\n" +
//                    "              }\n" +
//                    "            }\n" +
//                    "          }")
//                .body("{\"site\": {\"id\": 0,\n\"name\": \"Drottningholms GK\"}}")
                .body("{\"id\": 0,\n\"name\": \"Drottningholms GK\"}")
        .when()
                .post(SITE_RESOURCE_POST)
        .then()
                .statusCode(HttpStatus.SC_OK)
                .contentType(ContentType.JSON)
                .body("name", equalTo("Drottningholms GK"))
                .body("id", greaterThanOrEqualTo(1))
        .extract().path("id")
        ;

        given()
                .log().ifValidationFails()
                .contentType("application/json")
        .when()
                .get(SITE_RESOURCE_GET + newSiteId + ".json")
        .then()
                .statusCode(HttpStatus.SC_OK)
                .body("name", equalTo("Drottningholms GK"))
        ;
    }

}
