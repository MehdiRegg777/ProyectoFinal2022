
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Menu;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Action;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

	
class Ventana extends  JFrame {
	
	//PANELS
	Panel f1;
	Panel menu;
	
	
	//LABELS 
	JLabel title ;
	
	//BUTONS
	BotonPlanetStats bViewPSt;
	BotonBuildShips  bBuildShips;
	BotonUpgradeTech bUpgradeTech;
	BotonBattleReports bBattRep;
	BotonExit exit;

	
	//VAR
	
	boolean Ventana;
	
	public Ventana() {
		
		setTitle("Planet Wars");
		setSize(1000,600);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		

		
		//PANEL CREATION
		f1 = new Panel();
		menu = new Panel();
		menu.setLayout(new FlowLayout((5)));
		
	//	menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));
		
		//LABEL CREATION AND MOD
		title = new JLabel("PLANET WARS");
		title.setFont(new Font("Arial",Font.ROMAN_BASELINE,100));
		
		//BOTON CREARTION
		bViewPSt = new BotonPlanetStats("View Planet Stats");
		bBuildShips = new BotonBuildShips("Build Ships");
		bUpgradeTech = new BotonUpgradeTech("Upgrade Technology");
		bBattRep = new BotonBattleReports("View Battle Reports");
		exit = new BotonExit("Exit");
		
		
		
		this.add(f1,BorderLayout.NORTH);
		this.add(menu,BorderLayout.CENTER);

	
	
		
		f1.add(title);
		
		//PANEL BUTONS
		menu.add(Box.createRigidArea(new Dimension(150,50)));
		menu.add(bViewPSt);
		menu.add(bBuildShips);
		menu.add(bUpgradeTech);
		menu.add(bBattRep);
		menu.add(exit);
		
		
		bViewPSt.addMouseListener(bViewPSt);
		bBuildShips.addMouseListener(bBuildShips);
		bUpgradeTech.addMouseListener(bUpgradeTech);
		bBattRep.addMouseListener(bBattRep);
		exit.addMouseListener(exit);



		setVisible(true);
	}

	
	//BOTONES MENU INICIO

	class BotonPlanetStats extends JButton implements MouseListener{

		public BotonPlanetStats(String s) {
			super(s);
				
		}

		//MOUSE
		
		public void mouseClicked(MouseEvent e) {
			
			WinPlanetStats planStats = new WinPlanetStats();
			
		}

		
		public void mousePressed(MouseEvent e) {
			
		}

		
		public void mouseReleased(MouseEvent e) {
			
		}

		
		public void mouseEntered(MouseEvent e) {
			
		}

		
		public void mouseExited(MouseEvent e) {
			
		}
		
	}
	

class BotonBuildShips extends JButton implements MouseListener {

	public BotonBuildShips(String s) {
		super(s);
			
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		WinBuildShips buildShips = new WinBuildShips();
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}


class BotonUpgradeTech extends JButton implements MouseListener{

	public BotonUpgradeTech(String s) {
		super(s);
			
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		WinUpgradeTech upgradeTech = new WinUpgradeTech();
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}


class BotonBattleReports extends JButton implements MouseListener{

	public BotonBattleReports(String s) {
		super(s);
			
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		WinBattleRep battleRep = new WinBattleRep();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}


class BotonExit extends JButton implements MouseListener{

	public BotonExit(String s) {
		super(s);
			
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		System.exit(EXIT_ON_CLOSE);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
	
	
}

class Panel extends JPanel{
	
	BufferedImage background;
	
	public Panel () {
		
		try {
			background = ImageIO.read(new File("planeta.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
		
	}
}
	
//VENTANAS 

	class WinPlanetStats extends  JFrame {
	
	JLabel title;
	
	public WinPlanetStats() {
		
		setTitle("Planet Stats");
		setSize(1000,600);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
		
		title = new JLabel("Planet Stats ");
		title.setFont(new Font("Arial",Font.ROMAN_BASELINE,50));
		title.setForeground(new Color(0,0,0));
		
		title.setHorizontalAlignment(JLabel.CENTER);
		this.add(title,BorderLayout.NORTH);
		
		setVisible(true);
		
	}
	

}

class WinBuildShips extends  JFrame {
	
	JLabel title;
	
	public WinBuildShips(){
		
		setTitle("Build Ship");
		setSize(1000,600);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
		title = new JLabel("Build Ships");
		title.setFont(new Font("Arial",Font.ROMAN_BASELINE,50));
		title.setForeground(new Color(0,0,0));
		
		title.setHorizontalAlignment(JLabel.CENTER);
		this.add(title,BorderLayout.NORTH);
		
		setVisible(true);
		
	}
	

}
class WinUpgradeTech extends  JFrame {
	
	JLabel title;
	
	public WinUpgradeTech() {
		
		setTitle("Upgrade Tech");
		setSize(1000,600);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
		title = new JLabel("Upgrade Technology");
		title.setFont(new Font("Arial",Font.ROMAN_BASELINE,50));
		title.setForeground(new Color(0,0,0));
		
		title.setHorizontalAlignment(JLabel.CENTER);
		this.add(title,BorderLayout.NORTH);
		
		setVisible(true);
		
	}
	

}


class WinBattleRep extends  JFrame {
	
	JLabel title;
	
	public WinBattleRep() {
		
		setTitle("Battle Rep");
			setSize(1000,600);
			setResizable(false);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(HIDE_ON_CLOSE);
			
			title = new JLabel("Battle Report");
			title.setFont(new Font("Arial",Font.ROMAN_BASELINE,50));
			title.setForeground(new Color(0,0,0));
			
			
			title.setHorizontalAlignment(JLabel.CENTER);
			this.add(title,BorderLayout.NORTH);

			
			setVisible(true);
			
		}
}





