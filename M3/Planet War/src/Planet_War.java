import java.beans.Statement;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.Principal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import javax.lang.model.element.VariableElement;
import javax.naming.spi.DirStateFactory.Result;

public class Planet_War {

	private boolean attack_is_comming = false;
	private TimerTask Advertencia_Attack,Attack,GetMoreResource;
	
	Planet planeta = new Planet();
	Battle battle;
	
	ArrayList<MilitaryUnit>[] enemyArmy = new ArrayList[4];
	ArrayList<MilitaryUnit> lh = new ArrayList<MilitaryUnit>();
	ArrayList<MilitaryUnit> hh = new ArrayList<MilitaryUnit>();
	ArrayList<MilitaryUnit> bs = new ArrayList<MilitaryUnit>();
	ArrayList<MilitaryUnit> as = new ArrayList<MilitaryUnit>();
	
	ArrayList<Battle> Battles = new ArrayList<>();

	public static void main(String[] args) {
		Planet_War p = new Planet_War();
		p.login();
		p.tasks();
		Timer timer = new Timer();
		timer.schedule(p.getAdvertencia_Attack(), 120000, 240000);
		timer.schedule(p.getAttack(), 180000, 240000);
		timer.schedule(p.getGetMoreResource(), 10000,10000);
		p.bbdd(0);//initialitze
		p.getPlaneta().crearplaneta();
		p.CrearOestablecerPlanetaResources();
		p.CambioMenuINICIO(p.MostrarMenu());
	}

	public String MostrarMenu(){
		Scanner sc = new Scanner(System.in);
		if (attack_is_comming == false) {
		System.out.println("1)View Planet Stats\n2)Build\n3)Upgrade Technology\n4)View Battle Reports\n0)Exit\n\nOption >");
		return sc.nextLine();
		}
		else {
		System.out.println("1)View Planet Stats\n2)Build\n3)Upgrade Technology\n4)View Battle Reports\n5)View Thread Comming\n0)Exit\n\nOption >");
		return sc.nextLine();
		}
	}
	
