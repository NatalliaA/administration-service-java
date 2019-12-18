import java.util.*;
/**
 * The class Customer stores information about a customer: 
 * customer number, name and credit limit.
 * Regular customers have a credit limit of ?500, 
 * while for others the limit is ?100
 * 
 * @author  Natallia Akulenka
 * @version 12/01/2014
 */
public class Customer
{
    private static int HIGHEST_CUST_NO = 1;
    // the name of the customer
    private String cust;
    // the number of the customer
    private int custNumber;
    // a regular customer or not
    private boolean isRegular;
    // the credit limit of the customer
    private double creditLimit;
    private ArrayList<Job> jobs;
    //the customer's balance to be paid
    private double balance;

    /**
     * Constructor for objects of class Customer
     * @param cust represents the name of the customer
     * @param custNumber represents the number of the customer
     * @param isRegular is true if the customer is regular, false otherwise
     */
    public Customer(String cust)
    {
        this.cust = cust;
        isRegular = false;
        custNumber =  HIGHEST_CUST_NO++;
        jobs = new ArrayList<Job>();
        balance = 0;

        if (isRegular == true)
        {
            creditLimit = 500.00;
        }
        else
        {
            creditLimit = 100.00;
        }

    }

    /**Add the job cost to the customer's balance
     * 
     * @param jobCost represents the job cost
     */
    public void addJobCostToBalance(double jobCost)
    {
        balance += jobCost;
    }

    /**Get the customer's balance
     * 
     * @return returns the customer's balance
     */
    public double getBalance()
    {
        return balance;
    }

    /**Get the customer's credit limit
     * 
     * @return returns the customer's credit limit
     */
    public double getCreditLimit()
    {
        return creditLimit;
    }

    /**Add the job to the customer
     * 
     * @param job is the job to be added to the customer
     */
    public void addJob(Job job)
    {
        jobs.add(job);
    }

    /**Return whether the customer is regular or not
     * 
     * @return returns true if the customer is regular,
     *      false otherwise
     */
    public boolean getIsRegular()
    {
        return isRegular;
    }

    /** Set the customer as regular or not
     * 
     * @param isReg represents whether the customer
     *      is regular or not
     */
    public void setIsRegular(boolean isReg)
    {
        isRegular = isReg;
    }

    /**Return a String representation of the customer, including
     *      his/her name and number
     * @return returns a String representation of the customer, including
     *      his/her name and number
     **/
    public String toString()
    {
        return ("Customer name: " + cust + '\n' + "Number: " + custNumber + '\n' + 
            "Credit limit: " + creditLimit + " pounds" + '\n' + "Balance to be paid: " + balance + '\n');
    }
}
