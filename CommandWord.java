import java.util.HashMap;

/**
 * mot-commandes autorises
 * @author Clément Chomicki
 */
public enum CommandWord
{
    UNKNOWN("?"),
    GO("go", "aller"),
    QUIT("quit", "aurevoir"),
    HELP("help", "aled"),
    LOOK("look"),
    EAT("eat"),
    BACK("back"),
    TEST("test"),
    TAKE("take"),
    DROP("drop"),
    STONE("stone"),
    ALEA("alea"),
    ITEMS("items");

    private HashMap<Language, String> aWords;
    
    /**
     * Constructeur de l'enum
     * @param pWord la chaîne correspondant au mot-commande dans toutes les langues
     */
    CommandWord(final String pWord)
    {
	this.aWords = new HashMap<Language, String>();
	for (Language vLang : Language.values())
	    this.aWords.put(vLang, pWord);
	
    }
    

    /**
     * Constructeur de l'enum
     * @param pWordEn la chaîne correspondant au mot-commande en anglais
     * @param pWordFr la chaîne correspondant au mot-commande en francais
     */
    CommandWord(final String pWordEn,
		final String pWordFr )
    {
	this.aWords = new HashMap<Language, String>();
	
	this.aWords.put(Language.ENGLISH, pWordEn);
	this.aWords.put(Language.FRENCH , pWordFr);
    }

    /**
     * Retourne une des traductions du mot-commande
     * @param pLang langage voulu
     * @return la chaine de caractere correspondant au mot-commande dans la langue pLang
     */
    public String toString(final Language pLang)
    {
	return this.aWords.get(pLang);
    }
    
}
