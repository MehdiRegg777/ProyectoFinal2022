
public class PlasmaCannon extends Defense {
	
	public PlasmaCannon(int armor, int baseDamage) {
		setInitialArmor(armor);
		setArmor(armor);
		setBaseDamage(baseDamage);
	}
	
	public PlasmaCannon() {
		setInitialArmor(ARMOR_PLASMACANNON);
		setArmor(ARMOR_PLASMACANNON);
		setBaseDamage(BASE_DAMAGE_PLASMACANNON);
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
		return METAL_COST_PLASMACANNON;
	}

	@Override
	public int getDeuteriumCost() {
		return DEUTERIUM_COST_PLASMACANNON;
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
