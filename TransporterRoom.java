import java.util.HashMap;


/**
 * Piece dont les sorties sont aleatoires
 * @author Clément Chomicki
 */
public class TransporterRoom extends Room
{
    
    private RoomRandomizer aNeighborhood;
    
    /**
     * Constructeur
     * @param pDescription La chaine de caractere decrivant la piece.
     * @param pImgName le nom de l'image.
     * @param pMap le HashMap des Rooms dont disposera le RoomRandomizer
     */
    public TransporterRoom(final String pDescription,
			   final String pImgName,
			   final HashMap<String, Room> pMap)
    {
	super(pDescription, pImgName);
	this.aNeighborhood = new RoomRandomizer(pMap);
    } //TransporterRoom()


    /**
     * teste si le mot designe une Room de l'objet
     * @param pWord le mot a teste
     * @return un boolean
     */
    public boolean doesExist(final String pWord)
    {
	return this.aNeighborhood.doesExist(pWord);
    } //doesExist()
    

    /**
     * utile pour la commande alea
     * @param pString la String designant la prochaine Room tiree
     */
    public void setNext(final String pString)
    {
	this.aNeighborhood.setNext(pString);
    } //setNext()
    
    
    /**
     * Retourne la piece direction demandee (ici totalement aléatoire)
     * @param pDirection  La chaine de caractere indiquant la direction.
     * @return La piece sortie demandee.
     */
    @Override
    public Room getExit(final String pDirection)
    {
        return this.aNeighborhood.getRandomRoom();
    } // getExit

    
}
