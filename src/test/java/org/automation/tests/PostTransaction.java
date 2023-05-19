package org.automation.tests;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

import static org.automation.tests.utils.Constant.unixMaxValue;
import static org.automation.tests.utils.Constant.unixMinvalue;
import static org.automation.tests.utils.Constant.getUnixLessMinvalue;
import static org.automation.tests.utils.Constant.getUnixMoreMaxValue;
import static org.automation.tests.utils.Constant.nullDateTime;
import static org.automation.tests.utils.Constant.nullDateValue;
import static org.automation.tests.utils.Constant.nullDayValue;
import static org.automation.tests.utils.Constant.nullMonthValue;
import static org.automation.tests.utils.Constant.nullYearValue;
import static org.automation.tests.utils.Constant.nullTimeStartTime;
import static org.automation.tests.utils.Constant.nullTimeEndTime;


public class PostTransaction {

    private Map<String, String> getDefaultDto() {
        Map<String, String> map = new HashMap<>();

        map.put("id", "1");
        map.put("amount", "1");
        map.put("startTime", "2023-05-20T16:32:36");
        map.put("endTime", "2023-05-24T16:32:36");

        return map;

    }

    @Test
    @DisplayName("Amount field boundary value 1")
    public void testBoundaryValueOneAmountField() {
        Map<String, String> map = getDefaultDto();
        map.put("amount", "1");

        given().
                contentType(ContentType.JSON).body(map).
                when().
                post("/transaction").
                then().assertThat().
                statusCode(HttpStatus.SC_OK).
                contentType(ContentType.JSON);
    }

    @Test
    @DisplayName("Amount field boundary value less than integer min negative value")
    public void testBoundaryValueIntMinusAmountField() {
        Map<String, String> map = getDefaultDto();
        long valueInput = (long) Integer.MIN_VALUE - 1;
        map.put("amount", String.valueOf(valueInput));

        given().
                contentType(ContentType.JSON).body(map).
                when().
                post("/transaction").
                then().assertThat().
                statusCode(HttpStatus.SC_BAD_REQUEST).
                contentType(ContentType.JSON);
    }

    @Test
    @DisplayName("Amount field boundary value 0")
    public void testBoundaryValueNullAmountField() {
        Map<String, String> map = getDefaultDto();
        map.put("amount", "0");

        given().
                contentType(ContentType.JSON).body(map).
                when().
                post("/transaction").
                then().assertThat().
                statusCode(HttpStatus.SC_OK).
                contentType(ContentType.JSON);
    }

    @Test
    @DisplayName("Amount field boundary value equal integer max positive value")
    public void testBoundaryValueMaxAmountField() {
        Map<String, String> map = getDefaultDto();
        Integer valueInput = Integer.MAX_VALUE;
        map.put("amount", String.valueOf(valueInput));

        given().
                contentType(ContentType.JSON).body(map).
                when().
                post("/transaction").
                then().assertThat().
                statusCode(HttpStatus.SC_OK).
                contentType(ContentType.JSON);
    }

    @Test
    @DisplayName("Amount field boundary value more than integer max value")
    public void negativeTestBoundaryValueMaxAmountField() {
        Map<String, String> map = getDefaultDto();
        long valueInput = (long) Integer.MAX_VALUE + 1;
        map.put("amount", String.valueOf(valueInput));

        given().
                contentType(ContentType.JSON).body(map).
                when().
                post("/transaction").
                then().assertThat().
                statusCode(HttpStatus.SC_BAD_REQUEST).
                contentType(ContentType.JSON);
    }

    @Test
    @DisplayName("StartTime field boundary value equal Unix min value")
    public void testBoundaryValueStartTimeUnixMinField() {
        Map<String, String> map = getDefaultDto();
        map.put("startTime", unixMinvalue);

        given().
                contentType(ContentType.JSON).body(map).
                when().
                post("/transaction").
                then().assertThat().
                statusCode(HttpStatus.SC_OK).
                contentType(ContentType.JSON);
    }

