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

@SuppressWarnings("serial")

/**
 * 
 * Classe pour le binaire 
 * Classe fille de la classe principale Calculatrice
 * @author Florian
 *
 */

public class CalcBin extends Calculatrice 
{
	private static int num = 0, num2 = 0;
	
	
	/**
	 * méthode fenetre()
	 * sert à initialiser la fenêtre
	 * 
	 */

	public void fenetre()
	{
		window = new JFrame("Calculatrice binaire");
		window.setSize(500, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);	
		
		l = new JTextField(10);
		l.setFont(new Font("Serif", Font.BOLD, 50));
		window.add(l, BorderLayout.NORTH);	
		l.setEditable(false);
	
		p = new JPanel();
		grille = new GridLayout(2, 2, 1, 1);
		p.setLayout(grille);
		p.setBackground(Color.black);
		
		p1 = new JPanel();
		grille1 = new GridLayout(3, 1, 1, 1);
		p1.setLayout(grille1);
		p1.setBackground(Color.black);
		
		p2 = new JPanel();
		grille2 = new GridLayout(2, 1, 1, 1);
		p2.setLayout(grille2);
		p2.setBackground(Color.black);
		
		p3 = new JPanel();
		grille3 = new GridLayout(1, 2, 1, 1);
		p3.setLayout(grille3);
		p3.setBackground(Color.black);
	}
		
	
	/**
	 * 
	 * méthode boutons()
	 * sert à initialiser tous les boutons
	 * 
	 */
	
	public void boutons()
	{	
		zero = new JButton("0");
		p.add(zero);
		zero.setFont(new Font("Serif", Font.BOLD, 20));
		
		un = new JButton("1");
		p.add(un);
		un.setFont(new Font("Serif", Font.BOLD, 20));
		
		//nombre négatif
		neg = new JButton("(-)");
		p.add(neg);
		neg.setFont(new Font("Serif", Font.BOLD, 20));
		
		//opérateurs	
		moins = new JButton("    -    ");
		p1.add(moins);
		moins.setFont(new Font("Serif", Font.BOLD, 20));
		moins.setBackground(Color.orange);
		
		plus  = new JButton("    +    ");
		p1.add(plus);	
		plus.setFont(new Font("Serif", Font.BOLD, 20));
		plus.setBackground(Color.orange);
		
		egal  = new JButton("    =    ");
		p1.add(egal); 
		egal.setFont(new Font("Serif", Font.BOLD, 20));
		egal.setBackground(Color.orange);
		
		//effacer une ligne
		cor = new JButton("C");
		p2.add(cor);
		cor.setFont(new Font("Serif", Font.BOLD, 20));
		cor.setBackground(Color.red);
		cor.setForeground(Color.white);
		
		//effacer un caractère
		del = new JButton("Del");
		p2.add(del);
		del.setFont(new Font("Serif", Font.BOLD, 20));
		del.setBackground(Color.red);
		del.setForeground(Color.white);
		
		//fonctions supplémentaires
		
		//notation décimale, octale, binaire, hexadécimale
		dec = new JButton("Décimal");
		p3.add(dec);
		dec.setFont(new Font("Serif", Font.BOLD, 20));
		
		oct = new JButton("Octal");
		p3.add(oct);
		oct.setFont(new Font("Serif", Font.BOLD, 20));
		
		hex = new JButton("Héxa");
		p3.add(hex);
		hex.setFont(new Font("Serif", Font.BOLD, 20));
		
		window.add(p, BorderLayout.CENTER);
		window.add(p1, BorderLayout.EAST);
		window.add(p2, BorderLayout.WEST);
		window.add(p3, BorderLayout.SOUTH);
		window.setVisible(true);
			
		un.addActionListener(this);
		
		zero.addActionListener(this);
		
		neg.addActionListener(this);
			
		moins.addActionListener(this);
		
		plus.addActionListener(this);
		
		egal.addActionListener(this);
		
		cor.addActionListener(this);
		
		del.addActionListener(this);
		
		dec.addActionListener(this);
	
		oct.addActionListener(this);
		
		hex.addActionListener(this);		
	}
	
	
	/**
	 * 
	 * méthode actionPerfomed(ActionEvent e)
	 * sert à assigner des événements aux boutons
	 * 
	 */
		
