
import java.util.*;
import java.util.regex.*;

public class USER_PROFILE {

    
    public static boolean validateName(String name) {
        
        String regex = "^[a-zA-Z0-9]+$";
        if (!name.matches(regex)) {
            System.out.println("Error: Name must contain only alphanumeric characters.");
            return false;
        }
        return true;
    }

    
    public static boolean validateGmail(String gmail) {
        
        String regex = "^[a-zA-Z0-9._%+-]+@gmail\\.com$";
        if (!gmail.matches(regex)) {
            System.out.println("Error: Invalid Gmail address. It must end with @gmail.com.");
            return false;
        }
        return true;
    }

    
    public static boolean validateDateOfBirth(String dob) {
        
        String regex = "^([0-2][0-9]|(3)[0-1])/(0[1-9]|1[0-2])/([0-9]{4})$";
        if (!dob.matches(regex)) {
            System.out.println("Error: Date of Birth must be in DD/MM/YYYY format.");
            return false;
        }
        return true;
    }

    
    public static String getValidInput(Scanner sc, String prompt, ValidationType validationType) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = sc.nextLine();

            boolean isValid = false;
            switch (validationType) {
                case NAME:
                    isValid = validateName(input);
                    break;
                case GMAIL:
                    isValid = validateGmail(input);
                    break;
                case DOB:
                    isValid = validateDateOfBirth(input);
                    break;
            }

            if (isValid) {
                break; 
            }
        }
        return input;
    }

    
    public enum ValidationType {
        NAME,
        GMAIL,
        DOB
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        String name = getValidInput(sc, "Enter Name: ", ValidationType.NAME);

        
        String gmail = getValidInput(sc, "Enter Gmail: ", ValidationType.GMAIL);

       
        String dob = getValidInput(sc, "Enter Date of Birth (DD/MM/YYYY): ", ValidationType.DOB);

        
        System.out.println("\nUser Profile Created Successfully!");
        System.out.println("Name: " + name);
        System.out.println("Gmail: " + gmail);
        System.out.println("Date of Birth: " + dob);

        sc.close();
    }
}
