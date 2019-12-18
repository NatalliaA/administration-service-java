
/**
 * The subclass Clerk extends the class Staff. It stores 
 * specific information about the clerk.
 * Clerks can only work at the client's office 
 * (and not at home), and do not offer shorthand.
 * Clerks are paid ?8 per hour.
 * 
 * @author Natallia Akulenka
 * @version 12/01/2014
 */
public class Clerk extends Staff
{
    /**
     * Constructor for objects of class Clerk
     * @param id represents the staff member's id which consists of letters and digits e.g TY333
     * @param name is the staff member's name 
     */
    public Clerk(String id, String name)
    {
        super(id, name);
        setRate(8.00);
    }

    /**Return a String representation of the clerk
     * @return returns a String representation of the clerk
     **/
    public String toString()
    {
        return (super.toString());
    }
}
