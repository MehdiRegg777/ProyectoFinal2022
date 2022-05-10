
public class HeavyHunter extends Defense {
	
	public HeavyHunter(int armor, int baseDamage) {
		setInitialArmor(armor);
		setArmor(armor);
		setBaseDamage(baseDamage);
	}
	
	public HeavyHunter() {
		setInitialArmor(ARMOR_HEAVYHUNTER);
		setArmor(ARMOR_HEAVYHUNTER);
		setBaseDamage(BASE_DAMAGE_HEAVYHUNTER);
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
		return METAL_COST_HEAVYHUNTER;
	}

	@Override
	public int getDeuteriumCost() {
		return DEUTERIUM_COST_HEAVYHUNTER;
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
