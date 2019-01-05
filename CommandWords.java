import java.util.HashMap;

public class CommandWords
{
    private HashMap<String, CommandWord> aValidCommands;
    /*    private static final String[] sValidCommands = {
        "go", "quit", "help", "look", "eat", "back", "test", "take", "drop", "items"
	};*/

    /**
     * Constructeur par defaut
     */
    public CommandWords()
    {
	this.aValidCommands = new HashMap<String, CommandWord>();
	this.aValidCommands.put("go"   , CommandWord.GO   );
	this.aValidCommands.put("quit" , CommandWord.QUIT );
	this.aValidCommands.put("help" , CommandWord.HELP );
	this.aValidCommands.put("look" , CommandWord.LOOK );
	this.aValidCommands.put("eat"  , CommandWord.EAT  );
	this.aValidCommands.put("back" , CommandWord.BACK );
	this.aValidCommands.put("test" , CommandWord.TEST );
	this.aValidCommands.put("take" , CommandWord.TAKE );
	this.aValidCommands.put("drop" , CommandWord.DROP );
	this.aValidCommands.put("items", CommandWord.ITEMS);
    }

    /**
     * Verifie si une String donnee fait partie des commandes valides. 
     * @param pString la String a tester
     * @return true si pString est une comande valide, false sinon
     */
    public boolean isCommand( final String pString )
    {
	return aValidCommands.containsKey(pString);
    }

    /**
     * Methode construisant et retournant les commandes autorisees dans une String.
     * @return Une string listant les commandes autorisees.
     */
    public String makeCommandList ()
    {
	String vS = "";	
	for (String vCmd : aValidCommands.keySet())
	    {
		vS += vCmd + " ";
	    }
	return vS;
    }

    public CommandWord getCommand(final String pWord)
    {
	if ( this.isCommand(pWord) )
	    return this.aValidCommands.get(pWord);
	else
	    return CommandWord.UNKNOWN;
    }
}
