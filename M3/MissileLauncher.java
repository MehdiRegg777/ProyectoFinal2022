
public class MissileLauncher extends Defense {
	
	public MissileLauncher(int armor, int baseDamage) {
		
	}
	
	public MissileLauncher() {
		super();
		setInitialArmor(ARMOR_MISSILELAUNCHER);
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
		return 0;
	}

	@Override
	public int getMetalCost() {
		return METAL_COST_MISSILELAUNCHER;
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

	@Override
	public void resetArmor() {
		// TODO Auto-generated method stub
		
	}
	

}
