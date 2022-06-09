package projet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

@SuppressWarnings("serial")


/**
 * 
 * Classe Lien qui affiche un lien vers le site de l'Unistra
 * Classe fille de la classe principale Questions
 * @author Florian
 *
 */

public class Lien extends Questions {
		
	private String str = "www.unistra.fr";
    private JLabel lien = new JLabel(str);
 
    public Lien() throws HeadlessException 
    {
        lien.setForeground(Color.BLUE.darker());
        lien.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lien.setFont(new Font("Serif", Font.BOLD, 70));
 
        lien.addMouseListener(new MouseAdapter() 
        {
            public void mouseClicked(MouseEvent e) 
            {
                try 
                {
                    Desktop.getDesktop().browse(new URI("https://unistra.fr/"));
                } 
                catch (IOException | URISyntaxException e1) 
                {
                    e1.printStackTrace();
                }
            }
        });
 
        setLayout(new FlowLayout());
        getContentPane().add(lien);
        setTitle("Lien vers Unistra");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}
