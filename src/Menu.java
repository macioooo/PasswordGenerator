import java.util.Scanner;

public class Menu {
    public boolean start;

    public Menu() {
        start = true;
    }

    public void runMenu() {
        while (start) {
            displayOptions();
            String choice = getUserChoice();
            handleChoice(choice);
            startAgain();
        }
    }

    private void displayOptions() {
        System.out.println("Hi, this program is built to help you with creating a safe password.");
        System.out.println("If you want to check your password, type 'check'.");
        System.out.println("If you want the program to generate a password for you, type 'generate'.");
    }

    private String getUserChoice() {
        Scanner choose = new Scanner(System.in);
        return choose.nextLine().toLowerCase();
    }

    private void handleChoice(String choice) {
        if (choice.equals("check") || choice.equals("generate")) {
            System.out.println("You chose " + choice);
            if (choice.toLowerCase().equals("check")) {
                System.out.println("Type your password");
                Scanner scanner = new Scanner(System.in);
                String pass = scanner.nextLine();
                PasswordCheck passwordcheck = new PasswordCheck(pass);
                String result = passwordcheck.checkPassword();
                System.out.println(result);
            } else if (choice.toLowerCase().equals("generate")) {
                PasswordGenerator passwordgenerator = new PasswordGenerator();
                String yournewpassword = passwordgenerator.generatePassword();
                System.out.println("Your new password is: " + yournewpassword);
            }
        } else {
            System.out.println("Sorry, that's not an option");
        }
    }

    private void startAgain() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to start again? Yes/No");
        String option = scanner.nextLine();
        if (option.toLowerCase().equals("no")) {
            start = false;
            System.out.println("Okay, byee");
        } else {
            System.out.println("It was not an option, but i will take it as a yes");
        }

    }
}