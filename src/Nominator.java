import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Nominator {
    Scanner input = new Scanner(System.in);
    String isSenior;
    String hsGradFrom;
    String name;
    String email;
    Double distanceToDrive;
    String phone;
    ArrayList<NominatorInfo> nominees = new ArrayList<>();
    ArrayList<NominatorQuestions> questions = new ArrayList<>();
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
//        isNomineeASenior();
//        nomineesName();
//        getPosition();
//        getAttendance();
//        getEmail();
        getPhone();
//        showNominee();
    }

    public void welcomeGreeting() {
        System.out.println("\n****2020 Base Camp Student nomination!****\n");
        System.out.println("Total of 4 questions to answer.");
        creatingNominee();

    }

    public void getName() {
        System.out.print("Nominator's full name: ");
        String nameInput = input.nextLine();
        name = nameInput;
    }

    public void getEmail() {
        while (true) {
            System.out.println("\nExample email: santhony@basecampcodingacademy.org\n");
            System.out.print("Nominator's email: ");
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
            System.out.print("Nominator's Phone Number: ");
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

//    public void questions() {
//
//    }
//
//    public void showAnswers() {
//        questions.add(new NominatorQuestions(questionNumber, answer));
//        for (var question : questions) {
//            System.out.print("\n");
//            System.out.println(String.format("Name: %s", nominee.name));
//            System.out.println(String.format("Nominator's Email: %s", nominee.email));
//        }
//    }

//    public void showNominee() {
//        nominees.add(new NominatorInfo(name,email,isSenior, hsGradFrom, distanceToDrive, attendance, phone, contact, position, nomineeRelationship, nomineeName));
//        for (var nominee : nominees) {
//            System.out.print("\n");
//            System.out.println(String.format("Name: %s", nominee.name));
//            System.out.println(String.format("Nominator's Email: %s", nominee.email));
//            System.out.println(String.format("Name of nominee: %s", nominee.nomineeName));
//            System.out.println(String.format("Senior in Hs: %s", nominee.isSenior));
//            System.out.println(String.format("Total days missed: %s days", nominee.attendance));
//            System.out.println(String.format("Nominator's Phone Number: %s", nominee.number));
//            System.out.println(String.format("Preferred method of contact: %s", nominee.contactMethod));
//            System.out.println(String.format("Nominator's Current Position: %s", nominee.position));
//            System.out.println(String.format("Relationship to nominee:  %s", nominee.relationship));
//        }
//    }

    public void nomineesName() {
        System.out.print("What is your nominee's name? ");
        String nomName = input.nextLine();
        nomineeName = nomName;

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
            if (senior.toLowerCase().equals("yes")) {
//                getHS();
                isSenior = "yes";

                break;



            } else {
                System.out.println("Sorry, you are currently not eligible.");
                isSenior = "no";
                System.exit(0);




            }
        }
        getName();
    }

    public void getAttendance() {
        System.out.print("How many days has your nominee been absent? ");
        String nomineeAttendance = input.nextLine();


        attendance = nomineeAttendance;
        relationshipToNominee();

    }

    public void getContact() {
        System.out.print("How would you prefer to be contacted? ([1]Call, [2]Text or [3]Email) ");
        Integer contactMethod = input.nextInt();

        if (contactMethod.equals(1)) {
            contact = "Call";
        } else if (contactMethod.equals(2)) {
            contact = "Text";
        } else {
            contact = "Email";
        }
        opinionQuestions();


    }

    public void getPosition() {
        System.out.print("Your current position: ");
        String positionChoice = input.nextLine();

        position = positionChoice;


    }

    public void opinionQuestions() {
        question1();
        question2();
        question3();
        question4();
    }

    public void relationshipToNominee() {
        System.out.println("What is your relationship to your nominee? ");
        String relationship = input.nextLine();

        nomineeRelationship = relationship;
    }

    public void question2() {
        Scanner inputQuestion2 = new Scanner(System.in);
        System.out.println("\nPerseverance: Is there any evidence of the applicant being engaged" +
                "\n in something they are passionate about? ");
        String opinionQ2 = inputQuestion2.nextLine();
        answerQ2 = opinionQ2;

    }
    public void question3() {
        Scanner inputQuestion3 = new Scanner(System.in);
        System.out.println("\nDedication: Do you think the applicant would be able to reliably attend\n the program five days a week in Water Valley? ");
        String opinionQ3 = inputQuestion3.nextLine();
        answerQ3 = opinionQ3;
    }

    public void question4() {
        Scanner inputQuestion4 = new Scanner(System.in);
        System.out.println("\nWork Ethic / Heart: Why does this student deserve a position at Base Camp? ");
        String opinionQ4 = inputQuestion4.nextLine();
        answerQ4 = opinionQ4;
    }

    public void question1() {
        Scanner inputQuestion1 = new Scanner(System.in);

        System.out.println("\nAptitude: Do you have any experiences when this student has demonstrated a strong ability\n to think logically and/or strategically? ");
        String opinionQ1 = inputQuestion1.nextLine();
        answerQ1 = opinionQ1;
    }



}
