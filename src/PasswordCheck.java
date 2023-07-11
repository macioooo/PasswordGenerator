public class PasswordCheck {
    private String pass;

    public PasswordCheck(String pass) {
        this.pass = pass;
    }

    public String checkPassword() {
        String output = "";//what is wrong with the password
        boolean capital = false;
        boolean lowerCase = false;
        boolean number = false;
        boolean specialChar = false;
        if (pass.length() < 8) {
            output += "•Your password is too short.\n"; //checking if password is too short
        }
        for (char c : pass.toCharArray()) { //for every character in password
            if (Character.isUpperCase(c)) {
                capital = true;// checking if there is uppercase
            } else if (Character.isLowerCase(c)) {
                lowerCase = true;// -''- lowercase
            } else if (Character.isDigit(c)) {
                number = true;// -''- digit
            } else if (!Character.isLetterOrDigit(c)) {
                specialChar = true; //-''- special char
            }
        }
        if (!capital) {
            output += "•Your password should contain capital letter \n";
        }
        if (!lowerCase) {
            output += "•Your password should contain lowercase letter \n";
        }
        if (!number) {
            output += "•Your password should contain number \n";
        }
        if (!specialChar) {
            output += "•Your password should contain special character \n";
        }
        return output.isEmpty() ? "Congratulations! Your password is safe." : output + "Your password is not safe.";
    }
}

