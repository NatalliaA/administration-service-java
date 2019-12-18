
/**
 * The subclass Typist extends the class Staff. It stores
 * specific information about the typist.
 * Typists may choose to work only at home (those that 
 * specify that they can be office based, can also work at home).
 * They may also offer shorthand. Typists should provide an email.
 * Typists are paid ?12 per hour.
 * 
 * @author Natallia Akulenka
 * @version 12/01/2014
 */
public class Typist extends Staff
{
    // the typist's email
    private String email;

    /**
     * Constructor for objects of class Typist
     * @param id represents the staff member's id which
     *      consists of letters and digits e.g TY333
     * @param name is the staff member's name 
     * @param hOnly true if the staff member can work on site, false 
     *      if he/she can ONLY work at home
     * @param sHand true if the staff member can offer shorthand
     */
    public Typist(String id, String name, boolean hOnly, boolean sHand)
    {
        super(id, name);
        setHOnly(hOnly);
        setSHand(sHand);
        setRate(12.00);
        email = " ";
    }

    /** Set the email to the typist
     * @param email is the email of the typist
     */
    public void setTypistEmail(String email)
    {
        this.email = email;
    }

    /** Get the typist's email
     * @return returns the typist's email
     */
    public String getEmail()
    {
        return email;
    }

    /**Return a String representation of the typist
     * @return returns a String representation of the typist
     **/
    public String toString()
    {
        return (super.toString() + "Email: " + email + '\n');
    }
}
