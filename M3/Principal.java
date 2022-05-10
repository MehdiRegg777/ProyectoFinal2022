import java.util.Scanner;

public class Principal {
	
	public static void main(String[] args) {
		Principal p = new Principal();
	}
	public Principal() {
		seleccionar_menuprincipal();
	}
	
	public void seleccionar_menuprincipal(){
		boolean opcion_correcta = true;
		Scanner sc = new Scanner(System.in);
		while(opcion_correcta == true) {
			System.out.println("1)View Planet Stats\n2)Build\n3)Upgrade Tecnhology\n4)View Battle Reports\n0)Exit");
			String opcion = sc.nextLine();
			switch (opcion) {
			case "1": {
				System.out.println("Correcto");
				break;}
			case "2": {
				System.out.println("Correcto");
				break;}
			case "3": {
				System.out.println("Correcto");
				break;}
			case "4": {
				System.out.println("Correcto");
				break;}
			case "0": {
				System.out.println("See you soon...");
				opcion_correcta = false;
				break;
			}
			default:
				System.out.println("No es una opción correcta");
				break;
			}
		}
		
		
	}
	
}
