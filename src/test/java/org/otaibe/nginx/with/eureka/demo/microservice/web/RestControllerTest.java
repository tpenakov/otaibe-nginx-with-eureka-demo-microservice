package org.otaibe.nginx.with.eureka.demo.microservice.web;

import io.quarkus.test.junit.QuarkusTest;
import lombok.AccessLevel;
import lombok.Getter;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.junit.jupiter.api.Test;

import java.text.MessageFormat;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.startsWith;

@QuarkusTest
@Getter(AccessLevel.PROTECTED)
public class RestControllerTest {

    @ConfigProperty(name = "quarkus.application.name")
    String appName;

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/rest")
          .then()
             .statusCode(200)
             .body(startsWith(MessageFormat.format("application-name={0};", getAppName())));
    }

}