/**
 * Classe definissant le concept de 'commandes'
 */
public class Command
{
    private String aCommandWord;
    private String aSecondWord;

    /**
     * Constructeur de la classe
     * @param pCommandW le mot-commande
     * @param pSecondW  le second mot
     */
    public Command (final String pCommandW, final String pSecondW )
    {
        this.aCommandWord = pCommandW;
        this.aSecondWord = pSecondW;
    }

    /**
     * Accesseur du mot-commande
     * @return le mot-commande
     */
    public String getCommandWord () { return this.aCommandWord; }
    /**
     * Accesseur du second mot
     * @return le second mot
     */
    public String getSecondWord ()  { return this.aSecondWord;  }

    /**
     * Fonction booleene verifiant si la commande presente un second mot
     * @return true si et seulement si le second mot n'est pas null.
     */
    public boolean hasSecondWord ()
    {
        return this.aSecondWord != null;
    }
    
    /**
     * Fonction booleene verifiant si la commande presente un mot-commande
     * @return true si et seulement si le mot commande est null.
     */
    public boolean isUnknown ()
    {
        return this.aCommandWord == null;
    }
    
} // Command
