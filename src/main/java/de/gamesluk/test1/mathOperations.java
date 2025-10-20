package de.gamesluk.test1;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class mathOperations {

    public static void sum(String a) {
        if (Main.getMode().equals("fast")) {
            double res = Double.parseDouble(Main.getResult());
            double val = Double.parseDouble(a);
            res += val;
            Main.setResult(Double.toString(res));
        } else if (Main.getMode().equals("standard")) {
            BigDecimal res = new BigDecimal(Main.getResult());
            BigDecimal val = new BigDecimal(a);
            res = res.add(val);
            Main.setResult(res.toString());
        }
    }

    public static void subtract(String a) {
        if (Main.getMode().equals("fast")) {
            double res = Double.parseDouble(Main.getResult());
            double val = Double.parseDouble(a);
            res -= val;
            Main.setResult(Double.toString(res));
        } else if (Main.getMode().equals("standard")) {
            BigDecimal res = new BigDecimal(Main.getResult());
            BigDecimal val = new BigDecimal(a);
            res = res.subtract(val);
            Main.setResult(res.toString());
        }
    }

    public static void multiply(String a) {
        if (Main.getMode().equals("fast")) {
            double res = Double.parseDouble(Main.getResult());
            double val = Double.parseDouble(a);
            res *= val;
            Main.setResult(Double.toString(res));
        } else if (Main.getMode().equals("standard")) {
            BigDecimal res = new BigDecimal(Main.getResult());
            BigDecimal val = new BigDecimal(a);
            res = res.multiply(val);
            Main.setResult(res.toString());
        }
}

    public static void divide(String a) {
        if (Main.getMode().equals("fast")) {
            double res = Double.parseDouble(Main.getResult());
            double val = Double.parseDouble(a);
            res /= val;
            Main.setResult(Double.toString(res));
        } else if (Main.getMode().equals("standard")) {
            BigDecimal res = new BigDecimal(Main.getResult());
            BigDecimal val = new BigDecimal(a);
            try {
                res = res
                        .setScale(100)
                        .divide(val, RoundingMode.HALF_UP);
                res = res.setScale(calculateScale(res));
                Main.setResult(res.toString());
            } catch (java.lang.ArithmeticException e) {
                errorHandler.handleError("math_error");
            }
        }
    }

    private static int calculateScale(BigDecimal result) {
        result = result.stripTrailingZeros();
        String decimals = result.toPlainString().split("\\.")[1];
        return decimals.length();
    }

}
