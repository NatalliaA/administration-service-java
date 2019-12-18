import java.util.*;
import java.io.*;
/**
 * This class implements the behaviour expected from the RATS
 * system required for Coursework 2013/14
 * The Reliable Administration and Translation Service (RATS) provide staff
 * to perform office and translation jobs for clients. 
 * Branches at different locations e.g. Watford, are responsible for
 * accepting jobs from clients, maintaining information about jobs and
 * maintaining information about staff, including wages.
 * 
 * @author Natallia Akulenka
 * @version 12/01/2014
 */
public class Branch implements Manager
{
    // the location of the branch
    private String location;

    private HashMap<String, Staff> staff = new  HashMap<String, Staff>();
    private HashMap<String, Customer> customers = new HashMap<String, Customer>();
    private HashMap<Integer, Job> jobs = new HashMap<Integer, Job>();

    /**
     * Constructor of the class Branch
     * @param location represents the location of the branch
     */
    public Branch (String location)
    {
        this.location = location; 
    }

    /**Returns the location of the branch as a String
     * @return the location of the branch as a String
     **/ 
    public String getBranch()
    {
        return location;
    }

    /**Returns a String representation of the branch,including
     * its location and all its staff,customers and jobs
     * @return a String representation of the branch,including
     * its location and all its staff,customers and jobs
     **/
    public String toString()
    {
        return('\n' + "LOCATION: " + location + '\n' + '\n'+
            "STAFF: " + '\n' + '\n' +  getAllStaff() + '\n' + 
            "CUSTOMERS: " + '\n' + '\n' + getAllCustomers() + '\n' +
            "JOBS: " + '\n' + '\n' + getAllJobs() + '\n');
    }

    /**Returns a String representation of customers who have used the 
     * branch's services
     * @return a String representation of the customers who have used 
     * the branch's services 
     **/
    public String getAllCustomers()
    {
        String list = "";
        if (customers != null)
        {
            Collection<Customer> custValues = customers.values();
            Iterator<Customer> iter = custValues.iterator();
            while (iter.hasNext())
            {
                Customer custom = iter.next();
                if (custom != null)
                {
                    list += custom.toString() + '\n';
                }
            }
        }
        return list;
    }

    // ***************** Staff ************************   
    /** Allows a clerk to be added to the branch.The clerk's availability
     *  is set to "available"
     * @param id represents the employee code of the staff e.g TY333
     * @param name is the staff member's name 
     **/        
    public void addStaff(String id, String name)
    {
        Clerk newClerk = new Clerk(id, name);
        staff.put(id, newClerk);
    }

    /**Allows a typist to be added to a branch.The typist's availability
     *  is set to "available".Staff must specify if they can only work at 
     *  home.If false, then staff can work on site or at home if required
     * @param id represents the employee code of the staff e.g TY333
     * @param name is the staff member's name 
     * @param hOnly true if a member of staff can only work at home,
     * fals if they can only work at home
     * @param sHand true if a member of staff can offer shorthand
     **/       
    public void addStaff(String id, String name, boolean hOnly, 
    boolean sHand)
    {
        Typist newTypist = new Typist(id, name, hOnly, sHand);
        staff.put(id, newTypist);
    }

    /** Allows a translator to be added to the branch.The translator's 
     *  availability is set to "available".Staff must specify if they 
     *  can only work at home.If false, then staff can work on site or 
     *  at home if required.
     * @param id represents the employee code of the staff e.g TY333
     * @param name is the staff member's name 
     * @param hOnly true if a member of staff can work on site, false 
     * if they can only work at home
     * @param sHand true if a member of staff can offer shorthand
     * @param lang is the language which the staff member can translate
     * @param rate is the hourly rate
     **/   
    public void addStaff(String id, String name, boolean hOnly, 
    boolean sHand, String lang, double rate)
    {
        Translator newTranslator = new Translator(id, name, hOnly, sHand, lang, rate);
        staff.put(id, newTranslator);
    }

    /** Sets email for a typist
     * @param id represents the staff id
     * @param email is the email address
     */ 
    public void setEmail(String id, String email)
    {
        Staff s = staff.get(id);
        if (s != null && s instanceof Typist)
        {
            // cast the staff member into a typist
            Typist t = (Typist)s;
            // add email to the typist
            t.setTypistEmail(email);
        }                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            

    }

