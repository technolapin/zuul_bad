public class Item
{
    private String aDescription;
    private int aWeight;

    public Item( final String pDescr, final int pWei )
    {
	this.aDescription = pDescr;
	this.aWeight      = pWei;
    }

    public String
	getDescription()
    {
	return this.aDescription;
    }
    public int
	getWeight()
    {
	return this.aWeight;
    }
}
