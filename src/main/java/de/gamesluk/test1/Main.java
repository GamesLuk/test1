package de.gamesluk.test1;

import java.util.Scanner;

public class Main {

    private static String result = "0.0";
    private static String mode = "standard";
    private static Boolean isRunning = true;

    public static void main(String[] args) {

        System.out.println("Hello and welcome!");

        Scanner scan = new Scanner(System.in);

        commandHandler.sendResult();

        while(isRunning) {
            System.out.print("Enter command: ");
            String input = scan.nextLine();

            commandHandler.handleCommand(input);
        }
    }

    public static void stop(){
        isRunning = false;
    }

    public static String getResult() {
        return result;
    }

    public static void setResult(String result) {
        Main.result = result;
    }

    public static String getMode() {
        return mode;
    }

    public static void setMode(String mode) {
        Main.mode = mode;
    }
}