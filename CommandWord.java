import java.util.HashMap;

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
    ITEMS("items");

    private HashMap<Language, String> aWords;
    
    CommandWord(final String pWord)
    {
	this.aWords = new HashMap<Language, String>();
	for (Language vLang : Language.values())
	    this.aWords.put(vLang, pWord);
	
    }
    
    CommandWord(final String pWordEn,
		final String pWordFr )
    {
	this.aWords = new HashMap<Language, String>();
	
	this.aWords.put(Language.ENGLISH, pWordEn);
	this.aWords.put(Language.FRENCH , pWordFr);
    }

    public String toString(final Language pLang)
    {
	return this.aWords.get(pLang);
    }
    
}
