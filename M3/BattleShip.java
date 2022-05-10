
public class BattleShip extends Defense {
	
	public BattleShip(int armor, int baseDamage) {
		setInitialArmor(armor);
		setArmor(armor);
		setBaseDamage(baseDamage);
	}
	
	public BattleShip() {
		setInitialArmor(ARMOR_BATTLESHIP);
		setArmor(ARMOR_BATTLESHIP);
		setBaseDamage(BASE_DAMAGE_BATTLESHIP);
	}

	@Override
	public int attack() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void tekeDamage(int receivedDamage) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getActualArmor() {
		return getArmor();
	}

	@Override
	public int getMetalCost() {
		return METAL_COST_BATTLESHIP;
	}

	@Override
	public int getDeuteriumCost() {
		return DEUTERIUM_COST_BATTLESHIP;
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

	@Override
	public void resetArmor() {
		setArmor(getInitialArmor());
	}
	

}
