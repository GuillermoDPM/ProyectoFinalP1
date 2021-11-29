package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
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
	private JTextField txtCedulaCliente;
	private JTextField txtRNCliente;

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
		setTitle("Registro Cliente");
		setBounds(100, 100, 573, 461);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Informacion Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(12, 13, 531, 361);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(12, 37, 56, 16);
		panel.add(lblNewLabel);
		
		txtNombreCliente = new JTextField();
		txtNombreCliente.setBounds(72, 36, 371, 20);
		panel.add(txtNombreCliente);
		txtNombreCliente.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Direccion:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(12, 81, 68, 16);
		panel.add(lblNewLabel_1);
		
		txtDireccionCliente = new JTextField();
		txtDireccionCliente.setColumns(10);
		txtDireccionCliente.setBounds(82, 79, 361, 20);
		panel.add(txtDireccionCliente);
		
		JLabel lblNewLabel_2 = new JLabel("Telefono:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(12, 122, 68, 16);
		panel.add(lblNewLabel_2);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(82, 120, 361, 20);
		panel.add(txtTelefono);
		
		JLabel lblNewLabel_3 = new JLabel("Se trata de un individuo o una empresa?");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(102, 162, 354, 16);
		panel.add(lblNewLabel_3);
		
		JRadioButton rbtnIndividuo = new JRadioButton("Individuo");
		rbtnIndividuo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rbtnIndividuo.setBounds(118, 198, 127, 25);
		panel.add(rbtnIndividuo);
		rbtnIndividuo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(rbtnIndividuo.isSelected()) {
				}
				
			}
		});
		
		JRadioButton rbtnEmpresa = new JRadioButton("Empresa");
		rbtnEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rbtnEmpresa.setBounds(249, 198, 127, 25);
		panel.add(rbtnEmpresa);
		
		JLabel lblNewLabel_4 = new JLabel("Cedula:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(12, 243, 56, 16);
		panel.add(lblNewLabel_4);
		
		txtCedulaCliente = new JTextField();
		txtCedulaCliente.setEditable(false);
		txtCedulaCliente.setColumns(10);
		txtCedulaCliente.setBounds(67, 241, 354, 20);
		panel.add(txtCedulaCliente);
		
		JLabel lblNewLabel_5 = new JLabel("RNC:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(12, 280, 56, 16);
		panel.add(lblNewLabel_5);
		
		txtRNCliente = new JTextField();
		txtRNCliente.setEditable(false);
		txtRNCliente.setColumns(10);
		txtRNCliente.setBounds(67, 278, 354, 20);
		panel.add(txtRNCliente);
		
		JSpinner spnLimiteCredito = new JSpinner();
		spnLimiteCredito.setBounds(135, 311, 110, 22);
		panel.add(spnLimiteCredito);
		
		JLabel lblNewLabel_6 = new JLabel("Limite de Credito:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(12, 316, 139, 16);
		panel.add(lblNewLabel_6);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			JButton btnModificar = new JButton("Modificar");
			buttonPane.add(btnModificar);
			{
				JButton btnRegistrar = new JButton("Registrar");
				btnRegistrar.setActionCommand("OK");
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
