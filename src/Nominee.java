import java.util.Scanner;
import java.util.regex.Pattern;

public class Nominee {
    Scanner input = new Scanner(System.in);
    String isSenior;
    String hsGradFrom;

    public void callingMethods() {
        isNomineeASenior();
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

    public void getHS() {
        System.out.print("What high school are you currently in? ");
        String hs = input.nextLine();
        hsGradFrom = hs;
        getName();

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
                getHS();
                isSenior = "yes";
                break;



            } else {
                System.out.println("Sorry, you are currently not eligible.");
                isSenior = "no";
                System.exit(0);




            }
        }
    }
}
