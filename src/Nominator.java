import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Nominator {
    Scanner input = new Scanner(System.in);
    String isSenior;
    String name;
    String email;
    String phone;
    String attendance;
    String contact;
    String position;
    String nomineeRelationship;
    String nomineeName;
    String answerQ1;
    String answerQ2;
    String answerQ3;
    String answerQ4;



    public void creatingNominee() {
        isNomineeASenior();
        nomineesName();
        getPosition();
        getAttendance();
        getEmail();
        getPhone();
    }

    public void welcomeGreeting() {
        System.out.println("\n****2020 Base Camp Student nomination!****\n");
        System.out.println("\n--There are (12) questions in total--");
        System.out.println("\t-(8) are questions to gather information.");
        System.out.println("\t-(4) are personal opinion questions about your nominee.\n");
        creatingNominee();

    }

    public boolean isValidStrings(String s) {
        String n = "[a-zA-Z]+$";
        Pattern pattern = Pattern.compile(n);
        return pattern.matcher(s).matches();




    }

    public void getName() {
        System.out.print("(2.) Nominator's full name: ");
        while (true) {
            String nameInput = input.nextLine();
            if (isValidStrings(nameInput)) {
                name = nameInput;
                break;
            }
            else {
                System.out.println("Insert your real name! ");
            }

        }

    }

    public void getEmail() {
        while (true) {
            System.out.println("\nExample email: santhony@basecampcodingacademy.org\n");
            System.out.print("(7.) Nominator's email: ");
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



    public void getPhone() {
        while (true) {
            System.out.print("(8.) Nominator's Phone Number: ");
            String phoneInput = input.nextLine();



            try {
                if (isPhoneValid(phoneInput)) {
                    phone = String.valueOf(phoneInput).replaceAll("(\\d{3})(\\d{3})(\\d{4})", "($1)-$2-$3");
                    break;
                } else if (phoneInput instanceof String) {
                    System.out.println("Sorry, invalid phone number");
                }
                else {
                    System.out.print("Sorry, invalid phone number");
                }
            } catch (NumberFormatException nfe) {
                nfe.printStackTrace();

            }


        }
        getContact();

    }

    public boolean isPhoneValid(String phone) {
        String phoneReg = "\\d{10}";


        Pattern p = Pattern.compile(phoneReg);
        return p.matcher(phone).matches();
    }


    public void nomineesName() {
        System.out.print("(3.) What is your nominee's name? ");
        while (true) {
            String nomName = input.nextLine();
            if (isValidStrings(nomName)) {
                nomineeName = nomName;
                break;
            }
            else {
                System.out.println("Insert a valid name!");
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
        System.out.print("(1.) Is your nominee currently a senior? [Y]es or [N]o ");
        while (true) {
            String senior = input.nextLine();
            if (senior.toLowerCase().equals("y") | senior.equals("yes")) {
//                getHS();
                isSenior = "yes";

                break;



            } else if (senior.toLowerCase().equals("n") | senior.equals("no")) {
                System.out.println("I'm sorry! They have to be a current senior!");
                isSenior = "no";
                System.exit(0);
            } else {
                System.out.println("Please Say [Y] or [N]!");
            }
        }
        getName();
    }

    public void getAttendance() {
        System.out.print("(5.) How many days has your nominee been absent from school? ");
        while (true) {
            String nomineeAttendance = input.nextLine();
            if (nomineeAttendance.matches("\\d+")) {
                attendance = nomineeAttendance;
                relationshipToNominee();
                break;

            }
            else {
                System.out.println("Insert valid numbers of days missed! ");
            }



        }


    }

    public void getContact() {
        System.out.print("(9.) How would you prefer to be contacted? ([C]all, [T]ext or [E]mail) ");
        while (true) {

            String contactMethod = input.next();

            if (contactMethod.toLowerCase().equals("c")) {
                contact = "Call";
                break;
            } else if (contactMethod.toLowerCase().equals("t")) {
                contact = "Text";
                break;
            } else if (contactMethod.toLowerCase().equals("e")){
                contact = "Email";
                break;
            } else {
                System.out.println("Please Say [C], [T], or [E].");
            }
        }



        System.out.println("\nThese are opinion questions about the Nominee: ");
        System.out.println("_______________________________________________");
        opinionQuestions();
    }

    public void getPosition() {
        System.out.print("(4.) Your current position: ");
        while (true) {
            String positionChoice = input.nextLine();
            if (isValidStrings(positionChoice)) {
                position = positionChoice;
                break;
            }
            else {
                System.out.println("Insert your postion!");
            }
        }





    }

    public void opinionQuestions() {
        question1();
        question2();
        question3();
        question4();
    }

    public void relationshipToNominee() {
        System.out.print("(6.) What is your relationship to your nominee? ");
        while (true) {
            String relationship = input.nextLine();
            if (isValidStrings(relationship)) {
                nomineeRelationship = relationship;
                break;
            }
            else {
                System.out.println("Insert your relationship!");
            }
        }



    }

    public void question2() {
        Scanner inputQuestion2 = new Scanner(System.in);
        System.out.println("\n(2.) Perseverance: Is there any evidence of the applicant being engaged" +
                "\n in something they are passionate about? ");
        while (true) {
            String opinionQ2 = inputQuestion2.nextLine();
            if (isValidStrings(opinionQ2)) {
                answerQ2 = opinionQ2;
                break;
            }
            else {
                System.out.println("Go ahead and answer the question!");
            }
        }




    }
    public void question3() {
        Scanner inputQuestion3 = new Scanner(System.in);
        System.out.println("\n(3.) Dedication: Do you think the applicant would be able to reliably attend\n the program five days a week in Water Valley? ");
        while (true) {
            String opinionQ3 = inputQuestion3.nextLine();
            if (isValidStrings(opinionQ3)) {
                answerQ3 = opinionQ3;
                break;
            }
            else {
                System.out.println("Go ahead and answer the question!");
            }
        }

    }

    public void question4() {
        Scanner inputQuestion4 = new Scanner(System.in);
        System.out.println("\n(4.) Work Ethic / Heart: Why does this student deserve a position at Base Camp? ");
        while (true) {
            String opinionQ4 = inputQuestion4.nextLine();
            if (isValidStrings(opinionQ4)) {
                answerQ4 = opinionQ4;
                break;
            }
            else {
                System.out.println("Go ahead and answer the question!");
            }
        }

    }

    public void question1() {
        Scanner inputQuestion1 = new Scanner(System.in);

        System.out.println("\n(1.) Aptitude: Do you have any experiences when this student has demonstrated a strong ability\n to think logically and/or strategically? ");
        while (true) {
            String opinionQ1 = inputQuestion1.nextLine();
            if (isValidStrings(opinionQ1)) {
                answerQ1 = opinionQ1;
                break;
            }
            else {
                System.out.println("Go ahead and answer the question!");
            }
        }

    }



}
