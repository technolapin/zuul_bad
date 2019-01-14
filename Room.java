import java.util.HashMap;

/**
 * Classe gerant le concept de pieces
 * @author Clément Chomicki
 */
public class Room extends Entity
{
    
    private HashMap<String, Room> aExits;
    private String aImageName;
    
    /**
     * Constructeur de Room
     * @param pDescription La chaine de caractere decrivant la piece.
     * @param pImgName le nom de l'image.
     */
    public Room ( final String pDescription,
		  final String pImgName )
    {
	super( pDescription );
	this.aExits     = new HashMap<String, Room>();
	this.aImageName = pImgName;
    } // Room


    /**
     * Methode d'acces a la description de la piece
     * @return La description de la piece.
     */
    public String getDescription ()
    {
	return this.getName();
    } // getDescription

    
    /**
     * Methode construisant et retournant le texte de sortie de la piece.
     * @return la chaine de sortie de la piece
     */
    public String getExitString()
    {
        String vS = "Exits: ";
        for (String vKey : this.aExits.keySet()) {
            vS += vKey+" ";
        }
        return vS;
    } // getExitString()

    
    /**
     * Procedure permettant de relier les pieces entre elles.
     * @param pDirection  La chaine de caractere indiquant la direction.
     * @param pRoom       La piece de sortie correspondant a la direction.
     */
    public void setExit (final String pDirection, final Room pRoom)
    {
        this.aExits.put (pDirection , pRoom );
    } // setExit()


    /**
     * Retourne la piece direction demandee
     * @param pDirection  La chaine de caractere indiquant la direction.
     * @return La piece sortie demandee.
     */
    public Room getExit(final String pDirection)
    {
	return this.aExits.get( pDirection );
    } // getExit

    public boolean isExit(final Room pRoom)
    {
	return !(this.aExits.get(pRoom.getDescription())==null);
    } //isExit()


    /**
     * Retourne la String decrivant pleinement la piece.
     * @return La String a afficher pour decrire la scene.
     */
    public String getLongDescription()
    {
	return ( "You are " +
		 this.getDescription () + "\n" +
		 this.getExitString()   + "\n" +
		 this.makeItemsDescription() );
    } //getLongDescription()

    
    /**
     * Methode testant si au moins un item est present dans la piece.
     * @return un booleen
     */
    public boolean isEmpty()
    {
	return ! this.hasItems();
    } //isEmpty()

    
    /**
     * Methode construisant la description des items presents et leur nombre.
     * @return une String listant les items presents.
     */
    private String makeItemsDescription()
    {
	String vS = super.inventoryString();
	if (vS.equals(""))
	    return "There is nothing to take here.";
	else
	    return "You can see: "+vS;
    } //makeItemsDescription()
    

    /**
     * Accesseur de aImageName
     * @return aImageName (une String)
     */
    public String getImageName()
    {
	return aImageName;
    } //getImageName()


} // Room
