
public class LigthHunter extends Defense {
	
	public LigthHunter(int armor, int baseDamage) {
		setInitialArmor(armor);
		setArmor(armor);
		setBaseDamage(baseDamage);
	}
	
	public LigthHunter() {
		setInitialArmor(ARMOR_LIGTHHUNTER);
		setArmor(ARMOR_LIGTHHUNTER);
		setBaseDamage(BASE_DAMAGE_LIGTHHUNTER);
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
		return METAL_COST_LIGTHHUNTER;
	}

	@Override
	public int getDeuteriumCost() {
		return DEUTERIUM_COST_LIGTHHUNTER;
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
