import java.io.*;
/**
 * The class JobsIO provides a command line user interface which can run outside BlueJ
 * 
 * @author Natallia Akulenka
 * @version 12/01/2014
 */
public class JobsIO
{
    // assigns an object of class Branch to the Manager man variable
    private Manager man = new Branch("Watford");

    // the main method
    public static void main(String[] args)
    {
        new JobsIO().run();
    }

    private void run()
    {
        // add all staff
        addStaff();

        while (true)
        {
            System.out.print ("\n1. add job" + '\n' +
                "2. job done" + '\n' +
                "3. list jobs waiting" + '\n' +
                "4. quit" + '\n' +
                "Select the option of your choice : ");

            String userInput = inputReader();
            // convert string to int
            int userInputInt = Integer.parseInt(userInput);

            // add a job
            if (userInputInt==1)
            {
                System.out.print ("Write the customer name: ");
                String custNameInput = inputReader();

                System.out.print ("Shoud the job be done on customer's site?: Y/N ");
                String onSiteInput = inputReader();
                boolean onSiteInputBool = Boolean.parseBoolean(onSiteInput);

                System.out.print ("Is shorthand required?: Y/N ");
                String sHandInput = inputReader();
                boolean sHandInputBool = Boolean.parseBoolean(sHandInput);

                System.out.print ("Which language?: ");
                String langInput = inputReader();

                man.addJob(custNameInput,onSiteInputBool,sHandInputBool,langInput);
            }
            // job done
            else if (userInputInt==2)
            {
                System.out.print ("Write the job number: ");
                String jNoInput = inputReader();
                int jNoInputInt = Integer.parseInt(jNoInput);

                System.out.print ("Number of hours taken to do the job: ");
                String hoursInput = inputReader();
                int hoursInputInt = Integer.parseInt(hoursInput);

                man.setJobDone(jNoInputInt, hoursInputInt);
            }
            // list jobs waiting
            else if (userInputInt==3)
            {
                System.out.println(man.getJobsWaiting());
            }
            // quit
            else if (userInputInt==4)
            {
                return;
            }
            // invalid input
            else
            {
                System.out.println("Invalid input! Select 1-4");
            }
        }
    }

    private String inputReader()
    {
        //  open up the standard input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //  read the user input from the command-line
        String userInput = null;
        try {
            userInput = br.readLine();
        } catch (IOException ioe) {
            System.out.println("IO error!");
        }
        return userInput;
    }

    private void addStaff()
    {
        // add a clerk
        man.addStaff("CL1", "Ann");
        man.addStaff("CL2", "Bob");
        // add a typist
        man.addStaff("TY1", "Che", false, true);
        man.addStaff("TY2", "Dan", false, false);
        man.addStaff("TY3", "Eve", true, true);
        man.addStaff("TY4", "Fez", true, false);
        // add a translator
        man.addStaff("TR1", "Gil", false, true, "French", 50.00);
        man.addStaff("TR2", "Han", false, false, "French", 50.00);
        man.addStaff("TR3", "Kit", true, true, "German", 60.00);
        man.addStaff("TR4", "Lil", true, false, "German", 60.00);
    }
}
