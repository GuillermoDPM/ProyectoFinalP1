package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logi.Usuario;
import Logi.Controladora;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				FileInputStream controladora;
				FileOutputStream controladora2;
				ObjectInputStream controladoraRead;
				ObjectOutputStream controladoraWrite;
				try {
					controladora = new FileInputStream ("ZinioComputer.dat");
					controladoraRead = new ObjectInputStream(controladora);
					Controladora temp = (Controladora)controladoraRead.readObject();
					Controladora.setInstanciaGlobal(temp);;
					controladora.close();
					controladoraRead.close();
				} catch (FileNotFoundException e) {
					try {
						controladora2 = new  FileOutputStream("ZinioComputer.dat");
						controladoraWrite = new ObjectOutputStream(controladora2);
						Usuario aux = new Usuario("Guillermo","Chalecito","849","Admin","GP","1234");
						//String nombre, String direccion, String telefono, String login, String username, String password
						
						Controladora.getInstance().getMisUsuarios().add(aux);
						controladoraWrite.writeObject(Controladora.getInstance());
						controladora2.close();
						controladoraWrite.close();
					} catch (FileNotFoundException e1) {
					} catch (IOException e1) {
						// TODO Auto-generated catch block
					}
				} catch (IOException e) {
					
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(133, 86, 66, 15);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(133, 175, 91, 15);
		contentPane.add(lblContrasea);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(131, 82, 165, 23);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(131, 171, 165, 23);
		contentPane.add(txtPassword);
		
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String pass= new String(txtPassword.getPassword());
				for(int i=0; i<Controladora.getInstance().getMisUsuarios().size(); i++) {
					if(Controladora.getInstance().getMisUsuarios().get(i).getLogin().equals(txtUsuario.getText()) && Controladora.getInstance().getMisUsuarios().get(i).getPassword().equals(pass)) {
						
						MenuPrincipal menu = new MenuPrincipal();
						dispose(); 
						menu.setVisible(true);
					}
					
				}
				
			}
		});
		//btnIniciar.addActionListener(new ActionListener() {
			/*public void actionPerformed(ActionEvent e) {
				if(Controladora.getInstance().confirmLogin(txtUsuario.getText(), txtPassword.getText())== true){
					MenuPrincipal frame = new MenuPrincipal();
					frame.setVisible(true);
					dispose();
				}
				else{
					JOptionPane.showMessageDialog(null, "Usuario o Contraseña Incorrecta" );
				}
			}*/
		//});
		btnIniciar.setBounds(164, 205, 89, 23);
		contentPane.add(btnIniciar);
	}
}
