package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JButton;

public class RegistrarComponentes extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarComponentes frame = new RegistrarComponentes();
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
	public RegistrarComponentes() {
		setResizable(false);
		setTitle("Registro Componentes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 528, 636);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Informacion general", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(12, 13, 269, 188);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Codigo:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(12, 36, 56, 16);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tipo:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(12, 117, 56, 16);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Marca:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(12, 78, 56, 16);
		panel.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(68, 34, 166, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(68, 76, 166, 22);
		panel.add(textField_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "RAM", "Procesador", "Motherboard", "Disco"}));
		comboBox.setBounds(68, 115, 166, 22);
		panel.add(comboBox);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Memoria Ram", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(12, 217, 469, 75);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Capacidad (MB):");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(12, 34, 117, 16);
		panel_1.add(lblNewLabel_3);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(129, 32, 117, 22);
		panel_1.add(spinner);
		
		JLabel lblNewLabel_4 = new JLabel("Tipo:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(266, 36, 56, 16);
		panel_1.add(lblNewLabel_4);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "DDR1", "DDR2", "DDR3", "DDR4"}));
		comboBox_1.setBounds(307, 34, 117, 22);
		panel_1.add(comboBox_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Microprocesador", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(12, 306, 469, 114);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Modelo:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(23, 38, 57, 16);
		panel_2.add(lblNewLabel_5);
		
		textField_2 = new JTextField();
		textField_2.setBounds(75, 36, 382, 22);
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Conector:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(12, 78, 68, 16);
		panel_2.add(lblNewLabel_6);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Intel", "AMD"}));
		comboBox_2.setBounds(75, 76, 124, 22);
		panel_2.add(comboBox_2);
		
		JLabel lblNewLabel_7 = new JLabel("Velocidad(Mhz):");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(223, 79, 234, 16);
		panel_2.add(lblNewLabel_7);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(333, 76, 124, 22);
		panel_2.add(spinner_1);
		
		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.setBounds(324, 13, 97, 25);
		contentPane.add(btnNewButton);
	}
}
