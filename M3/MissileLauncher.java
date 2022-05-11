
public class MissileLauncher extends Defense {
	
	public MissileLauncher(int armor, int baseDamage) {
		setInitialArmor(armor);
		setArmor(armor);
		setBaseDamage(baseDamage);
	}
	
	public MissileLauncher() {
		setInitialArmor(ARMOR_MISSILELAUNCHER);
		setArmor(ARMOR_MISSILELAUNCHER);
		setBaseDamage(BASE_DAMAGE_MISSILELAUNCHER);
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
		return METAL_COST_MISSILELAUNCHER;
	}

	@Override
	public int getDeuteriumCost() {
		return DEUTERIUM_COST_MISSILELAUNCHER;
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