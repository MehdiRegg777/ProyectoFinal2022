
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Flow;

import javax.imageio.ImageIO;
import javax.swing.Action;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;


	
class Ventana extends  JFrame {
	
	//PANELS
	JPanel f1;
	JPanel menu;
	
	
	//LABELS 
	JLabel title ;
	
	//BUTONS
	BotonPlanetStats bViewPSt;
	BotonBuildShips  bBuildShips;
	BotonUpgradeTech bUpgradeTech;
	BotonBattleReports bBattRep;
	BotonExit exit;
	
	BufferedImage icono = null;

	
	//VAR
	
	boolean Ventana;
	
	public Ventana() {
		
		setTitle("Planet Wars");
		setSize(1000,600);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		try {
			icono = ImageIO.read(new File("icono.png"));
			setIconImage(icono);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		//PANEL CREATION
		f1 = new JPanel();
		menu = new JPanel();
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
		
		private WinPlanetStats planStats = null;

		public BotonPlanetStats(String s) {
			super(s);
			
				
		}

		//MOUSE
		
		public void mouseClicked(MouseEvent e) {
			
			if (planStats == null) {
				
				 planStats = new WinPlanetStats();

			}
			else {
				planStats.setVisible(true);
			}
			
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

	WinBuildShips buildShips = null;
	public BotonBuildShips(String s) {
		super(s);
			
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		if (buildShips == null) {
			
			buildShips = new WinBuildShips();
		}
		else {
			buildShips.setVisible(true);
		}
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

	WinUpgradeTech upgradeTech = null;
	
	public BotonUpgradeTech(String s) {
		super(s);
			
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		if (upgradeTech == null) {
		 upgradeTech = new WinUpgradeTech();
		}
		else {
			upgradeTech.setVisible(true);
		}
		
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
	
	WinBattleRep battleRep = null;

	public BotonBattleReports(String s) {
		super(s);	
	}

	
	public void mouseClicked(MouseEvent e) {
		
		if (battleRep == null) {

		 battleRep = new WinBattleRep();
		}
		
		else {
			battleRep.setVisible(true);
		}
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

	
//VENTANAS 

	class WinPlanetStats extends  JFrame {
	
	JLabel title;
	
	BufferedImage icono = null;

	public WinPlanetStats() {
		
		setTitle("Planet Stats");
		setSize(1000,600);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
		
		try {
			icono = ImageIO.read(new File("icono.png"));
			setIconImage(icono);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		title = new JLabel("Planet Stats ");
		title.setFont(new Font("Arial",Font.ROMAN_BASELINE,50));
		title.setForeground(new Color(0,0,0));
		
		title.setHorizontalAlignment(JLabel.CENTER);
		this.add(title,BorderLayout.NORTH);
		
		setVisible(true);
		
	}
	

}

class WinBuildShips extends  JFrame {
	
	private JLabel title;
	
	private JPanel panelCentral;	
	private JPanel attackShips;	
	private JPanel defenseShips;
	
	private BufferedImage icono = null;
	
	private WinAttckShips  winattack = null;
	private WinDefenseShips d1 = null;

	public WinBuildShips(){
		
		setTitle("Build Ship");
		setSize(1000,600);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
		try {
			icono = ImageIO.read(new File("icono.png"));
			setIconImage(icono);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		title = new JLabel("Build Ships");
		title.setFont(new Font("Arial",Font.ROMAN_BASELINE,50));
		title.setForeground(new Color(0,0,0));
		
		title.setHorizontalAlignment(JLabel.CENTER);
		this.add(title,BorderLayout.NORTH);
	
		
		
		panelCentral = new JPanel();
		panelCentral.setLayout(new GridLayout(1,3));

		
		attackShips = new JPanel();
		attackShips.add(new JLabel(new ImageIcon("ata.jpg")));
		
		defenseShips = new JPanel();
		defenseShips.add(new JLabel(new ImageIcon("def.png")));
		
		panelCentral.add(attackShips);
		
		panelCentral.add(defenseShips);

		
		this.add(panelCentral);
		
		attackShips.addMouseListener(new MouseListener() {
			
			
			public void mouseReleased(MouseEvent e) {
			}
			
			
			public void mousePressed(MouseEvent e) {
				
				if (winattack == null) {
					
				  winattack = new WinAttckShips();
				}
				
				else {
					winattack.setVisible(true);
				}
				
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		defenseShips.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
				if (d1 == null) {
				 d1 = new WinDefenseShips();
				 
				}
				else {
					d1.setVisible(true);
				}
				
		}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});

		
		setVisible(true);
		
		
		
	}
	

}
class WinUpgradeTech extends  JFrame {
	
	JLabel title;
	
	JPanel panelcent;
	
	JButton upgradeAT;
	JButton upgradeDT;
	
	BufferedImage icono = null;

	public WinUpgradeTech() {
		
		setTitle("Upgrade Tech");
		setSize(1000,600);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
		try {
			icono = ImageIO.read(new File("icono.png"));
			setIconImage(icono);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		title = new JLabel("Upgrade Technology");
		title.setFont(new Font("Arial",Font.ROMAN_BASELINE,50));
		title.setForeground(new Color(0,0,0));
		
		title.setHorizontalAlignment(JLabel.CENTER);
		this.add(title,BorderLayout.NORTH);
		
		panelcent = new JPanel();
		
		upgradeAT = new JButton("Upgrade Atack Tecnology");
		upgradeDT = new JButton("Upgrade Defense Tecnology");
		
		
		panelcent.setLayout(new GridLayout(1,2));
		panelcent.add(upgradeAT);
		panelcent.add(upgradeDT);
		
		
		this.add(panelcent);
		
		setVisible(true);
		
	}
	

}


class WinBattleRep extends  JFrame {
	
	JLabel title;

	BufferedImage icono = null;
	
	public WinBattleRep() {
		
			setTitle("Battle Rep");
			setSize(1000,600);
			setResizable(false);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(HIDE_ON_CLOSE);
			
			try {
				icono = ImageIO.read(new File("icono.png"));
				setIconImage(icono);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			title = new JLabel("Battle Report");
			title.setFont(new Font("Arial",Font.ROMAN_BASELINE,50));
			title.setForeground(new Color(0,0,0));
			
			
			title.setHorizontalAlignment(JLabel.CENTER);
			this.add(title,BorderLayout.NORTH);
						

			
			setVisible(true);
			
		}
	
	
}
	
	
class WinAttckShips extends JFrame {
	
	JPanel pcentral;
	JPanel PanelBotones;
	JPanel respuesta;
	
	ButtonGroup grupoSA;
	
	JRadioButton lightHun;
	JRadioButton heavyHun;
	JRadioButton battleSh;
	JRadioButton armoredSh;
	
	JTextField numShips;
	
	JLabel ntitle;
	
	BufferedImage icono = null;

	JButton bcrea;
	
	public WinAttckShips() {
		
		setTitle("Attack Ships");
		setSize(400,300);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
		try {
			icono = ImageIO.read(new File("icono.png"));
			setIconImage(icono);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		pcentral = new JPanel();
		pcentral.setLayout(new GridLayout(1,3));
		
		
		lightHun = new JRadioButton("Light Hunter");
		heavyHun = new JRadioButton("Heavy Hunter");
		battleSh = new JRadioButton("Battle Ship");
		armoredSh = new JRadioButton("Armored Ship");
		
		PanelBotones = new JPanel();
		PanelBotones.setLayout(new BoxLayout(PanelBotones, BoxLayout.Y_AXIS));
		
		numShips = new JTextField();
		numShips.setPreferredSize(new Dimension(40,20));
		
		grupoSA = new ButtonGroup();
		
		grupoSA.add(lightHun);
		grupoSA.add(heavyHun);
		grupoSA.add(battleSh);
		grupoSA.add(armoredSh);
		
		PanelBotones.add(Box.createRigidArea(new Dimension(50,70)));
		PanelBotones.add(lightHun);
		PanelBotones.add(heavyHun);
		PanelBotones.add(battleSh);
		PanelBotones.add(armoredSh);

		
		pcentral.add(PanelBotones);
		
		respuesta = new JPanel();
		respuesta.add(Box.createRigidArea(new Dimension(10,150)));	
		ntitle = new JLabel("Numero de naves a crear");
		bcrea = new JButton("Confirmar");
		respuesta.add(ntitle);
		respuesta.add(numShips);
		respuesta.add(bcrea);		
		pcentral.add(respuesta);
		this.add(pcentral);
		
		

		setVisible(true);
		}
	
	}

class WinDefenseShips extends JFrame {
	
	JPanel pcentral;
	JPanel PanelBotones;
	JPanel respuesta;
	
	ButtonGroup grupoSA;
	
	JRadioButton missLaunch;
	JRadioButton ionCannon;
	JRadioButton plasmaCannon;
	
	JTextField numShips;
	
	JLabel ntitle;
	
	BufferedImage icono = null;

	
	JButton bcrea;

	public WinDefenseShips() {
		
		setTitle("Defense Ships");
		setSize(400,300);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
		try {
			icono = ImageIO.read(new File("icono.png"));
			setIconImage(icono);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		pcentral = new JPanel();
		pcentral.setLayout(new GridLayout(1,3));
		
		
		missLaunch = new JRadioButton("Missile Launcher ");
		ionCannon = new JRadioButton("Ion Cannon");
		plasmaCannon = new JRadioButton("Plasma Cannon");
		
		
		PanelBotones = new JPanel();
		PanelBotones.setLayout(new BoxLayout(PanelBotones, BoxLayout.Y_AXIS));
		
		numShips = new JTextField();
		numShips.setPreferredSize(new Dimension(40,20));
		
		grupoSA = new ButtonGroup();
		
		grupoSA.add(missLaunch);
		grupoSA.add(ionCannon);
		grupoSA.add(plasmaCannon);
		
		PanelBotones.add(Box.createRigidArea(new Dimension(50,70)));
		PanelBotones.add(missLaunch);
		PanelBotones.add(ionCannon);
		PanelBotones.add(plasmaCannon);

		
		pcentral.add(PanelBotones);
		
		respuesta = new JPanel();
		respuesta.add(Box.createRigidArea(new Dimension(10,150)));	
		ntitle = new JLabel("Numero de naves a crear");
		bcrea = new JButton("Confirmar");
		respuesta.add(ntitle);
		respuesta.add(numShips);
		respuesta.add(bcrea);
		
		pcentral.add(respuesta);
		this.add(pcentral);
		
		

		setVisible(true);
		}
	
	}






