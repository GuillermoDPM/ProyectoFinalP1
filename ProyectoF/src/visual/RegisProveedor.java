package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import Logi.Proveedores;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;

public class RegisProveedor extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombreEmpresa;
	private JTextField txtDireccionEmpresa;
	private JTextField txtTelefono;
	private JTextField txtRNC;
	private JTextField txtCuentaPorPagar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegisProveedor dialog = new RegisProveedor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegisProveedor() {
		setModal(true);
		setResizable(false);
		setTitle("Registro Proveedor");
		setBounds(100, 100, 573, 490);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Informacion Proveedor", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(12, 13, 531, 383);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(254, 27, 56, 16);
		panel.add(lblNewLabel);
		
		txtNombreEmpresa = new JTextField();
		txtNombreEmpresa.setBounds(253, 54, 220, 20);
		panel.add(txtNombreEmpresa);
		txtNombreEmpresa.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Direccion:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(254, 127, 68, 16);
		panel.add(lblNewLabel_1);
		
		txtDireccionEmpresa = new JTextField();
		txtDireccionEmpresa.setColumns(10);
		txtDireccionEmpresa.setBounds(253, 158, 220, 20);
		panel.add(txtDireccionEmpresa);
		
		JLabel lblNewLabel_2 = new JLabel("Telefono:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 127, 68, 16);
		panel.add(lblNewLabel_2);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(10, 158, 106, 20);
		panel.add(txtTelefono);
		
		txtRNC = new JTextField();
		txtRNC.setColumns(10);
		txtRNC.setBounds(10, 54, 106, 20);
		panel.add(txtRNC);
		
		JLabel lblRnc = new JLabel("RNC:");
		lblRnc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRnc.setBounds(10, 27, 56, 16);
		panel.add(lblRnc);
		
		txtCuentaPorPagar = new JTextField();
		txtCuentaPorPagar.setColumns(10);
		txtCuentaPorPagar.setBounds(10, 242, 106, 20);
		panel.add(txtCuentaPorPagar);
		
		JLabel lblCuentaPorPagar = new JLabel("Cuenta por pagar:");
		lblCuentaPorPagar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCuentaPorPagar.setBounds(10, 211, 125, 16);
		panel.add(lblCuentaPorPagar);
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
						Proveedores aux = new Proveedores(txtNombreEmpresa.getText(),txtRNC.getText(), txtTelefono.getText(),txtDireccionEmpresa.getText(), Float.valueOf(txtCuentaPorPagar.getText()));
						//String nombre, String rnc, String telefono, String direccion, float cuentaPorPagar
						JOptionPane.showMessageDialog(null, "Registro Satisfactorio", "Información", JOptionPane.INFORMATION_MESSAGE);
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
}