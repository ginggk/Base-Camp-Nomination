import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ExternalProgram {

    public static void main(String[] args) throws IOException {
        Nominator student = new Nominator();
        student.welcomeGreeting();
        System.out.println("\n****Nominee info****\n");
        Nominee nominee = new Nominee();
        nominee.creatingNominee();
        DateFormat df  = new SimpleDateFormat("EEE, MMM d yyyy h:mm aa");
        Date today = Calendar.getInstance().getTime();
        String reportDate = df.format(today);


        File textFile = new File("nomineeNames.txt");

        BufferedWriter nomineeName = new BufferedWriter(
                new FileWriter(textFile, true));
        nomineeName.write("Name of nominee: " + nominee.name + "\n");
        nomineeName.write("Date of nomination: " + reportDate);

        nomineeName.close();

        String file = nominee.name.toLowerCase().replace(" ", "_") + ".txt";

        if (file.matches(file)) {
            BufferedWriter out = new BufferedWriter(
                    new FileWriter(file));
            out.write("This is the Nominator's information\n");
            out.write("-------------------------------------------------\n");
            out.write(String.format("Name: %s", student.name + "\n"));
            out.write(String.format("Nominator's Email: %s", student.email + "\n"));
            out.write(String.format("Name of nominee: %s", student.nomineeName + "\n"));
            out.write(String.format("Senior in Hs: %s", student.isSenior + "\n"));
            out.write(String.format("Total days missed: %s", student.attendance + " days" + "\n"));
            out.write(String.format("Nominator's Phone Number: %s", student.phone + "\n"));
            out.write(String.format("Preferred method of contact: %s", student.contact + "\n"));
            out.write(String.format("Nominator's Current Position: %s", student.position + "\n"));
            out.write(String.format("Relationship to nominee:  %s", student.nomineeRelationship + "\n" + "\n"));

            out.write("This is the Nominee's information\n");
            out.write("-------------------------------------------------\n");
            out.write(String.format("Student name: %s", nominee.name + "\n"));
            out.write((String.format("Student email: %s", nominee.email + "\n")));
            out.write((String.format("High School: %s", nominee.hsGradFrom + "\n")));
            out.write((String.format("Distance to Drive: %s", nominee.distanceToDrive + " miles" + "\n")));
            out.write((String.format("Student Phone Number: %s", nominee.phone + "\n")));
            out.write((String.format("Preferred method of contact: %s", nominee.contact + "\n")));

            out.write("These are opinion questions about the Nominee: \n");
            out.write("--------------------------------------------------\n");
            out.write(String.format("Question one: %s", student.answerQ1 + "\n"));
            out.write(String.format("Question two: %s", student.answerQ2 + "\n"));
            out.write(String.format("Question three: %s", student.answerQ3 + "\n"));
            out.write(String.format("Question four: %s", student.answerQ4 + "\n"));


            out.close();
        }




    }
}
