import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LigthHunter extends Ship {
	
	public LigthHunter(int armor, int baseDamage) {
		
		setInitialArmor(armor);
		setArmor(armor);
		setBaseDamage(baseDamage);
	}
	
	public LigthHunter() {
		try {
			setInitialArmor(data_bbdd_ship(1).getInt(6));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			setArmor(data_bbdd_ship(1).getInt(6));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			setBaseDamage(data_bbdd_ship(1).getInt(8));
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
			return data_bbdd_ship(1).getInt(3);
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int getDeuteriumCost() {
		try {
			return data_bbdd_ship(1).getInt(5);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int getChanceGeneratinWaste() {
		// TODO Auto-generated method stub
		return Variables.CHANCE_GENERATNG_WASTE_LIGTHHUNTER;
	}

	@Override
	public int getChanceAttackAgain() {
		return Variables.CHANCE_ATTACK_AGAIN_LIGTHHUNTER;
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
