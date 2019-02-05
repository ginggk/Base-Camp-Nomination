import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Nominee {
    Scanner input = new Scanner(System.in);
    String isSenior;
    String hsGradFrom;
    String name;
    String email;
    Double distanceToDrive;
    ArrayList<NomineeInfo> nominees = new ArrayList<>();
    String attendance;

    public void creatingNominee() {
        isNomineeASenior();
        getEmail();
        getAttendance();
        findDistance();

        showNominee();

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

    public void findDistance() {
        while (true) {
            System.out.print("Driving distance(miles)? ");
            double driveDis = input.nextDouble();
            if (driveDis > 150) {
                System.out.println("Might want to relocate closer.");
                distanceToDrive = driveDis;
                break;
            } else if (driveDis < 150){
                distanceToDrive = driveDis;
                break;
            } else {
                System.out.println("Please give a valid distance.");
                break;
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
        nominees.add(new NomineeInfo(name,email,isSenior, hsGradFrom, distanceToDrive, attendance));
        for (var nominee : nominees) {
            System.out.print("\n");
            System.out.println(String.format("Name: %s", nominee.name));
            System.out.println(String.format("Email: %s", nominee.email));
            System.out.println(String.format("Senior in Hs: %s", nominee.isSenior));
            System.out.println(String.format("High School: %s", nominee.hsGradFrom));
            System.out.println(String.format("Distance to Drive: %s miles", nominee.distanceToDrive));
            System.out.println(String.format("Attendance: %s", nominee.attendance));


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

    public void getAttendance() {
        System.out.print("What was your nominee's attendance for the current year? ");
        String nomineeAttendance = input.nextLine();


//        System.out.print("What was your nominee's attendance for the current year? ");
//        String nomineeAttendance = input.nextLine();

        attendance = nomineeAttendance;

    }

}
