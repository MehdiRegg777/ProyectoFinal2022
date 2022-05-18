import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Battle {
	private ArrayList<MilitaryUnit>[] planetArmy;
	private ArrayList<MilitaryUnit>[] enemyArmy;
	private ArrayList[][] armies;
	private String battleDevelopment;
	

	private int[][] initialCostFleet;
	private int initialNumberUnitsPlanet, initialNumberUnitsEnemy;
	private int[] wasteMetalDeuterium;
	private int[] enemyDrops, planetDrops;
	private int[][] resourcesLooses;
	private int[][] initialArmies;
	private int[] actualNumberUnitsPlanet, actualNumberUnitsEnemy;
	
	
	
	public Battle( ArrayList<MilitaryUnit>[] Army , ArrayList<MilitaryUnit>[] enemyArmy) {
		
		this.enemyArmy = enemyArmy;
		this.planetArmy = Army;
		
		this.initialCostFleet = new int[2][2];
		fleetResourceCost();
		
		initialFleetNumber(Army);
		initialFleetNumber(enemyArmy);
		
		this.actualNumberUnitsPlanet = new int[7];

		UpdateActualArmy(planetArmy);
		
		this.actualNumberUnitsEnemy = new int[4];
		
		UpdateActualArmy(enemyArmy);
		
		this.wasteMetalDeuterium = new int[2];
		
		wasteMetalDeuterium[0] = 0;
		wasteMetalDeuterium[1] = 0;
		
		this.enemyDrops = new int[4];
		
		this.enemyDrops[0] = 0;
		this.enemyDrops[1] = 0;
		this.enemyDrops[2] = 0;
		this.enemyDrops[3] = 0;
		
		this.planetDrops = new int[7];

		this.planetDrops[0] = 0;
		this.planetDrops[1] = 0;
		this.planetDrops[2] = 0;
		this.planetDrops[3] = 0;
		this.planetDrops[4] = 0;
		this.planetDrops[5] = 0;
		this.planetDrops[6] = 0;
		
		this.resourcesLooses = new int[2][3];
		
		this.resourcesLooses[0][0] = 0;
		this.resourcesLooses[0][1] = 0;
		this.resourcesLooses[0][2] = 0;
		this.resourcesLooses[1][0] = 0;
		this.resourcesLooses[1][1] = 0;
		this.resourcesLooses[1][2] = 0;
		
		this.initialArmies = new int[2][7];
		
		this.initialArmies[0][0] = 0;
		this.initialArmies[0][1] = 0;
		this.initialArmies[0][2] = 0;
		this.initialArmies[0][3] = 0;
		this.initialArmies[0][4] = 0;
		this.initialArmies[0][5] = 0;
		this.initialArmies[0][6] = 0;
		this.initialArmies[1][0] = 0;
		this.initialArmies[1][1] = 0;
		this.initialArmies[1][2] = 0;
		this.initialArmies[1][3] = 0;
		
		this.wasteMetalDeuterium = new int[2];
		
		this.wasteMetalDeuterium[0] = 0;
		this.wasteMetalDeuterium[1] = 0;
		
		initInitialArmies();
		
		
		
		ArrayList<MilitaryUnit>[] A = BeginRandomTurn();
		ArrayList<MilitaryUnit>[] D;
		if (A == getPlanetArmy()) {
			D = getEnemyArmy();
		}
		else {
			D = getPlanetArmy();
		}
		
		this.battleDevelopment = "START THE BATTLE\n";
		
		while (remainderPercentageFleet(getPlanetArmy())>20 && remainderPercentageFleet(getEnemyArmy())>20) {
			ArrayList<MilitaryUnit>[] AUX = A;
			 A = D;
			 D = AUX;
			 int PGA = getPlanetGroupAttacker(); // ESTO ES EL GRUPO DEL PLANETA ATACANTE
			 int GD = getGroupDefender(D); // GRUPO DEFENSOR
			 int EGA = getEnemyGroupAttacker(); // ESTO ES EL GRUPO DEL ENEMIGO ATACANTE

				 if (A == getPlanetArmy() && GD <4 && PGA<7) {
					 int PUA = (int)(Math.random()*this.actualNumberUnitsPlanet[PGA]); // UNIDAD ALEATORIA DEL GRUPO PLANETA ATACANTE
					 int UDE = (int)(Math.random()*this.actualNumberUnitsEnemy[GD]); // UNIDAD DEL GRUPO DEFENSOR
						D[GD].get(UDE).tekeDamage(A[PGA].get(PUA).attack());
						this.battleDevelopment += ("Attacks Planet: "+getnameship_planet(PGA)+" attacks "+ getnameship_enemy(GD)+ "\n"+getnameship_planet(PGA)+" generates the damage = "+ A[PGA].get(PUA).attack()+"\n"+getnameship_enemy(GD)+" stays with armor = "+D[GD].get(UDE).getActualArmor()+"\n");
						if (D[GD].get(UDE).getActualArmor()<=0) {//SI MUEREN LAS NAVES DEL ENEMIGO ENTONCES
							if ((int)(Math.random()*100)<=D[GD].get(UDE).getChanceGeneratinWaste()) {
								getWasteMetalDeuterium()[0] += D[GD].get(UDE).getMetalCost()*70/100;
								getWasteMetalDeuterium()[1] += D[GD].get(UDE).getDeuteriumCost()*70/100;
							}
							this.battleDevelopment += ("We eliminate "+ getnameship_enemy(GD)+"\n");
							D[GD].remove(UDE);
							this.enemyDrops[GD]++;
							
						}
						UpdateActualArmy(D);
						setEnemyArmy(D);
						
						 if (A[PGA].get(PUA).getChanceAttackAgain()>=(int)(Math.random()*100)) {
							 AUX = A;
							 A = D;
							 D = AUX;
							}else {
								this.battleDevelopment +=("\n*************************Change Attacker*************************\n");

							}
						
						
					}
					 else if(A == getEnemyArmy() && GD <7 && EGA<4) {
						int UDP = (int)(Math.random()*this.actualNumberUnitsPlanet[GD]); // UNIDAD DEL GRUPO DEFENSOR	
						int EUA = (int)(Math.random()*this.actualNumberUnitsEnemy[EGA]); //UNIDAD ALEATORIA DEL GRUPO ENEMIGO ATACANTE
						D[GD].get(UDP).tekeDamage(A[EGA].get(EUA).attack());
						this.battleDevelopment +=("Attacks fleet enemy: "+getnameship_enemy(EGA)+" attacks "+ getnameship_planet(GD)+ "\n"+getnameship_enemy(EGA)+" generates the damage = "+ A[EGA].get(EUA).attack()+"\n"+getnameship_planet(GD)+" stays with armor = "+D[GD].get(UDP).getActualArmor()+"\n");
						if (D[GD].get(UDP).getActualArmor()<=0) { //SI MUEREN LAS NAVES DEL PLANETA ENTONCES
							if ((int)(Math.random()*100)<=D[GD].get(UDP).getChanceGeneratinWaste()) {
								getWasteMetalDeuterium()[0] += D[GD].get(UDP).getMetalCost()*70/100;
								getWasteMetalDeuterium()[1] += D[GD].get(UDP).getDeuteriumCost()*70/100;
							}
							this.battleDevelopment += ("They eliminate "+ getnameship_planet(GD)+"\n");
							D[GD].remove(UDP);
							this.planetDrops[GD]++;
							
							
						}
						
						
						UpdateActualArmy(D);
						setPlanetArmy(D);
						
						if (A[EGA].get(EUA).getChanceAttackAgain()>(int)(Math.random()*100)) {
							 AUX = A;
							 A = D;
							 D = AUX;
							}else {
								this.battleDevelopment +=("\n*************************Change Attacker*************************\n");

							}
					}
				 
		}
		updateResourcesLooses();
		}
		
	
	
	public String getBattleReport(int battles) {
		String report = "";
		String winner;
		if (getResourcesLooses()[0][2]<getResourcesLooses()[1][2]) {
			winner = "Battle Winned by Planeta, We collect Rubble";
		}else if (getResourcesLooses()[0][2]>getResourcesLooses()[1][2]) {
			winner = "Battle Winned by Enemy, We do not collect Rubble";
		}else {
			winner = "Empate";
		}
		report +=("BATTLE NUMBER "+ battles+"\nArmy Planet			Units	Drops	Initial Army Enemy	Units	Drops\n") ;
		
		for (int i=0;i<getPlanetArmy().length;i++) {
			if (i == 4) {
				report += getnameship_planet(i)+"		";
			}else {
				report += getnameship_planet(i)+"			";
			}
			report += getInitialArmies()[0][i]+"	"+getPlanetDrops()[i]+"	";
			if (i<4) {
				report += getnameship_enemy(i)+"		"+getInitialArmies()[1][i]+"	"+getEnemyDrops()[i]+"	\n";
			}else {
				report += "\n";
			}
		}
		
		report += "\n***********************************************************************************************\n\n";
		
		report += "Cost Army Planet					Cost Army Enemy\n\nMetal:			"+ getInitialCostFleet()[0][0]+"				Metal:			"+getInitialCostFleet()[1][0]+"\n";
		report += "Deuterium:		"+ getInitialCostFleet()[0][1]+"				Deuterium:		"+getInitialCostFleet()[1][1]+"\n";

		report += "\n***********************************************************************************************\n\n";
		
		report += "Losses Army Planet					Losses Army Enemy\n\nMetal:			"+ getResourcesLooses()[0][0]+"				Metal:			"+getResourcesLooses()[1][0]+"\n";
		report += "Deuterium:		"+ getResourcesLooses()[0][1]+"				Deuterium:		"+getResourcesLooses()[1][1]+"\n";
		report += "Weighted:		"+ getResourcesLooses()[0][2]+"				Weighted:		"+getResourcesLooses()[1][2]+"\n";

		report += "\n***********************************************************************************************\n\n";
		
		report += "Waste generate\nMetal:			"+getWasteMetalDeuterium()[0]+"\nDeuterium:		"+getWasteMetalDeuterium()[1]+"\n\n";
		report += winner;
		report += "\n***********************************************************************************************\n\n";
		report += "View Battle development?(S/n)\n\n";

		return report;
	}
	
	public String getBattleDevelopment() {
		return battleDevelopment;
	}
	
	public void initInitialArmies() {
		for (int i=0;i<getPlanetArmy().length;i++) {
			getInitialArmies()[0][i] = getPlanetArmy()[i].size();
		}
		
		for (int i=0;i<getEnemyArmy().length;i++) {
			getInitialArmies()[1][i] = getEnemyArmy()[i].size();
		}
		
	}
	
	public void updateResourcesLooses() {
		for (int i=0;i<planetDrops.length;i++) {
			try {
				if (getPlanetArmy()[i].size() != 0) {
					this.resourcesLooses[0][0] = planetDrops[i] * getPlanetArmy()[i].get(0).getMetalCost();
					this.resourcesLooses[0][1] = planetDrops[i] * getPlanetArmy()[i].get(0).getDeuteriumCost();
					this.resourcesLooses[0][2] = (planetDrops[i] * getPlanetArmy()[i].get(0).getMetalCost())+5*(planetDrops[i] * getPlanetArmy()[i].get(0).getDeuteriumCost());
				}
			} catch (Exception e) {
			}
		}
		for (int i=0;i<enemyDrops.length;i++) {
			try {
				if (getEnemyArmy()[i].size() != 0) {
					this.resourcesLooses[1][0] = enemyDrops[i] * getEnemyArmy()[i].get(0).getMetalCost();
					this.resourcesLooses[1][1] = enemyDrops[i] * getEnemyArmy()[i].get(0).getDeuteriumCost();
					this.resourcesLooses[1][2] = (enemyDrops[i] * getEnemyArmy()[i].get(0).getMetalCost())+5*(enemyDrops[i] * getEnemyArmy()[i].get(0).getDeuteriumCost());
				}
			} catch (Exception e) {
			}
			
				
		}
		
	}
	
	public void fleetResourceCost(){
		
		int cost_metal_planet = 0;
		int cost_metal_enemy = 0;
		int cost_deuterium_enemy = 0;
		int cost_deuterium_planet = 0;

			
		for (int i=0;i<enemyArmy.length;i++) {
			for (int j=0;j<enemyArmy[i].size();j++) {
				cost_metal_enemy += enemyArmy[i].get(j).getMetalCost();
				cost_deuterium_enemy += enemyArmy[i].get(j).getDeuteriumCost();
			}
		}
		for (int i=0;i<planetArmy.length;i++) {
			for (int j=0;j<planetArmy[i].size();j++) {
				cost_metal_planet += planetArmy[i].get(j).getMetalCost();
				cost_deuterium_planet += planetArmy[i].get(j).getDeuteriumCost();
			}
		}
	
		this.initialCostFleet[0][0] = cost_metal_planet;
		this.initialCostFleet[0][1] = cost_deuterium_planet;
		this.initialCostFleet[1][0] = cost_metal_enemy;
		this.initialCostFleet[1][1] = cost_deuterium_enemy;
		
	}
	
	public void initialFleetNumber(ArrayList<MilitaryUnit>[] army){
		int contador = 0;
		for (int i=0;i<army.length;i++) {
			contador+=army[i].size();
		}
		if (army.length == 7) {
			this.initialNumberUnitsPlanet = contador;
		}
		else {
			this.initialNumberUnitsEnemy = contador;
		}
		
	}
	public int remainderPercentageFleet(ArrayList<MilitaryUnit>[] army){
		int actualTotalUnits = 0;
		try {
			if (army.length == 7) {
				for (int i=0;i<actualNumberUnitsPlanet.length;i++){
					actualTotalUnits += actualNumberUnitsPlanet[i];
				}
				return actualTotalUnits*100/this.initialNumberUnitsPlanet;	
			}
			else {
				for (int i=0;i<actualNumberUnitsEnemy.length;i++){
					actualTotalUnits += actualNumberUnitsEnemy[i];
				}
				return actualTotalUnits*100/this.initialNumberUnitsEnemy;
			}
		} catch (Exception e) {
			return 0;
		}
	}
	
	public int getGroupDefender(ArrayList<MilitaryUnit>[] army) {
		int aleatorio = (int) (Math.random()*100);
		int actualTotalUnits = 0;
		
		if (army.length == 7) {
			for (int i=0;i<actualNumberUnitsPlanet.length;i++){
				actualTotalUnits += actualNumberUnitsPlanet[i];
			}	
		}
		else {
			for (int i=0;i<actualNumberUnitsEnemy.length;i++){
				actualTotalUnits += actualNumberUnitsEnemy[i];
			}
		}
		if(army.length == 7) {
			if (aleatorio<100*actualNumberUnitsPlanet[0]/actualTotalUnits) {
				return 0;
			}
			else if (aleatorio<100*actualNumberUnitsPlanet[0]/actualTotalUnits + 100*actualNumberUnitsPlanet[1]/actualTotalUnits) {
				return 1;
			}
			else if (aleatorio<100*actualNumberUnitsPlanet[0]/actualTotalUnits + 100*actualNumberUnitsPlanet[1]/actualTotalUnits + 100*actualNumberUnitsPlanet[2]/actualTotalUnits) {
				return 2;
			}
			else if (aleatorio<100*actualNumberUnitsPlanet[0]/actualTotalUnits + 100*actualNumberUnitsPlanet[1]/actualTotalUnits + 100*actualNumberUnitsPlanet[2]/actualTotalUnits + 100*actualNumberUnitsPlanet[3]/actualTotalUnits) {
				return 3;
			}
			else if (aleatorio<100*actualNumberUnitsPlanet[0]/actualTotalUnits + 100*actualNumberUnitsPlanet[1]/actualTotalUnits + 100*actualNumberUnitsPlanet[2]/actualTotalUnits + 100*actualNumberUnitsPlanet[3]/actualTotalUnits + 100*actualNumberUnitsPlanet[4]/actualTotalUnits) {
				return 4;
			}
			else if (aleatorio<100*actualNumberUnitsPlanet[0]/actualTotalUnits + 100*actualNumberUnitsPlanet[1]/actualTotalUnits + 100*actualNumberUnitsPlanet[2]/actualTotalUnits + 100*actualNumberUnitsPlanet[3]/actualTotalUnits + 100*actualNumberUnitsPlanet[4]/actualTotalUnits + 100*actualNumberUnitsPlanet[5]/actualTotalUnits)  {
				return 5;
			}
			else if (aleatorio<100*actualNumberUnitsPlanet[0]/actualTotalUnits + 100*actualNumberUnitsPlanet[1]/actualTotalUnits + 100*actualNumberUnitsPlanet[2]/actualTotalUnits + 100*actualNumberUnitsPlanet[3]/actualTotalUnits + 100*actualNumberUnitsPlanet[4]/actualTotalUnits + 100*actualNumberUnitsPlanet[5]/actualTotalUnits + 100*actualNumberUnitsPlanet[6]/actualTotalUnits) {
				return 6;
			}
			else {
				return 7;
			}
		}
		else {
			if (aleatorio<100*actualNumberUnitsEnemy[0]/actualTotalUnits) {
				return 0;
			}
			else if (aleatorio<100*actualNumberUnitsEnemy[0]/actualTotalUnits + 100*actualNumberUnitsEnemy[1]/actualTotalUnits) {
				return 1;
			}
			else if (aleatorio<100*actualNumberUnitsEnemy[0]/actualTotalUnits + 100*actualNumberUnitsEnemy[1]/actualTotalUnits + 100*actualNumberUnitsEnemy[2]/actualTotalUnits) {
				return 2;
			}
			else if (aleatorio<100*actualNumberUnitsEnemy[0]/actualTotalUnits + 100*actualNumberUnitsEnemy[1]/actualTotalUnits + 100*actualNumberUnitsEnemy[2]/actualTotalUnits + 100*actualNumberUnitsEnemy[3]/actualTotalUnits) {
				return 3;
			}
			else {
				return 4;
			}
		}
		
		
	}
	
	public int getPlanetGroupAttacker() {
		int aleatorio = (int) (Math.random()*100);
		int actualTotalUnits = 0;
		
		for (int i=0;i<actualNumberUnitsPlanet.length;i++){
			actualTotalUnits += actualNumberUnitsPlanet[i];
		}
		
		if (aleatorio<Variables.CHANCE_ATTACK_PLANET_UNITS[0]) {
			if (actualNumberUnitsPlanet[0]>0) {
				return 0;
			}else {
				return getPlanetGroupAttacker();
			}
		}
		else if (aleatorio<Variables.CHANCE_ATTACK_PLANET_UNITS[0]+Variables.CHANCE_ATTACK_PLANET_UNITS[1]) {
			if (actualNumberUnitsPlanet[1]>0) {
				return 1;
			}else {
				return getPlanetGroupAttacker();
			}
		}
		else if (aleatorio<Variables.CHANCE_ATTACK_PLANET_UNITS[0]+Variables.CHANCE_ATTACK_PLANET_UNITS[1]+Variables.CHANCE_ATTACK_PLANET_UNITS[2]) {
			if (actualNumberUnitsPlanet[2]>0) {
				return 2;
			}else {
				return getPlanetGroupAttacker();
			}
		}
		else if (aleatorio<Variables.CHANCE_ATTACK_PLANET_UNITS[0]+Variables.CHANCE_ATTACK_PLANET_UNITS[1]+Variables.CHANCE_ATTACK_PLANET_UNITS[2]+Variables.CHANCE_ATTACK_PLANET_UNITS[3]) {
			if (actualNumberUnitsPlanet[3]>0) {
				return 3;
			}else {
				return getPlanetGroupAttacker();
			}
		}
		else if (aleatorio<Variables.CHANCE_ATTACK_PLANET_UNITS[0]+Variables.CHANCE_ATTACK_PLANET_UNITS[1]+Variables.CHANCE_ATTACK_PLANET_UNITS[2]+Variables.CHANCE_ATTACK_PLANET_UNITS[3]+Variables.CHANCE_ATTACK_PLANET_UNITS[4]) {
			if (actualNumberUnitsPlanet[4]>0) {
				return 4;
			}else {
				return getPlanetGroupAttacker();
			}
		}
		else if (aleatorio<Variables.CHANCE_ATTACK_PLANET_UNITS[0]+Variables.CHANCE_ATTACK_PLANET_UNITS[1]+Variables.CHANCE_ATTACK_PLANET_UNITS[2]+Variables.CHANCE_ATTACK_PLANET_UNITS[3]+Variables.CHANCE_ATTACK_PLANET_UNITS[4]+Variables.CHANCE_ATTACK_PLANET_UNITS[5])  {
			if (actualNumberUnitsPlanet[5]>0) {
				return 5;
			}else {
				return getPlanetGroupAttacker();
			}
		}
		else if (aleatorio<Variables.CHANCE_ATTACK_PLANET_UNITS[0]+Variables.CHANCE_ATTACK_PLANET_UNITS[1]+Variables.CHANCE_ATTACK_PLANET_UNITS[2]+Variables.CHANCE_ATTACK_PLANET_UNITS[3]+Variables.CHANCE_ATTACK_PLANET_UNITS[4]+Variables.CHANCE_ATTACK_PLANET_UNITS[5]+Variables.CHANCE_ATTACK_PLANET_UNITS[6]) {
			if (actualNumberUnitsPlanet[6]>0) {
				return 6;
			}else {
				return getPlanetGroupAttacker();
			}
		}
		else {
			return getPlanetGroupAttacker();
		}
	}
	public int getEnemyGroupAttacker() {
		int aleatorio = (int) (Math.random()*100+1);
		int actualTotalUnits = 0;
		
		for (int i=0;i<actualNumberUnitsEnemy.length;i++){
			actualTotalUnits += actualNumberUnitsEnemy[i];
		}
		
		if (aleatorio<Variables.CHANCE_ATTACK_ENEMY_UNITS[0]) {
			if (actualNumberUnitsEnemy[0]>0) {
				return 0;
			}else {
				return getEnemyGroupAttacker();
			}
		}
		else if (aleatorio<Variables.CHANCE_ATTACK_ENEMY_UNITS[0]+Variables.CHANCE_ATTACK_ENEMY_UNITS[1]) {
			if (actualNumberUnitsEnemy[1]>0) {
				return 1;
			}else {
				return getEnemyGroupAttacker();
			}
		}
		else if (aleatorio<Variables.CHANCE_ATTACK_ENEMY_UNITS[0]+Variables.CHANCE_ATTACK_ENEMY_UNITS[1]+Variables.CHANCE_ATTACK_ENEMY_UNITS[2]) {
			if (actualNumberUnitsEnemy[2]>0) {
				return 2;
			}else {
				return getEnemyGroupAttacker();
			}
		}
		else if (aleatorio<Variables.CHANCE_ATTACK_ENEMY_UNITS[0]+Variables.CHANCE_ATTACK_ENEMY_UNITS[1]+Variables.CHANCE_ATTACK_ENEMY_UNITS[2]+Variables.CHANCE_ATTACK_ENEMY_UNITS[3]) {
			if (actualNumberUnitsEnemy[3]>0) {
				return 3;
			}else {
				return getEnemyGroupAttacker();
			}
		}
		else {
			return getEnemyGroupAttacker();
		}
	}
	public void resetArmyArmor() {
		for (int i=0;i<getPlanetArmy().length;i++) {
			for (int j=0;j<getPlanetArmy()[i].size();j++) {
				getPlanetArmy()[i].get(j).resetArmor();
			}
		}
	}
	
	public ArrayList<MilitaryUnit>[] BeginRandomTurn(){
		int random = (int) (Math.random()*2);
		if (random == 1) {
			return getEnemyArmy();
		}
		else {
			return getPlanetArmy();
		}
		
	}
	
	public ArrayList<MilitaryUnit>[] getEnemyArmy() {
		return this.enemyArmy;
	}

	public void setEnemyArmy(ArrayList<MilitaryUnit>[] enemyArmy) {
		this.enemyArmy = enemyArmy;
	}
	
	public void setPlanetArmy(ArrayList<MilitaryUnit>[] PlanetArmy) {
		this.planetArmy = PlanetArmy;
	}
	
	
	public int[][] getInitialCostFleet() {
		return this.initialCostFleet;
	}


	public int getInitialNumberUnitsPlanet() {
		return this.initialNumberUnitsPlanet;
	}


	public int getInitialNumberUnitsEnemy() {
		return this.initialNumberUnitsEnemy;
	}

	public ArrayList<MilitaryUnit>[] getPlanetArmy() {
		return this.planetArmy;
	}
	
	public void UpdateActualArmy(ArrayList<MilitaryUnit>[] Army) {
		
		if (Army.length == 7) {
			for (int i=0;i<Army.length;i++) {
				this.actualNumberUnitsPlanet[i] = Army[i].size();
			}
		}else {
			for (int i=0;i<Army.length;i++) {
				this.actualNumberUnitsEnemy[i] = Army[i].size();
			}
		}
	}
	
	public String getnameship_planet(int n) {
		switch (n) {
		case 0: {
			return "Light Hunter";
		}
		case 1: {
			return "Heavy Hunter";
		}
		case 2: {
			return "Battle Ship";
		}
		case 3: {
			return "Armored Ship";
		}
		case 4: {
			return "Missile Launcher";
		}
		case 5: {
			return "Ion Cannon";
		}
		case 6: {
			return "Plasma Cannon";
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + n);
		}
	}
	public String getnameship_enemy(int n) {
		switch (n) {
		case 0: {
			return "Light Hunter";
		}
		case 1: {
			return "Heavy Hunter";
		}
		case 2: {
			return "Battle Ship";
		}
		case 3: {
			return "Armored Ship";
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + n);
		}
	}



	public ArrayList[][] getArmies() {
		return armies;
	}



	public void setArmies(ArrayList[][] armies) {
		this.armies = armies;
	}



	public int[] getWasteMetalDeuterium() {
		return wasteMetalDeuterium;
	}



	public void setWasteMetalDeuterium(int[] wasteMetalDeuterium) {
		this.wasteMetalDeuterium = wasteMetalDeuterium;
	}



	public int[] getEnemyDrops() {
		return enemyDrops;
	}



	public void setEnemyDrops(int[] enemyDrops) {
		this.enemyDrops = enemyDrops;
	}



	public int[] getPlanetDrops() {
		return planetDrops;
	}



	public void setPlanetDrops(int[] planetDrops) {
		this.planetDrops = planetDrops;
	}



	public int[][] getResourcesLooses() {
		return resourcesLooses;
	}



	public void setResourcesLooses(int[][] resourcesLooses) {
		this.resourcesLooses = resourcesLooses;
	}



	public int[][] getInitialArmies() {
		return initialArmies;
	}



	public void setInitialArmies(int[][] initialArmies) {
		this.initialArmies = initialArmies;
	}



	public int[] getActualNumberUnitsPlanet() {
		return actualNumberUnitsPlanet;
	}



	public void setActualNumberUnitsPlanet(int[] actualNumberUnitsPlanet) {
		this.actualNumberUnitsPlanet = actualNumberUnitsPlanet;
	}



	public int[] getActualNumberUnitsEnemy() {
		return actualNumberUnitsEnemy;
	}



	public void setActualNumberUnitsEnemy(int[] actualNumberUnitsEnemy) {
		this.actualNumberUnitsEnemy = actualNumberUnitsEnemy;
	}



	public void setBattleDevelopment(String battleDevelopment) {
		this.battleDevelopment = battleDevelopment;
	}



	public void setInitialCostFleet(int[][] initialCostFleet) {
		this.initialCostFleet = initialCostFleet;
	}



	public void setInitialNumberUnitsPlanet(int initialNumberUnitsPlanet) {
		this.initialNumberUnitsPlanet = initialNumberUnitsPlanet;
	}



	public void setInitialNumberUnitsEnemy(int initialNumberUnitsEnemy) {
		this.initialNumberUnitsEnemy = initialNumberUnitsEnemy;
	}
	
	
	
}


