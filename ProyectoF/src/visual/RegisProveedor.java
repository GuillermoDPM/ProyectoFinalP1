package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import Logi.Controladora;
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
	private JButton btnModificar;
	private JButton btnRegistrar;
	private JButton cancelButton;
	private JButton btnBuscar;

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
		setBounds(100, 100, 448, 255);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Informacion Proveedor", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(12, 13, 406, 156);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(16, 63, 56, 16);
		panel.add(lblNewLabel);
		
		txtNombreEmpresa = new JTextField();
		txtNombreEmpresa.setEditable(false);
		txtNombreEmpresa.setBounds(84, 63, 220, 17);
		panel.add(txtNombreEmpresa);
		txtNombreEmpresa.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Direccion:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 125, 68, 16);
		panel.add(lblNewLabel_1);
		
		txtDireccionEmpresa = new JTextField();
		txtDireccionEmpresa.setEditable(false);
		txtDireccionEmpresa.setColumns(10);
		txtDireccionEmpresa.setBounds(84, 125, 220, 16);
		panel.add(txtDireccionEmpresa);
		
		JLabel lblNewLabel_2 = new JLabel("Telefono:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 96, 68, 16);
		panel.add(lblNewLabel_2);
		
		txtTelefono = new JTextField();
		txtTelefono.setEditable(false);
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(84, 95, 220, 16);
		panel.add(txtTelefono);
		
		txtRNC = new JTextField();
		txtRNC.setColumns(10);
		txtRNC.setBounds(84, 35, 220, 17);
		panel.add(txtRNC);
		
		JLabel lblRnc = new JLabel("RNC:");
		lblRnc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRnc.setBounds(36, 34, 56, 16);
		panel.add(lblRnc);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(310, 32, 84, 20);
		btnBuscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Proveedores aux = Controladora.getInstance().buscarProveedor(txtRNC.getText());
				
				if(aux == null) {
					int option = JOptionPane.showConfirmDialog(null, "El proveedor no existe, desea crearlo?", "Confirmar", JOptionPane.WARNING_MESSAGE);
					if(JOptionPane.NO_OPTION == option){
						dispose();
					}else {
						txtNombreEmpresa.setEditable(true);
						txtDireccionEmpresa.setEditable(true);
						txtTelefono.setEditable(true);
					
					}
				}else {
					txtNombreEmpresa.setText(aux.getNombre());
					txtDireccionEmpresa.setText(aux.getDireccion());
					txtTelefono.setText(aux.getTelefono());
					txtNombreEmpresa.setEditable(false);
					txtDireccionEmpresa.setEditable(false);
					txtTelefono.setEditable(false);
					btnModificar.setEnabled(true);
					
				}
				
			}
		});
		panel.add(btnBuscar);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			btnModificar = new JButton("Modificar");
			btnModificar.setEnabled(false);
			btnModificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					habilitar();
				}
			});
			{
				btnRegistrar = new JButton("Registrar");
				btnRegistrar.setActionCommand("OK");
				btnRegistrar.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						Proveedores aux1 = Controladora.getInstance().buscarProveedor(txtRNC.getText());
						if(aux1==null) {
						Proveedores aux = new Proveedores(txtNombreEmpresa.getText(),txtRNC.getText(), txtTelefono.getText(),txtDireccionEmpresa.getText());
						//String nombre, String rnc, String telefono, String direccion, float cuentaPorPagar
						Controladora.getInstance().insertarProveedor(aux);
						JOptionPane.showMessageDialog(null, "Registro Satisfactorio", "Información", JOptionPane.INFORMATION_MESSAGE);
						deshabilitar();
						clean();
					}else {
						Proveedores aux = new Proveedores(txtNombreEmpresa.getText(),txtRNC.getText(),txtTelefono.getText(),txtDireccionEmpresa.getText());
						Controladora.getInstance().modificarProveedor(aux);
						JOptionPane.showMessageDialog(null, "Modificacion Satisfactoria", "Información", JOptionPane.INFORMATION_MESSAGE);
						deshabilitar();
						clean();
					}
						}

					
				});
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			buttonPane.add(btnModificar);
			{
				cancelButton = new JButton("Cancelar");
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
	
	private void clean() {
		txtRNC.setText("");
		txtNombreEmpresa.setText("");
		txtDireccionEmpresa.setText("");
		txtTelefono.setText("");
		
	}
	
	private void habilitar() {
		txtNombreEmpresa.setEditable(true);
		txtDireccionEmpresa.setEditable(true);
		txtTelefono.setEditable(true);
		
	}
	
	private void deshabilitar() {
		txtNombreEmpresa.setEditable(false);
		txtDireccionEmpresa.setEditable(false);
		txtTelefono.setEditable(false);
		btnModificar.setEnabled(false);
	}
}