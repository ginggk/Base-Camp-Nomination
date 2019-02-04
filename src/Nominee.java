import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Nominee {
    Scanner input = new Scanner(System.in);
    String isSenior;
    String hsGradFrom;
    String name;
    String email;
    ArrayList<NomineeInfo> nominees = new ArrayList<>();

    public void callingMethods() {
        isNomineeASenior();
        getEmail();
//        showNominee();
    }

    public void getName() {
        System.out.print("Full name: ");
        String nameInput = input.nextLine();
        name = nameInput;
    }

    public void getEmail() {
        while (true) {
            System.out.print("Email: ");
            String emailInput = input.nextLine();
            if (isEmailValid(emailInput)) {
                email = emailInput;
                break;
            }
            else {
                System.out.println("Sorry, invalid email");
            }
        }

    }

    public void getHS() {
        System.out.print("What high school is your nominee currently in? ");
        String hs = input.nextLine();
        hsGradFrom = hs;
        getName();

    }

    public void showNominee() {
        nominees.add(new NomineeInfo(name,email,isSenior, hsGradFrom));
        for (var nominee : nominees) {
            System.out.println(String.format("Name: %s", nominee.name));
            System.out.println(String.format("Email: %s", nominee.email));
            System.out.println(String.format("Senior in Hs: %s", nominee.isSenior));
            System.out.println(String.format("High School: %s", nominee.hsGradFrom));

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
        System.out.print("Is your nominee currently a senior? ");
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
