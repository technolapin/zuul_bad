import java.util.HashMap;

/**
 * Classe decrivant le concept d'inventaire
 * @author Clément Chomicki
 */
public class Inventory
{
    private HashMap<Item, Integer> aItems;
    private int aWeight;

    /**
     * Constructeur de la classe
     */
    public Inventory()
    {
	this.aItems = new HashMap<Item, Integer>();
	this.aWeight = 0;
    }


    /**
     * Cherche un item dans l'inventaire de l'entite via son nom
     * @param pItemName le nom de l'item cherche
     * @return un item ou null
     */
    public Item getByName( final String pItemName )
    {
	for (Item vItem : this.aItems.keySet() )
	    {
		if ( vItem.getDescription().equals( pItemName ) )
		    {
			return vItem;
		    }
	    }
	return null;
    }

    
    /**
     * Verifie la presence d'un item dans l'inventaire
     * @param pItem l'item cherche
     * @return un booleen traduisant la presence de l'item
     */
    public boolean hasItem( final Item pItem )
    {
	return ( this.aItems.get( pItem ) != null );
    }

    /**
     * Verifie si l'inventaire est vide
     * @return un booleen
     */
    public boolean isEmpty()
    {
	return this.aItems.isEmpty();
    }

    /**
     * ajoute un item a l'inventaire
     * @param pItem l'item a ajouter
     */
    public void add( final Item pItem )
    {
	if ( this.hasItem(pItem) )
	    this.aItems.put( pItem, this.aItems.get( pItem ) +1 );
	else
	    this.aItems.put( pItem, 1 );
	
	this.aWeight += pItem.getWeight();
    }

    /**
     * ajoute des items a l'inventaire
     * @param pItem l'item a ajouter
     * @param pNombre le nombre de fois que pItem doit etre ajoute
     */
    public void add( final Item pItem, final int pNombre )
    {
	for (int vI = 0; vI < pNombre; vI++)
	    this.add( pItem );
    }

    /**
     * retire un item de l'inventaire
     * @param pItem l'item a supprimer
     */
    public void remove( final Item pItem )
    {
	if (this.aItems.get( pItem ) > 1)
	    this.aItems.put( pItem, this.aItems.get( pItem ) - 1);
	else
	    this.aItems.remove( pItem );
	
	this.aWeight -= pItem.getWeight();
    }

    /**
     * Retourne une chaine decrivant le contenu de l'inventaire
     * @return une chaine decrivant le contenu de l'inventaire
     */
    public String toString()
    {
	if ( this.isEmpty() )
	    return "";
	else
	    {
		
		String vS = "";
		for (Item vItem : this.aItems.keySet())
		    {
			Integer vNombre = this.aItems.get( vItem );
			vS += (	"\n            " + vNombre.toString() + " " +
				vItem.getDescription() +
				( (vNombre > 1) ? "s":"" ) +
				"("+
				(new Integer(vItem.getWeight() * vNombre)
				 ).toString()+")" );

		    }
		return vS;
	    }
    }

    /**
     * retourne le poids total
     *@return le poids total
     */
    public int totalWeight()
    {
	int vTotal = 0;
	for ( Item vItem : this.aItems.keySet() )
	    {
		vTotal += vItem.getWeight();
	    }
	return vTotal;
    }
       
}
