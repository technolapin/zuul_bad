import javax.swing.JTextArea;
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
public class FancyTextArea extends JTextArea
{

    private BufferedImage aImg;

    
    public FancyTextArea(final BufferedImage pImage)
    {
        super();
	this.aImg = pImage;
    }
    public FancyTextArea()
    {
        super();
    }
    
    public void setImage(final BufferedImage pImage)
    {
	this.aImg = pImage;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.aImg,0,0,null);
    }
}
