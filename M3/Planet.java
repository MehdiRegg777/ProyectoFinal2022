import java.util.ArrayList;
import java.util.Iterator;

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
		System.out.println("Deuterium			"+getDeuterium());
		
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
	}
	public static void main(String[] args){
		Planet p1 = new Planet();
		p1.printStats();
		
	}
	
	public void upgradeTechnologyDefense() throws ResourceException {
		if (this.upgradeDefenseTechnologyDeuteriumCost > this.deuterium) throw new ResourceException("Sin Recursos suficientes");
		else {
			++this.technologyDefense;
			this.deuterium -= this.upgradeDefenseTechnologyDeuteriumCost;
			this.upgradeDefenseTechnologyDeuteriumCost = this.upgradeDefenseTechnologyDeuteriumCost + (this.upgradeDefenseTechnologyDeuteriumCost * Variables.UPGRADE_PLUS_DEFENSE_TECHNOLOGY_DEUTERIUM_COST) / 100;
		}
	}
	
	public void upgradeTechnologyAttack() throws ResourceException {
		if (this.upgradeAttackTechnologyDeuteriumCost > this.deuterium) throw new ResourceException("Sin Recursos suficientes");
		else {
			++this.technologyAttack;
			this.deuterium -= this.upgradeAttackTechnologyDeuteriumCost;
			this.upgradeAttackTechnologyDeuteriumCost = this.upgradeAttackTechnologyDeuteriumCost + (this.upgradeAttackTechnologyDeuteriumCost * Variables.UPGRADE_PLUS_ATTACK_TECHNOLOGY_DEUTERIUM_COST) / 100;
		}
	}
}
