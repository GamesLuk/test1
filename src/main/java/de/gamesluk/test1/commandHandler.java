package de.gamesluk.test1;

import java.math.BigDecimal;

public class commandHandler {

    public static

    public static void sendResult() {
        System.out.println("= " + Main.getResult());
    }

    public static void handleCommand(String input) {
        String[] parts = input.split(" ");
        String command = parts[0];

        if (command.equals("clear")) {
            Main.setResult("0");
            sendResult();
            return;
        }
        else if (command.equals("help")) {
            System.out.println("Available commands:");
            System.out.println(" + or sum [number]       : Add number to the current results");
            System.out.println(" - or subtract [number]  : Subtract number from the current result");
            System.out.println(" * or multiply [number]  : Multiply the current result by number");
            System.out.println(" / or divide [number]    : Divide the current result by number");

            System.out.println(" clear                   : Reset the current result to 0");
            System.out.println(" help                    : Show this help message");
            System.out.println(" exit                    : Exit the application");
            return;
        }
        else if (command.equals("exit")) {
            Main.stop();
            return;
        }

        if (parts.length != 2) {
            errorHandler.handleError("arguments_count");
            return;
        }

        String a = parts[1];

        switch (command) {
            case "mode":
                if (a.equals("standard") || a.equals("bigdecimal")) {
                    Main.setMode(a);
                    System.out.println("Mode set to " + a);
                } else {
                    errorHandler.handleError("invalid_command");
                }
                return;
            case "+":
            case "sum":
                mathOperations.sum(a);
                break;
            case "-":
            case "subtract":
                mathOperations.subtract(a);
                break;
            case "*":
            case "multiply":
                mathOperations.multiply(a);
                break;
            case "/":
            case "divide":
                mathOperations.divide(a);
                break;
            default:
                errorHandler.handleError("invalid_command");
                return;
        }

        sendResult();
    }

}
