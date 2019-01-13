import java.util.Stack;


public class Player extends Entity
{
    private Room        aLocation;
    private Stack<Room> aPreviousRooms;
    private int         aMaxWeight;

    /**
     * Constructeur de la classe
     * @param pN le nom de l'entite
     */
    public Player( final String pN )
    {
	super( pN );
	this.aPreviousRooms = new Stack<Room>();
    }

    /**
     * vide la stack
     */
    public void resetStack()
    {
	this.aPreviousRooms = new Stack<Room>();
    }



    /**
     * Accesseur de aLocation
     * @return la location
     */
    public Room getLocation()
    {
	return this.aLocation;
    }

    /**
     * retire la derniere piece visitee de la pile et la retourne
     * @return la derniere piece visitee
     */
    public Room goToPreviousLocation()
    {
	return this.aPreviousRooms.pop();
    }

    /**
     * Ajoute une piece a la pile de l'historique des pieces
     * @param pNextRoom la piece a empiler sur la pile des pieces deja visitees
     */
    public void pushPreviousLocation( final Room pNextRoom )
    {
	this.aPreviousRooms.push( this.getLocation() );
    }

    /**
     * deplace le Joueur a un endroit donne
     * @param pNextRoom la piece où l'on deplace le joueur
     */
    public void setLocation( final Room pNextRoom )
    {
	this.aLocation = pNextRoom;
    } // setLocation()

    /**
     * setter de aMaxWeight
     * @param pMW nouveau poids maximal
     */
    public void setMaxWeight( final int pMW)
    {
	this.aMaxWeight = pMW;
    }

    /**
     * accesseur de aMaxWeight
     * @return le poids maximal
     */
    public int getMaxWeight()
    {
	return this.aMaxWeight;
    }

    /**
     * teste si la pile est vide
     * @return un booleen
     */
    public boolean hasNoPreviousLocations()
    {
	return this.aPreviousRooms.isEmpty();
    }

    /**
     * Cree la description de l'inventaire du joueur
     * @return la description de l'inventaire du joueur
     */
    public String makeItemsDescription()
    {
	String vS = super.inventoryString();
	if (vS.equals(""))
	    return "You own nothing.\nTotal: 0 / "+this.getMaxWeight();
	else
	    return (
		    "You have " + vS + "\nTotal: " +
		    super.getCarriedWeight() +
		    " / " + this.getMaxWeight()
		    );
    }

    public boolean canCarryItem( final Item pItem )
    {
	return super.getCarriedWeight() + pItem.getWeight() <= this.getMaxWeight();
    }


    
}
