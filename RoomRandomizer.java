import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;

/**
 * classe permettant d'obtenir des Room aléatoires
 * @author Clément Chomicki
 */
public class RoomRandomizer
{

    private HashMap<String, Room> aRooms;
    private String aNext;
    private Random aRNG;

    
    /**
     * Constructeur
     * @param pMap le HashMap des Rooms dont disposera le RoomRandomizer
     */
    public RoomRandomizer(final HashMap<String, Room> pMap)
    {
	this.aRooms = pMap;
	this.aRNG = new Random();
    } //RoomRandomizer()

    
    /**
     * teste si le mot designe une Room de l'objet
     * @param pWord le mot a teste
     * @return un boolean
     */
    public boolean doesExist(final String pWord)
    {
	return this.aRooms.containsKey(pWord);
    } //doesExist()

    
    /**
     * utile pour la commande alea
     * @param pString la String designant la prochaine Room tiree
     */
    public void setNext(final String pString)
    {
	this.aNext = pString;
    } //setNext()


    /**
     * Retourne la Room correspondante a aNext ou une Room aleatoire
     * @return une Room parmis celles possibles
     */
    public Room getRandomRoom()
    {
	if (this.aNext != null)
	    {
		String vNext = this.aNext;
		this.aNext = null;
		return this.aRooms.get(vNext);
	    }
	else
	    {
		ArrayList<Room> vList = new ArrayList<Room>(this.aRooms.values());
		int vI = this.aRNG.nextInt(vList.size());
		return vList.get(vI);
	    }
    } //getRandomRoom()
    
}
