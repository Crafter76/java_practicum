package com.practicum;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DeliveryTests {
    @Test
    @DisplayName("distance > 30 and good is fragile")
    void fragileLongDistance() {
        Delivery delivery = new Delivery();
        assertThrows(RuntimeException.class,  () ->
            delivery.calc(31, false, true, "normal"));
    }

    @Test
    @DisplayName("distance < 0")
    void negativeDistance() {
        Delivery delivery = new Delivery();
        assertThrows(RuntimeException.class,  () ->
            delivery.calc(-1, false, true, "normal"));
    }


    @ParameterizedTest(name = "distance is {0}, high dimension is {1}, fragile is {2}, workload is {3}, excepted is {4}")
    @CsvSource({
            "0,    false,   false,  normal,     400",
            "1,     true,   false,  very high,  400",
            "2,     false,  true,   high,       630",
            "3,     true,   true,   normal,     600",
            "9,     false,  false,  increase,   400",
            "10,    true,   false,  increase,   400",
            "11,    false,  true,   very high,  960",
            "29,    true,   true,   high,       980",
            "30,    false,  false,  high,       420",
            "31,    true,   false,  normal,     500"
    })

    void calcPositive(double distance, boolean highDimension, boolean fragile, String workload, double expectedResult) {
        Delivery delivery = new Delivery();
        assertEquals(expectedResult, delivery.calc(distance, highDimension, fragile, workload),
                () ->"distance is " + distance + " km"
                        + " high demension is " + highDimension
                        + " fragile is " + fragile
                        + " workload is " + workload
                        + ", delivery should cost " + expectedResult);
    }
}
