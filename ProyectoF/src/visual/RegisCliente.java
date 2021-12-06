package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import Logi.Cliente;
import Logi.Controladora;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;

public class RegisCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombreCliente;
	private JTextField txtDireccionCliente;
	private JTextField txtTelefono;
	private JTextField txtIdentificacion;
	private JRadioButton rbtnEmpresa;
	private JRadioButton rbtnIndividuo;
	private JButton btnBuscar;
	private JButton btnModificar;
	private JButton btnAtras;
	private JSpinner spnLimiteCredito;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegisCliente dialog = new RegisCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegisCliente() {
		setModal(true);
		setResizable(false);
		setTitle("Registro Cliente");
		setBounds(100, 100, 532, 488);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Informacion Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(12, 13, 467, 397);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Se trata de un individuo o una empresa?");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(109, 39, 354, 16);
		panel.add(lblNewLabel_3);
		
		rbtnIndividuo = new JRadioButton("Individuo");
		rbtnIndividuo.setSelected(true);
		rbtnIndividuo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rbtnIndividuo.setBounds(125, 75, 127, 25);
		panel.add(rbtnIndividuo);
		rbtnIndividuo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(rbtnIndividuo.isSelected()) {
					rbtnEmpresa.setSelected(false);
					txtIdentificacion.setEditable(true);
				}else {
					rbtnEmpresa.setSelected(true);
				}
			
			}
		}
		);
		
		rbtnEmpresa = new JRadioButton("Empresa");
		rbtnEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rbtnEmpresa.setBounds(256, 75, 127, 25);
		panel.add(rbtnEmpresa);
		rbtnEmpresa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			 if(rbtnEmpresa.isSelected()) {
				rbtnIndividuo.setSelected(false);
				txtIdentificacion.setEditable(true);
			}else {
				rbtnIndividuo.setSelected(true);
			}
				
			}
		});
		
		JLabel lblNewLabel_5 = new JLabel("Cedula/RNC:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(19, 152, 90, 16);
		panel.add(lblNewLabel_5);
		
		txtIdentificacion = new JTextField();
		txtIdentificacion.setColumns(10);
		txtIdentificacion.setBounds(106, 151, 332, 20);
		panel.add(txtIdentificacion);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setBounds(19, 227, 56, 16);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtNombreCliente = new JTextField();
		txtNombreCliente.setEditable(false);
		txtNombreCliente.setBounds(84, 226, 354, 20);
		panel.add(txtNombreCliente);
		txtNombreCliente.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Direccion:");
		lblNewLabel_1.setBounds(19, 271, 68, 16);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtDireccionCliente = new JTextField();
		txtDireccionCliente.setEditable(false);
		txtDireccionCliente.setBounds(84, 269, 354, 20);
		panel.add(txtDireccionCliente);
		txtDireccionCliente.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Telefono:");
		lblNewLabel_2.setBounds(19, 312, 68, 16);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtTelefono = new JTextField();
		txtTelefono.setEditable(false);
		txtTelefono.setBounds(84, 310, 354, 20);
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Limite de Credito:");
		lblNewLabel_6.setBounds(206, 423, 139, 16);
		panel.add(lblNewLabel_6);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(206, 184, 97, 25);
		panel.add(btnBuscar);
		
		JLabel lblNewLabel_4 = new JLabel("Limite credito:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(19, 352, 90, 16);
		panel.add(lblNewLabel_4);
		
		spnLimiteCredito = new JSpinner();
		spnLimiteCredito.setBounds(117, 350, 135, 20);
		panel.add(spnLimiteCredito);
		btnBuscar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(rbtnIndividuo.isSelected()) {
				Cliente aux = Controladora.getInstance().buscarCliente(txtIdentificacion.getText());
				
				if(aux == null) {
					int option = JOptionPane.showConfirmDialog(null, "El cliente no existe, desea crearlo?", "Confirmar", JOptionPane.WARNING_MESSAGE);
					if(JOptionPane.NO_OPTION == option){
						dispose();
					}else {
						txtNombreCliente.setEditable(true);
						txtDireccionCliente.setEditable(true);
						txtTelefono.setEditable(true);
					}
				}else {
					txtNombreCliente.setText(aux.getNombre());
					txtDireccionCliente.setText(aux.getDireccion());
					txtTelefono.setText(aux.getTelefono());
					txtNombreCliente.setEditable(false);
					txtDireccionCliente.setEditable(false);
					txtTelefono.setEditable(false);
					btnModificar.setEnabled(true);
					rbtnEmpresa.setEnabled(false);
					rbtnIndividuo.setEnabled(false);
					txtIdentificacion.setEditable(false);
					spnLimiteCredito.setEnabled(false);
					spnLimiteCredito.setValue(aux.getLimiteCredito());
					rbtnIndividuo.setSelected(true);
					
				}
				}else{
					txtIdentificacion.setEditable(false);
				}
				
				if(rbtnEmpresa.isSelected()) {
					Cliente aux = Controladora.getInstance().buscarCliente(txtIdentificacion.getText());
					
					if(aux == null) {
						int option = JOptionPane.showConfirmDialog(null, "La empresa no existe, desea crearla?", "Confirmar", JOptionPane.WARNING_MESSAGE);
						if(JOptionPane.NO_OPTION == option){
							dispose();
						}else {
							txtNombreCliente.setEditable(true);
							txtDireccionCliente.setEditable(true);
							txtTelefono.setEditable(true);
						}
					}else {
						txtNombreCliente.setText(aux.getNombre());
						txtDireccionCliente.setText(aux.getDireccion());
						txtTelefono.setText(aux.getTelefono());
						txtNombreCliente.setEditable(false);
						txtDireccionCliente.setEditable(false);
						spnLimiteCredito.setValue(aux.getLimiteCredito());
						txtTelefono.setEditable(false);
						btnModificar.setEnabled(true);
						rbtnEmpresa.setEnabled(false);
						rbtnIndividuo.setEnabled(false);
						txtIdentificacion.setEditable(false);
						btnAtras.setEnabled(true);
						spnLimiteCredito.setEnabled(false);
						rbtnEmpresa.setSelected(true);
						
					}
				}
				
				
				
			}
			
		});
	
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			btnModificar = new JButton("Modificar");
			btnModificar.setEnabled(false);
			btnModificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					txtNombreCliente.setEditable(true);
					txtDireccionCliente.setEditable(true);
					txtTelefono.setEditable(true);
					btnAtras.setEnabled(true);
					rbtnEmpresa.setEnabled(true);
					rbtnIndividuo.setEnabled(true);	
					btnModificar.setEnabled(false);
					spnLimiteCredito.setEnabled(true);
				}
			});
			buttonPane.add(btnModificar);
			{
				JButton btnRegistrar = new JButton("Registrar");
				btnRegistrar.setActionCommand("OK");
				btnRegistrar.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						Cliente aux1 = Controladora.getInstance().buscarCliente(txtIdentificacion.getText());
						if(aux1==null) {
						if(rbtnIndividuo.isEnabled()) {
						Cliente aux = new Cliente(txtNombreCliente.getText(), txtDireccionCliente.getText(), txtTelefono.getText(),"Individuo", txtIdentificacion.getText(),Integer.valueOf(spnLimiteCredito.getValue().toString()));
						Controladora.getInstance().insertarClientes(aux);
						}
						if(rbtnEmpresa.isEnabled()) {
							Cliente aux = new Cliente(txtNombreCliente.getText(), txtDireccionCliente.getText(), txtTelefono.getText(),"Empresa", txtIdentificacion.getText(),Integer.valueOf(spnLimiteCredito.getValue().toString()));	
							Controladora.getInstance().insertarClientes(aux);
						}
						
						JOptionPane.showMessageDialog(null, "Registro Satisfactorio", "Información", JOptionPane.INFORMATION_MESSAGE);
						clean();
						deshabilitar();
						}else {
							if(rbtnIndividuo.isEnabled()) {
								Cliente aux = new Cliente(txtNombreCliente.getText(), txtDireccionCliente.getText(), txtTelefono.getText(),"Individuo", txtIdentificacion.getText(),Integer.valueOf(spnLimiteCredito.getValue().toString()));
								Controladora.getInstance().modificarCliente(aux);
								}
								if(rbtnEmpresa.isEnabled()) {
									Cliente aux = new Cliente(txtNombreCliente.getText(), txtDireccionCliente.getText(), txtTelefono.getText(),"Empresa", txtIdentificacion.getText(),Integer.valueOf(spnLimiteCredito.getValue().toString()));	
									Controladora.getInstance().modificarCliente(aux);
								}
							JOptionPane.showMessageDialog(null, "Modificacion Satisfactoria", "Información", JOptionPane.INFORMATION_MESSAGE);
							clean();
							deshabilitar();
						}
					}

					

				});
				
				btnAtras = new JButton("Atras");
				btnAtras.setEnabled(false);
				buttonPane.add(btnAtras);
				btnAtras.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						rbtnIndividuo.isEnabled();
						rbtnEmpresa.isEnabled();
						clean();
						deshabilitar();
						
					}
				});
				buttonPane.add(btnRegistrar);
				getRootPane().setDefaultButton(btnRegistrar);
			}
			{
				JButton cancelButton = new JButton("Salir");
				cancelButton.setActionCommand("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						int option = JOptionPane.showConfirmDialog(null, "¿Realmente desea cancelar el registro del cliente?","Confirmar",JOptionPane.INFORMATION_MESSAGE);
						if(JOptionPane.YES_OPTION == option) {
							dispose();
						}
						
						
					}
				});
				buttonPane.add(cancelButton);
			}
		}
	}
	
	private void clean() {
		txtNombreCliente.setText("");
		txtDireccionCliente.setText("");
		txtTelefono.setText("");
		txtIdentificacion.setText("");
		spnLimiteCredito.setValue(0);
	}
	
	private void deshabilitar() {
		txtNombreCliente.setEditable(false);
		txtDireccionCliente.setEditable(false);
		txtTelefono.setEditable(false);
		spnLimiteCredito.setEnabled(false);
	}
}
