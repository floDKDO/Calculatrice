package projet;

import javax.swing.*;
import java.text.DecimalFormat;
import java.lang.Math;
import java.awt.*;
import java.awt.event.*;


@SuppressWarnings("serial")


/**
 * 
 * Classe principale : Calculatrice décimale
 * @author Florian
 *
 */

public class Calculatrice extends JFrame implements ActionListener
{
	public JFrame window;
	public JTextField l;
	public JPanel p, p1, p2, p3;
	public JButton zero, un, deux, trois, quatre, cinq, six, sept, huit, neuf, virg, neg, div, fois, moins, plus, egal, cor, del, graph, param, exp, sin, cos, tan, log, ln, dec, exposant, exposant_res, oct, bin, hex, questions;
	public GridLayout grille, grille1, grille2, grille3;
	public static double op1 = 0, op2 = 0;
	public static int operateur = 0;
	public static double valeur = 0;
	public static final int op_plus = 1, op_moins = 2, op_fois = 3, op_div = 4;
	public static double resultat = 0;
	public static double mantisse = 0, puissance = 0;
	public String signe = "";
	public static int compteur_virg = 0;
	public static String fonc = "";
	public static int compteur_param = 0;
	public static float a, n, b;
	
	
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
		l.setEditable(false);
		
		p = new JPanel();
		grille = new GridLayout(4, 3, 1, 1);
		p.setLayout(grille);
		p.setBackground(Color.black);
		
		p1 = new JPanel();
		grille1 = new GridLayout(5, 1, 1, 1);
		p1.setLayout(grille1);
		p1.setBackground(Color.black);
		
		p2 = new JPanel();
		grille2 = new GridLayout(12, 1, 1, 1);
		p2.setLayout(grille2);
		p2.setBackground(Color.black);
		
		p3 = new JPanel();
		grille3 = new GridLayout(1, 1, 1, 1);
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
		
		virg = new JButton(",");
		p.add(virg);
		virg.setFont(new Font("Serif", Font.BOLD, 20));
		
		//nombre négatif
		neg = new JButton("(-)");
		p.add(neg);
		neg.setFont(new Font("Serif", Font.BOLD, 20));
		
		//opérateurs
		div   = new JButton("    /    ");
		p1.add(div);
		div.setFont(new Font("Serif", Font.BOLD, 20));
		div.setBackground(Color.orange);
		
		fois  = new JButton("    *    ");
		p1.add(fois);
		fois.setFont(new Font("Serif", Font.BOLD, 20));
		fois.setBackground(Color.orange);
		
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
		
		//gestion du graphique
		graph = new JButton("Graph");
		p2.add(graph);
		graph.setFont(new Font("Serif", Font.BOLD, 20));
		
		param = new JButton("Param");
		param.setFont(new Font("Serif", Font.BOLD, 20));
		p2.add(param);
		
		//fonctions supplémentaires
		exp = new JButton("exp");
		exp.setFont(new Font("Serif", Font.BOLD, 20));
		p2.add(exp);
		
		ln = new JButton("ln");
		ln.setFont(new Font("Serif", Font.BOLD, 20));
		p2.add(ln);
		
		log = new JButton("log");
		log.setFont(new Font("Serif", Font.BOLD, 20));
		p2.add(log);
		
		sin = new JButton("sin");
		sin.setFont(new Font("Serif", Font.BOLD, 20));
		p2.add(sin);
		
		cos = new JButton("cos");
		cos.setFont(new Font("Serif", Font.BOLD, 20));
		p2.add(cos);
		
		tan = new JButton("tan");
		tan.setFont(new Font("Serif", Font.BOLD, 20));
		p2.add(tan);
		
		exposant_res = new JButton("res_exposant");
		exposant_res.setFont(new Font("Serif", Font.BOLD, 20));
		p2.add(exposant_res);
		
		exposant = new JButton("^");
		exposant.setFont(new Font("Serif", Font.BOLD, 20));
		p2.add(exposant);
		
		oct = new JButton("Octal");
		p3.add(oct);
		oct.setFont(new Font("Serif", Font.BOLD, 20));
		
		bin = new JButton("Binaire");
		p3.add(bin);
		bin.setFont(new Font("Serif", Font.BOLD, 20));
		
		hex = new JButton("Hexa");
		p3.add(hex);
		hex.setFont(new Font("Serif", Font.BOLD, 20));
		
