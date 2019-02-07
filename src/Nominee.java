import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Nominee {
        Scanner input = new Scanner(System.in);
        String hsGradFrom;
        String name;
        String email;
        String distanceToDrive;
        String phone;
        ArrayList<NomineeInformation> nominees = new ArrayList<>();
        String contact;
        String position;


        public void creatingNominee() {
            getHS();
            getEmail();
            getPhone();
            findDistance();

        }


    public boolean isValidStrings(String s) {
        String n = "[a-zA-Z]+$";
        Pattern pattern = Pattern.compile(n);
        return pattern.matcher(s).matches();




    }

        public void getName() {
            System.out.print("(2.) Nominee's full name: ");
            while (true) {
                String nameInput = input.nextLine();
                if (isValidStrings(nameInput)) {
                    name = nameInput;
                    break;
                }
                else {
                    System.out.println("Insert your real name!");
                }
            }



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
            System.out.print("(6.) Driving distance(miles)? ");

            while (true) {
                String driveDis = input.next();
                if (driveDis.matches("\\d+")) {
                    distanceToDrive = driveDis;
                    break;
                } else {
                    System.out.println("Please provide a valid distance.");

                }




            }
        }

        public void getHS() {
            System.out.print("(1.) What high school are you currently in? ");
            while (true) {
                String hs = input.nextLine();
                if (isValidStrings(hs)) {
                    hsGradFrom = hs;
                    getName();
                    break;
                }
                else {
                    System.out.println("Insert your high School!");
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


    public void getContact() {

        while (true) {
            System.out.print("(5.) How would you prefer to be contacted? ([C]all, [T]ext or [E]mail) ");
            String contactMethod = input.next();

            if (contactMethod.toLowerCase().equals("c")) {
                contact = "Call";
                break;
            } else if (contactMethod.toLowerCase().equals("t")) {
                contact = "Text";
                break;
            } else if (contactMethod.toLowerCase().equals("e")) {
                contact = "Email";
                break;
            } else {
                System.out.println("Please Say [C], [T], or [E].");
            }
        }


    }

        public void getPosition() {
            while (true) {
                System.out.print("Your current position: ");
                String positionChoice = input.nextLine();
                if (isValidStrings(positionChoice)) {
                    position = positionChoice;
                    break;
                }
                else {
                    System.out.println("Insert your position!");
                }


            }



        }



}

