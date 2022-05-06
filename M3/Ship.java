//El nivel de tech (ataque/defensa) puede ser diferente dependiendo de quando se crease la nave,
//Sacar las variables que se modifican de la BD


public abstract class Ship implements MilitaryUnit,Variables{
	
	private int armor;
	private int initialArmor;
	private int baseDamage;

	//GETTERS AND SETTERS

	public int getArmor() {
		return armor;
	}


	public void setArmor(int armor) {
		this.armor = armor;
	}


	public int getInitialArmor() {
		return initialArmor;
	}


	public void setInitialArmor(int initialArmor) {
		this.initialArmor = initialArmor;
	}


	public int getBaseDamage() {
		return baseDamage;
	}


	public void setBaseDamage(int baseDamage) {
		this.baseDamage = baseDamage;
	}
	
}

interface MilitaryUnit {
	
	abstract int atack();
	abstract void takeDamage(int recivedDamage);
	abstract void getActualArmor();
	abstract int getMetalCost();
	abstract int getDeuteriumCost();
	abstract int getChanceGeneratinWaste();
	abstract int getChanceAttackAgain();
	abstract void resetArmor();
}

class LigthHunter extends Ship {

	

	public LigthHunter(int armor,int baseDamage) {
		super();
					//EL LEVEL DE TECH DEL PLANETA 
		armor = ARMOR_LIGTHHUNTER + (0 * PLUS_ARMOR_LIGTHHUNTER_BY_TECHNOLOGY)%1000;
		baseDamage = BASE_DAMAGE_LIGTHHUNTER + (0*PLUS_ATTACK_LIGTHHUNTER_BY_TECHNOLOGY)%1000;
		setInitialArmor(ARMOR_LIGTHHUNTER);
	}

	public LigthHunter() {
		super();
		
		this.setArmor(getInitialArmor()); 
		this.setBaseDamage(BASE_DAMAGE_LIGTHHUNTER);
	}

	public int atack() {
		return getBaseDamage();
	}

	
	public void takeDamage(int recivedDamage) {
		
	}

	
	public void getActualArmor() {
		
	}

	
	public int getMetalCost() {
		return METAL_COST_LIGTHHUNTER;
	}

	
	public int getDeuteriumCost() {
		return DEUTERIUM_COST_LIGTHHUNTER;
	}

	
	public int getChanceGeneratinWaste() {
		return 0;
	}

	
	public int getChanceAttackAgain() {
		return 0;
	}

	
	public void resetArmor() {
		
	}
}
	


class HeavyHunter extends Ship {

	public HeavyHunter(int armor,int baseDamage) {
		super();
		//EL LEVEL DE TECH DEL PLANETA 
armor = ARMOR_HEAVYHUNTER + (0 * PLUS_ARMOR_HEAVYHUNTER_BY_TECHNOLOGY)%1000;
baseDamage = BASE_DAMAGE_HEAVYHUNTER + (0 * PLUS_ATTACK_HEAVYHUNTER_BY_TECHNOLOGY)%1000;
setInitialArmor(ARMOR_HEAVYHUNTER);
}

	public HeavyHunter() {
		super();
	
	this.setArmor(getInitialArmor()); 
	this.setBaseDamage(BASE_DAMAGE_HEAVYHUNTER);
	}
		
	public int atack() {
		return getBaseDamage();
	}

	
	public void takeDamage(int recivedDamage) {
		
	}

	
	public void getActualArmor() {
		
	}

	
	public int getMetalCost() {
		return 0;
	}

	
	public int getDeuteriumCost() {
		return 0;
	}

	
	public int getChanceGeneratinWaste() {
		return 0;
	}

	
	public int getChanceAttackAgain() {
		return 0;
	}

	
	public void resetArmor() {
		
	}
}

class BattleShip extends Ship {

	public BattleShip(int armor, int baseDamage) {
		super();
		armor = ARMOR_BATTLESHIP + (0 * PLUS_ARMOR_BATTLESHIP_BY_TECHNOLOGY)%1000;
		baseDamage = BASE_DAMAGE_BATTLESHIP + (0 * PLUS_ATTACK_BATTLESHIP_BY_TECHNOLOGY)%1000;
		setInitialArmor(ARMOR_BATTLESHIP);
	}
	
	public BattleShip() {
		super();
		
		this.setArmor(getInitialArmor()); 
		this.setBaseDamage(BASE_DAMAGE_BATTLESHIP);
	}

	
	public int atack() {
		return 0;
	}

	
	public void takeDamage(int recivedDamage) {
		
	}

	
	public void getActualArmor() {
		
	}

	
	public int getMetalCost() {
		return 0;
	}

	
	public int getDeuteriumCost() {
		return 0;
	}

	
	public int getChanceGeneratinWaste() {
		return 0;
	}

	
	public int getChanceAttackAgain() {
		return 0;
	}

	
	public void resetArmor() {

		
	}
}

class ArmoredShip extends Ship {

	public ArmoredShip(int armor, int baseDamage) {
		super();
		
		armor = ARMOR_BATTLESHIP + (0 * PLUS_ARMOR_BATTLESHIP_BY_TECHNOLOGY)%1000;
		baseDamage = BASE_DAMAGE_BATTLESHIP + (0 * PLUS_ATTACK_BATTLESHIP_BY_TECHNOLOGY)%1000;
		setInitialArmor(ARMOR_ARMOREDSHIP);
	}

	public ArmoredShip() {
		super();
		
		this.setArmor(getInitialArmor()); 
		this.setBaseDamage(BASE_DAMAGE_ARMOREDSHIP);
	}

	public int atack() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void takeDamage(int recivedDamage) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getActualArmor() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getMetalCost() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getDeuteriumCost() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getChanceGeneratinWaste() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getChanceAttackAgain() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public void resetArmor() {
		// TODO Auto-generated method stub
		
	}
}



