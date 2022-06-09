package projet;

import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Color;

@SuppressWarnings("serial")


/**
 * 
 * Classe Courbe qui sert à l'affichage de la courbe
 * Classe fille de la classe principale Calculatrice
 * @author Florian
 *
 */


public class Courbe extends Calculatrice 
{
	private Dimension dimension;
	private Image imageBuffer;
	private Dimension imageBufferSize;
	private Graphics imageBufferGraphics;
	private float x, y;
	
	public Courbe(Dimension dimension) 
	{
		this.setDimension(dimension);
		setBackground(Color.white);
	}
	
	/**
	 * 
	 * méthode paint(Graphics g)
	 * sert à afficher la courbe
	 * 
	 */
	
	public void paint(Graphics g) 
	{
		update(g);
	}
	
	
	/**
	 * 
	 * méthode update(Graphics g)
	 * gère la courbe
	 * 
	 */
	
	public void update(Graphics g) 
	{
		// Création du buffer image dans lequel on dessine
		if ((imageBuffer == null) || (getSize().width != imageBufferSize.width) || (getSize().height != imageBufferSize.height)) 
		{
			imageBuffer = createImage(getSize().width, getSize().height);
			imageBufferSize = getSize();
			imageBufferGraphics = imageBuffer.getGraphics();
			imageBufferGraphics.setFont(getFont());
		}
		// On efface le buffer image
		imageBufferGraphics.setColor(getBackground());
		imageBufferGraphics.fillRect(0, 0, getSize().width, getSize().height);
			
		// Calcul de la courbe	
		float xMin = (float)-10;
		float xMax = (float)10;
		
		int xEcran;
		int yEcran;
		
		int xEcranPrec = Integer.MIN_VALUE ;
		int yEcranPrec = Integer.MIN_VALUE;
		
		
		float fX = (float)getWidth() / (xMax-xMin);
		
		imageBufferGraphics.setColor(Color.red);
		
		for (xEcran=0; xEcran <= getWidth(); xEcran++)
		{
			x = (float)xEcran / fX + xMin;
			y = a * (float)Math.pow(x, n) + b; 
			
			yEcran = getHeight() - Math.round(fX * y);
		
			if ((xEcranPrec != Integer.MIN_VALUE) && (yEcranPrec != Integer.MIN_VALUE)) 
			{
				// Dessin de la courbe dans le buffer image
				imageBufferGraphics.drawLine(xEcranPrec, yEcranPrec, xEcran, yEcran);
			}
			xEcranPrec = xEcran;
			yEcranPrec = yEcran;
		}
		
		// Dessin du buffer image dans le panel
		g.drawImage(imageBuffer, 0, 0, getSize().width, getSize().height, null);
	}

	/**
	 * 
	 * méthode getDimension()
	 * getter de dimension
	 * @return dimension
	 * 
	 */
	
	public Dimension getDimension()
	{
		return dimension;
	}
	
	/**
	 * 
	 * méthode setDimension(Dimension dimension)
	 * setter de dimension
	 * @param dimension
	 * 
	 */

	public void setDimension(Dimension dimension) 
	{
		this.dimension = dimension;
	}
}