    /** Returns true if the staff with the staff identifier 
     * can be found in the system, false otherwise.
     * @param stfId represents the staff identifier 
     * @return returns true if the staff with the staff identifier 
     * can be found, false otherwise.
     **/
    public boolean isStaff(String stfId)
    {
        return (staff.get(stfId) != null);
    }

    /** Removes a staff from the branch.
     * pre-condition: isStaff(stfId)
     * @param stfId represents the staff identifier 
     **/
    public void removeStaff(String stfId)
    {
        if (isStaff(stfId) == true)
        {
            staff.remove(stfId);
        }
    }

    /** Returns a String representation of all the staffs  
     * @return returns a String representation of all staffs 
     **/
    public String getAllStaff()
    {
        String list = "";
        Collection<Staff> staffValues = staff.values();
        Iterator<Staff> iter = staffValues.iterator();
        while (iter.hasNext())
        {
            Staff st = iter.next();
            list += st.toString() + '\n';
        }
        return list;
    }

    //************************************************************** 
    /** Finds the customer and if the customer is not in the system,
     *  adds the customer.If the customer is over their credit limit, 
     *  "Customer over credit limit is returned and the job is not 
     *  accepted.If the job is accepted it gets a number sequentially 
     *  from 100.If a suitable staff member is available,the state of 
     *  the job is set to "on going",the selected staff member is added
     *  to the job and the staff's set to "on job".If a staff member is
     *  not available,the job's state is state is set to "waiting".If 
     *  suitable staff cannot be found,"Job waiting" is returned, else
     *  "Staff allocated:" together with the staff details.
     * @param cust is the name of the customer
     * @param onSite true if job is on customer's site, false if 
     *      required to work at home
     * @param sHand true if shorthand is required, false otherwise
     * @param lang should the "English" if no translation required, 
     *      otherwise the name 
     * of the language
     * @return returns"Customer over credit limit", or if the job is 
     * possible,the job number with either "Job waiting" if no staff is
     * available, or "staff allocated:" together with the staff details
     **/ 
    public String addJob(String cust, boolean onSite, 
    boolean sHand, String lang)
    {
        Customer c = customers.get(cust);
        // if the customer is not in the system yet
        if (c == null)
        {
            c = new Customer(cust);
            // add the customer
            customers.put(cust, c);
        }
        // if the customer is over his/her credit limit
        if (c.getBalance() > c.getCreditLimit())
        {
            return ("Customer is over the credit limit. The job cannot be accepted.");
        }
        // create a new job with the job id initially starting from 100
        Job newJob = new Job(cust, onSite, sHand, lang);
        int newJobNo = newJob.getJobNumber();
        jobs.put(newJobNo, newJob);
        newJob.setCustomer(c);

        // search for a suitable and available staff member
        Staff st = findSuitableStaffMember(onSite,sHand,lang,"available");
        if (st!=null)
        {
            newJob.changeJobStatus("on going");
            newJob.setStaff(st);
            st.changeStatus("on job");
            return ("Staff allocated for the job number: " + newJob.getJobNumber() + '\n' + st.toString());
        }
        else
        {
            newJob.changeJobStatus("waiting");
            return ("Job waiting for the job number: " + newJob.getJobNumber()); 
        } 
    }

    /** Provides a String representation of all jobs 
     * @return returns a String representation of of all jobs
     **/
    public String getAllJobs()
    {
        String list = "";
        Collection<Job> jobValues = jobs.values();
        Iterator<Job> iter = jobValues.iterator();
        while (iter.hasNext())
        {
            Job j = iter.next();
            list += j.toString() + '\n';
        }
        return list;
    }

    /** Provides a String representation of all jobs which are 
     * still waiting to be done
     * @return returns a String representation of all jobs which are 
     * still waiting to be doneg
     **/
    public String getJobsWaiting()
    {
        // line change for simple gui to get nice looks
        String list = "\n";
        Collection<Job> jobValues = jobs.values();
        Iterator<Job> iter = jobValues.iterator();
        while (iter.hasNext())
        {
            Job j = iter.next();
            if (j.getJobStatus().equalsIgnoreCase("waiting"))
            {
                list += j.toString() + '\n';
            }
        }
        return list;
    }

