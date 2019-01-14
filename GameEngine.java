import java.util.HashMap;
import java.util.Stack;
import java.net.URL;
import java.util.Scanner;
import java.io.IOException;
import java.lang.NullPointerException;


/**
 * La classe gerant le jeu.
 */
public class GameEngine
{
    private Parser aParser;
    private UserInterface aGui;
    private HashMap<String, Room> aRooms;
    private Player aPlayer;
    private int aTimeLimit;
    private int aTimeSpent;


    /**
     * Constructeur de la classe
     */
    public GameEngine()
    {
        this.aParser = new Parser();
	this.aRooms  = new HashMap<String, Room>();
	this.aPlayer = new Player("Anon");
	this.aTimeLimit = 200;
	this.aTimeSpent = 0;
        createRooms();
    } //GameEngine()
    

    /**
     * Initie aGui
     * @param userInterface: l'interface du jeu
     */
    public void setGUI(final UserInterface userInterface)
    {
        this.aGui = userInterface;
        this.printWelcome();
    } //setGUI()

    
    /**
     * Procedure affichant la description de la piece et les sorties.
     */
    private void printLocationInfos()
    {
	this.aGui.println ( this.aPlayer.getLocation().getLongDescription() );
    } //printLocationInfos()

    
    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        this.aGui.println ( "Welcome to “Within the Woods”" );
        this.aGui.println ( "Type 'help' if you want help (you won't get any)." );
	this.printLocationInfos();
        this.aGui.showImage(aPlayer.getLocation().getImageName());
    } //printWelcome()
    

    /**
     * Procedure creant les pieces et les reliant entre elles.
     */
    private void createRooms ()
    {
	String vFolder = "Ressources/Images";
	String vFormat = "png";

	String vImgForest    = vFolder+"/"+"dryads_res"+"."+vFormat;
	
	String vImgDryads  = vFolder+"/"+"dryads_res"+"."+vFormat;
	String vImgNaiads  = vFolder+"/"+"naiads_res"+"."+vFormat;
	String vImgFaun    = vFolder+"/"+"faun_res"+"."+vFormat;
	String vImgFlowers = vFolder+"/"+"flowers_res"+"."+vFormat;
	String vImgCave    = vFolder+"/"+"sanctuary_res"+"."+vFormat;
	String vImgShrooms = vFolder+"/"+"shrooms_res"+"."+vFormat;
	String vImgSquirel = vFolder+"/"+"squirel_res"+"."+vFormat;
	String vImgWitch   = vFolder+"/"+"witch_res"+"."+vFormat;
	String vImgCorgy   = vFolder+"/"+"corgy.jpg";

	Room vSpirit  = new Room ("in a strange forest. You feel observed.", vImgForest);

	
	Room vForest  = new Room ("lost in the forest.", vImgForest);
	Room vForest1 = new Room ("lost in the forest.", vImgForest);
	Room vForest2 = new Room ("lost in the forest.", vImgForest);
	Room vForest3 = new Room ("lost in the forest.", vImgForest);
	Room vWitch   = new Room ("at the wicked witch's house.", vImgWitch);
	Room vNaiads  = new Room ("in a warm, enlighted and clean cave with some kinds of clear ponds.", vImgNaiads);
	Room vDryads  = new Room ("in a dense and dark part of the forest.", vImgDryads);
	Room vCave    = new Room ("surrounded by calm darknesses.\nThe water is clean and warm and the walls are veined by a phosphorescent mineral.\nYou feel comfortable.", vImgCave);
	Room vFaun    = new Room ("near a convenient house-shaped tree.", vImgFaun);
	Room vShrooms = new Room ("surrounded by mushrooms. They are absolutly everywhere.", vImgShrooms);
	Room vSquirel = new Room ("at some big tree with an hole in it.", vImgSquirel);
	Room vFlower  = new Room ("in a warm and windy glade, covered by nice and odorant flowers of all sort.", vImgFlowers);

	aRooms.put("spirit", vSpirit);
	vSpirit.setExit("north", vForest);
	vSpirit.setExit("south", vForest);
	vSpirit.setExit("east", vForest);
	vSpirit.setExit("west", vForest);
	
	aRooms.put ( "forest" , vForest  );
	aRooms.put ( "forest1", vForest1 );
	aRooms.put ( "forest2", vForest2 );
	aRooms.put ( "forest3", vForest3 );
	aRooms.put ( "witch"  , vWitch   );
 	aRooms.put ( "naiads" , vNaiads  );
 	aRooms.put ( "dryads" , vDryads  );
	aRooms.put ( "cave"   , vCave    );
 	aRooms.put ( "faun"   , vFaun    );
 	aRooms.put ( "shrooms", vShrooms );
 	aRooms.put ( "squirel", vSquirel );
 	aRooms.put ( "flower" , vFlower  );
     
	vWitch.setExit ( "south", vDryads );
	vWitch.setExit ( "north", vForest );
	vWitch.setExit ( "east" , vForest );
	vWitch.setExit ( "west" , vForest );
	vWitch.setExit ( "south-east" , vFlower );
	
	vNaiads.setExit ( "south", vForest );
	vNaiads.setExit ( "north", vDryads );
	vNaiads.setExit ( "east" , vFaun   );
	vNaiads.setExit ( "west" , vForest );
	vNaiads.setExit ( "down" , vCave   );
    
	vCave.setExit ("up", vNaiads );

	vDryads.setExit ( "south", vNaiads );
	vDryads.setExit ( "north", vWitch  );
	vDryads.setExit ( "east" , vFlower );
	vDryads.setExit ( "west" , vForest );

	vFaun.setExit ( "south", vForest );
	vFaun.setExit ( "north", vFlower );
	vFaun.setExit ( "east" , vForest );
	vFaun.setExit ( "west" , vNaiads );

	vShrooms.setExit ( "south", vForest );
	vShrooms.setExit ( "north", vSquirel);
	vShrooms.setExit ( "east" , vForest );
	vShrooms.setExit ( "west" , vFlower );

	vSquirel.setExit ( "north", vForest );
	vSquirel.setExit ( "south", vShrooms);
	vSquirel.setExit ( "east" , vForest );
	vSquirel.setExit ( "west" , vForest );

	vFlower.setExit ( "south", vFaun   );
	vFlower.setExit ( "north", vForest );
	vFlower.setExit ( "east" , vShrooms);
	vFlower.setExit ( "west" , vDryads );
	vFlower.setExit ( "north-west" , vWitch );


	vForest.setExit ( "south", vForest1 );
	vForest.setExit ( "north", vForest  );
	vForest.setExit ( "east" , vForest2 );
	vForest.setExit ( "west" , vForest1 );

	vForest1.setExit ( "south", vForest2 );
	vForest1.setExit ( "north", vForest3 );
	vForest1.setExit ( "east" , vForest  );
	vForest1.setExit ( "west" , vForest1 );

	vForest2.setExit ( "south", vForest  );
	vForest2.setExit ( "north", vForest3 );
	vForest2.setExit ( "east" , vForest1 );
	vForest2.setExit ( "west" , vForest2 );

	vForest3.setExit ( "south", vFaun    );
	vForest3.setExit ( "north", vFlower  );
	vForest3.setExit ( "east" , vDryads  );
	vForest3.setExit ( "west" , vForest  );


	Item vDague   = new Item("dagger", 8);
	Item vTheiere = new Item("teapot", 1);
	Item vFleur   = new Item("flower", 0);
	Item vNoix    = new Item("nut", 2);

	Item vCailloux = new Beamer("stone", 1);
	Item vPantalon = new Item("trouser", 1);
	vDryads.addItem  ( vTheiere );
	vSquirel.addItem ( vDague );
	vFlower.addItem   ( vFleur );
	vFlower.addItem   ( vFleur );
	vShrooms.addItem ( vNoix, 666 );
	vForest.addItem   ( vCailloux );
	vForest.addItem   ( vPantalon );

	this.aPlayer.setMaxWeight(2);
	this.aPlayer.setLocation(vSpirit);
	
    } //createRooms()

    
    /**
     * Methode traitant une commande.
     * @param pCommandLine: String entree
     */
    public void interpretCommand (final String pCommandLine)
    {
	this.aGui.println(pCommandLine);
        Command vCommand = this.aParser.getCommand(pCommandLine);

        if (vCommand.isUnknown())
	    {
		this.aGui.println ( "I don't know what you mean..." );
	    }
        else
	    switch (vCommand.getCommandWord())
		{
		case GO   :
		    this.goRoom(vCommand);
		    break;
		    
		case HELP :
		    this.printHelp();
		    break;

		case QUIT :
		    if ( vCommand.hasSecondWord() )
			aGui.println("Quit what?");
		    else
			this.endGame();
		    break;
		    
		case LOOK :
		    this.look();
		    break;

		case EAT  :
		    this.eat(vCommand);
		    break;

		case BACK :
		    this.back( vCommand );
		    break;

		case TEST :
		    this.test(vCommand);
		    break;

		case TAKE : 
		    this.take( vCommand );
		    break;

		case DROP : 
		    this.drop( vCommand );
		    break;

		case ITEMS:
		    this.items( vCommand );
		    break;

		case STONE:
		    this.stone( vCommand );
		    break;
		    
		default               :
		    this.aGui.println ( "Looks like the dev forgot to implement that command but yet whitelisted it." );
		}

    } // interpretCommand()


    /**
     * procedure appellee par la commande stone
     * @param pCommand la commande entree
     */
    public void stone(final Command pCommand)
    {
	Beamer vStone = (Beamer) this.aPlayer.getItemByName("stone");
	if ( vStone == null)
	    this.aGui.println("You don't have any stone.");
	    
	else if ( pCommand.hasSecondWord() )
	    {
	        String vWord = pCommand.getSecondWord();
		if (vWord.equals("infuse")) {
		    vStone.charge(this.aPlayer.getLocation());
		    this.aGui.println("The stone takes the colour of the ambiant light.");
		}
		else if (vWord.equals("jump") )
		    {
			if ( vStone.isCharged() )
			    {
				this.aGui.println("You look into the stone, the stone look into you. Your surroundings changed without you noticing it.");
				Room vDestination = vStone.discharge();
				this.aPlayer.resetStack();
				this.changeRoom( vDestination );
			    }
			else
			    this.aGui.println("Your look into the stone. Your mind get lost in its plain gray color. You suddendly realize you're getting nowhere.");
		    }
		else
		    this.aGui.println("Stop doing that to the stone!");
	    }
	else
	    this.aGui.println("You put the stone on your head. It has no effect.");
	
    } //stone()
    
    
    /**
     * Procedure appelee par la commande 'items'
     * @param pCommand une commande dont on sait que le mot-commande est 'items'
     */
    private void items( final Command pCommand )
    {
	if ( pCommand.hasSecondWord() )
	    this.aGui.println("That doesn't make any sense");
	else
	    this.aGui.println(this.aPlayer.makeItemsDescription());
			
    } //items()

    
    /**
     * Procedure appelee par la commande 'take'
     * @param pCommand une commande dont on sait que le mot-commande est 'take'
     */
    private void take( final Command pCommand )
    {
	if ( pCommand.hasSecondWord() )
	    {
		String vSec = pCommand.getSecondWord();
		Room vLocation = this.aPlayer.getLocation();
		Item vItem  = vLocation.getItemByName( vSec );
		if (vItem == null)
		    this.aGui.println( "This isn't something you can take." );
		else if (this.aPlayer.canCarryItem( vItem) )
		{
		    this.aPlayer.addItem( vItem );
		    vLocation.removeItem( vItem );
		    this.aGui.println( "You took a " + vSec );
		}
		else
		    this.aGui.println("You cannot carry more weight.");
	    }
	else
	    {
		this.aGui.println ( "Take what?" );	    }
    } //take()

    
    /**
     * Procedure appelee par la commande 'drop'
     * @param pCommand une commande dont on sait que le mot-commande est 'drop'
     */
    private void drop( final Command pCommand )
    {
	if ( pCommand.hasSecondWord() )
	    {
		String vSec = pCommand.getSecondWord();
		Room vLocation = this.aPlayer.getLocation();
		Item vItem  = this.aPlayer.getItemByName( vSec );
		if (vItem == null)
		    this.aGui.println( "You don't have this." );
		else {
		    this.aPlayer.removeItem( vItem );
		    vLocation.addItem( vItem );
		    this.aGui.println( "You dropped a " + vSec );
		}
	    }
	else
	    {
		this.aGui.println ( "Drop what?" );	    }
    } //drop()

    
    /**
     * Procedure appelee par la commande 'eat'
     * @param pCommand une commande dont on sait que le mot-commande est 'eat'
     */
    private void eat ( final Command pCommand )
    {
	if ( pCommand.hasSecondWord() )
	    {
		if ( pCommand.getSecondWord().equals("nut") )
		    {
			Item vNut = this.aPlayer.getItemByName("nut");
			if (vNut == null)
			    this.aGui.println( "You don't have anything to eat." );
			else
			    {
				this.aPlayer.removeItem( vNut );
				this.aPlayer.setMaxWeight(this.aPlayer.getMaxWeight()+1);
				this.aGui.println( "You just ate a nut.\nYou feel good, stronger than ever." );
			    }
		    }
		else
		    this.aGui.println("You can't eat that.");
	    }
	else
	    this.aGui.println("You try to eat thin air. You kind of like it.");
    } //eat()

    
    /**
     * Procedure appelee par la commande 'look'
     */
    private void look ()
    {
	this.printLocationInfos();
    } // look()

    
    /**
     * Procedure affichant l'aide.
     */
    private void printHelp ()
    {
	this.aGui.println( "You are lost in this mysterious forest.\nYour command words are:" );   
	this.aGui.println( this.aParser.getCommandList() );
    } //printHelp()

    
    /**
     * Methode changeant la piece courrante et appellant l'affichage de description de la nouvelle piece.
     * @param pNextRoom: Room dans laquelle on se deplace
     */
    private void changeRoom( final Room pNextRoom )
    {
	this.aPlayer.setLocation( pNextRoom );
	this.printLocationInfos();
	if (this.aPlayer.getLocation().getImageName() != null)
	    this.aGui.showImage(aPlayer.getLocation().getImageName());
    } //changeRoom()

    
    /**
     * Procedure changeant la piece courante.
     * @param pCommand objet Command dont on sait que le premier mot est 'go'
     */
    private void goRoom (final Command pCommand)
    {
        if ( ! pCommand.hasSecondWord() )
	    {
		this.aGui.println("Go where?");
		return;
	    }
        
        Room vNextRoom = this.aPlayer.getLocation().getExit ( pCommand.getSecondWord() );
        if (vNextRoom == null) {
           this.aGui.println ( "There is no door!" );
        } else {
	    if ( vNextRoom.isExit(this.aPlayer.getLocation()) )
		{
		    this.aPlayer.pushPreviousLocation( vNextRoom );
		}
	    else
		{
		    this.aPlayer.resetStack();
		}
	    this.changeRoom( vNextRoom );
	    this.addTime();
        }
    } //goRoom()


    /**
     * incremente le temps passe de 1
     */
    private void addTime()
    {
	this.aTimeSpent += 1;
	if (this.aTimeSpent >= this.aTimeLimit)
	    looseGame();
    } //addTime()

    
    /**
     * Methode permettant de revenir en arriere
     * @param pCommand: commande entree
     */
    private void back( final Command pCommand )
    {
	if ( pCommand.hasSecondWord() )
	    {
		this.aGui.println("Backstreet's back alright!");
	    } else
	    {
		if ( this.aPlayer.hasNoPreviousLocations() )
		    this.aGui.println ( "There is no going back." );
		else
		    this.changeRoom( this.aPlayer.goToPreviousLocation() );
	    }
    } //back()

    
    /**
     * Methode appellee par la commande test
     * @param pCommand: commande entree
     */
    private void test( final Command pCommand )
    {
	if ( pCommand.hasSecondWord() )
	    {
		String vName = pCommand.getSecondWord();
		if (! vName.matches(".*.txt") )
		    vName += ".txt";
		
		Scanner vScript = RessourcesFetcher.openScript( vName );
		if (! (vScript == null) )
		    {
			while ( vScript.hasNextLine() )
			    {
				this.interpretCommand( vScript.nextLine() );
			    }
		    }
	    } else {
	    this.aGui.println ( "Please specify the script to use." );
	}
    } //test()


    /**
     * @return la description de la piece courante
     */
    private String getCurrentRoomName()
    {
	return this.aPlayer.getLocation().getDescription();
    } //getCurrentRoomName()

	
    /**
     * @param pRoomName la description d'une piece
     * @return un booleen
     */
    private boolean estDansPiece( final String pRoomName )
    {
	return this.aPlayer.getLocation().getDescription().equals( pRoomName );
    } //estDansPiece()

    
    /**
     * Procedure de meurtre
     */
    private void kill()
    {
	if ( this.aPlayer.getLocation() == this.aRooms.get("witch") )
	    winGame();
	else
	    looseGame();
    } //kill()

    
    /**
     * Procedure de victoire
     */
    private void winGame()
    {
	this.aGui.println("You win!");
	endGame();
    } //winGame()

    
    /**
     * Procedure de defaite
     */
    private void looseGame()
    {
	this.aGui.println("You lost!");
	endGame();
    } //looseGame()

    
    /**
     * Procedure terminant le jeu.
     */
    private void endGame()
    {
	this.aGui.println("Thank you for playing.  Good bye.");
        this.aGui.enable(false);
    } //endGame()

    
}
