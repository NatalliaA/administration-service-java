
/**
 * This interface specifies behaviour expected from the RATS
 * system required for Coursework 
 * 2007/8
 * 
 * @author A.A.Marczyk 
 * @version 07/03/08
 */
public interface Manager
{
    /**Returns the location of the branch as a String
     * @return the location of the branch as a String
     **/ 
    public String getBranch();
    
    /**Returns a String representation of the branch,including
     * its location and all its staff,customers and jobs
     * @return a String representation of the branch,including
     * its location and all its staff,customers and jobs
     **/
    public String toString();
    
    /**Returns a String representation of customers who have used the 
     * branch's services
     * @return a String representation of the customers who have used 
     * the branch's services 
     **/
    public String getAllCustomers();
        
 // ***************** Staff ************************   
    /** Allows a clerk to be added to the branch.The clerk's availability
     *  is set to "available"
     * @param id represents the employee code of the staff e.g TY333
     * @param name is the staff member's name 
     **/        
     public void addStaff(String id,String name);
    
     /**Allows a typist to be added to a branch.The typist's availability
     *  is set to "available".Staff must specify if they can only work at 
     *  home.If false, then staff can work on site or at home if required
     * @param id represents the employee code of the staff e.g TY333
     * @param name is the staff member's name 
     * @param hOnly true if a member of staff can only work at home,
     * fals if they can only work at home
     * @param sHand true if a member of staff can offer shorthand
     **/       
     public void addStaff(String id,String name, boolean hOnly, 
                                            boolean sHand);
    
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
    public void addStaff(String id,String name, boolean hOnly, 
                    boolean sHand,String lang, double rate);
    
                
    /** Sets email for a typist
     * @param id represents the staff id
     * @param email is the email address
     */ 
    public void setEmail(String id, String email);
    
    
    /** Returns true if the staff with the staff identifier 
     * can be found in the system, false otherwise.
     * @param stfId represents the staff identifier 
     * @return returns true if the staff with the staff identifier 
     * can be found, false otherwise.
     **/
    public boolean isStaff(String stfId);
    
    /** Removes a staff from the branch.
     * pre-condition: isStaff(stfId)
     * @param stfId represents the staff identifier 
     **/
    public void removeStaff(String stfId);
    
    /** Returns a String representation of all the staffs  
     * @return returns a String representation of all staffs 
     **/
    public String getAllStaff();
   

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
     public String addJob(String cust,boolean onSite, 
                                    boolean sHand, String lang);
     
     
    /** Provides a String representation of all jobs 
     * @return returns a String representation of of all jobs
     **/
    public String getAllJobs();
    
    /** Provides a String representation of all jobs which are 
     * still waiting to be done
     * @return returns a String representation of all jobs which are 
     * still waiting to be doneg
     **/
    public String getJobsWaiting();

    /** Returns the cost of job specified by the parameter value once it
     * has been done.If the job cannot be found or the job has not been 
     * done return -1.Clerks are paid ? per hour, typists ?2 per hour, 
     * while translators specify their own hourly rate.A job which 
     * requires shorthand has an added standard fee of ?0.Cost of the 
     * job is added to the wages of the staff member and this cost 
     * together with a standard charge (currently ?5) is added to the 
     * money owed by the customer.
     * @param jobNo is the number of the job
     * @return the cost of a job calculated as described above
     **/
    public double getJobCost(int jNo);
    
    
    /** Records that the job specified by the parameter value has been 
     * done.If the job can be found and its state is "on going", sets 
     * the state of the job to "done", the state of its staff to 
     * "available", costs are calculated and added as appropriate,and 0 
     * is returned,otherwise return -1
     * @param jNO is the job number
     * @param hours is the number of hours taken to do the job
     * @return -1 if job is not found or is not "on going", else 0
     **/
    public int setJobDone(int jNo, int hours);
    
    
    /** Checks the list of jobs and returns the job number of the first
     * job for which a staff member is now available.If such a job is 
     * found, the state of the job is set to "on going", the selected 
     * staff is added to the job information and the staff's state is 
     * set to "on job"and the job number is returned. If there no such
     * jobs,return -1
     * @return number of the job which can now be done
     **/
    public int checkJobsWaiting();
   
 
// ***************   file write/read  *********************
// These methods may be added for Task 5

//    /** Writes all staff information to the specified file
//     * @param fname name of file to which staff information is written
//     */
//    public void writeStaffToFile(String fname);

    
//    /** Read all staff information from the specified file
//     * @param fname name of file from which staff information is read
//     */
//    public void readStaffFromFile(String fname);

}