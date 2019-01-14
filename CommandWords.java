import java.util.HashMap;

public class CommandWords
{
    private HashMap<String, CommandWord> aValidCommands;


    /**
     * Constructeur par defaut
     */
    public CommandWords()
    {
	this.aValidCommands = new HashMap<String, CommandWord>();
	for(CommandWord vCmd : CommandWord.values())
	    {
		if(vCmd != CommandWord.UNKNOWN)
		    {
			for (Language vLang : Language.values())
			    {
				this.aValidCommands.put(vCmd.toString(vLang), vCmd);
			    }
		    }
	    }
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

    /**
     * Donne le mot-commande correspondant a une String
     * @param pWord String correspondant a un mot-commande
     * @return le mot-commande correspondant
     */
    public CommandWord getCommand(final String pWord)
    {
	if ( this.isCommand(pWord) )
	    return this.aValidCommands.get(pWord);
	else
	    return CommandWord.UNKNOWN;
    }
}
