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

	
	public Vue()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Dessinez vos pays");
		setSize(1000, 1000);
		panneau = new Panneau();
		setContentPane(panneau);
		panneau.setLayout(new MigLayout("", "[][][][][][][][][][][][][][][][][][][][][][][][][][][]", "[][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][][]"));
		
		JButton btnEffacer = new JButton("Effacer");		
		JButton btnEnregistrer = new JButton("Enregistrer");
		
		btnEffacer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		btnEnregistrer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("\n\n               TEST");
				
			}
		});
		
		panneau.add(btnEnregistrer, "cell 26 30");
		panneau.add(btnEffacer, "cell 26 31");
		
		
		
		setVisible(true);	
		
	}

	public void setListener(Controleur controleur) 
	{
		panneau.addMouseListener(controleur);
		panneau.addMouseMotionListener(controleur);	
		
//		btnEffacer.addActionListener(controleur);
//		btnEnregistrer.addActionListener(controleur);
		
		
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

	}
	
}




