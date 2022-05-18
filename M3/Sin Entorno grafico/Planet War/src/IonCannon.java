import java.sql.SQLException;

public class IonCannon extends Defense {
	
	public IonCannon(int armor, int baseDamage) {
		setInitialArmor(armor);
		setArmor(armor);
		setBaseDamage(baseDamage);
	}
	
	public IonCannon() {
		try {
			setInitialArmor(data_bbdd_defense(2).getInt(6));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			setArmor(data_bbdd_defense(2).getInt(6));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			setBaseDamage(data_bbdd_defense(2).getInt(8));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int attack() {
		return getBaseDamage();
	}

	public void tekeDamage(int receivedDamage) {
		setArmor(getActualArmor()-receivedDamage);
		
	}

	public int getActualArmor() {
		return getArmor();
	}

	public int getMetalCost() {
		try {
			return data_bbdd_defense(2).getInt(3);
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int getDeuteriumCost() {
		try {
			return data_bbdd_defense(2).getInt(5);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int getChanceGeneratinWaste() {
		// TODO Auto-generated method stub
		return CHANCE_GENERATNG_WASTE_IONCANNON;
	}

	@Override
	public int getChanceAttackAgain() {
		// TODO Auto-generated method stub
		return Variables.BASE_DAMAGE_IONCANNON;
	}

	@Override
	public void resetArmor() {
		setArmor(getInitialArmor());
	}
	
	@Override
	public int getBaseDamage() {
		// TODO Auto-generated method stub
		return super.getBaseDamage();
	}
	

}