    @Test
    @DisplayName("StartTime field boundary value less then Unix min value")
    public void testBoundaryValueStartTimeField() {
        Map<String, String> map = getDefaultDto();
        map.put("startTime", getUnixLessMinvalue);

        given().
                contentType(ContentType.JSON).body(map).
                when().
                post("/transaction").
                then().assertThat().
                statusCode(HttpStatus.SC_BAD_REQUEST).
                contentType(ContentType.JSON);
    }

    @Test
    @DisplayName("StartTime field boundary value equal Unix max value")
    public void testBoundaryValueStartTimeUnixMaxField() {
        Map<String, String> map = getDefaultDto();
        map.put("startTime", unixMaxValue);

        given().
                contentType(ContentType.JSON).body(map).
                when().
                post("/transaction").
                then().assertThat().
                statusCode(HttpStatus.SC_OK).
                contentType(ContentType.JSON);
    }

    @Test
    @DisplayName("StartTime field boundary value more Unix max value")
    public void testBoundaryValueStartTimeMoreUnixMaxField() {
        Map<String, String> map = getDefaultDto();
        map.put("startTime", getUnixMoreMaxValue);

        given().
                contentType(ContentType.JSON).body(map).
                when().
                post("/transaction").
                then().assertThat().
                statusCode(HttpStatus.SC_BAD_REQUEST).
                contentType(ContentType.JSON);
    }

    @Test
    @DisplayName("StartTime field with NULL year value")
    public void testBoundaryValueNullYearStartTimeField() {
        Map<String, String> map = getDefaultDto();
        map.put("startTime", nullYearValue);

        given().
                contentType(ContentType.JSON).body(map).
                when().
                post("/transaction").
                then().assertThat().
                statusCode(HttpStatus.SC_BAD_REQUEST).
                contentType(ContentType.JSON);
    }

    @Test
    @DisplayName("StartTime field with NULL month value")
    public void testBoundaryValueNullMonthStartTimeField() {
        Map<String, String> map = getDefaultDto();
        map.put("startTime", nullMonthValue);

        given().
                contentType(ContentType.JSON).body(map).
                when().
                post("/transaction").
                then().assertThat().
                statusCode(HttpStatus.SC_BAD_REQUEST).
                contentType(ContentType.JSON);
    }

    @Test
    @DisplayName("StartTime field with NULL day value")
    public void testBoundaryValueNullDayStartTimeField() {
        Map<String, String> map = getDefaultDto();
        map.put("startTime", nullDayValue);

        given().
                contentType(ContentType.JSON).body(map).
                when().
                post("/transaction").
                then().assertThat().
                statusCode(HttpStatus.SC_BAD_REQUEST).
                contentType(ContentType.JSON);
    }

    @Test
    @DisplayName("StartTime field with NULL date value")
    public void testBoundaryValueNullDateStartTimeField() {
        Map<String, String> map = getDefaultDto();
        map.put("startTime", nullDateValue);

        given().
                contentType(ContentType.JSON).body(map).
                when().
                post("/transaction").
                then().assertThat().
                statusCode(HttpStatus.SC_BAD_REQUEST).
                contentType(ContentType.JSON);
    }

    @Test
    @DisplayName("StartTime field with NULL time value")
    public void testBoundaryValueNullTimeStartTimeField() {
        Map<String, String> map = getDefaultDto();
        map.put("startTime", nullTimeStartTime);

        given().
                contentType(ContentType.JSON).body(map).
                when().
                post("/transaction").
                then().assertThat().
                statusCode(HttpStatus.SC_OK).
                contentType(ContentType.JSON);
    }

    @Test
    @DisplayName("StartTime field with NULL date and time value")
    public void testBoundaryValueNullDateTimeStartTimeField() {
        Map<String, String> map = getDefaultDto();
        map.put("startTime", nullDateTime);

        given().
                contentType(ContentType.JSON).body(map).
                when().
                post("/transaction").
                then().assertThat().
                statusCode(HttpStatus.SC_BAD_REQUEST).
                contentType(ContentType.JSON);
    }

    @Test
    @DisplayName("EndTime field boundary value equal Unix max value")
    public void testBoundaryValueEndTimeUnixMaxField() {
        Map<String, String> map = getDefaultDto();
        map.put("endTime", unixMaxValue);

        given().
                contentType(ContentType.JSON).body(map).
                when().
                post("/transaction").
                then().assertThat().
                statusCode(HttpStatus.SC_OK).
                contentType(ContentType.JSON);
    }

