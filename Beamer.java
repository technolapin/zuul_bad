/**
 * Item permettant de se téléporter
 */
public class Beamer extends Item
{
    private Room aDestination;


    /**
     * constructeur de la classe
     * @param pDescr la description de l'item
     * @param pWei le poids de l'item
     */
    public Beamer(final String pDescr, final int pWei)
    {
	super(pDescr, pWei);
    } //Beamer()


    /**
     * Teste si le beamer est charge
     * @return true si le beamer est charge
     */
    public boolean isCharged()
    {
	return this.aDestination != null;
    } //isCharged()

    
    /**
     * charge le beamer
     * @param pRoom la piece dans laquelle on charge le beamer
     */
    public void charge(final Room pRoom)
    {
	this.aDestination = pRoom;
    } //charge()

    
    /**
     * decharge le beamer (lors de son utilisation pour se teleporter)
     * @return la piece stockee dans le beamer
     */
    public Room discharge()
    {
	Room vRoom = this.aDestination;
	this.aDestination = null;
	return vRoom;
    } //discharge()

}
