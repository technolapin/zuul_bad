import java.net.URL;
import java.util.Scanner;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;


public class RessourcesFetcher
{

    /**
     * Find the file requested
     * @return an URL indicating the emplacement of the requested file OR null if the file doesn't exist/the filename is invalid.
     * @param pName the name of the file
     * @param pType the Subfolder of Ressources/ the file should be in.
     */
    static public URL findRessource( final String pName, final String pType)
    {
	if ( pName.matches("[a-zA-Z_0-9]*.[a-zA-Z_0-9]*") )
	    {
		String vPath = "Ressources/" + pType + "/" + pName; 
		URL vURL = RessourcesFetcher.class.getClassLoader().getResource( vPath );
		//		URL vURL = this.getClass().getClassLoader().getResource( vPath );
		if (vURL == null)
		    System.out.println ( "Ressource not found: " + vPath );
		return vURL;
	    }
	else {
	    System.out.println ( "Invalid file name" );
	    return null;
	}

    } //findRessource()


    /**
     * Tries to open a script
     * @return a Scanner of the text file OR null
     * @param pName the name of the script (with or without '.txt' at the end)
     */
    static public Scanner openScript( final String pName )
    {
	URL vURL = RessourcesFetcher.findRessource( pName, "Scripts" );
	try {
	    return new Scanner( vURL.openStream() );
	}
	catch (NullPointerException e) {
	    return null;
	}
	catch (IOException e) {
	    return null;
	}
    } //openScript()

    /**
     * Tries to open an Image
     * @return a BufferedImage OR null
     * @param pName the name of the Image
     */
    static public BufferedImage openImage( final String pName )
    {
	URL vURL = RessourcesFetcher.findRessource( pName+".jpg", "Images" );
	BufferedImage vImg;
	
	try {
	    vImg = ImageIO.read(vURL);
	}
	catch(Exception pE)
	    {
		System.out.println("Erreur: Image manquante!");
		vImg = null;
	    }
	return vImg;

	
    } //openImage()

}
