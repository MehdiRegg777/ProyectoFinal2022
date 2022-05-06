import java.util.ArrayList;

public class Planet {
	
	private int technologyDefense;
	private int technologyAtack;
	private int metal;
	private int deuterium; 
	private int upgradeDefenseTechnologyDeuteriumCost;
	private int upgradeAtackTechnologyDeuteriumCost;
	
	//ARRAYS NAVES
	ArrayList<MilitaryUnit>[] army = new ArrayList[7];
	
	//CONSTRUCTOR
	
	public Planet(int technologyDefense, int technologyAtack, int metal, int deuterium,
			int upgradeDefenseTechnologyDeuteriumCost, int upgradeAtackTechnologyDeuteriumCost,
			ArrayList<MilitaryUnit>[] army) {
		super();
		this.technologyDefense = technologyDefense;
		this.technologyAtack = technologyAtack;
		this.metal = metal;
		this.deuterium = deuterium;
		this.upgradeDefenseTechnologyDeuteriumCost = upgradeDefenseTechnologyDeuteriumCost;
		this.upgradeAtackTechnologyDeuteriumCost = upgradeAtackTechnologyDeuteriumCost;
		this.army = army;
	}

	//GETTERS AND SETTERS 
	
	public int getTechnologyDefense() {
		return technologyDefense;
	}

	public void setTechnologyDefense(int technologyDefense) {
		this.technologyDefense = technologyDefense;
	}

	public int getTechnologyAtack() {
		return technologyAtack;
	}

	public void setTechnologyAtack(int technologyAtack) {
		this.technologyAtack = technologyAtack;
	}

	public int getMetal() {
		return metal;
	}

	public void setMetal(int metal) {
		this.metal = metal;
	}

	public int getDeuterium() {
		return deuterium;
	}

	public void setDeuterium(int deuterium) {
		this.deuterium = deuterium;
	}

	public int getUpgradeDefenseTechnologyDeuteriumCost() {
		return upgradeDefenseTechnologyDeuteriumCost;
	}

	public void setUpgradeDefenseTechnologyDeuteriumCost(int upgradeDefenseTechnologyDeuteriumCost) {
		this.upgradeDefenseTechnologyDeuteriumCost = upgradeDefenseTechnologyDeuteriumCost;
	}

	public int getUpgradeAtackTechnologyDeuteriumCost() {
		return upgradeAtackTechnologyDeuteriumCost;
	}

	public void setUpgradeAtackTechnologyDeuteriumCost(int upgradeAtackTechnologyDeuteriumCost) {
		this.upgradeAtackTechnologyDeuteriumCost = upgradeAtackTechnologyDeuteriumCost;
	}

	//METHODS
	
	//UPGRADE TECH 
	//Check resources befor upgrade
	//Make expensive the upgrade cost
	public void upgradeTechnologyDefense() throws ResourceException{
		
		if (upgradeDefenseTechnologyDeuteriumCost >= deuterium) {
			
			this.setTechnologyDefense(this.getTechnologyDefense()+1);
		}
		
		else { 
			throw new ResourceException();
		}
	}
		
	public void upgradeTechnologyAtack() throws ResourceException{
		
		if (upgradeDefenseTechnologyDeuteriumCost >= deuterium) {
			
			this.setTechnologyAtack(this.getTechnologyAtack()+1);
		}
		
		else { 
			throw new ResourceException();
		}
	}
	
}



//RESOURCE EXCEPTION

class ResourceException extends Exception{
	
	public ResourceException() {
		super("No tienes los recursos suficientes");
	}
	public ResourceException(String s) {
		super(s);
	}
	
	
	
	
}