		questions = new JButton("Questions");
		p3.add(questions);
		questions.setFont(new Font("Serif", Font.BOLD, 20));
		
		window.add(p, BorderLayout.CENTER);
		window.add(p1, BorderLayout.EAST);
		window.add(p2, BorderLayout.WEST);
		window.add(p3, BorderLayout.SOUTH);
		window.setVisible(true);
		
		sept.addActionListener(this);

		huit.addActionListener(this);
		
		neuf.addActionListener(this);
		
		quatre.addActionListener(this);
		
		cinq.addActionListener(this);
		
		six.addActionListener(this);
		
		un.addActionListener(this);
		
		deux.addActionListener(this);
		
		trois.addActionListener(this);
		
		zero.addActionListener(this);
		
		virg.addActionListener(this);
		
		neg.addActionListener(this);
		
		div.addActionListener(this);
		
		fois.addActionListener(this);
		
		moins.addActionListener(this);
		
		plus.addActionListener(this);
		
		egal.addActionListener(this);
		
		cor.addActionListener(this);
		
		del.addActionListener(this);
		
		graph.addActionListener(this);
		
		param.addActionListener(this);
		
		exp.addActionListener(this);
		
		ln.addActionListener(this);
		
		log.addActionListener(this);
		
		sin.addActionListener(this);
		
		cos.addActionListener(this);
		
		tan.addActionListener(this);
		
		exposant.addActionListener(this);
		
		exposant_res.addActionListener(this);

		oct.addActionListener(this);
		
		bin.addActionListener(this);
		
		hex.addActionListener(this);
		
