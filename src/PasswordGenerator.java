import java.util.Random;

public class PasswordGenerator {
    //all the symbols, letters and numbers available
    private static final String lowercase = "abcdefghijklmnopqrstuvwxyz";
    private static final String uppercase = "ABCDEFGJKLMNPRSTUVWXYZ";
    private static final String symbols = "^$?!@#%&";
    private static final String numbers = "0123456789";

    public static String generatePassword() {
        Random random = new Random();//random amount of signs from 8-14;
        int amount = random.nextInt(14) + 8;
        String generatedpassword = "";
        boolean haslowercase = false;
        boolean hasuppercase = false;
        boolean hassymbol = false;
        boolean hasnumber = false;
        for (int i = 0; i < amount; i++) {
            int randomletter = (int) (4 * Math.random());     //random case generator
            switch (randomletter) {                          //adding sign to the string
                case 0:
                    randomletter = random.nextInt(lowercase.length());
                    generatedpassword += lowercase.charAt(randomletter);
                    haslowercase = true;
                    break;
                case 1:
                    randomletter = random.nextInt(numbers.length());
                    generatedpassword += numbers.charAt(randomletter);
                    hasnumber = true;
                    break;
                case 2:
                    randomletter = random.nextInt(uppercase.length());
                    generatedpassword += uppercase.charAt(randomletter);
                    hasuppercase = true;
                    break;
                case 3:
                    randomletter = random.nextInt(symbols.length());
                    generatedpassword += symbols.charAt(randomletter);
                    hassymbol = true;
                    break;
            }
            boolean allCasesUsed = haslowercase && hasuppercase && hasnumber && hassymbol;
            if (!allCasesUsed && i == amount - 1) {               //checking if there were all cases used in generating password
                if (!haslowercase) {
                    generatedpassword += lowercase.charAt(random.nextInt(lowercase.length()));
                }
                if (!hasnumber) {
                    generatedpassword += numbers.charAt(random.nextInt(numbers.length()));
                }
                if (!hassymbol) {
                    generatedpassword += symbols.charAt(random.nextInt(symbols.length()));
                    ;
                }
                if (!hasuppercase) {
                    generatedpassword += uppercase.charAt(random.nextInt(uppercase.length()));
                }
            }

        }
        return generatedpassword;
    }
}
