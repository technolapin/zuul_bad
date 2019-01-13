public class Beamer extends Item
{
    private Room aDestination;

    public Beamer(final String pDescr, final int pWei)
    {
	super(pDescr, pWei);
    }

    public boolean isCharged()
    {
	return this.aDestination != null;
    }
    
    public void charge(final Room pRoom)
    {
	this.aDestination = pRoom;
    }

    public Room discharge()
    {
	Room vRoom = this.aDestination;
	this.aDestination = null;
	return vRoom;
    }

}
