package de.gamesluk.test1;

import java.math.RoundingMode;

public class mathOperations {

    public static void sum(String a) {
        if (Main.getMode().equals("standard")) {
            double res = Double.parseDouble(Main.getResult());
            double val = Double.parseDouble(a);
            res += val;
            Main.setResult(Double.toString(res));
        } else if (Main.getMode().equals("bigdecimal")) {
            java.math.BigDecimal res = new java.math.BigDecimal(Main.getResult());
            java.math.BigDecimal val = new java.math.BigDecimal(a);
            res = res.add(val);
            Main.setResult(res.toString());
        }
    }

    public static void subtract(String a) {
        if (Main.getMode().equals("standard")) {
            double res = Double.parseDouble(Main.getResult());
            double val = Double.parseDouble(a);
            res -= val;
            Main.setResult(Double.toString(res));
        } else if (Main.getMode().equals("bigdecimal")) {
            java.math.BigDecimal res = new java.math.BigDecimal(Main.getResult());
            java.math.BigDecimal val = new java.math.BigDecimal(a);
            res = res.subtract(val);
            Main.setResult(res.toString());
        }
    }

    public static void multiply(String a) {
        if (Main.getMode().equals("standard")) {
            double res = Double.parseDouble(Main.getResult());
            double val = Double.parseDouble(a);
            res *= val;
            Main.setResult(Double.toString(res));
        } else if (Main.getMode().equals("bigdecimal")) {
            java.math.BigDecimal res = new java.math.BigDecimal(Main.getResult());
            java.math.BigDecimal val = new java.math.BigDecimal(a);
            res = res.multiply(val);
            Main.setResult(res.toString());
        }
}

    public static void divide(String a) {
        if (Main.getMode().equals("standard")) {
            double res = Double.parseDouble(Main.getResult());
            double val = Double.parseDouble(a);
            res /= val;
            Main.setResult(Double.toString(res));
        } else if (Main.getMode().equals("bigdecimal")) {
            java.math.BigDecimal res = new java.math.BigDecimal(Main.getResult());
            java.math.BigDecimal val = new java.math.BigDecimal(a);
            try {
                res = res.divide(val, RoundingMode.UNNECESSARY);
                Main.setResult(res.toString());
            } catch (java.lang.ArithmeticException e) {
                errorHandler.handleError("math_error");
            }
        }
    }

}
