
/**
 * The subclass Translator extends the class Staff. It stores 
 * specific information about the translator.
 * Typists may choose to work only at home (those that specify that they can be office based, 
 * can also work at home), and may also offer shorthand. 
 * Only translators can translate and must specify a foreign language.
 * Translators negotiate their own hourly rate.
 * 
 * @author Natallia Akulenka
 * @version 12/01/2014
 */
public class Translator extends Staff
{
    /**
     * Constructor for objects of class Translator
     * @param id represents the staff member's id which 
     *      consists of letters and digits e.g TY333
     * @param name is the staff member's name 
     * @param hOnly true if the staff member can work on site, false 
     *      if he/she can ONLY work at home
     * @param sHand true if the staff member can offer shorthand
     * @param lang is the language which the staff member can translate
     * @param rate is the hourly rate
     */
    public Translator(String id, String name, boolean hOnly, 
    boolean sHand, String lang, double rate)
    {
        super(id, name);
        setHOnly(hOnly);
        setSHand(sHand);
        setLanguage(lang);
        setRate(rate);
    }

    /**Return a String representation of the translator
     * @return a String representation of the translator
     **/
    public String toString()
    {
        return (super.toString());
    }
}