	public void Buildmenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Menu Build\n1)Build troops\n2)Build Defenses\n3)Go Back\n\nOption >");
		switch (sc.nextLine()){
		case "1": {
			//Aqui vamos a entrar al menu para insertar tropas
			Buildmenu_troops();
			Buildmenu();
			break;
		}
		case "2": {
			//Aqui vamos a entrar al menu para crear defensas
			Buildmenu_defenses();
			Buildmenu();
			break;
		}
		case "3": {
			CambioMenuINICIO(MostrarMenu());
			break;
		}
		default:
			Buildmenu();
		}
	}
	public void Buildmenu_troops() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Menu Build Troops\n1)Build Light Hunter\n2)Build HeavyHunter\n3)Build Battle Ship\n4)Build Armored Ship\n5)Go Back\n\nOption >");
		switch (sc.nextLine()){
		case "1": {
			try {
				planeta.newLigthHunter(Amount_of_units());
			} catch (ResourceException e) {
				System.out.println(e.getMessage());
			}
			Buildmenu_troops();
			break;
		}
		case "2": {
			try {
				planeta.newHeavyHunter(Amount_of_units());
			} catch (ResourceException e) {
				System.out.println(e.getMessage());
			}
			Buildmenu_troops();
			break;
		}
		case "3": {
			try {
				planeta.newBattleShip(Amount_of_units());
			} catch (ResourceException e) {
				System.out.println(e.getMessage());
			}
			Buildmenu_troops();
			break;
		}
		case "4": {
			try {
				planeta.newArmoredShip(Amount_of_units());
			} catch (ResourceException e) {
				System.out.println(e.getMessage());
			}
			Buildmenu_troops();
			break;
		}
		case "5": {
			Buildmenu();
			break;
		}
		default:
			Buildmenu_troops();
		}
	}
	
	public void Buildmenu_defenses() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Menu Build Defenses\n1)Build Missile Launcher\n2)Build Ion Cannon\n3)Build Plasma Cannon\n4)Go Back\n\nOption >");
		switch (sc.nextLine()){
		case "1": {
			try {
				planeta.newMissileLauncher(Amount_of_units());
			} catch (ResourceException e) {
				System.out.println(e.getMessage());
			}
			Buildmenu_defenses();
			break;
		}
		case "2": {
			try {
				planeta.newIonCannon(Amount_of_units());
			} catch (ResourceException e) {
				System.out.println(e.getMessage());
			}
			Buildmenu_defenses();
			break;
		}
		case "3": {
			try {
				planeta.newPlasmaCannon(Amount_of_units());
			} catch (ResourceException e) {
				System.out.println(e.getMessage());
			}
			Buildmenu_defenses();
			break;
		}
		case "4": {
			Buildmenu();
			break;
		}
		default:
			Buildmenu_defenses();
		}
	}
	
	public int Amount_of_units(){ //Esta funcion nos devuelve un int donde insertaremos el numero de tropas que quiere el usuario. en caso de no ser un numero valido entonces
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Amount of Units\nAmount: >");
			int total = sc.nextInt();
			if (total<0) {
				return 0;
			}
			return total;
		} catch (Exception e) {
			return 0;
		}
	}
	
	public void ViewPlanetStats(){
		getPlaneta().printStats();
	}

	public void UpgradeTechnology(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Upgrade Technology");
		System.out.println(""
				+ "Actual Defense Technology:		"+getPlaneta().getTechnologyDefense()+"\n"
				+ "Actual Attack Technology:		"+getPlaneta().getTechnologyAtack()+"\n\n"
				+ "1)Upgrade Defense Technology. Cost: "+getPlaneta().getUpgradeDefenseTechnologyDeuteriumCost()+" Deuterium\n"
				+ "2)Upgrade Attack Technology. Cost: "+getPlaneta().getUpgradeAttackTechnologyDeuteriumCost()+" Deuterium\n"
				+ "3)Go back\n\nDeuterium Resources = "+getPlaneta().getDeuterium()+"\n"
				+ "Option >");
		switch (sc.nextLine()) {
		case "1": {
			try {
				planeta.upgradeTechnologyDefense();
				actualizar_datos();
			} catch (ResourceException e) {
				System.out.println(e.getMessage());
			}
			UpgradeTechnology();
			break;
		}
		case "2": {
			try {
				planeta.upgradeTechnologyAttack();
				actualizar_datos();
			} catch (ResourceException e) {
				System.out.println(e.getMessage());
			}
			UpgradeTechnology();
			break;
		}
		case "3": {
			CambioMenuINICIO(MostrarMenu());
			break;
		}
		default:
			UpgradeTechnology();
		}

	}
	public void ViewBatlleReports(){
		
	}
	public void ViewThreadComing(){
		
		System.out.println("NEW THREAD COMMING\n\n\nLight Hunter		"+ getEnemyArmy()[0].size()
				+ "\n\nHeavy Hunter		"+getEnemyArmy()[1].size()
				+ "\n\nBattle Ship		"+getEnemyArmy()[2].size()
				+ "\n\nArmored Ship		"+getEnemyArmy()[3].size()
				+ "\n\n\n\n");
	}
	
	
	public void CambioMenuINICIO(String op) {
		switch (op) {
		case "1": {
			ViewPlanetStats();
			CambioMenuINICIO(MostrarMenu());
			break;
		}
		case "2": {
			Buildmenu();
			CambioMenuINICIO(MostrarMenu());
			break;
		}
		case "3": {
			UpgradeTechnology();
			CambioMenuINICIO(MostrarMenu());
			break;
		}
		case "4": {
			seleccionarBattle();
			CambioMenuINICIO(MostrarMenu());
			break;
		}
		case "5": {
			if (attack_is_comming == true) {
				ViewThreadComing();
				CambioMenuINICIO(MostrarMenu());
			}
			else {
			CambioMenuINICIO(MostrarMenu());

			}
			break;
		}
		case "0": {
			System.out.println("See you next time!");
			System.exit(0);
			break;
		}
		default:
			CambioMenuINICIO(MostrarMenu());
			break;
		}
	}

	public boolean isAttack_is_comming() {
		return attack_is_comming;
	}

	public void setAttack_is_comming(boolean attack_is_comming) {
		this.attack_is_comming = attack_is_comming;
	}
	
	public Planet getPlaneta() {
		return planeta;
	}

	public void setPlaneta(Planet planeta) {
		this.planeta = planeta;
	}
	
	public void tasks() {
		
		setAttack(new TimerTask() {
			
			public void run() {
				System.out.println("\n\n\n\n\n\nWE HAVE BEEN ATTACKED!!!\n\n");
				battle = new Battle(planeta.getArmy(),enemyArmy);
				insertarBatallas(battle);
				setAttack_is_comming(false);
			}
			
		});
		
		setAdvertencia_Attack(new TimerTask() {
			
			public void run() {
				setAttack_is_comming(true);
				System.out.println("\n\n\n\n\n\n1 NEW THREAD IS COMMING\n\n");
				createEnemyArmy_Planet();
				
			}
		});
		
		setGetMoreResource(new TimerTask() {
			
			public void run() {
				planeta.setMetal(planeta.getMetal()+20000);
				planeta.setDeuterium(planeta.getDeuterium()+20000);
				actualizar_datos();
			}
		});	
		
	}
	public TimerTask getAdvertencia_Attack() {
		return Advertencia_Attack;
	}

	public void setAdvertencia_Attack(TimerTask advertencia_Attack) {
		Advertencia_Attack = advertencia_Attack;
	}

	public TimerTask getGetMoreResource() {
		return GetMoreResource;
	}

	public void setGetMoreResource(TimerTask getMoreResource) {
		GetMoreResource = getMoreResource;
	}

	public TimerTask getAttack() {
		return Attack;
	}
	
	public void setAttack(TimerTask attack) {
		Attack = attack;
	}

	public void bbdd(int reset) {
        Connection cn = null;
        String query = "{call INITIALIZE("+reset+")";
		try {
			cn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.40.2:1521:orcl", "alumnoMIX8", "alumnoMIX8");
	        CallableStatement cst = cn.prepareCall(query);
	        cst.execute();
	        System.out.println("Base de datos actualizada");
		} catch (SQLException e) {
			System.out.println("Error en la conexion");
		}
	}
	
	public void login () {
		Scanner sc =new  Scanner(System.in);
		Connection cn = null;
		int correcto = 0;
        String query1 = "{call userexist1(?,?,?)}";
        System.out.println("Username:");
        String username = sc.nextLine();
        System.out.println("Password:");
        String password = sc.nextLine();
        
		try {
			cn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.40.2:1521:orcl", "alumnoMIX8", "alumnoMIX8");
			CallableStatement cst = cn.prepareCall(query1);
			cst.setString(1, username);
			cst.setString(2, password);
			cst.registerOutParameter(3,java.sql.Types.INTEGER);
			cst.execute();
			correcto = cst.getInt(3);
		} catch (SQLException e) {
			System.out.println("Error en la conexion");
		}
		
		if (correcto == 1) {
			System.out.println("WELCOME "+ username + " TO PLANET WAR\n\n");
		}
		else {
			System.out.println("The pass or user are incorrect");
			login();
		}
	}
	
	public void createEnemyArmy_Planet() {
		int actualmetal = Variables.METAL_BASE_ENEMY_ARMY;
		int actualdeuterium = Variables.DEUTERIUM_BASE_ENEMY_ARMY;
		int randomfloote = (int)(Math.random()*100);
		enemyArmy[0] = lh;
		enemyArmy[1] = hh;
		enemyArmy[2] = bs;
		enemyArmy[3] = as;
		
		while (true) {
			try {
				if (randomfloote<=35 && actualmetal>= getPlaneta().data_bbdd(1).getInt(3) && actualdeuterium >= getPlaneta().data_bbdd(1).getInt(5)) {
					enemyArmy[0].add(new LigthHunter());
					actualmetal -= getPlaneta().data_bbdd(1).getInt(3);
					actualdeuterium -= getPlaneta().data_bbdd(1).getInt(5);
					randomfloote = (int)(Math.random()*100);
				}
				else if(randomfloote<=60 && actualmetal>= getPlaneta().data_bbdd(2).getInt(3) && actualdeuterium >= getPlaneta().data_bbdd(1).getInt(5)) {
					enemyArmy[1].add(new HeavyHunter());
					actualmetal -= getPlaneta().data_bbdd(2).getInt(3);
					actualdeuterium -= getPlaneta().data_bbdd(2).getInt(5);
					randomfloote = (int)(Math.random()*100);
				}
				else if(randomfloote<=80 && actualmetal>= getPlaneta().data_bbdd(3).getInt(3) && actualdeuterium >= getPlaneta().data_bbdd(1).getInt(5)) {
					enemyArmy[2].add(new BattleShip());
					actualmetal -= getPlaneta().data_bbdd(3).getInt(3);
					actualdeuterium -= getPlaneta().data_bbdd(3).getInt(5);
					randomfloote = (int)(Math.random()*100);
				}
				else if(randomfloote<=100 && actualmetal>= getPlaneta().data_bbdd(4).getInt(3) && actualdeuterium >= getPlaneta().data_bbdd(1).getInt(5)){
					enemyArmy[3].add(new ArmoredShip());
					actualmetal -= getPlaneta().data_bbdd(4).getInt(3);
					actualdeuterium -= getPlaneta().data_bbdd(4).getInt(5);
					randomfloote = (int)(Math.random()*100);
				}
				else if (actualmetal>= getPlaneta().data_bbdd(1).getInt(3) && actualdeuterium >= getPlaneta().data_bbdd(1).getInt(5)){
					randomfloote = (int)(Math.random()*100);
				}
				else{
					break;
				}
			} catch (SQLException e) {
				
			}
		}

	}
	
	public Battle getBattle() {
		return battle;
	}

	public void setBattle(Battle battle) {
		this.battle = battle;
	}

	public ArrayList<MilitaryUnit>[] getEnemyArmy() {
		return enemyArmy;
	}

	public void setEnemyArmy(ArrayList<MilitaryUnit>[] enemyArmy) {
		this.enemyArmy = enemyArmy;
	}
	
	public void CrearOestablecerPlanetaResources() {//introduce los valores de la base de datos al juego
		try {
			getPlaneta().setTechnologyAtack(getPlaneta().crearplaneta().getInt(2));
			getPlaneta().setTechnologyDefense(getPlaneta().crearplaneta().getInt(3));
			getPlaneta().setMetal(getPlaneta().crearplaneta().getInt(4));
			getPlaneta().setDeuterium(getPlaneta().crearplaneta().getInt(5));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void actualizar_datos() {//introduce los datos del programa a la bbdd
		getPlaneta().updateResources(getPlaneta().getMetal(), getPlaneta().getDeuterium(), getPlaneta().getTechnologyAtack(), getPlaneta().getTechnologyDefense());
	}
	
	public void dibujitoScroll() {
		String Scroll = "";
		
		switch (getBattles().size()){
		case 0: {
			Scroll = "(NO BATTLES HERE)";
			break;
		}
		case 1: {
			Scroll = "(1)";
			break;
		}
		case 2: {
			Scroll = "(1-2)";
			break;
		}
		case 3: {
			Scroll = "(1-2-3)";
			break;
		}
		case 4: {
			Scroll = "(1-2-3-4)";
			break;
		}
		case 5: {
			Scroll = "(1-2-3-4-5)";
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + getBattles().size());
		}
		System.out.println("Battle Reports\nSelect Reports Read (0 go back)"+Scroll+"\nOption>");
	}
	
	public void seleccionarBattle() {
		dibujitoScroll();
		Scanner sc = new Scanner(System.in);
		try {
			int i = sc.nextInt();
			System.out.println(getBattles().get(i-1).getBattleReport(i));
			mostrarDevelop(getBattles().get(i-1));
		} catch (Exception e) {
			CambioMenuINICIO(MostrarMenu());
		}
	}

	public ArrayList<Battle> getBattles() {
		return Battles;
	}

	public void setBattles(ArrayList<Battle> battles) {
		Battles = battles;
	}
	
	public void insertarBatallas(Battle batalla){
		getBattles().add(batalla);
		if (getBattles().size()==5) {
			getBattles().remove(4);
		}
	}
	public void mostrarDevelop(Battle b) {
		Scanner sc = new Scanner(System.in);
		String sn = sc.nextLine();
		switch (sn) {
		case "s": {
			System.out.println(b.getBattleDevelopment());
			seleccionarBattle();
			break;
		}
		default:
			seleccionarBattle();
			break;
		}
		
	}
	
	
}
