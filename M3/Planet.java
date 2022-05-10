import java.util.ArrayList;
import java.util.Iterator;

public class Planet {
	private int technologyDefense;
	private int technologyAtack;
	private int metal;
	private int deuterium;
	private int upgradeDefenseTechnologyDeuteriumCost;
	private int upgradeAttackTechnologyDeuteriumCost;
	ArrayList<MilitaryUnit>[] army = new ArrayList[7];

	
	public void printStats(){
		for(int i = 0; i < 7; i++) {
			if (army[i] == null) {
				army[i] = new ArrayList<>();
			}
		}
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
		return technologyAtack;
	}
	public void setTechnologyAtack(int technologyAtack) {
		this.technologyAtack = technologyAtack;
	}
	
	public void newLigthHunter(int n){
	}
	
	public void newHeavyHunter(int n){
	}
	
	public void newBattleShip(int n){
	}
	
	public void newArmoredShip(int n){
	}
	
	public void newMissileLauncher(int n) throws ResourceException {
		int contador = 0;
		army[4] = new ArrayList<>();
		MissileLauncher d = new MissileLauncher();
			for(int i = 0; i < n; i++) {
			if (this.metal>=d.getMetalCost()) {
				this.metal = this.metal - d.getMetalCost();
				army[4].add(new MissileLauncher(d.getInitialArmor()+technologyDefense*Variables.PLUS_ARMOR_MISSILELAUNCHER_BY_TECHNOLOGY*d.getInitialArmor()/100,
												d.getBaseDamage()+technologyAtack*Variables.PLUS_ATTACK_MISSILELAUNCHER_BY_TECHNOLOGY*d.getBaseDamage()/100));
				contador += 1;
			}
			else {
				throw new ResourceException("Not enough metal for Missile Launcher\n\nSe han insertado "+contador+" Missile launcher\n");
			}
		}
			
	}
	public void newIonCannon(int n){
	}
	
	public void newPlasmaCannon(int n) {
	}
	public static void main(String[] args){
		Planet p1 = new Planet();
		try {
			p1.newMissileLauncher(2);
		} catch (ResourceException e) {
			System.out.println(e.getMessage());
		}
		p1.printStats();
		
	}
}
