package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import Logi.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class RegisUsuario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombreUsuario;
	private JTextField txtDireccionUsuario;
	private JTextField txtTelefono;
	private JTextField txtLogin;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegisUsuario dialog = new RegisUsuario();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegisUsuario() {
		setModal(true);
		setResizable(false);
		setTitle("Registro Usuario");
		setBounds(100, 100, 573, 490);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Informacion Usuario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(12, 13, 531, 383);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(12, 50, 56, 16);
		panel.add(lblNewLabel);
		
		txtNombreUsuario = new JTextField();
		txtNombreUsuario.setBounds(90, 47, 366, 20);
		panel.add(txtNombreUsuario);
		txtNombreUsuario.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Direcci\u00F3n:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(12, 116, 68, 16);
		panel.add(lblNewLabel_1);
		
		txtDireccionUsuario = new JTextField();
		txtDireccionUsuario.setColumns(10);
		txtDireccionUsuario.setBounds(90, 114, 366, 20);
		panel.add(txtDireccionUsuario);
		
		JLabel lblNewLabel_2 = new JLabel("Telefono:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(12, 182, 68, 16);
		panel.add(lblNewLabel_2);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(90, 181, 366, 20);
		panel.add(txtTelefono);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLogin.setBounds(12, 248, 50, 16);
		panel.add(lblLogin);
		
		txtLogin = new JTextField();
		txtLogin.setColumns(10);
		txtLogin.setBounds(90, 248, 366, 20);
		panel.add(txtLogin);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(12, 314, 68, 16);
		panel.add(lblPassword);
		
		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(90, 315, 366, 20);
		panel.add(txtPassword);
		
		JLabel lblPuesto = new JLabel("Puesto:");
		lblPuesto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPuesto.setBounds(12, 356, 68, 16);
		panel.add(lblPuesto);
		
		JComboBox cbxPuesto = new JComboBox();
		cbxPuesto.setModel(new DefaultComboBoxModel(new String[] {"<<Seleccionar>>", "Vendedor", "Administrador"}));
		cbxPuesto.setBounds(90, 356, 366, 20);
		panel.add(cbxPuesto);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			JButton btnModificar = new JButton("Modificar");
			btnModificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			buttonPane.add(btnModificar);
			{
				JButton btnRegistrar = new JButton("Registrar");
				btnRegistrar.setActionCommand("OK");
				btnRegistrar.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						Usuario aux = new Usuario(txtNombreUsuario.getText(), txtDireccionUsuario.getText(), txtTelefono.getText(), txtLogin.getText(), cbxPuesto.getSelectedItem().toString(), txtPassword.getText());
						JOptionPane.showMessageDialog(null, "Registro Satisfactorio", "Información", JOptionPane.INFORMATION_MESSAGE);
						clear();
					}
				});
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
							dispose();

					}
				});
				buttonPane.add(cancelButton);
			}
		}
	}
	
	private void clear() {
		
		txtNombreUsuario.setText("");
	    txtDireccionUsuario.setText("");
	    txtTelefono.setText("");
	    txtLogin.setText("");
	    txtPassword.setText("");
	}
}
