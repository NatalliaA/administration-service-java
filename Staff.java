/**
 * The superclass Staff stores common information of different staff
 * types (clerk, typist, translator).
 * Each staff member has a unique identifier which consist of 
 * letters and digits e.g. TY333. Clerks can only work at the client's office 
 * (and not at home), and do not offer shorthand. Typists and translators may 
 * choose to work only at home (those that specify that they can be office based, 
 * can also work at home). Typists and translators may also offer shorthand. 
 * Typists should provide an email. Only translators can translate and 
 * must specify a foreign language. Each staff  member at a branch has an 
 * availability status: available, on job, unavailable. When a staff member is 
 * added to the branch, their availability status is "available".
 * 
 * @author  Natallia Akulenka
 * @version 12/01/2014
 */
public class Staff
{
    // the unique identifier of the staff member
    private String id;
    // the staff member's name
    private String name;
    // the availability status of the staff member
    private String status;
    // true if the staff member can work on site, false if he/she can ONLY work at home
    private boolean hOnly;
    // true if the staff member can offer shorthand
    private boolean sHand;
    // "English" if no translation required, otherwise the name of the language
    private String lang;
    // rate of the staff member
    private double rate;
    // wage of the staff member
    private double wage;

    /**
     * Constructor for objects of class Staff
     * @param id represents the staff member's id which consists of letters and digits e.g TY333
     * @param name is the staff member's name 
     */
    public Staff(String id, String name)
    {
        this.id = id;
        this.name = name;
        sHand = false;
        hOnly = true;
        status = "available";
        lang = "English";
        rate = 0;
        wage = 0;
    }

    /** Get the staff member's id
     * @return returns the staff member's id
     */
    public String getId()
    {
        return id;
    }

    /**Only change the availability status of the staff member
     *      for the valid statuses
     * @param status represents the availability status 
     * of the staff member: available, on job or unavailable
     */
    public void changeStatus(String status)
    {
        if (status.equalsIgnoreCase("available") || status.equalsIgnoreCase("on job") || status.equalsIgnoreCase("unavailable"))
        {
            this.status = status;
        }
    }

    /**Return true if the staff member can offer shorthand, 
     *      false otherwise
     * @return returns true if the staff member can offer shorthand, 
     *      false otherwise
     */
    public boolean getSHand()
    {
        return sHand;
    }

    /**Change shorthand
     * @param sHand is true if the staff member can work on site, 
     *      false if he/she can ONLY work at home
     */
    public void setSHand(boolean sHand)
    {
        this.sHand = sHand;
    }

    /**Return true if the staff member can work on site, 
     *      false if he/she can ONLY work at home
     * @return true if the staff member can work on site, 
     *      false if he/she can ONLY work at home
     */
    public boolean getHOnly()
    {
        return hOnly;
    }

    /**Change whether the staff member can work on site or ONLY work at home
     * @param hOnly is true if the staff member can offer shorthand,
     *      false otherwise
     */
    public void setHOnly(boolean hOnly)
    {
        this.hOnly = hOnly;
    }

    /**Get the staus of the staff member
     * @return returns the status of the staff member: available,
     *      on job or unavailable
     */
    public String getStatus()
    {
        return status;
    }

    /**Get the language
     * @return returns the language
     */
    public String getLanguage()
    {
        return lang;
    }

    /**Change the language
     * @param lang represents the language
     */    
    public void setLanguage(String lang)
    {
        this.lang = lang;
    }

    /**Change the rate
     * @param r represents the rate
     */
    public void setRate(double r)
    {
        rate = r;       
    }

    /**Get the rate
     * @return returns the rate
     */
    public double getRate()
    {
        return rate;       
    }    

    /**Add the job cost to the wage of the staff member
     * @param jobCost represents the job cost
     */
    public void addJobToWage(double jobCost)
    {
        wage += jobCost;       
    }

    /**Return a String representation of the staff member
     * @return a String representation of the staff member,including
     *      his/her name, number and status
     **/
    public String toString()
    {
        String home = "";
        if(hOnly){home = "no";}
        else {home = "yes";}

        String hand = "";
        if(sHand){hand = "yes";}
        else {hand = "no";}

        return ("Staff member id: " + id + '\n' + "Name: " + name + '\n' +
            "Availability status: " + status + '\n' +  
            "Only works at home: " + home + '\n' + 
            "Offers shorthand: " + hand + '\n' +
            "Language: " + lang + '\n' +
            "Hourly rate: " + rate + " pounds" + '\n' +
            "Wage for the jobs done: " + wage + '\n');
    }
}
