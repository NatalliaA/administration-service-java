import java.util.ArrayList;
import java.util.Iterator;
/**
 * The class Job stores information about a job: 
 * a unique job number allocated sequentially starting from 100, 
 * the customer information, whether the job is to be done at home or on site, 
 * whether it requires shorthand and the language required. 
 * For jobs which do not require any translation work, 
 * the default language is "English".  
 * 
 * @author  Natallia Akulenka
 * @version 12/01/2014
 */
public class Job
{
    // the starting number of the job
    private static int HIGHEST_JOB_ID = 100;
    // the number of the job
    private int JobNo;
    // the name of the customer
    private String cust;
    // the place of the job: on customer's site or at home
    private boolean onSite;
    // whether the shorthand is required
    private boolean sHand;
    // the language (by default "English" if no translation required)
    private String lang;
    // the current state of the job: waiting, on going or done
    private String jobStatus;
    // the customer who ordered the job
    private Customer customer;
    // the staff member assigned to the job
    private Staff staff;
    // the job cost
    private double cost;

    /**
     * Constructor of the class Job
     * @param cust is the name of the customer
     * @param onSite represents true if the job is on customer's site, false 
     *      if required to work at home
     * @param sHand represents true if the shorthand is required, false otherwise
     * @param lang should the "English" if no translation required, otherwise
     *      the name of the language
     */
    public Job (String cust, boolean onSite, boolean sHand, String lang)
    {
        JobNo = HIGHEST_JOB_ID++;
        this.cust = cust;
        this.onSite = onSite;
        this.sHand = sHand;
        jobStatus = "waiting";
        cost = 0;
        // "English" if no translation required, otherwise the name of the language
        if (lang.equalsIgnoreCase(""))
        {
            lang = "English";
        }
        else
        {
            this.lang = lang;
        }       
    }

    /**Get the language required for the translation
     * 
     * @return returns the language required for the translation
     */
    public String getLanguage()
    {
        return lang;
    }

    /**Return whether the job requires shorthand
     * 
     * @return returns true if the shorthand is required, false otherwise
     */
    public boolean isShorthand()
    {
        return sHand;
    }

    /**Change the job status
     * 
     * @param jobStatus represents the job status: waiting, on going or done
     */
    public void changeJobStatus(String jobStatus)
    {
        this.jobStatus = jobStatus;
    }

    /**Get the job status
     * 
     * @return returns the job status: waiting, on going or done
     */
    public String getJobStatus()
    {
        return jobStatus;
    }

    /**Return whether the place of the job is on customer's site or at home
     * 
     * @return returns true if the job is on customer's site, 
     *      false if required to work at home
     */
    public boolean isOnSite()
    {
        return onSite;
    }

    /**Set the customer to the job
     * 
     * @param c represents the job's customer
     */
    public void setCustomer(Customer c)
    {
        customer = c;       
    }

    /**Get the job's customer
     * 
     * @return returns the job's customer
     */
    public Customer getCustomer()
    {
        return customer;       
    }

    /**Assign the staff member to the job
     * 
     * @param s represents the staff member assigned to the job
     */
    public void setStaff(Staff s)
    {
        staff = s;       
    }

    /**Get the staff member assigned to the job
     * 
     * @return returns the staff member assigned to the job
     */
    public Staff getStaff()
    {
        return staff;       
    }

    /**Set the job cost
     * 
     * @param c represents the job cost
     */
    public void setCost(double c)
    {
        cost = c;  
    }

    /**Get the job cost
     * 
     * @return returns the job cost
     */
    public double getCost()
    {
        return cost;  
    }

    /**Get the job number
     * 
     * @return returns the job number
     */
    public int getJobNumber()
    {
        return JobNo;
    }

    /**Return a String representation of the job
     * @return a String representation of the job, 
     *      including its number, the customer information, 
     *      whether the job is to be done at home or on site,
     *      whether it requires shorthand and the language required
     **/

    public String toString()
    {
        String site = "";
        if(onSite){site = "yes";}
        else {site = "no";}

        String hand = "";
        if(sHand){hand = "yes";}
        else {hand = "no";}

        String string = ("Job number: " + JobNo + '\n' + "Status: " + jobStatus + '\n' +
                "On customer's site: " + site + '\n' + 
                "Shorthand is required: " + hand + '\n' + "Language: " + lang + '\n' +
                "Cost (zero if job not done yet): " + cost + '\n');
        if (customer!=null)
        {
            string += ('\n' + "Customer information:" + '\n' + customer.toString() + '\n');
        }
        if (staff!=null)
        {
            string += ("Staff information:" + '\n' + staff.toString() + '\n');
        }

        return string;
    }
}
