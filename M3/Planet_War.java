import java.util.Scanner;

public class Planet_War {
	
	private Planet planeta = new Planet();
	
	public String MostrarMenu(){
		Scanner sc = new Scanner(System.in);
		System.out.println("1)View Planet Stats\n2)Build\n3)Upgrade Technology\n4)View Battle Reports\n0)Exit\n\nOption >\n");
		return sc.nextLine();
	}
	
	public static void main(String[] args) {
		String op = MostrarMenu();
	}


	public Planet getPlaneta() {
		return planeta;
	}


	public void setPlaneta(Planet planeta) {
		this.planeta = planeta;
	}
	
}
