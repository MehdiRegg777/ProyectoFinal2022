
public class ArmoredShip extends Defense {
	
	public ArmoredShip(int armor, int baseDamage) {
		setInitialArmor(armor);
		setArmor(armor);
		setBaseDamage(baseDamage);
	}
	
	public ArmoredShip() {
		setInitialArmor(ARMOR_ARMOREDSHIP);
		setArmor(ARMOR_ARMOREDSHIP);
		setBaseDamage(BASE_DAMAGE_ARMOREDSHIP);
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
		return METAL_COST_ARMOREDSHIP;
	}

	@Override
	public int getDeuteriumCost() {
		return DEUTERIUM_COST_ARMOREDSHIP;
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
