package projet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

@SuppressWarnings("serial")


/**
 * 
 * Classe pour poser des questions
 * Classe fille de la classe principale Calculatrice
 * @author Florian
 *
 */


public class Questions extends Calculatrice {
	
	private JButton reponse, lien;
	private String phrase = "";
	
	
	
	/**
	 * méthode fenetre()
	 * sert à initialiser la fenêtre
	 * 
	 */
	
	public void fenetre()
	{
		window = new JFrame("Calculatrice");
		window.setSize(500, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);	
		
		l = new JTextField(10);
		l.setFont(new Font("Serif", Font.BOLD, 50));
		window.add(l, BorderLayout.NORTH);	
		
		p = new JPanel();
		grille = new GridLayout(1, 1, 1, 1);
		p.setLayout(grille);
		p.setBackground(Color.black);
		
		p1 = new JPanel();
		grille1 = new GridLayout(1, 1, 1, 1);
		p1.setLayout(grille);
		p1.setBackground(Color.black);
	}
	
	
	/**
	 * 
	 * méthode boutons()
	 * sert à initialiser tous les boutons
	 * 
	 */
	
	public void boutons()
	{
		reponse = new JButton("Réponse !");
		p.add(reponse);
		reponse.setFont(new Font("Serif", Font.BOLD, 20));
		
		dec = new JButton("Décimal");
		p.add(dec);
		dec.setFont(new Font("Serif", Font.BOLD, 20));
		
		cor = new JButton("C");
		p.add(cor);
		cor.setFont(new Font("Serif", Font.BOLD, 20));
		cor.setBackground(Color.red);
		cor.setForeground(Color.white);
		
		lien = new JButton("Lien vers Unistra");
		p1.add(lien);
		lien.setFont(new Font ("Serif", Font.BOLD, 20));
		
		window.add(p, BorderLayout.CENTER);
		window.add(p1, BorderLayout.SOUTH);
		window.setVisible(true);
		
		reponse.addActionListener(this);
		dec.addActionListener(this);
		cor.addActionListener(this);
		lien.addActionListener(this);
	}

	
	/**
	 * 
	 * méthode actionPerfomed(ActionEvent e)
	 * sert à assigner des événements aux boutons
	 * 
	 */
	
	public void actionPerformed (ActionEvent e)
	{	
		if(e.getSource() == reponse)
		{
			phrase = l.getText();
			
			switch(phrase)
			{
				case "" : 					
					l.setText("Entrer quelque chose !");
					break;
				
				case "date" : 
				case "DATE" : 
				case "Date" : 					
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
					LocalDateTime now = LocalDateTime.now();
					l.setText(dtf.format(now));
					break;
				
				case "nom" : 
				case "NOM" : 
				case "Nom" : 					
					String nom = System.getProperty("user.name");
					l.setText(nom);
					break;
					
				case "version" : 
				case "VERSION" : 
				case "Version" :					
					String version = System.getProperty("java.version");
					l.setText(version);
					break;
					
				case "jaune" :
				case "Jaune" :
				case "JAUNE" : 					
					cor.setBackground(Color.yellow);
					break;
					
				default : 
					l.setText("Question inconnue !");
					break;
			}
			
		}
		
		if(e.getSource() == dec && l.getText().isEmpty())
		{
			new Calculatrice();
		}
		
		if(e.getSource() == cor)
		{
			l.setText("");
		}
		
		if(e.getSource() == lien && l.getText().isEmpty())
		{
			new Lien().setVisible(true);
		}
	}
	
	public Questions()
	{
		super();		
	}

}
