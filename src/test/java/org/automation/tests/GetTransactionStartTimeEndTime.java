package org.automation.tests;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.automation.tests.utils.Constant.*;

public class GetTransactionStartTimeEndTime {

    @Test
    @DisplayName("StartTime field boundary value equal Unix min value")
    public void testBoundaryValueStartTimeMinUnixPath() {

        given().
                contentType(ContentType.JSON).
                pathParams("startTime", unixMinvalue).
                pathParams("endTime", endDateTimeValue).
                when().
                log().all().
                get("/transaction/start/{startTime}/endTime/{endTime}").
                then().assertThat().
                statusCode(HttpStatus.SC_NOT_FOUND).
                contentType(ContentType.JSON);
    }

    @Test
    @DisplayName("EndTime field boundary value equal Unix min value")
    public void testBoundaryValueEndTimeUnixMinPath() {

        given().
                contentType(ContentType.JSON).
                pathParams("startTime", startDateTimeValue).
                pathParams("endTime", unixMinvalue).
                when().
                get("/transaction/start/{startTime}/endTime/{endTime}").
                then().assertThat().
                statusCode(HttpStatus.SC_BAD_REQUEST).
                contentType(ContentType.JSON);
    }

    @Test
    @DisplayName("StartTime field boundary value less then Unix min value")
    public void testBoundaryValueStartTimeUnixLessMinPath() {

        given().
                contentType(ContentType.JSON).
                pathParams("startTime", getUnixLessMinvalue).
                pathParams("endTime", endDateTimeValue).
                when().
                get("/transaction/start/{startTime}/endTime/{endTime}").
                then().assertThat().
                statusCode(HttpStatus.SC_BAD_REQUEST).
                contentType(ContentType.JSON);
    }

    @Test
    @DisplayName("EndTime field boundary value less then Unix min value")
    public void testBoundaryValueEndTimeUnixLessMinPath() {

        given().
                contentType(ContentType.JSON).
                pathParams("startTime", startDateTimeValue).
                pathParams("endTime", getUnixLessMinvalue).
                when().
                get("/transaction/start/{startTime}/endTime/{endTime}").
                then().assertThat().
                statusCode(HttpStatus.SC_BAD_REQUEST).
                contentType(ContentType.JSON);
    }

    @Test
    @DisplayName("StartTime field boundary value equal Unix max value")
    public void testBoundaryValueStartTimeUnixMaxPath() {

        given().
                contentType(ContentType.JSON).
                pathParams("startTime", unixMaxValue).
                pathParams("endTime", endDateTimeValue).
                when().
                get("/transaction/start/{startTime}/endTime/{endTime}").
                then().assertThat().
                statusCode(HttpStatus.SC_BAD_REQUEST).
                contentType(ContentType.JSON);
    }

    @Test
    @DisplayName("EndTime field boundary value equal Unix max value")
    public void testBoundaryValueEndTimeUnixMaxPath() {

        given().
                contentType(ContentType.JSON).
                pathParams("startTime", startDateTimeValue).
                pathParams("endTime", unixMaxValue).
                when().
                get("/transaction/start/{startTime}/endTime/{endTime}").
                then().assertThat().
                statusCode(HttpStatus.SC_NOT_FOUND).
                contentType(ContentType.JSON);
    }

    @Test
    @DisplayName("StartTime field boundary value more Unix max value")
    public void testBoundaryValueStartTimeUnixPath() {

        given().
                contentType(ContentType.JSON).
                pathParams("startTime", getUnixMoreMaxValue).
                pathParams("endTime", endDateTimeValue).
                when().
                get("/transaction/start/{startTime}/endTime/{endTime}").
                then().assertThat().
                statusCode(HttpStatus.SC_BAD_REQUEST).
                contentType(ContentType.JSON);
    }

    @Test
    @DisplayName("EndTime field boundary value more Unix max value")
    public void testBoundaryValueEndTimeUnixPath() {

        given().
                contentType(ContentType.JSON).
                pathParams("startTime", startDateTimeValue).
                pathParams("endTime", getUnixMoreMaxValue).
                when().
                get("/transaction/start/{startTime}/endTime/{endTime}").
                then().assertThat().
                statusCode(HttpStatus.SC_BAD_REQUEST).
                contentType(ContentType.JSON);
    }

    @Test
    @DisplayName("StartTime field with NULL year value")
    public void testBoundaryValueStartTimeNullYearPath() {

        given().
                contentType(ContentType.JSON).
                pathParams("startTime", nullYearValue).
                pathParams("endTime", endDateTimeValue).
                when().
                get("/transaction/start/{startTime}/endTime/{endTime}").
                then().assertThat().
                statusCode(HttpStatus.SC_BAD_REQUEST).
                contentType(ContentType.JSON);
    }

    @Test
    @DisplayName("EndTime field with NULL year value")
    public void testBoundaryValueEndTimeNullYearPath() {

        given().
                contentType(ContentType.JSON).
                pathParams("startTime", startDateTimeValue).
                pathParams("endTime", nullYearValue).
                when().
                get("/transaction/start/{startTime}/endTime/{endTime}").
                then().assertThat().
                statusCode(HttpStatus.SC_BAD_REQUEST).
                contentType(ContentType.JSON);
    }

