package de.gamesluk.test1;

import java.math.BigDecimal;

public class commandHandler {

    public static void sendResult() {
        System.out.println("= " + Main.getResult());
    }

    private static void sendMode() {
        System.out.println("Current mode: " + Main.getMode());
    }

    public static void handleCommand(String input) {
        String[] parts = input.split(" ");
        String command = parts[0];
        String a = parts.length > 1 ? parts[1] : "";

        switch (command) {
            case "clear" -> {
                Main.setResult("0");
                sendResult();
                return;
            }
            case "help" -> {
                System.out.println("Available commands:");
                System.out.println(" + or sum [number]       : Add number to the current results");
                System.out.println(" - or subtract [number]  : Subtract number from the current result");
                System.out.println(" * or multiply [number]  : Multiply the current result by number");
                System.out.println(" / or divide [number]    : Divide the current result by number");

                System.out.println(" clear                   : Reset the current result to 0");
                System.out.println(" help                    : Show this help message");
                System.out.println(" exit                    : Exit the application");
                System.out.println(" mode [standard|fast]    : Show or set the calculation mode");
                return;
            }
            case "exit" -> {
                Main.stop();
                return;
            }
            case "mode" -> {
                if (parts.length == 1) {
                    sendMode();
                    return;
                } else if (a.equals("standard") || a.equals("fast")) {
                    Main.setMode(a);
                    System.out.println("Mode set to " + a);
                } else {
                    errorHandler.handleError("invalid_command");
                }
                return;
            }
        }

        if (!validArgumentsCount(parts, 2)) {
            return;
        }

        try{
            new BigDecimal(a);
        } catch (NumberFormatException e) {
            errorHandler.handleError("invalid_number");
            return;
        }

        switch (command) {
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

    private static boolean validArgumentsCount(String[] parts, int expectedCount) {
        if (parts.length != expectedCount) {
            errorHandler.handleError("arguments_count");
            return false;
        }
        return true;
    }

}
