package org.automation.core;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import org.junit.BeforeClass;

public class TestBase {
    private static final String URL = "http://localhost:8080";

    @BeforeClass
    public static void initClass() {
        RestAssured.baseURI = URL;
        Header defaultHeader = new Header("Content-Type", "application/json");
    }
}
