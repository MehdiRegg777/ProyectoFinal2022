import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Planet{
	private int technologyDefense;
	private int technologyAttack;
	private int metal;
	private int deuterium;
	private int upgradeDefenseTechnologyDeuteriumCost;
	private int upgradeAttackTechnologyDeuteriumCost;
	ArrayList<MilitaryUnit>[] army = new ArrayList[7];
	
	public Planet() {
		super();
		this.technologyAttack = 0;
		this.technologyDefense = 0;
		this.metal = 300000;
		this.deuterium = 250000;
		this.upgradeDefenseTechnologyDeuteriumCost = Variables.UPGRADE_BASE_DEFENSE_TECHNOLOGY_DEUTERIUM_COST;
		this.upgradeAttackTechnologyDeuteriumCost = Variables.UPGRADE_BASE_ATTACK_TECHNOLOGY_DEUTERIUM_COST;
		
		ArrayList<MilitaryUnit> lh = new ArrayList<MilitaryUnit>();
		ArrayList<MilitaryUnit> hh = new ArrayList<MilitaryUnit>();
		ArrayList<MilitaryUnit> bs = new ArrayList<MilitaryUnit>();
		ArrayList<MilitaryUnit> as = new ArrayList<MilitaryUnit>();
		ArrayList<MilitaryUnit> ml = new ArrayList<MilitaryUnit>();
		ArrayList<MilitaryUnit> ic = new ArrayList<MilitaryUnit>();
		ArrayList<MilitaryUnit> pc = new ArrayList<MilitaryUnit>();
		
		this.army[0] = lh;
		this.army[1] = hh;
		this.army[2] = bs;
		this.army[3] = as;
		this.army[4] = ml;
		this.army[5] = ic;
		this.army[6] = pc;
	}
	
	public int getUpgradeDefenseTechnologyDeuteriumCost() {
		return upgradeDefenseTechnologyDeuteriumCost;
	}

	public void setUpgradeDefenseTechnologyDeuteriumCost(int upgradeDefenseTechnologyDeuteriumCost) {
		this.upgradeDefenseTechnologyDeuteriumCost = upgradeDefenseTechnologyDeuteriumCost;
	}

	public int getUpgradeAttackTechnologyDeuteriumCost() {
		return upgradeAttackTechnologyDeuteriumCost;
	}

	public void setUpgradeAttackTechnologyDeuteriumCost(int upgradeAttackTechnologyDeuteriumCost) {
		this.upgradeAttackTechnologyDeuteriumCost = upgradeAttackTechnologyDeuteriumCost;
	}

	public void printStats(){
		
		System.out.println("Planet Stats:\n\n");
		System.out.println("TECHNOLOGY\n");
		System.out.println("Atack Technology		"+getTechnologyAtack());
		System.out.println("Defende Technology		"+getTechnologyDefense());
		System.out.println("\nDEFENSES\n");
		System.out.println("Missile Launcher		"+army[4].size());
		System.out.println("Ion Cannon			"+army[5].size());
		System.out.println("Plasma Cannon			"+army[6].size());
		System.out.println("\nFLEET\n");
		System.out.println("Light Hunter			"+army[0].size());
		System.out.println("Heavy Hunter			"+army[1].size());
		System.out.println("Battle Ship			"+army[2].size());
		System.out.println("Armored Ship			"+army[3].size());
		System.out.println("\nRESOURCES\n");
		System.out.println("Metal				"+getMetal());
		System.out.println("Deuterium			"+getDeuterium()+"\n");
		
	}
	
	public int getMetal() {
		return metal;
	}

	public void setMetal(int metal) {
		this.metal = metal;
	}

	public int getDeuterium() {
		return deuterium;
	}

	public void setDeuterium(int deuterium) {
		this.deuterium = deuterium;
	}

	public int getTechnologyDefense() {
		return technologyDefense;
	}
	public void setTechnologyDefense(int technologyDefense) {
		this.technologyDefense = technologyDefense;
	}
	public int getTechnologyAtack() {
		return technologyAttack;
	}
	public void setTechnologyAtack(int technologyAtack) {
		this.technologyAttack = technologyAtack;
	}
	
	public void newLigthHunter(int n) throws ResourceException {
		int contador = 0;
		LigthHunter d = new LigthHunter();
			for(int i = 0; i < n; i++) {
			if (this.metal>=d.getMetalCost()) {
				this.metal -= d.getMetalCost();
				army[0].add(new LigthHunter(d.getInitialArmor()+this.technologyDefense*Variables.PLUS_ARMOR_LIGTHHUNTER_BY_TECHNOLOGY*d.getInitialArmor()/100,
												d.getBaseDamage()+this.technologyAttack*Variables.PLUS_ATTACK_LIGTHHUNTER_BY_TECHNOLOGY*d.getBaseDamage()/100));
				contador += 1;
			}
			else {
				throw new ResourceException("Not enough metal for Ligth Hunter\n\nSe han insertado "+contador+" Ligth Hunter\n");
			}
		}
			System.out.println("Added "+contador+" LigthHunter");
			insertNaves(1, contador, 0);
	}
	
	public void newHeavyHunter(int n) throws ResourceException {
		int contador = 0;
		HeavyHunter d = new HeavyHunter();
			for(int i = 0; i < n; i++) {
			if (this.metal>=d.getMetalCost()) {
				this.metal -= d.getMetalCost();
				army[1].add(new HeavyHunter(d.getInitialArmor()+this.technologyDefense*Variables.PLUS_ARMOR_HEAVYHUNTER_BY_TECHNOLOGY*d.getInitialArmor()/100,
												d.getBaseDamage()+this.technologyAttack*Variables.PLUS_ATTACK_HEAVYHUNTER_BY_TECHNOLOGY*d.getBaseDamage()/100));
				contador += 1;
			}
			else {
				throw new ResourceException("Not enough metal for Heavy Hunter\n\nSe han insertado "+contador+" Heavy Hunter\n");
			}
		}
			System.out.println("Added "+contador+" HeavyHunter");
			insertNaves(2, contador, 0);
	}	
	public void newBattleShip(int n) throws ResourceException {
		int contador = 0;
		BattleShip d = new BattleShip();
			for(int i = 0; i < n; i++) {
			if (this.metal>=d.getMetalCost()) {
				this.metal -= d.getMetalCost();
				army[2].add(new BattleShip(d.getInitialArmor()+this.technologyDefense*Variables.PLUS_ARMOR_BATTLESHIP_BY_TECHNOLOGY*d.getInitialArmor()/100,
												d.getBaseDamage()+this.technologyAttack*Variables.PLUS_ATTACK_BATTLESHIP_BY_TECHNOLOGY*d.getBaseDamage()/100));
				contador += 1;
			}
			else {
				throw new ResourceException("Not enough metal for Battle Ship\n\nSe han insertado "+contador+" Battle Ship\n");
			}
		}
			System.out.println("Added "+contador+" BattleShip");
			insertNaves(3, contador, 0);
	}
	
	public void newArmoredShip(int n) throws ResourceException {
		int contador = 0;
		ArmoredShip d = new ArmoredShip();
			for(int i = 0; i < n; i++) {
			if (this.metal>=d.getMetalCost()) {
				this.metal -= d.getMetalCost();
				army[3].add(new ArmoredShip(d.getInitialArmor()+this.technologyDefense*Variables.PLUS_ARMOR_ARMOREDSHIP_BY_TECHNOLOGY*d.getInitialArmor()/100,
												d.getBaseDamage()+this.technologyAttack*Variables.PLUS_ATTACK_ARMOREDSHIP_BY_TECHNOLOGY*d.getBaseDamage()/100));
				contador += 1;
			}
			else {
				throw new ResourceException("Not enough metal for Armored Ship\n\nSe han insertado "+contador+" Armored Ship\n");
			}
		}
			System.out.println("Added "+contador+" BattleShip");
			insertNaves(4, contador, 0);
	}
	public void newMissileLauncher(int n) throws ResourceException {
		int contador = 0;
		MissileLauncher d = new MissileLauncher();
			for(int i = 0; i < n; i++) {
			if (this.metal>=d.getMetalCost()) {
				this.metal -= d.getMetalCost();
				army[4].add(new MissileLauncher(d.getInitialArmor()+this.technologyDefense*Variables.PLUS_ARMOR_MISSILELAUNCHER_BY_TECHNOLOGY*d.getInitialArmor()/100,
												d.getBaseDamage()+this.technologyAttack*Variables.PLUS_ATTACK_MISSILELAUNCHER_BY_TECHNOLOGY*d.getBaseDamage()/100));
				contador += 1;
			}
			else {
				throw new ResourceException("Not enough metal for Missile Launcher\n\nSe han insertado "+contador+" Missile launcher\n");
			}
		}
			System.out.println("Added "+contador+" MissileLauncher");
			insertDefenses(1,contador,0);
	}
	public void newIonCannon(int n) throws ResourceException {
		int contador = 0;
		IonCannon d = new IonCannon();
			for(int i = 0; i < n; i++) {
			if (this.metal>=d.getMetalCost()) {
				this.metal -= d.getMetalCost();
				army[5].add(new IonCannon(d.getInitialArmor()+this.technologyDefense*Variables.PLUS_ARMOR_IONCANNON_BY_TECHNOLOGY*d.getInitialArmor()/100,
												d.getBaseDamage()+this.technologyAttack*Variables.PLUS_ATTACK_IONCANNON_BY_TECHNOLOGY*d.getBaseDamage()/100));
				contador += 1;
			}
			else {
				throw new ResourceException("Not enough metal for Ion Cannon\n\nSe han insertado "+contador+" Ion Cannon\n");
			}
		}
			System.out.println("Add "+contador+" IonCannon");
			insertDefenses(2,contador,0);
	}
	
	public void newPlasmaCannon(int n) throws ResourceException {
		int contador = 0;
		PlasmaCannon d = new PlasmaCannon();
			for(int i = 0; i < n; i++) {
			if (this.metal>=d.getMetalCost()) {
				this.metal -= d.getMetalCost();
				army[6].add(new PlasmaCannon(d.getInitialArmor()+this.technologyDefense*Variables.PLUS_ARMOR_PLASMACANNON_BY_TECHNOLOGY*d.getInitialArmor()/100,
												d.getBaseDamage()+this.technologyAttack*Variables.PLUS_ATTACK_PLASMACANNON_BY_TECHNOLOGY*d.getBaseDamage()/100));
				contador += 1;
			}
			else {
				throw new ResourceException("Not enough metal for Plasma Cannon\n\nSe han insertado "+contador+" Plasma Cannon\n");
			}
		}
			System.out.println("Added "+contador+" PlasmaCannon");
			insertDefenses(3,contador,0);
	}
	public static void main(String[] args){
		Planet p1 = new Planet();
		p1.printStats();
		
	}
	
	public ArrayList<MilitaryUnit>[] getArmy() {
		return army;
	}

	public void setArmy(ArrayList<MilitaryUnit>[] army) {
		this.army = army;
	}

	public void upgradeTechnologyDefense() throws ResourceException {
		if (this.upgradeDefenseTechnologyDeuteriumCost > this.deuterium) 
			throw new ResourceException("\n\nNot enough Deuterium!!!\n\n");
		else {
			++this.technologyDefense;
			this.deuterium -= this.upgradeDefenseTechnologyDeuteriumCost;
			this.upgradeDefenseTechnologyDeuteriumCost = this.upgradeDefenseTechnologyDeuteriumCost + (this.upgradeDefenseTechnologyDeuteriumCost * Variables.UPGRADE_PLUS_DEFENSE_TECHNOLOGY_DEUTERIUM_COST) / 100;
		}
	}
	
	public void upgradeTechnologyAttack() throws ResourceException {
		if (this.upgradeAttackTechnologyDeuteriumCost > this.deuterium) 
			throw new ResourceException("\n\nNot enough Deuterium!!!\n\n");
		else {
			++this.technologyAttack;
			this.deuterium -= this.upgradeAttackTechnologyDeuteriumCost;
			this.upgradeAttackTechnologyDeuteriumCost = this.upgradeAttackTechnologyDeuteriumCost + (this.upgradeAttackTechnologyDeuteriumCost * Variables.UPGRADE_PLUS_ATTACK_TECHNOLOGY_DEUTERIUM_COST) / 100;
		}
	}
	public void login_player() {
		Scanner sc = new Scanner(System.in);
		
	}
	public CallableStatement data_bbdd(int id){ //con este metodo vamos a coger los datos de la tabla de ship dentro de la base de datos.
        Connection cn = null;
        
    	try {
			cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "P@ssw0rd");
            CallableStatement cst = cn.prepareCall("{call GET_SHIP (?,?,?,?,?,?,?,?,?,?)}");
            cst.setInt(1, id); //id
            cst.registerOutParameter(2, java.sql.Types.VARCHAR); //nombre
            cst.registerOutParameter(3, java.sql.Types.INTEGER);//metalcost
            cst.registerOutParameter(4, java.sql.Types.INTEGER);//crystal
            cst.registerOutParameter(5, java.sql.Types.INTEGER);//deuterium_cost
            cst.registerOutParameter(6, java.sql.Types.INTEGER);//initialarmor
            cst.registerOutParameter(7, java.sql.Types.INTEGER);//armor
            cst.registerOutParameter(8, java.sql.Types.INTEGER);//basedamage
            cst.registerOutParameter(9, java.sql.Types.INTEGER);//speed
            cst.registerOutParameter(10, java.sql.Types.INTEGER);//generate wasting
            cst.execute();
            return cst;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Ha habido un error");
			return null;
		}
	}
	public CallableStatement crearplaneta() {//crea el planeta en la base de datos segun los datos del juego o saca lo valores de planeta para luego introducirlos
        Connection cn = null;
        try {
			cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "P@ssw0rd");
            CallableStatement cst = cn.prepareCall("{call crearplaneta (?,?,?,?,?,?,?)}");
            cst.setString(1, "Planeta Andromeda");
            cst.registerOutParameter(2, java.sql.Types.INTEGER);
            cst.registerOutParameter(3, java.sql.Types.INTEGER);
            cst.registerOutParameter(4, java.sql.Types.INTEGER);
            cst.registerOutParameter(5, java.sql.Types.INTEGER);
            cst.setInt(6, getMetal());
            cst.setInt(7, getDeuterium());
            cst.execute();
            return cst;
            
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Ha habido un error al crear el planeta");
		}
		return null;
	}
	
	public void insertDefenses(int num, int cantidad,int eliminar) {
        Connection cn = null;

		try {
			cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "P@ssw0rd");
            CallableStatement cst = cn.prepareCall("{call CREARDEFENSAS (?,?,?)}");
            cst.setInt(1, num); //id
            cst.setInt(2, cantidad);
            cst.setInt(3, eliminar);
            cst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Ha habido un error");
		}
	}
	public void insertNaves(int num, int cantidad,int eliminar) {
        Connection cn = null;

		try {
			cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "P@ssw0rd");
            CallableStatement cst = cn.prepareCall("{call CREARATAQUE (?,?,?)}");
            cst.setInt(1, num); //id
            cst.setInt(2, cantidad);
            cst.setInt(3, eliminar);
            cst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Ha habido un error");
		}
	}
	public void updateResources(int metal, int deuterium, int tca, int tcd) {
        Connection cn = null;
        try {
			cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "P@ssw0rd");
            CallableStatement cst = cn.prepareCall("{call dataupdate (?,?,?,?)}");
            cst.setInt(1, metal);
            cst.setInt(2, deuterium);
            cst.setInt(3, tca);
            cst.setInt(4, tcd);
            cst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Ha habido un error");
		}
	}
	
}


