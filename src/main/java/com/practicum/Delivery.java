package com.practicum;

public class Delivery {

    public double calc(double distance, boolean highDemension, boolean fragility, String workload) {
        double result = 0;

        if (distance > 30) {
            result += 300;
        } else if (distance > 10) {
            result += 200;
        } else if (distance > 2) {
            result += 100;
        } else {
            result += 50;
        }

        if (highDemension) {
            result += 200;
        } else {
            result += 100;
        }

        if (fragility) {
            result += 300;
            if (distance > 30) {
                throw new RuntimeException("Fragile goods cannot be transported more then 30 km");
            }
        }

        if (workload == "very high") {
            result *= 1.6;
        } else if (workload == "high") {
            result *= 1.4;
        } else if (workload == "increase") {
            result *= 1.2;
        }

        if (result < 400) {
            return 400;
        }
        return result;
    }
}