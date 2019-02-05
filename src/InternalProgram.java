import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class InternalProgram {

    public static void main(String[] args) throws IOException {

        Nominee nominee = new Nominee();

        Scanner input = new Scanner(System.in);

        System.out.println("What nominee would you like to see? ");



        while (input.hasNext()) {

            try {
                String name = input.next();

                String fileName = name.toLowerCase();

                String file = fileName.replace(" ", "_") + ".txt";

                BufferedReader br = new BufferedReader(new FileReader(file));

                String st;
                while ((st = br.readLine()) != null) System.out.println(st);
                break;
            } catch (FileNotFoundException ex) {
                System.out.println("There has been a problem.");
            }

        }


  }
}
