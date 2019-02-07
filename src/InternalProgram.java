import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InternalProgram {


    public static void welcome() {
        System.out.println("\n---Welcome to the Internal Side of Base Camp's nomination process---");
    }


    public static void main(String[] args) throws IOException {

//        Nominee nominee = new Nominee();


        welcome();


        File fileNomName = new File("nomineeNames.txt");

        BufferedReader nameNom = new BufferedReader(new FileReader(fileNomName));


        String stName;
        while ((stName = nameNom.readLine()) != null) {
            System.out.println(stName);

        }




        System.out.print("What nominee would you like to see? ");


        Scanner input = new Scanner(System.in);



        while (input.hasNext()) {

            try {

                String name = input.nextLine();
                String fileName = name.toLowerCase();
                File file = new File(fileName.replace(" ", "_") + ".txt");
                BufferedReader br = new BufferedReader(new FileReader(file));
                String st;
                while ((st = br.readLine()) !=null) System.out.println(st);

                System.out.println("---------------------------------------------------------");
                System.out.print("Would you like to to set up an interview with " + name + "? \n ([1] for yes, [2] for no) ");
                String email = Files.readAllLines(Paths.get(String.valueOf(file))).get(15);
                while (true) {
                    String interview = input.next();
                    if (interview.equals("1") && interview.matches("\\d+")) {
                        System.out.println("\n-----------------------------------------------------------\n");
                        System.out.println("Great! A default email will be sent to " + name + "'s " + email.replace("Student ", ""));

                        System.exit(0);
                        break;
                    } else if (interview.equals("2") && interview.matches("\\d+")) {
                        System.out.println("-----------------------------------------");
                        System.out.println("Thanks for using our program!!");
                        System.exit(0);
                        break;
                    } else {
                        System.out.println("Please say 1 or 2");
                    }
                }
            } catch (FileNotFoundException ex) {
                System.out.println("The person you are trying to see is not currently nominated, please try again later.");
            }

        }




  }
}
