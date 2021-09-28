package com.practicum;

public class Delivery {

    public double calc(double distance, boolean highDimension, boolean fragility, String workload) {
        double result = 0;

        if (fragility) {
            result += 300;
            if (distance > 30) {
                throw new RuntimeException("Fragile goods cannot be transported more then 30 km");
            }
        }

        if (distance > 30) {
            result += 300;
        } else if (distance > 10) {
            result += 200;
        } else if (distance > 2) {
            result += 100;
        } else if (distance >= 0){
            result += 50;
        } else {
            throw new RuntimeException("Distance ought to be more then 0 km ");
        }

        if (highDimension) {
            result += 200;
        } else {
            result += 100;
        }

        switch (workload) {
            case "very high":
                result *= 1.6;
                break;
            case "high":
                result *= 1.4;
                break;
            case "increase":
                result *= 1.2;
                break;
            default:
                break;
        }

        return result < 400 ? 400 : result;
    }
}