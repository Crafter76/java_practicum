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
        assertThrows(RuntimeException.class,  () -> {
            delivery.calc(31, false, true, "normal");
        });
    }


    @ParameterizedTest(name = "distance is {0}, high demension is {1}, fragile is {2}, workload is {3}, excepted is {4}")
    @CsvSource({
            "0,    false,   false,  normal, 400"
    })

    void calcAll(double distance, boolean highDemension, boolean fragile, String workload, double expectedResult) {
        Delivery delivery = new Delivery();
        assertEquals(expectedResult, delivery.calc(distance, highDemension, fragile, workload),
                () ->"distance is " + distance + " km"
                        + " high demension is " + highDemension
                        + " fragile is " + fragile
                        + " workload is " + workload
                        + ", delivery should cost" + expectedResult);
    }
}
