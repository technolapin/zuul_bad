/**
 * classe gerant les Items
 */
public class Item
{
    private String aDescription;
    private int aWeight;

    
    /**
     * le constructeur
     * @param pDecr la description de la piece
     * @param pWei le poids de l'item
     */
    public Item( final String pDescr, final int pWei )
    {
	this.aDescription = pDescr;
	this.aWeight      = pWei;
    }

    
    /**
     * retourne la description de la piece
     * @return une chaine de caracteres decrivant la piece
     */
    public String
	getDescription()
    {
	return this.aDescription;
    }


    /**
     * retourne le poids de l'item
     * @return le poids de l'item
     */
    public int
	getWeight()
    {
	return this.aWeight;
    }
}
