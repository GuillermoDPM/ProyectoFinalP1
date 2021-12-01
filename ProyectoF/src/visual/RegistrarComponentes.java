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
import javax.swing.JRadioButton;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		setBounds(100, 100, 581, 891);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Informacion general", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(12, 13, 269, 170);
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
		
		JPanel JPMemoriaRam = new JPanel();
		JPMemoriaRam.setBorder(new TitledBorder(null, "Memoria Ram", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		JPMemoriaRam.setBounds(12, 285, 469, 75);
		contentPane.add(JPMemoriaRam);
		JPMemoriaRam.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Capacidad (MB):");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(12, 34, 117, 16);
		JPMemoriaRam.add(lblNewLabel_3);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(129, 32, 117, 22);
		JPMemoriaRam.add(spinner);
		
		JLabel lblNewLabel_4 = new JLabel("Tipo:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(266, 36, 56, 16);
		JPMemoriaRam.add(lblNewLabel_4);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "DDR1", "DDR2", "DDR3", "DDR4"}));
		comboBox_1.setBounds(307, 34, 117, 22);
		JPMemoriaRam.add(comboBox_1);
		
		JPanel JPMicroprocesador = new JPanel();
		JPMicroprocesador.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Microprocesador", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		JPMicroprocesador.setBounds(12, 395, 469, 114);
		contentPane.add(JPMicroprocesador);
		JPMicroprocesador.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Modelo:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(23, 38, 57, 16);
		JPMicroprocesador.add(lblNewLabel_5);
		
		textField_2 = new JTextField();
		textField_2.setBounds(75, 36, 382, 22);
		JPMicroprocesador.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Conector:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(12, 78, 68, 16);
		JPMicroprocesador.add(lblNewLabel_6);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Intel", "AMD"}));
		comboBox_2.setBounds(75, 76, 124, 22);
		JPMicroprocesador.add(comboBox_2);
		
		JLabel lblNewLabel_7 = new JLabel("Velocidad(Mhz):");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(223, 79, 234, 16);
		JPMicroprocesador.add(lblNewLabel_7);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(333, 76, 124, 22);
		JPMicroprocesador.add(spinner_1);
		
		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.setBounds(324, 13, 97, 25);
		contentPane.add(btnNewButton);
		
		JPanel JPMotherboard = new JPanel();
		JPMotherboard.setBorder(new TitledBorder(null, "Motherboard", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		JPMotherboard.setBounds(12, 520, 469, 114);
		contentPane.add(JPMotherboard);
		JPMotherboard.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("Marca");
		lblNewLabel_8.setBounds(21, 23, 46, 14);
		JPMotherboard.add(lblNewLabel_8);
		
		JLabel label = new JLabel("Marca");
		label.setBounds(21, 45, 46, 14);
		JPMotherboard.add(label);
		
		JLabel label_1 = new JLabel("Marca");
		label_1.setBounds(21, 67, 46, 14);
		JPMotherboard.add(label_1);
		
		JPanel JPComponentes = new JPanel();
		JPComponentes.setBorder(new TitledBorder(null, "Componentes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		JPComponentes.setBounds(12, 194, 498, 72);
		contentPane.add(JPComponentes);
		JPComponentes.setLayout(null);
		
		JPanel JPDiscoDuro = new JPanel();
		JPDiscoDuro.setBorder(new TitledBorder(null, "Disco Duro", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		JPDiscoDuro.setBounds(12, 634, 469, 114);
		contentPane.add(JPDiscoDuro);
		JRadioButton rdbtnMemoriaRam = new JRadioButton("Memoria Ram");
		rdbtnMemoriaRam.setBounds(6, 25, 109, 23);
		rdbtnMemoriaRam.setHorizontalAlignment(SwingConstants.CENTER);
		JPComponentes.add(rdbtnMemoriaRam);
		
		JRadioButton rdbtnMicroprocesador = new JRadioButton("Microprocesador");
		rdbtnMicroprocesador.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnMicroprocesador.setBounds(117, 25, 109, 23);
		JPComponentes.add(rdbtnMicroprocesador);
		
		JRadioButton rdbtnMotherboard = new JRadioButton("Motherboard");
		rdbtnMotherboard.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnMotherboard.setBounds(241, 25, 109, 23);
		JPComponentes.add(rdbtnMotherboard);
		
		
		
		JRadioButton rdbtnDiscoDuro = new JRadioButton("Disco Duro");
		rdbtnDiscoDuro.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnDiscoDuro.setBounds(352, 25, 109, 23);
		JPComponentes.add(rdbtnDiscoDuro);
		
		rdbtnDiscoDuro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JPMotherboard.setVisible(false);
				JPMicroprocesador.setVisible(false);
				JPMemoriaRam.setVisible(false);
				JPDiscoDuro.setVisible(true);
				rdbtnMemoriaRam.setSelected(false);
				rdbtnMicroprocesador.setSelected(false);
				rdbtnMotherboard.setSelected(false);
			}
		});
		
		
		rdbtnMotherboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JPMotherboard.setVisible(true);
				JPMicroprocesador.setVisible(false);
				JPMemoriaRam.setVisible(false);
				JPDiscoDuro.setVisible(false);
				rdbtnDiscoDuro.setSelected(false);
				rdbtnMicroprocesador.setSelected(false);
				rdbtnMemoriaRam.setSelected(false);
			}
		});
		
		
		rdbtnMicroprocesador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JPMotherboard.setVisible(false);
				JPMicroprocesador.setVisible(true);
				JPMemoriaRam.setVisible(false);
				JPDiscoDuro.setVisible(false);
				rdbtnDiscoDuro.setSelected(false);
				rdbtnMemoriaRam.setSelected(false);
				rdbtnMotherboard.setSelected(false);
			}
		});
		
		
		rdbtnMemoriaRam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JPMotherboard.setVisible(false);
				JPMicroprocesador.setVisible(false);
				JPMemoriaRam.setVisible(true);
				JPDiscoDuro.setVisible(false);
				rdbtnDiscoDuro.setSelected(false);
				rdbtnMicroprocesador.setSelected(false);
				rdbtnMotherboard.setSelected(false);
			}
		});
		
	}
}