		questions.addActionListener(this);
	}
	
	public Calculatrice()
	{				
		fenetre();	
		boutons();	
	}
	
	
	/**
	 * 
	 * méthode actionPerfomed(ActionEvent e)
	 * sert à assigner des événements aux boutons
	 * 
	 */
	
	public void actionPerformed (ActionEvent e)
	{
		DecimalFormat df = new DecimalFormat("#.###");
		
		if(e.getSource() == zero && !(l.getText().contains("=")) && !(l.getText().contains("Erreur division par 0")) && !(l.getText().contains("Erreur ln avec n <= 0")) && !(l.getText().contains("Erreur log avec n <= 0")))
		{
			l.setText(l.getText().concat("0"));
		}
		
		if(e.getSource() == un && !(l.getText().contains("=")) && !(l.getText().contains("Erreur division par 0")) && !(l.getText().contains("Erreur ln avec n <= 0")) && !(l.getText().contains("Erreur log avec n <= 0")))
		{
			l.setText(l.getText().concat("1"));
		}
		
		if(e.getSource() == deux && !(l.getText().contains("=")) && !(l.getText().contains("Erreur division par 0")) && !(l.getText().contains("Erreur ln avec n <= 0")) && !(l.getText().contains("Erreur log avec n <= 0")))
		{
			l.setText(l.getText().concat("2"));
		}
		
		if(e.getSource() == trois && !(l.getText().contains("=")) && !(l.getText().contains("Erreur division par 0")) && !(l.getText().contains("Erreur ln avec n <= 0")) && !(l.getText().contains("Erreur log avec n <= 0")))
		{
			l.setText(l.getText().concat("3"));
		}
		
		if(e.getSource() == quatre && !(l.getText().contains("=")) && !(l.getText().contains("Erreur division par 0")) && !(l.getText().contains("Erreur ln avec n <= 0")) && !(l.getText().contains("Erreur log avec n <= 0")))
		{
			l.setText(l.getText().concat("4"));
		}
		
		if(e.getSource() == cinq && !(l.getText().contains("=")) && !(l.getText().contains("Erreur division par 0")) && !(l.getText().contains("Erreur ln avec n <= 0")) && !(l.getText().contains("Erreur log avec n <= 0")))
		{
			l.setText(l.getText().concat("5"));
		}
		
		if(e.getSource() == six && !(l.getText().contains("=")) && !(l.getText().contains("Erreur division par 0")) && !(l.getText().contains("Erreur ln avec n <= 0")) && !(l.getText().contains("Erreur log avec n <= 0")))
		{
			l.setText(l.getText().concat("6"));
		}
		
		if(e.getSource() == sept && !(l.getText().contains("=")) && !(l.getText().contains("Erreur division par 0")) && !(l.getText().contains("Erreur ln avec n <= 0")) && !(l.getText().contains("Erreur log avec n <= 0")))
		{
			l.setText(l.getText().concat("7"));
		}
		
		if(e.getSource() == huit && !(l.getText().contains("=")) && !(l.getText().contains("Erreur division par 0")) && !(l.getText().contains("Erreur ln avec n <= 0")) && !(l.getText().contains("Erreur log avec n <= 0")))
		{
			l.setText(l.getText().concat("8"));
		}
		
		if(e.getSource() == neuf && !(l.getText().contains("=")) && !(l.getText().contains("Erreur division par 0")) && !(l.getText().contains("Erreur ln avec n <= 0")) && !(l.getText().contains("Erreur log avec n <= 0")))
		{
			l.setText(l.getText().concat("9"));
		}
		
		if(e.getSource() == exp && !(l.getText().contains("=")) && !(l.getText().contains("Erreur division par 0")) && !(l.getText().contains("Erreur ln avec n <= 0")) && !(l.getText().contains("Erreur log avec n <= 0")))
		{
			try
			{
				valeur = Math.exp(Double.parseDouble(l.getText()));
				l.setText("");
				l.setText(l.getText().concat(Double.toString(valeur)));
			}
			catch(Exception exception)
			{
				System.out.println("Il faut d'abord entrer une valeur !");
			}
		}
		
		if(e.getSource() == ln && !(l.getText().contains("=")) && !(l.getText().contains("Erreur division par 0")) && !(l.getText().contains("Erreur ln avec n <= 0")) && !(l.getText().contains("Erreur log avec n <= 0")))
		{
			try
			{
				if(Double.parseDouble(l.getText()) <= 0)
				{
					l.setText("Erreur ln avec n <= 0");
				}
				else
				{
					valeur = Math.log(Double.parseDouble(l.getText()));
					l.setText("");
					l.setText(l.getText().concat(Double.toString(valeur)));
				}
			}
			catch(Exception exception)
			{
				System.out.println("Il faut d'abord entrer une valeur !");
			}
		}
		
		if(e.getSource() == log && !(l.getText().contains("=")) && !(l.getText().contains("Erreur division par 0")) && !(l.getText().contains("Erreur ln avec n <= 0")) && !(l.getText().contains("Erreur log avec n <= 0")))
		{
			try
			{
				if(Double.parseDouble(l.getText()) <= 0)
				{
					l.setText("Erreur log avec n <= 0");
				}
				else
				{
					valeur = Math.log10(Double.parseDouble(l.getText()));
					l.setText("");
					l.setText(l.getText().concat(Double.toString(valeur)));
				}
			}
			catch(Exception exception)
			{
				System.out.println("Il faut d'abord entrer une valeur !");
			}
		}
		
		if(e.getSource() == sin && !(l.getText().contains("=")) && !(l.getText().contains("Erreur division par 0")) && !(l.getText().contains("Erreur ln avec n <= 0")) && !(l.getText().contains("Erreur log avec n <= 0")))
		{
			try
			{
				valeur = Math.sin(Double.parseDouble(l.getText()));
				l.setText("");
				l.setText(l.getText().concat(Double.toString(valeur)));
			}
			catch(Exception exception)
			{
				System.out.println("Il faut d'abord entrer une valeur !");
			}
		}
		
		if(e.getSource() == cos && !(l.getText().contains("=")) && !(l.getText().contains("Erreur division par 0")) && !(l.getText().contains("Erreur ln avec n <= 0")) && !(l.getText().contains("Erreur log avec n <= 0")))
		{
			try
			{
				valeur = Math.cos(Double.parseDouble(l.getText()));
				l.setText("");
				l.setText(l.getText().concat(Double.toString(valeur)));
			}
			catch(Exception exception)
			{
				System.out.println("Il faut d'abord entrer une valeur !");
			}
		}
		
		if(e.getSource() == tan && !(l.getText().contains("=")) && !(l.getText().contains("Erreur division par 0")) && !(l.getText().contains("Erreur ln avec n <= 0")) && !(l.getText().contains("Erreur log avec n <= 0")))
		{
			try
			{
				valeur = Math.tan(Double.parseDouble(l.getText()));
				l.setText("");
				l.setText(l.getText().concat(Double.toString(valeur)));
			}
			catch(Exception exception)
			{
				System.out.println("Il faut d'abord entrer une valeur !");
			}
		}
		
		if(e.getSource() == exposant_res && !(l.getText().contains("=")) && !(l.getText().contains("Erreur division par 0")) && !(l.getText().contains("Erreur ln avec n <= 0")) && !(l.getText().contains("Erreur log avec n <= 0")))
		{
			if(l.getText().contains("^"))
			{
				String phrase = l.getText();
				String temp_mantisse = "";
				String temp_exposant = "";
				int compteur = 0;
				double temp = 0;
				for(int i = 0; i < phrase.length(); i++)
				{
					if(phrase.charAt(i) == '^')
					{
						compteur ++;
					}
					
					if(phrase.charAt(i) != '^' && compteur == 0)
					{
						temp_mantisse += phrase.charAt(i); 
					}
					
					if(phrase.charAt(i) != '^' && compteur == 1)
					{
						temp_exposant += phrase.charAt(i);
					}				
				}
				if(!temp_exposant.isEmpty())
				{
					temp = Math.pow(Double.parseDouble(temp_mantisse), Double.parseDouble(temp_exposant));
				}
				else
				{
					throw new ArithmeticException("Veuillez entrer un nombre pour la puissance");
				}
				l.setText(Double.toString(temp));	
			}
		}
		
		if(e.getSource() == exposant && !(l.getText().contains("=")) && !(l.getText().contains("Erreur division par 0")) && !(l.getText().contains("Erreur ln avec n <= 0")) && !(l.getText().contains("Erreur log avec n <= 0")))
		{
			if(!l.getText().equals("") && !l.getText().contains("^"))
				l.setText(l.getText().concat("^"));
		}
		
		if(e.getSource() == cor)
		{
			l.setText("");
			operateur = 0;
			resultat = 0;
			op1 = 0;
			op2 = 0;
		}
		
		if(e.getSource() == del && !(l.getText().equals("")) && !(l.getText().contains("=")) && !(l.getText().contains("Erreur division par 0")) && !(l.getText().contains("Erreur ln avec n <= 0")) && !(l.getText().contains("Erreur log avec n <= 0")))
		{
			l.setText("" + l.getText().substring(0, l.getText().length() - 1));
		}
		
		if(e.getSource() == plus && !(l.getText().contains("Erreur division par 0")) && !(l.getText().contains("Erreur ln avec n <= 0")) && !(l.getText().contains("Erreur log avec n <= 0")))
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
				}
				else 
				{
					throw new ArithmeticException("Il manque un nombre");
				}
			}
			operateur = op_plus;
			compteur_virg = 0;
			l.setText("");
		}
		
		if(e.getSource() == moins && !(l.getText().contains("Erreur division par 0")) && !(l.getText().contains("Erreur ln avec n <= 0")) && !(l.getText().contains("Erreur log avec n <= 0")))
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
				}
				else 
				{
					throw new ArithmeticException("Il manque un nombre");
				}
			}
			operateur = op_moins;
			compteur_virg = 0;
			l.setText("");
		}
		
		if(e.getSource() == fois && !(l.getText().contains("Erreur division par 0")) && !(l.getText().contains("Erreur ln avec n <= 0")) && !(l.getText().contains("Erreur log avec n <= 0")))
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
				}
				else 
				{
					throw new ArithmeticException("Il manque un nombre");
				}
			}
			operateur = op_fois;
			compteur_virg = 0;
			l.setText("");
		}
		
		if(e.getSource() == div && !(l.getText().contains("Erreur division par 0")) && !(l.getText().contains("Erreur ln avec n <= 0")) && !(l.getText().contains("Erreur log avec n <= 0")))
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
				}
				else 
				{
					throw new ArithmeticException("Il manque un nombre");
				}
			}
			operateur = op_div;
			compteur_virg = 0;
			l.setText("");
		}
		
		if(e.getSource() == neg && !(l.getText().contains("=")) && !(l.getText().contains("Erreur division par 0")) && !(l.getText().contains("Erreur ln avec n <= 0")) && !(l.getText().contains("Erreur log avec n <= 0")))
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
		
		if(e.getSource() == egal && !(l.getText().contains("Erreur division par 0")) && !(l.getText().contains("Erreur ln avec n <= 0")) && !(l.getText().contains("Erreur log avec n <= 0")))
		{
			op2 = Double.parseDouble(l.getText());
			
			switch(operateur)
			{
				case op_plus :
					resultat = op1 + op2;
					signe = "+";
					break;
					
				case op_moins : 
					resultat = op1 - op2;
					signe = "-";
					break;
				
				case op_fois : 
					resultat = op1 * op2;
					signe = "*";
					break;
					
				case op_div : 
					resultat = op1 / op2;
					signe = "/";
					break;
					
				default : 
					resultat = op2;
			}
			compteur_virg = 0;
			
			if(op2 == 0 && operateur == op_div)
			{
				l.setText("Erreur division par 0");
			}
			else if(!signe.isEmpty())
			{
				l.setText(df.format(op1) + signe + df.format(op2) + " = " + df.format(resultat));
				signe = "";
			}
			else
			{
				l.setText("" + op2);
				signe = "";
			}
		}
		
		if(e.getSource() == virg && !(l.getText().contains("=")) && !(l.getText().contains("Erreur division par 0")) && !l.getText().isEmpty() && !(l.getText().contains("Erreur ln avec n <= 0")) && !(l.getText().contains("Erreur log avec n <= 0")))
		{
			if(compteur_virg == 0)
			{
				l.setText(l.getText() + ".");
				compteur_virg++;
			}
		}
		
		if(e.getSource() == oct && !(l.getText().contains("=")) && !(l.getText().contains("Erreur division par 0")) && !(l.getText().contains("Erreur ln avec n <= 0")) && !(l.getText().contains("Erreur log avec n <= 0")))
		{
			new CalcOct();
		}
		
		if(e.getSource() == bin && !(l.getText().contains("=")) && !(l.getText().contains("Erreur division par 0")) && !(l.getText().contains("Erreur ln avec n <= 0")) && !(l.getText().contains("Erreur log avec n <= 0")))
		{
			new CalcBin();
		}
		
		if(e.getSource() == hex && !(l.getText().contains("=")) && !(l.getText().contains("Erreur division par 0")) && !(l.getText().contains("Erreur ln avec n <= 0")) && !(l.getText().contains("Erreur log avec n <= 0")))
		{
			new CalcHexa();
		}
		
		if(e.getSource() == questions && !(l.getText().contains("=")) && !(l.getText().contains("Erreur division par 0")) && !(l.getText().contains("Erreur ln avec n <= 0")) && !(l.getText().contains("Erreur log avec n <= 0")))
		{
			new Questions();
		}
		
		if(e.getSource() == param && !(l.getText().contains("=")) && !(l.getText().contains("Erreur division par 0")) && !(l.getText().contains("Erreur ln avec n <= 0")) && !(l.getText().contains("Erreur log avec n <= 0")))
		{
			l.setEditable(true);
			if(compteur_param == 0)
			{
				param.setText("Entrer a de ax^n+b");
				compteur_param++;
			}		
			else if(compteur_param == 1)
			{
				if(l.getText().isEmpty())
					throw new ArithmeticException("manque un nombre");
				else
				{
					a = Float.parseFloat(l.getText());
					l.setText("");
					param.setText("Entrer n de ax^n+b");
					compteur_param++;
				}
			}
			else if(compteur_param == 2)
			{
				if(l.getText().isEmpty())
					throw new ArithmeticException("manque un nombre");
				else
				{
					n = Float.parseFloat(l.getText());
					l.setText("");
					param.setText("Entrer b de ax^n+b");
					compteur_param++;
				}
			}
			else if(compteur_param == 3)
			{
				if(l.getText().isEmpty())
					throw new ArithmeticException("manque un nombre");
				else
				{
					b = Float.parseFloat(l.getText());
					l.setText("");
					param.setText("Param");
					compteur_param ++;
				}
			}
		}
		
		if(e.getSource() == graph && !(l.getText().contains("=")) && !(l.getText().contains("Erreur division par 0")) && !(l.getText().contains("Erreur ln avec n <= 0")) && !(l.getText().contains("Erreur log avec n <= 0")))
		{
			if(compteur_param >= 3)
			{
				Courbe c = new Courbe(new Dimension(640, 480));
				c.addWindowListener(new WindowAdapter() 
				{
					public void windowClosing(WindowEvent e) 
					{ 
						System.exit(0); 
					}
				});
				c.pack();
				c.setSize(1920, 1080);
				c.setVisible(true);
			}
		}
	}	

	public static void main(String[] args) 
	{
		new Calculatrice();
	}
}