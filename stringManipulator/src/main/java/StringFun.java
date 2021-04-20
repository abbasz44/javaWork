/**
 * This StringFun class provides some methods that can 
 * be used to manipulate strings and return the results.
 *
 */
public class StringFun {
    
    /**
     * an instance variable string
     */
    private String theBaseString;

    /**
     * This is a constructor for StringFun class.
     *
     * @param newstring is the value of the string
     */
    public StringFun(String newString) {
        theBaseString = newString;
    }
    /**
    * returns the string that was used to initialize
    * the object
    */
    
    public String getText(){
        return theBaseString;
    }
    /**
     * returns the number of characters in the string
     *
     */
    public int getCharCount() {

        int count = 0;

        for(int i = 0; i < theBaseString.length(); i++){
            if(theBaseString.charAt(i) != ' ')
            count++;
        }

         return count;
    }

    /**
     * returns the string converted to lower case
     *
     */
    public String allLowerCase() {
        return null;
    } 

    /**
     * returns the string without the first character
     *
     */
    public String removeFirst() {



        return theBaseString.substring(0,1).toUpperCase() + theBaseString.substring(1);
    } 

    /**
     * returns the character at the position given by pos
     *
     */
    public char getCharacter( int pos) {
        return 0;
    }

    /**
     * returns the string with the characters in the parameter added to the end
     *
     */
    public String addCharacters(String toAdd)    {
        return null;
    }

    /**
     * returns true if the string starts with the target string, false otherwise
     *
     */
    public Boolean startsWith(String target)    {

        return false;
        
    }

    /**
     * returns the string with the first occurence of character replaced
     *
     * @param old a char to be replaced in the string
     * @param replace a char to replace the old char in the string
     */
    public String replaceOneCharacter(char old, char replace)    {
        return null;
    }
}