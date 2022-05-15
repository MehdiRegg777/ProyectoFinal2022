import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.security.auth.spi.LoginModule;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LogIn extends JFrame{
	
	private JPanel panel1;
	private JPanel panel2;

	private JLabel contrasenya,nombre;
	private JTextField jtText;
	private JPasswordField password;
	
	private JButton buttonlog;
	private JButton buttoncan;
	
	private String user;
	private char [] pass;
	private char [] p;
	
	public LogIn() {
		
		this.setSize(300,150);
		this.setTitle("LOG IN");
		panel1 = new JPanel();
		panel1.setLayout(new GridLayout(2,2));
		
		panel2 = new JPanel();
		panel2.setLayout(new GridLayout(0,2));
		
		password = new JPasswordField(10);
		jtText = new JTextField(10);
		nombre = new JLabel("Usuario");
		contrasenya = new JLabel("Contraseña");
		buttonlog = new JButton("Aceptar");
		buttoncan = new JButton("Cancelar");
		
		pass = new char [5];
		pass[0] = 'a';
		pass[1] = 'd';
		pass[2] = 'm';
		pass[3] = 'i';
		pass[4] = 'n';
		
		
		user = "User";
		
		buttoncan.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
					System.exit(EXIT_ON_CLOSE);
			}
		});
		
		buttonlog.addActionListener(new EventoLog());
		
		
		panel1.add(nombre);
		panel1.add(jtText);
		panel1.add(contrasenya);
		panel1.add(password);
		
		panel2.add(buttoncan);
		panel2.add(buttonlog);
		
		
		this.add(panel1,BorderLayout.NORTH);
		this.add(panel2,BorderLayout.SOUTH);
		
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		}
	
	class EventoLog implements ActionListener {
		
		
		public void actionPerformed(ActionEvent e) {
			
			System.out.println(user+" "+jtText.getText());

				
			if (user.equals(jtText.getText()) & Arrays.equals(pass, password.getPassword())) {
					
				Ventana v1 = new Ventana();	
					
				setVisible(false);
				
				}	
			else {
				
				JOptionPane.showMessageDialog(null,"The user or the password are incorrect","Login Fail",JOptionPane.ERROR_MESSAGE);

				}
			}
	}

}



