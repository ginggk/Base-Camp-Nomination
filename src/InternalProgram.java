import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class InternalProgram {


    public static void main(String[] args) throws IOException {

//        Nominee nominee = new Nominee();





        File fileNomName = new File("nomineeNames.txt");

        BufferedReader nameNom = new BufferedReader(new FileReader(fileNomName));


        String stName;
        while ((stName = nameNom.readLine()) != null) System.out.println(stName);

        System.out.print("What nominee would you like to see? ");


        Scanner input = new Scanner(System.in);



        while (input.hasNext()) {

            try {
                String name = input.nextLine();

                String fileName = name.toLowerCase();

                File file = new File(fileName.replace(" ", "_") + ".txt");

                BufferedReader br = new BufferedReader(new FileReader(file));


                String st;
                while ((st = br.readLine()) != null) System.out.println(st);
                break;
            } catch (FileNotFoundException ex) {
                System.out.println("The person you are trying to see is not currently nominated, please try again later.");
            }

        }


  }
}
