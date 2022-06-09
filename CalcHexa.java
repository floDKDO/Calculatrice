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
 * Classe pour l'hexadécimal
 * Classe fille de la classe principale Calculatrice
 * @author Florian
 *
 */


public class CalcHexa extends Calculatrice 
{
	private JButton a, b, c, d, e, f;
	private String num = "", num2 = "", res = "";
	private static int num0 = 0;
	
	/**
	 * méthode fenetre()
	 * sert à initialiser la fenêtre
	 * 
	 */
	
	public void fenetre()
	{
		window = new JFrame("Calculatrice hexadécimale");
		window.setSize(500, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);	
		
		l = new JTextField(10);
		l.setFont(new Font("Serif", Font.BOLD, 50));
		window.add(l, BorderLayout.NORTH);	
		l.setEditable(false);
	
		p = new JPanel();
		grille = new GridLayout(6, 3, 1, 1);
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
		d = new JButton("d");
		p.add(d);
		d.setFont(new Font("Serif", Font.BOLD, 20));
		
		e = new JButton("e");
		p.add(e);
		e.setFont(new Font("Serif", Font.BOLD, 20));
		
		f = new JButton("f");
		p.add(f);
		f.setFont(new Font("Serif", Font.BOLD, 20));
		
		a = new JButton("a");
		p.add(a);
		a.setFont(new Font("Serif", Font.BOLD, 20));
		
		b = new JButton("b");
		p.add(b);
		b.setFont(new Font("Serif", Font.BOLD, 20));
		
		c = new JButton("c");
		p.add(c);
		c.setFont(new Font("Serif", Font.BOLD, 20));
		
		sept = new JButton("7");
		p.add(sept);
		sept.setFont(new Font("Serif", Font.BOLD, 20));
		
		huit = new JButton("8");
		p.add(huit);
		huit.setFont(new Font("Serif", Font.BOLD, 20));
		
		neuf = new JButton("9");
		p.add(neuf);
		neuf.setFont(new Font("Serif", Font.BOLD, 20));	
		
		quatre = new JButton("4");
		p.add(quatre);
		quatre.setFont(new Font("Serif", Font.BOLD, 20));
		
		cinq = new JButton("5");
		p.add(cinq);
		cinq.setFont(new Font("Serif", Font.BOLD, 20));
		
		six = new JButton("6");
		p.add(six);
		six.setFont(new Font("Serif", Font.BOLD, 20));
		
		un = new JButton("1");
		p.add(un);
		un.setFont(new Font("Serif", Font.BOLD, 20));
		
		deux = new JButton("2");
		p.add(deux);
		deux.setFont(new Font("Serif", Font.BOLD, 20));
		
		trois = new JButton("3");
		p.add(trois);
		trois.setFont(new Font("Serif", Font.BOLD, 20));
		
		zero = new JButton("0");
		p.add(zero);
		zero.setFont(new Font("Serif", Font.BOLD, 20));
						
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
		
		bin = new JButton("Binaire");
		p3.add(bin);
		bin.setFont(new Font("Serif", Font.BOLD, 20));
		
		window.add(p, BorderLayout.CENTER);
		window.add(p1, BorderLayout.EAST);
		window.add(p2, BorderLayout.WEST);
		window.add(p3, BorderLayout.SOUTH);
		window.setVisible(true);
		
		a.addActionListener(this);
		
		b.addActionListener(this);
		
		c.addActionListener(this);
		
		d.addActionListener(this);
		
		e.addActionListener(this);
		
		f.addActionListener(this);
		
		huit.addActionListener(this);
		
		neuf.addActionListener(this);
		
		sept.addActionListener(this);
		
		quatre.addActionListener(this);
		
		cinq.addActionListener(this);
		
		six.addActionListener(this);
		
		un.addActionListener(this);
		
		deux.addActionListener(this);
		
		trois.addActionListener(this);
		
		zero.addActionListener(this);
		
		moins.addActionListener(this);
		
		plus.addActionListener(this);
		
		egal.addActionListener(this);
		
		cor.addActionListener(this);
		
		del.addActionListener(this);
		
		dec.addActionListener(this);

		oct.addActionListener(this);
		
		bin.addActionListener(this);	
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
		
		if(e.getSource() == huit && !(l.getText().contains("=")) && !(l.getText().contains("Erreur division par 0")))
		{
			l.setText(l.getText().concat("8"));
		}
		
		if(e.getSource() == neuf && !(l.getText().contains("=")) && !(l.getText().contains("Erreur division par 0")))
		{
			l.setText(l.getText().concat("9"));
		}
		
		if(e.getSource() == a && !(l.getText().contains("=")) && !(l.getText().contains("Erreur division par 0")))
		{
			l.setText(l.getText().concat("a"));
		}
		
		if(e.getSource() == b && !(l.getText().contains("=")) && !(l.getText().contains("Erreur division par 0")))
		{
			l.setText(l.getText().concat("b"));
		}
		
		if(e.getSource() == c && !(l.getText().contains("=")) && !(l.getText().contains("Erreur division par 0")))
		{
			l.setText(l.getText().concat("c"));
		}
		
		if(e.getSource() == d && !(l.getText().contains("=")) && !(l.getText().contains("Erreur division par 0")))
		{
			l.setText(l.getText().concat("d"));
		}
		
		if(e.getSource() == this.e && !(l.getText().contains("=")) && !(l.getText().contains("Erreur division par 0")))
		{
			l.setText(l.getText().concat("e"));
		}
		
		if(e.getSource() == f && !(l.getText().contains("=")) && !(l.getText().contains("Erreur division par 0")))
		{
			l.setText(l.getText().concat("f"));
		}
		
		if(e.getSource() == cor)
		{
			l.setText("");
			operateur = 0;
			res = "";
			op1 = 0;
			op2 = 0;
		}
		
		if(e.getSource() == del && !(l.getText().equals("")) && !(l.getText().contains("=")) && !(l.getText().contains("Erreur division par 0")))
		{
			l.setText("" + l.getText().substring(0, l.getText().length() - 1));
		}
		
		if(e.getSource() == plus && !(l.getText().contains("Erreur division par 0")))
		{
			if(res != "")
			{
				num = res;
			}
			else
			{
				if(!(l.getText().isEmpty()))
				{
					op1 = Integer.parseInt(l.getText(), 16);
					num = Integer.toHexString((int) op1);
				}
				else 
				{
					throw new ArithmeticException("Il manque un nombre");
				}	
			}	
			operateur = op_plus;
			l.setText("");
		}
		
		if(e.getSource() == moins && !(l.getText().contains("Erreur division par 0")))
		{
		    if(res != "")
			{
		    	num = res;
			}
			else
			{
				if(!(l.getText().isEmpty()))
				{
					op1 = Integer.parseInt(l.getText(), 16);
					num = Integer.toHexString((int) op1);
				}
				else 
				{
					throw new ArithmeticException("Il manque un nombre");
				}
			}		
			operateur = op_moins;
			l.setText("");
		}
		
		if(e.getSource() == egal && !(l.getText().contains("Erreur division par 0")))
		{
			op2 = Integer.parseInt(l.getText(), 16);
			num2 = Integer.toHexString((int) op2);	
			
			switch(operateur)
			{
				case op_plus :
					num0 = Integer.parseInt(num, 16) + Integer.parseInt(num2, 16);
					if(Integer.parseInt(num, 16) + Integer.parseInt(num2, 16) < 0)
					{
						res = "0";
					}
					else
					{
						res = Integer.toHexString(num0);
					}
					signe = "+";
					break;
					
				case op_moins : 
					num0 = Integer.parseInt(num, 16) - Integer.parseInt(num2, 16);
					if(Integer.parseInt(num, 16) - Integer.parseInt(num2, 16) < 0)
					{
						res = "0";
					}
					else
					{
						res = Integer.toHexString(num0);
					}
					signe = "-";
					break;
					
				default : 
					res = Double.toString(op2);
			}	
			
			if(!signe.isEmpty())
			{
				l.setText(num + signe + num2 + " = " + res);
				signe = "";
			}
			else
			{
				l.setText("" + res);
				signe = "";
			}			
		}
		
		
		if(e.getSource() == oct && !(l.getText().contains("=")) && !(l.getText().contains("Erreur division par 0")))
		{
			new CalcOct();
		}
		
		if(e.getSource() == bin && !(l.getText().contains("=")) && !(l.getText().contains("Erreur division par 0")))
		{
			new CalcBin();
		}
		
		if(e.getSource() == dec && !(l.getText().contains("=")) && !(l.getText().contains("Erreur division par 0")))
		{
			new Calculatrice();
		}		
	}

	public CalcHexa()
	{
		super();
	}
	
}
		

