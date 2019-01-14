import javax.swing.JTextArea;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.Color;

public class FancyTextArea extends JTextArea
{

    private BufferedImage aImg;

    
    public FancyTextArea(final BufferedImage pImage)
    {
        this();
	this.aImg = pImage;
    }
    
    public FancyTextArea()
    {
        super();
	super.setOpaque(false);
	super.setBackground(new Color(10, 23, 0));
	super.setForeground(new Color(150, 180, 100));
	
    }
    
    public void setImage(final BufferedImage pImage)
    {
	this.aImg = pImage;
    }

    /*
    @Override
    protected void paintComponent(Graphics g) {
	Graphics2D g2d = (Graphics2D) g.create();
	g2d.setColor(this.getBackground());
        g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
        if (this.aImg != null) {
            int x = this.getWidth() - this.aImg.getWidth();
            int y = this.getHeight() - this.aImg.getHeight();
            g2d.drawImage(this.aImg, x, y, this);    
        }
	else
	    {
		System.out.println("La frame n'a pas d'image");
	    }
        super.paintComponent(g2d);
        g2d.dispose();
    }
    */
    @Override
    protected void paintComponent(Graphics g) {
	g.setColor(this.getBackground());
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        if (this.aImg != null) {
            int x = this.getWidth() - this.aImg.getWidth();
            int y = this.getHeight() - this.aImg.getHeight();
            g.drawImage(this.aImg, x, y, this);    
        }
	else
	    {
		System.out.println("La frame n'a pas d'image");
	    }
        super.paintComponent(g);
        g.dispose();
    }

}
