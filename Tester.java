import java.util.*;
/**
 * Class Tester tests the impementation of the Branch methods.
 * 
 * 
 * @author Natallia Akulenka 
 * @version 12/01/2014
 */
public class Tester
{
public static void main (String[] args)
{
        new Tester().run();
    }

    private void run()
    {
        // clear the terminal window
        System.out.print('\u000C');

        // assigns an object of class Branch to the Manager variable test1/test2
        Manager test1 = new Branch("Watford");
        Manager test2 = new Branch("Minsk");

        /** 
         * Test 1. Get the location of the branch
         */
        System.out.println('\n' + "----Test 1.Get the location of the branch.----" + '\n');
        System.out.println ("Expected: Watford. Received: " + test1.getBranch() + '\n');

        /** 
         * Test 2. Add a staff member (clerk, typist, translator) to the branch
         */
        System.out.println('\n' + "----Test 2. Add a staff member to the branch (clerk, typist, translator).----" + '\n');

        // add a clerk
        test1.addStaff("CL1", "Ann");
        test1.addStaff("CL2", "Bob");
        // add a typist
        test1.addStaff("TY1", "Che", false, true);
        test1.addStaff("TY2", "Dan", false, false);
        test1.addStaff("TY3", "Eve", true, true);
        test1.addStaff("TY4", "Fez", true, false);
        // add a translator
        test1.addStaff("TR1", "Gil", false, true, "French", 50.00);
        test1.addStaff("TR2", "Han", false, false, "French", 50.00);
        test1.addStaff("TR3", "Kit", true, true, "German", 60.00);
        test1.addStaff("TR4", "Lil", true, false, "German", 60.00);

        System.out.println(test1.getAllStaff());

        /** 
         * Test 3. Set email for a typist 
         */

        System.out.println("----Test 3. Set email for a typist.----" + '\n');

        test1.setEmail("TY1", "che@watford.com");
        test1.setEmail("TY2", "dan@watford.com");
        test1.setEmail("TY3", "eve@watford.com");
        test1.setEmail("TY4", "fez@watford.com");
        System.out.println(test1.getAllStaff());

        /** 
         * Test 4. Checks if the staff with the staff identifier can be found in the system 
         */

        System.out.println("----Test 4. Checks if the staff with the staff identifier can be found in the system. ----" + '\n');

        System.out.println("Expected true. Returned " + test1.isStaff("TY1") + '\n');
        System.out.println("Expected true. Returned " + test1.isStaff("CL2") + '\n');
        System.out.println("Expected true. Returned " + test1.isStaff("TR3") + '\n');
        System.out.println("Giving a non-existing id of the staff member. Expected false. Returned " + test1.isStaff("TY10") + '\n');

        /** 
         * Test 5. Remove a staff member from the branch
         */

        System.out.println('\n' + "----Test 5. Remove a staff member from the branch.----" + '\n');

        test1.removeStaff("TY2");
        test1.removeStaff("TR1");
        test1.removeStaff("TR17");
        System.out.println("The staff members with the id TY2, TR1 should be removed from the branch.");
        System.out.println("Trying to remove a non-existing staff member with the id TR17 causes no action." + '\n');
        System.out.println(test1.getAllStaff());

        /** 
         * Test 6. Add a job to the branch
         */

        System.out.println("----Test 6. Add a job to the branch.----" + '\n');

        System.out.println("Expect to receive: 'Staff allocated...'. Received: " + 
            test1.addJob("Anna", true, true, "German"));

        System.out.println("Expect to receive: 'Staff allocated...'. Received: " + 
            test1.addJob("Tom", true, false, "English"));

        System.out.println("Expect to receive: 'Staff allocated...'. Received: " + 
            test1.addJob("Bill", false, false, "French"));

        System.out.println("Expect to receive: 'Job waiting...'. Received: " + 
            test1.addJob("Georg", false, false, "French"));

        /** 
         * Test 7. Get all customers
         */
        System.out.println('\n' + "----Test 7. Get all customers.----" + '\n');
        System.out.println(test1.getAllCustomers());

        /** 
         * Test 8. Get all jobs which are still waiting to be done
         */
        System.out.println("----Test 8. Get all jobs which are still waiting to be done.----" + '\n');
        System.out.println(test1.getJobsWaiting());

        /** 
         * Test 9a. Set job done and calculate job cost
         */
        System.out.println("----Test 9a. Set job done and calculate job cost.----" + '\n');
        test1.setJobDone(101,2);
        test1.setJobDone(102,3);
        test1.setJobDone(109,40);

        System.out.println("Cost for job no. 101. Expected 24.0. Received: " + test1.getJobCost(101) + '\n' +
            "Cost for job no. 102. Expected 150.0. Received: " + test1.getJobCost(102) + '\n' +
            "Trying to set non-existing job 109 done. Expected to receive -1.0. Received: " + test1.getJobCost(109) + '\n');

        System.out.println(test1.getAllJobs());

        /** 
         * Test 9b. Try adding a job for a customer with balance over the credit limit
         */
        System.out.println("----Test 9b. Try adding a job for a customer with balance over the credit limit.----" + '\n');
        System.out.println("Expect to receive: 'Customer over credit limit' message.");
        System.out.println("Received: " + test1.addJob("Bill", false, false, "French") + '\n');

        /** 
         * Test 9c. Get job cost
         */
        System.out.println("----9c. Get job cost.----" + '\n');
        System.out.println("Job cost for existing job. Expected to receive job cost for the job 101. Received: " + test1.getJobCost(101));
        System.out.println("Job cost for waiting job. Expected to receive 0.0. Received: " + test1.getJobCost(103));
        System.out.println("Job cost for non-existing job. Expected to receive -1.0. Received: " + test1.getJobCost(109) + '\n');        

        /** 
         * Test 10. Check the list of jobs and return the job number of the first
         * job for which a staff member is now available
         */
        System.out.println("----Test 10. Check the list of jobs and return the job number of the----");
        System.out.println("first job for which a staff member is now available.----" + '\n');
        System.out.println("Expected job number 103. Returned job number: " + test1.checkJobsWaiting() + '\n');

        /** 
         * Test 11. Return details about the branch, including
         * its location and all its staff,customers and jobs
         */
        System.out.println('\n' + "----Test 11. Return details about the branch, including----");
        System.out.println("its location and all its staff,customers and jobs.----" + '\n');
        System.out.println(test1.toString());

        /** 
         * Test 12. Create a new branch and check that methods work with an empty branch
         */
        System.out.println("----Test 12. Create a new branch and check that methods work with an empty branch.----" + '\n');
        System.out.println("branch toString method: " + test2.toString());
        System.out.println("checkJobsWaiting method. Expected -1. Received: " + test2.checkJobsWaiting());
   }
}