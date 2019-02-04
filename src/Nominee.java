import java.util.Scanner;
import java.util.regex.Pattern;

public class Nominee {
    Scanner input = new Scanner(System.in);
    String isSenior;

    public void callingMethods() {
        isNomineeASenior();
        getName();
        getEmail();
    }

    public String getName() {
        System.out.print("Full name: ");
        String name = input.nextLine();
        return name;
    }

    public String getEmail() {
        while (true) {
            System.out.print("Email: ");
            String email = input.nextLine();
            if (isEmailValid(email)) {
                return email;
            }
            else {
                System.out.println("Sorry, invalid email");
            }
        }

    }

    public boolean isEmailValid(String email) {
        String emailReg = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern p = Pattern.compile(emailReg);
        return p.matcher(email).matches();
    }

    public void isNomineeASenior() {
        System.out.println("Is your nominee currently a senior? ");
        String senior = input.nextLine();
        while (true) {
            if (senior.equals("yes")) {
                isSenior = "yes";


            } else {
                System.out.println("Sorry, you are currently not eligible.");
                isSenior = "no";
                System.exit(0);




            }
        }
    }
}
