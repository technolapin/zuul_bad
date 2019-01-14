/**
 * classe mère de Room et Player
 */
public abstract class Entity
{
    private String    aName;
    private Inventory aInventory;

    /** Constructeur de la classe
     * @param pN le nom de l'entite (sa description courte)
     */
    public Entity( final String pN )
    {
	this.aName      = pN;
	this.aInventory = new Inventory();
    } //Entity()

    /**
     * Accesseur de aName
     * @return le nom de l'entite
     */
    public String getName()
    {
	return this.aName;
    } //getName()
    
    /**
     * Cherche un item dans l'inventaire de l'entite via son nom
     * @param pItemName le nom de l'item cherche
     * @return un item ou null
     */
    public Item getItemByName( final String pItemName )
    {
	return this.aInventory.getByName( pItemName );
    } //getItemByName()
    
    /**
     * Verifie la presence d'un item dans l'inventaire
     * @param pItem l'item cherche
     * @return un booleen traduisant la presence de l'item
     */
    public boolean hasItem( final Item pItem )
    {
	return this.aInventory.hasItem( pItem );
    } //hasItem()

    /**
     * Verifie si l'inventaire contient au moins un item
     * @return un booleen
     */
    public boolean hasItems()
    {
	return (! this.aInventory.isEmpty());
    } //hasItems()
    
    /**
     * ajoute un item a l'inventaire
     * @param pItem l'item a ajouter
     */
    public void addItem( final Item pItem )
    {
	this.aInventory.add( pItem );
    } //addItem()

    /**
     * ajoute des items a l'inventaire
     * @param pItem l'item a ajouter
     * @param pNombre le nombre de fois que pItem doit etre ajoute
     */
    public void addItem( final Item pItem, final int pNombre )
    {
	this.aInventory.add( pItem, pNombre);
    } //addItem()

    /**
     * retire un item de l'inventaire
     * @param pItem l'item a supprimer
     */
    public void removeItem( final Item pItem )
    {
	this.aInventory.remove( pItem );
    } //removeItem()
    
    /**
     * Retourne une chaine decrivant le contenu de l'inventaire
     * @return une chaine decrivant le contenu de l'inventaire
     */
    public String inventoryString()
    {
	return this.aInventory.toString();
    } //inventoryString()
 
    /**
     * retourne le poids total
     *@return le poids total
     */
    public int getCarriedWeight()
    {
	return this.aInventory.totalWeight();
    } //getCarriedWeight()

}
