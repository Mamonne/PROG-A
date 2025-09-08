package series;

import java.util.Scanner;

public class InputValidator {
    private static Scanner scanner = new Scanner(System.in);
    
    public static boolean isValidAge(String age) {
        try {
            int ageValue = Integer.parseInt(age);
            return ageValue >= 2 && ageValue <= 18;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public static String getValidatedAge(String prompt) {
        while (true) {
            System.out.print(prompt);
            String ageInput = scanner.nextLine();
            
            if (isValidAge(ageInput)) {
                return ageInput;
            } else {
                System.out.println("You have entered an incorrect series age!!! Please re-enter the series age >>");
            }
        }
    }
    
    public static String getInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
    
    public static boolean getConfirmation(String prompt) {
        System.out.print(prompt);
        String response = scanner.nextLine();
        return "y".equalsIgnoreCase(response);
    }
}