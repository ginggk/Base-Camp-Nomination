import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Nominee {
        Scanner input = new Scanner(System.in);
        String hsGradFrom;
        String name;
        String email;
        Double distanceToDrive;
        String phone;
        ArrayList<NomineeInformation> nominees = new ArrayList<>();
        String contact;
        String position;


        public void creatingNominee() {
            getHS();
            getEmail();
            getPhone();
            findDistance();
//            showNominee();

        }


        public void getName() {
            System.out.print("(2.) Nominee's full name: ");
            String nameInput = input.nextLine();
            name = nameInput;

        }

        public void getEmail() {
            while (true) {
                System.out.println("\nExample email: dannyp123@gmail.com\n");
                System.out.print("(3.) Nominee's email: ");

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
                System.out.print("(4.) Nominee's Phone Number: ");
                Long phoneInput = input.nextLong();



                try {
                    if (isPhoneValid(phoneInput)) {
                        phone = String.valueOf(phoneInput).replaceAll("(\\d{3})(\\d{3})(\\d{4})", "($1)-$2-$3");
                        break;
                    } else {
                        System.out.print("Sorry, invalid phone number");
                    }
                } catch (NumberFormatException nfe) {
                    nfe.printStackTrace();

                }


            }
            getContact();

        }

        public boolean isPhoneValid(long phone) {
            String phoneReg = "\\d{10}";


            String  result = Long.toString(phone);
            Pattern p = Pattern.compile(phoneReg);
            return p.matcher(result).matches();
        }

        public void findDistance() {

            while (true) {
                System.out.print("(6.) Driving distance(miles)? ");
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
            System.out.print("(1.) What high school are you currently in? ");
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


        public void getContact() {
            System.out.print("(5.) How would you prefer to be contacted? ([1]Call, [2]Text or [3]Email) ");
            Integer contactMethod = input.nextInt();

            if (contactMethod.equals(1)) {
                contact = "Call";
            } else if (contactMethod.equals(2)) {
                contact = "Text";
            } else {
                contact = "Email";
            }


        }

        public void getPosition() {
            System.out.print("Your current position: ");
            String positionChoice = input.nextLine();

            position = positionChoice;


        }



}

