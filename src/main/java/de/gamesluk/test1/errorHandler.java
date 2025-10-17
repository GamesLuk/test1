package de.gamesluk.test1;

public class errorHandler {

    public static void handleError(Exception e) {
        System.out.println("Error: " + e.getMessage());
    }

    public static void handleError(String message) {
        switch (message) {
            case "arguments_count":
                System.out.println("Error: Please provide the required number of arguments.");
                break;
            case "invalid_number":
                System.out.println("Error: One or more provided values are not valid.");
                break;
            case "invalid_command":
                System.out.println("Error: The command entered is not recognized.");
                break;
            case "math_error":
                System.out.println("Error: A mathematical error occurred (e.g., division by zero).");
                break;
            case "invalid_mode":
                System.out.println("Error: The specified mode is not supported.");
                break;
            default:
                System.out.println("Error: An unknown error occurred.");
                break;
        }
    }

}
