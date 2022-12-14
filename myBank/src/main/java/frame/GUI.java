package frame;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import models.ResourceModel;
import panels.TitleBar;
import utilities.LayerPanel;



public class GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private LayerPanel layeredPane;
	private TitleBar titlePanel;
	private Point currentLocation;
	
	public GUI() {
		
		titlePanel = new TitleBar(this);
		layeredPane = new LayerPanel(titlePanel, 0);
		

		initialize();
		
	} // GUI()
	

	private void initialize() {
			
		setUndecorated(true);
		setBounds(100, 100, 1002, 642);
		setIconImage(new ImageIcon(GUI.class.getResource(new ResourceModel().getICON_PATH())).getImage());
		getContentPane().setBackground(Color.DARK_GRAY);
		getContentPane().setLayout(null);
		
		titlePanel.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				currentLocation = e.getPoint();
			}
		});
		
		titlePanel.addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {
				Point currentScreenLocation = e.getLocationOnScreen();
				setLocation(currentScreenLocation.x - currentLocation.x,
						currentScreenLocation.y - currentLocation.y);
			}
		});
		
		titlePanel.setBounds(1, 1, 1000, 40);
		layeredPane.setBounds(1, 41, 1000, 600);
		

		getContentPane().add(titlePanel);
		getContentPane().add(layeredPane);
		setVisible(true);
		
	} // initialize()
	
} // class