    /** Returns the cost of job specified by the parameter value once it
     * has been done.If the job cannot be found or the job has not been 
     * done return -1.Clerks are paid 8 per hour, typists 12 per hour, 
     * while translators specify their own hourly rate.A job which 
     * requires shorthand has an added standard fee of 20.Cost of the 
     * job is added to the wages of the staff member and this cost 
     * together with a standard charge (currently 25) is added to the 
     * money owed by the customer.
     * @param jobNo is the number of the job
     * @return the cost of a job calculated as described above
     **/
    public double getJobCost(int jNo)
    {
        Job j = jobs.get(jNo);
        if (j != null)
        {
            // job cost of waiting jobs is zero
            return j.getCost();
        } else
        {
            return -1;
        }
    }

    /** Records that the job specified by the parameter value has been 
     * done.If the job can be found and its state is "on going", sets 
     * the state of the job to "done", the state of its staff to 
     * "available", costs are calculated and added as appropriate,and 0 
     * is returned,otherwise return -1
     * @param jNO is the job number
     * @param hours is the number of hours taken to do the job
     * @return -1 if job is not found or is not "on going", else 0
     **/
    public int setJobDone(int jNo, int hours)
    {
        Job j = jobs.get(jNo);
        if (j != null && j.getJobStatus().equalsIgnoreCase("on going"))
        {
            j.changeJobStatus("done");
            Staff st = j.getStaff();
            if (st != null) // if staff member for some reason has been removed
            {
                st.changeStatus("available");
            }
            // calculate job hourly cost
            double cost = st.getRate() * hours;
            // add 20 for shorthand
            if (j.isShorthand() == true)
            {
                cost += 20;
            }
            // add job cost to staff member wage
            st.addJobToWage(cost);
            // add job cost to the job
            j.setCost(cost);
            // add job cost + 25 to the customer
            Customer c = j.getCustomer();
            c.addJobCostToBalance(cost+25.00);
            return 0;
        } else
        {
            return -1;
        }
    }

    /** Checks the list of jobs and returns the job number of the first
     * job for which a staff member is now available.If such a job is 
     * found, the state of the job is set to "on going", the selected 
     * staff is added to the job information and the staff's state is 
     * set to "on job"and the job number is returned. If there no such
     * jobs,return -1
     * @return number of the job which can now be done
     **/
    public int checkJobsWaiting()
    {
        // get an arraylist of jobs
        ArrayList<Job> allJobs = new ArrayList<Job>();
        allJobs = jobList();
        for(Job j: allJobs)
        {
            // check that the job is waiting
            if (j.getJobStatus() != "waiting")
            {
                continue;
            }
            // search for suitable staff member
            Staff st = findSuitableStaffMember(j.isOnSite(),j.isShorthand(),j.getLanguage(),"available");
            // if a suitable staff member was found
            if (st != null)
            {
                j.changeJobStatus("on going");
                j.setStaff(st);
                st.changeStatus("on job");
                return j.getJobNumber();
            }
        }
        return -1;
    }

    /** Return an ArrayList of all jobs stored in Hashmap
     * @return return an ArrayList of all jobs stored in Hashmap
     **/
    private ArrayList<Job> jobList()
    {
        return new ArrayList<Job> (jobs.values());
    }

    /** Find a suitable staff member for a job
     * @param onSite true if job is on customer's site, false if 
     *      required to work at home
     * @param sHand true if shorthand is required, false otherwise
     * @param lang should the "English" if no translation required, 
     *      otherwise the name of the language
     * @param status represents the status of the job
     * @return returns a suitable staff member for a job if found, otherwise null
     **/
    private Staff findSuitableStaffMember(boolean onSite, boolean sHand, String lang, String status)
    {
        Collection<Staff> staffValues = staff.values();
        Iterator<Staff> iter = staffValues.iterator();
        while (iter.hasNext())
        {
            Staff st = iter.next();
            if ((st.getHOnly() == onSite) && (st.getSHand() == sHand) && 
            (st.getLanguage().equalsIgnoreCase(lang)) && (st.getStatus().equalsIgnoreCase(status)))
            {
                return st;
            }   
        } 
        return null;
    }
}

