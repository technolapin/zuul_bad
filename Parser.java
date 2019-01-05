import java.util.StringTokenizer;


public class Parser 
{

    private CommandWords aCommandWords;  // holds all valid command words

    /**
     * Create a new Parser.
     */
    public Parser() 
    {
        this.aCommandWords = new CommandWords();
    } // Parser()

    /**
     * Get a new command from the user. The command is read by
     * parsing the 'inputLine'.
     * @param pInputLine la String entree
     * @return une Commande
     */
    public Command getCommand( final String pInputLine ) 
    {
        String vWord1;
        String vWord2;

        StringTokenizer tokenizer = new StringTokenizer( pInputLine );

        if ( tokenizer.hasMoreTokens() )
            vWord1 = tokenizer.nextToken();      // get first word
        else
            vWord1 = null;

        if ( tokenizer.hasMoreTokens() )
            vWord2 = tokenizer.nextToken();      // get second word
        else
            vWord2 = null;

        // note: we just ignore the rest of the input line.

        // Now check whether this word is known. If so, create a command
        // with it. If not, create a "null" command (for unknown command).
	

	return new Command( this.aCommandWords.getCommand(vWord1), vWord2 );
    } // getCommand(.)

    /**
     * Demande la construction d'une String listant les commandes valides et la retourne.
     * @return Une string listant les commandes autorisees.
     */
    public String getCommandList()
    {
	return this.aCommandWords.makeCommandList();
    }

} // Parser
