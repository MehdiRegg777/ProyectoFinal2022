import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

abstract class Ship implements MilitaryUnit, Variables{
	private int armor;
	private int initialArmor;
	private int baseDamage;
	
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
	public int getArmor() {
		return armor;
	}
	public void setArmor(int armor) {
		this.armor = armor;
	}
	
	public CallableStatement data_bbdd_ship(int id){
        Connection cn = null;
        
    	try {
			cn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.40.2:1521:orcl", "alumnoMIX8", "alumnoMIX8");
            CallableStatement cst = cn.prepareCall("{call GET_SHIP (?,?,?,?,?,?,?,?,?,?)}");
            cst.setInt(1, id); //id
            cst.registerOutParameter(2, java.sql.Types.VARCHAR); //nombre
            cst.registerOutParameter(3, java.sql.Types.INTEGER);//metalcost
            cst.registerOutParameter(4, java.sql.Types.INTEGER);//crystal
            cst.registerOutParameter(5, java.sql.Types.INTEGER);//deuterium_cost
            cst.registerOutParameter(6, java.sql.Types.INTEGER);//initialarmor
            cst.registerOutParameter(7, java.sql.Types.INTEGER);//armor
            cst.registerOutParameter(8, java.sql.Types.INTEGER);//basedamage
            cst.registerOutParameter(9, java.sql.Types.INTEGER);//speed
            cst.registerOutParameter(10, java.sql.Types.INTEGER);//generate wasting
            cst.execute();
            return cst;
		} catch (SQLException e) {
			System.out.println("Ha habido un error");
			return null;
		}


	}
	
	public void modifica_bbdd(String table, String column, int value, int iduser) {
		String query = "update "+table+" set "+column+" = ? where id_ship = ?";
		try {
			Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.40.2:1521:orcl", "alumnoMIX8", "alumnoMIX8");
			PreparedStatement pstmnt = cn.prepareStatement(query);
			pstmnt.setInt(1, value);
			pstmnt.setInt(2, iduser);
			pstmnt.executeUpdate();
			System.out.println("CORRECTO");
		} catch (SQLException e) {
			System.out.println("Error al conectar con la bbdd");
		}
	}
	
}