    @Test
    @DisplayName("EndTime field boundary value more than Unix max value")
    public void testBoundaryValueEndTimeUnixMoreMaxField() {
        Map<String, String> map = getDefaultDto();
        map.put("endTime", getUnixMoreMaxValue);

        given().
                contentType(ContentType.JSON).body(map).
                when().
                post("/transaction").
                then().assertThat().
                statusCode(HttpStatus.SC_BAD_REQUEST).
                contentType(ContentType.JSON);
    }

    @Test
    @DisplayName("EndTime field boundary value equal Unix min value")
    public void testBoundaryValueEndTimeUnixMinField() {
        Map<String, String> map = getDefaultDto();
        map.put("endTime", unixMinvalue);

        given().
                contentType(ContentType.JSON).body(map).
                when().
                post("/transaction").
                then().assertThat().
                statusCode(HttpStatus.SC_OK).
                contentType(ContentType.JSON);
    }

    @Test
    @DisplayName("EndTime field boundary value less then Unix min value")
    public void testBoundaryValueEndTimeField() {
        Map<String, String> map = getDefaultDto();
        map.put("endTime", getUnixLessMinvalue);

        given().
                contentType(ContentType.JSON).body(map).
                when().
                post("/transaction").
                then().assertThat().
                statusCode(HttpStatus.SC_BAD_REQUEST).
                contentType(ContentType.JSON);
    }

    @Test
    @DisplayName("EndTime field with NULL year value")
    public void testBoundaryValueNullYearEndTimeField() {
        Map<String, String> map = getDefaultDto();
        map.put("endTime", nullYearValue);

        given().
                contentType(ContentType.JSON).body(map).
                when().
                post("/transaction").
                then().assertThat().
                statusCode(HttpStatus.SC_BAD_REQUEST).
                contentType(ContentType.JSON);
    }

    @Test
    @DisplayName("EndTime field with NULL month value")
    public void testBoundaryValueNullMonthEndTimeField() {
        Map<String, String> map = getDefaultDto();
        map.put("endTime", nullMonthValue);

        given().
                contentType(ContentType.JSON).body(map).
                when().
                post("/transaction").
                then().assertThat().
                statusCode(HttpStatus.SC_BAD_REQUEST).
                contentType(ContentType.JSON);
    }

    @Test
    @DisplayName("EndTime field with NULL day value")
    public void testBoundaryValueNullDayEndTimeField() {
        Map<String, String> map = getDefaultDto();
        map.put("endTime", nullDayValue);

        given().
                contentType(ContentType.JSON).body(map).
                when().
                post("/transaction").
                then().assertThat().
                statusCode(HttpStatus.SC_BAD_REQUEST).
                contentType(ContentType.JSON);
    }

    @Test
    @DisplayName("EndTime field with NULL date value")
    public void testBoundaryValueNullDateEndTimeField() {
        Map<String, String> map = getDefaultDto();
        map.put("endTime", nullDateValue);

        given().
                contentType(ContentType.JSON).body(map).
                when().
                post("/transaction").
                then().assertThat().
                statusCode(HttpStatus.SC_BAD_REQUEST).
                contentType(ContentType.JSON);
    }

    @Test
    @DisplayName("EndTime field with NULL time value")
    public void testBoundaryValueNullTimeEndTimeField() {
        Map<String, String> map = getDefaultDto();
        map.put("endTime", nullTimeEndTime);

        given().
                contentType(ContentType.JSON).body(map).
                when().
                post("/transaction").
                then().assertThat().
                statusCode(HttpStatus.SC_OK).
                contentType(ContentType.JSON);
    }

    @Test
    @DisplayName("EndTime field with NULL date and time value")
    public void testBoundaryValueNullDateTimeEndTimeField() {
        Map<String, String> map = getDefaultDto();
        map.put("endTime", nullDateTime);

        given().
                contentType(ContentType.JSON).body(map).
                when().
                post("/transaction").
                then().assertThat().
                statusCode(HttpStatus.SC_BAD_REQUEST).
                contentType(ContentType.JSON);
    }
}