    @Test
    @DisplayName("StartTime field with NULL month value")
    public void testBoundaryValueStartTimeNullMonthPath() {

        given().
                contentType(ContentType.JSON).
                pathParams("startTime", nullMonthValue).
                pathParams("endTime", endDateTimeValue).
                when().
                get("/transaction/start/{startTime}/endTime/{endTime}").
                then().assertThat().
                statusCode(HttpStatus.SC_BAD_REQUEST).
                contentType(ContentType.JSON);
    }

    @Test
    @DisplayName("EndTime field with NULL month value")
    public void testBoundaryValueEndTimeNullMonthPath() {

        given().
                contentType(ContentType.JSON).
                pathParams("startTime", startDateTimeValue).
                pathParams("endTime", nullMonthValue).
                when().
                get("/transaction/start/{startTime}/endTime/{endTime}").
                then().assertThat().
                statusCode(HttpStatus.SC_BAD_REQUEST).
                contentType(ContentType.JSON);
    }

    @Test
    @DisplayName("StartTime field with NULL day value")
    public void testBoundaryValueStartTimeNullDayPath() {

        given().
                contentType(ContentType.JSON).
                pathParams("startTime", nullDayValue).
                pathParams("endTime", endDateTimeValue).
                when().
                get("/transaction/start/{startTime}/endTime/{endTime}").
                then().assertThat().
                statusCode(HttpStatus.SC_BAD_REQUEST).
                contentType(ContentType.JSON);
    }

    @Test
    @DisplayName("EndTime field with NULL day value")
    public void testBoundaryValueEndTimeNullDayPath() {

        given().
                contentType(ContentType.JSON).
                pathParams("startTime", startDateTimeValue).
                pathParams("endTime", nullDayValue).
                when().
                get("/transaction/start/{startTime}/endTime/{endTime}").
                then().assertThat().
                statusCode(HttpStatus.SC_BAD_REQUEST).
                contentType(ContentType.JSON);
    }

    @Test
    @DisplayName("StartTime field with NULL date value")
    public void testBoundaryValueStartTimeNullDatePath() {

        given().
                contentType(ContentType.JSON).
                pathParams("startTime", nullDateValue).
                pathParams("endTime", endDateTimeValue).
                when().
                get("/transaction/start/{startTime}/endTime/{endTime}").
                then().assertThat().
                statusCode(HttpStatus.SC_BAD_REQUEST).
                contentType(ContentType.JSON);
    }

    @Test
    @DisplayName("EndTime field with NULL date value")
    public void testBoundaryValueEndTimeNullDatePath() {


        given().
                contentType(ContentType.JSON).
                pathParams("startTime", startDateTimeValue).
                pathParams("endTime", nullDateValue).
                when().
                get("/transaction/start/{startTime}/endTime/{endTime}").
                then().assertThat().
                statusCode(HttpStatus.SC_BAD_REQUEST).
                contentType(ContentType.JSON);
    }

    @Test
    @DisplayName("StartTime field with NULL time value")
    public void testBoundaryValueStartTimeNullTimePath() {

        given().
                contentType(ContentType.JSON).
                pathParams("startTime", nullTimeStartTime).
                pathParams("endTime", endDateTimeValue).
                when().
                get("/transaction/start/{startTime}/endTime/{endTime}").
                then().assertThat().
                statusCode(HttpStatus.SC_NOT_FOUND).
                contentType(ContentType.JSON);
    }

    @Test
    @DisplayName("EndTime field with NULL time value")
    public void testBoundaryValueEndTimeNullTimePath() {

        given().
                contentType(ContentType.JSON).
                pathParams("startTime", startDateTimeValue).
                pathParams("endTime", nullTimeEndTime).
                when().
                get("/transaction/start/{startTime}/endTime/{endTime}").
                then().assertThat().
                statusCode(HttpStatus.SC_NOT_FOUND).
                contentType(ContentType.JSON);
    }

    @Test
    @DisplayName("StartTime field with NULL date and time value")
    public void testBoundaryValueStartTimeNullDateTimePath() {

        given().
                contentType(ContentType.JSON).
                pathParams("startTime", nullDateTime).
                pathParams("endTime", endDateTimeValue).
                when().
                get("/transaction/start/{startTime}/endTime/{endTime}").
                then().assertThat().
                statusCode(HttpStatus.SC_BAD_REQUEST).
                contentType(ContentType.JSON);
    }

    @Test
    @DisplayName("EndTime field with NULL date and time value")
    public void testBoundaryValueEndTimeNullDateTimePath() {


        given().
                contentType(ContentType.JSON).
                pathParams("startTime", startDateTimeValue).
                pathParams("endTime", nullDateTime).
                when().
                get("/transaction/start/{startTime}/endTime/{endTime}").
                then().assertThat().
                statusCode(HttpStatus.SC_BAD_REQUEST).
                contentType(ContentType.JSON);
    }
}