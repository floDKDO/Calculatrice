package projet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")

/**
 * 
 * Classe pour l'octal
 * Classe fille de la classe principale Calculatrice
 * @author Florian
 *
 */

public class CalcOct extends Calculatrice
{
	private static int num = 0, num2 = 0;
	
	
	/**
	 * méthode fenetre()
	 * sert à initialiser la fenêtre
	 * 
	 */
	
	public void fenetre()
	{
		window = new JFrame("Calculatrice octale");
		window.setSize(500, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
			
		l = new JTextField(10);
		l.setFont(new Font("Serif", Font.BOLD, 50));
		window.add(l, BorderLayout.NORTH);	
		l.setEditable(false);
	
		p = new JPanel();
		grille = new GridLayout(5, 2, 1, 1);
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
		//chiffres		
		six = new JButton("6");
		p.add(six);
		six.setFont(new Font("Serif", Font.BOLD, 20));
		
		sept = new JButton("7");
		p.add(sept);
		sept.setFont(new Font("Serif", Font.BOLD, 20));
		
		quatre = new JButton("4");
		p.add(quatre);
		quatre.setFont(new Font("Serif", Font.BOLD, 20));
		
		cinq = new JButton("5");
		p.add(cinq);
		cinq.setFont(new Font("Serif", Font.BOLD, 20));
	
		deux = new JButton("2");
		p.add(deux);
		deux.setFont(new Font("Serif", Font.BOLD, 20));
		
		trois = new JButton("3");
		p.add(trois);
		trois.setFont(new Font("Serif", Font.BOLD, 20));
		
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
		
		bin = new JButton("Binaire");
		p3.add(bin);
		bin.setFont(new Font("Serif", Font.BOLD, 20));
		
		hex = new JButton("Héxa");
		p3.add(hex);
		hex.setFont(new Font("Serif", Font.BOLD, 20));
		
		window.add(p, BorderLayout.CENTER);
		window.add(p1, BorderLayout.EAST);
		window.add(p2, BorderLayout.WEST);
		window.add(p3, BorderLayout.SOUTH);
		window.setVisible(true);
		
		sept.addActionListener(this);
		
		quatre.addActionListener(this);
		
		cinq.addActionListener(this);
		
		six.addActionListener(this);
		
		un.addActionListener(this);
		
		deux.addActionListener(this);
		
		trois.addActionListener(this);
		
		zero.addActionListener(this);
		
		neg.addActionListener(this);
		
		moins.addActionListener(this);
		
		plus.addActionListener(this);
		
		egal.addActionListener(this);
		
		cor.addActionListener(this);
		
		del.addActionListener(this);
		
		dec.addActionListener(this);
		
		bin.addActionListener(this);
		
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
		
		if(e.getSource() == deux && !(l.getText().contains("=")) && !(l.getText().contains("Erreur division par 0")))
		{
			l.setText(l.getText().concat("2"));
		}
		
		if(e.getSource() == trois && !(l.getText().contains("=")) && !(l.getText().contains("Erreur division par 0")))
		{
			l.setText(l.getText().concat("3"));
		}
		
		if(e.getSource() == quatre && !(l.getText().contains("=")) && !(l.getText().contains("Erreur division par 0")))
		{
			l.setText(l.getText().concat("4"));
		}
		
		if(e.getSource() == cinq && !(l.getText().contains("=")) && !(l.getText().contains("Erreur division par 0")))
		{
			l.setText(l.getText().concat("5"));
		}
		
		if(e.getSource() == six && !(l.getText().contains("=")) && !(l.getText().contains("Erreur division par 0")))
		{
			l.setText(l.getText().concat("6"));
		}
		
		if(e.getSource() == sept && !(l.getText().contains("=")) && !(l.getText().contains("Erreur division par 0")))
		{
			l.setText(l.getText().concat("7"));
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
				num = (int)resultat;
			}
			else
			{
				if(!(l.getText().isEmpty()))
				{
					op1 = Double.parseDouble(l.getText());
					num = Integer.parseInt(Integer.toString((int)op1), 8);
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
			if(resultat != 0 && operateur != 0)
			{
				num = (int)resultat;
			}
			else
			{
				if(!(l.getText().isEmpty()))
				{
					op1 = Double.parseDouble(l.getText());
					num = Integer.parseInt(Integer.toString((int)op1), 8);
				}
				else 
				{
					throw new ArithmeticException("Il manque un nombre");
				}
				
				/*op1 = Double.parseDouble(l.getText());
			    int temp = 0;
			    String temp_nombre = "";
			    String nombre = "";
			    while((int)op1 / 8 != 0)
			    {
			        temp = (int)op1 % 8;
			        temp_nombre += Integer.toString(temp);
		            op1 /= 8;
			    }
			    if((int)op1 / 8 == 0)
			    {
			        temp_nombre += (int)op1 % 8;
			    }
			    
			    for(int j = 0 ; j < temp_nombre.length(); j++)
			    {
			        nombre += temp_nombre.charAt(temp_nombre.length() - j - 1);
				}
				op1 = Double.parseDouble(nombre);*/
			}
			operateur = op_moins;
			l.setText("");
		}
		
		if(e.getSource() == egal && !(l.getText().contains("Erreur division par 0")))
		{
			op2 = Double.parseDouble(l.getText());
			num2 = Integer.parseInt(Integer.toString((int)op2), 8);
			
			switch(operateur)
			{
				case op_plus :
					String str = Integer.toOctalString((int)(num + num2));
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
					String str1 = Integer.toOctalString((int)(num - num2));
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
		
		if(e.getSource() == bin && !(l.getText().contains("=")) && !(l.getText().contains("Erreur division par 0")))
		{
			new CalcBin();
		}
		
		if(e.getSource() == hex && !(l.getText().contains("=")) && !(l.getText().contains("Erreur division par 0")))
		{
			new CalcHexa();
		}
		
		if(e.getSource() == dec && !(l.getText().contains("=")) && !(l.getText().contains("Erreur division par 0")))
		{
			new Calculatrice();
		}	
	}	
		
	public CalcOct()
	{
		super();		
	}
	
}

