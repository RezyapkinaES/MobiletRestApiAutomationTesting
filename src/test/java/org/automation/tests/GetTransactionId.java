package org.automation.tests;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetTransactionId {

    @Test
    @DisplayName("Id path boundary value 1")
    public void testBoundaryValueOneIdPath() {
        Integer pathValue = 1;

        given().
                contentType(ContentType.JSON).
                pathParam("id", pathValue).
                when().
                get("/transaction/id/{id}").
                then().assertThat().
                statusCode(HttpStatus.SC_OK).
                contentType(ContentType.JSON).
                body("id", equalTo(pathValue));
    }

    @Test
    @DisplayName("Id field boundary value less than integer min negative value")
    public void testBoundaryValueIntMinusIdField() {
        long pathValue = (long) Integer.MIN_VALUE - 1;;

        given().
                contentType(ContentType.JSON).
                pathParam("id", pathValue).
                when().
                get("/transaction/id/{id}").
                then().assertThat().
                statusCode(HttpStatus.SC_NOT_FOUND).
                contentType(ContentType.JSON);
    }

    @Test
    @DisplayName("Id field boundary value 0")
    public void testBoundaryValueNullIdField() {
        Integer pathValue = 0;

        given().
                contentType(ContentType.JSON).
                pathParam("id", pathValue).
                when().
                get("/transaction/id/{id}").
                then().assertThat().
                statusCode(HttpStatus.SC_NOT_FOUND).
                contentType(ContentType.JSON);
    }

    @Test
    @DisplayName("Id field boundary value equal integer max positive value")
    public void testBoundaryValueMaxIdField() {
        Integer pathValue = Integer.MAX_VALUE;

        given().
                contentType(ContentType.JSON).
                pathParam("id", pathValue).
                when().
                get("/transaction/id/{id}").
                then().assertThat().
                statusCode(HttpStatus.SC_NOT_FOUND).
                contentType(ContentType.JSON);
    }

    @Test
    @DisplayName("Id field boundary value more than integer max value")
    public void negativeTestBoundaryValueMaxIdField() {
        long pathValue = (long) Integer.MAX_VALUE + 1;

        given().
                contentType(ContentType.JSON).
                pathParam("id", pathValue).
                log().all().
                when().
                get("/transaction/id/{id}").
                then().assertThat().
                statusCode(HttpStatus.SC_BAD_REQUEST).
                contentType(ContentType.JSON);
    }
}