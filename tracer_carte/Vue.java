package tracer_carte;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.awt.GridLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;

public class Vue extends JFrame implements ActionListener, FocusListener {
	public Panneau panneau ;
	public JButton btnEffacer;
	public JButton btnEnregistrer;;
	
	public Vue()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Dessinez vos pays");
		setSize(1000, 1000);
		panneau = new Panneau();
		setContentPane(panneau);
		panneau.setLayout(new MigLayout("", "[][][][][][][][][][][][][][][][][][][][][][][][][][][]", "[][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]"));
		
		btnEffacer = new JButton("Effacer");		
		btnEnregistrer = new JButton("Enregistrer");
		
		btnEnregistrer.addActionListener(this);
		btnEffacer.addActionListener(this);
		
		panneau.add(btnEnregistrer, "cell 01 01");
		panneau.add(btnEffacer, "cell 01 02");
		
		
		
		setVisible(true);	
		
	}

	public void setListener(Controleur controleur) 
	{
		panneau.addMouseListener(controleur);
		panneau.addMouseMotionListener(controleur);	
		

//		this.btnEnregistrer.addActionListener(controleur);
		
		
	}
	
	
	
	
	public void tracerRectangle(int x, int y) 
	{
		System.out.println("Vue.tracerRectangle()");
		Graphics g = panneau.getGraphics();

		panneau.collection.redimensionner(panneau.collection.rectangles.length - 1,x,y,g);
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		
		if (e.getSource() == btnEnregistrer){
		
			Parser parser = new Parser(this.panneau.collection);
		
		
			try {
				parser.ecriture("./Carte.txt");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		}
		else {

			this.panneau.collection.effacerDernierRectangle();
			this.panneau.repaint();
		}

	
	
	}
	
}