	public void actionPerformed (ActionEvent e)
	{
		if(e.getSource() == zero && !(l.getText().contains("=")) && !(l.getText().contains("Erreur division par 0")))
		{
			l.setText(l.getText().concat("0"));
		}
		if(e.getSource() == un && !(l.getText().contains("=")) && !(l.getText().contains("Erreur division par 0")))
		{
			l.setText(l.getText().concat("1"));
		}
		
		if(e.getSource() == cor)
		{
			l.setText("");
			operateur = 0;
			resultat = 0;
			op1 = 0;
			op2 = 0;
		}
		
		if(e.getSource() == del && !(l.getText().equals("")) && !(l.getText().contains("=")) && !(l.getText().contains("Erreur division par 0")))
		{
			l.setText("" + l.getText().substring(0, l.getText().length() - 1));
		}
		
		if(e.getSource() == plus && !(l.getText().contains("Erreur division par 0")) && !(l.getText().contains("=")))
		{
			if(resultat != 0)
			{
				op1 = resultat;
			}
			else
			{
				if(!(l.getText().isEmpty()))
				{
					op1 = Double.parseDouble(l.getText());
					num = Integer.parseInt(Integer.toString((int)op1), 2);
				}
				else 
				{
					throw new ArithmeticException("Il manque un nombre");
				}				
			}
			operateur = op_plus;
			l.setText("");
		}
		
		if(e.getSource() == moins && !(l.getText().contains("Erreur division par 0")) && !(l.getText().contains("=")))
		{
			if(resultat != 0)
			{
				op1 = resultat;
			}
			else
			{
				if(!(l.getText().isEmpty()))
				{
					op1 = Double.parseDouble(l.getText());
					num = Integer.parseInt(Integer.toString((int)op1), 2);
				}
				else 
				{
					throw new ArithmeticException("Il manque un nombre");
				}
			}
			operateur = op_moins;
			l.setText("");
		}
		
		if(e.getSource() == neg && !(l.getText().contains("=")) && !(l.getText().contains("Erreur division par 0")))
		{
			if(op1 == 0)
			{
				if(!(l.getText().isEmpty()))
				{
					op1 = Double.parseDouble(l.getText());
					op1 *= -1;
					l.setText("-" + l.getText());
				}
				else 
				{
					throw new ArithmeticException("Il manque un nombre");
				}			
			}
			else
			{
				if(!(l.getText().isEmpty()))
				{
					op2 = Double.parseDouble(l.getText());
					op2 *= -1;
					l.setText("-" + l.getText());
				}
				else 
				{
					throw new ArithmeticException("Il manque un nombre");
				}
			}
		}
		
		if(e.getSource() == egal && !(l.getText().contains("Erreur division par 0")))
		{
			op2 = Double.parseDouble(l.getText());
			num2 = Integer.parseInt(Integer.toString((int)op2), 2);
			/*int temp = 0;
			int j = 0;
			int taille = Double.toString(op2).length();
			for(int i =  taille - 3; i >= 0; i--)
			{				
				if(Double.toString(op2).charAt(i) == '1')
				{
					temp += Math.pow(2, j);					
				}
				j++;
			}
			op2 = temp;*/
			
			switch(operateur)
			{
				case op_plus :
					String str = Integer.toBinaryString((int)(num + num2));
					if(op1 + op2 < 0)
					{
						resultat = 0;
					}
					else
					{
						resultat = Double.parseDouble(str);
					}
					signe = "+";
					break;
					
				case op_moins : 
					String str1 = Integer.toBinaryString((int)(num - num2));
					if(op1 - op2 < 0)
					{
						resultat = 0;
					}
					else
					{
						resultat = Double.parseDouble(str1);
					}	
					signe = "-";
					break;
					
				default : 
					resultat = op2;
			}
			
			if(!signe.isEmpty())
			{
				l.setText(op1 + signe + op2 + " = " + resultat);
				signe = "";
			}
			else
			{
				l.setText("" + op2);
				signe = "";
			}
		}
		
		if(e.getSource() == oct && !(l.getText().contains("=")) && !(l.getText().contains("Erreur division par 0")))
		{
			new CalcOct();
		}
		
		if(e.getSource() == dec && !(l.getText().contains("=")) && !(l.getText().contains("Erreur division par 0")))
		{
			new Calculatrice();
		}
		
		if(e.getSource() == hex && !(l.getText().contains("=")) && !(l.getText().contains("Erreur division par 0")))
		{
			new CalcHexa();
		}	
	}
	
	public CalcBin()
	{
		super();
	}
	
}
