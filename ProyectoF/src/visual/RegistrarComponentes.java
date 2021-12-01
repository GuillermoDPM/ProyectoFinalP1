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
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

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
		setBounds(100, 100, 653, 891);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Informacion general", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(12, 13, 269, 124);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Codigo:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(12, 36, 56, 16);
		panel.add(lblNewLabel);
		
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
		
		JPanel JPMemoriaRam = new JPanel();
		JPMemoriaRam.setBorder(new TitledBorder(null, "Memoria Ram", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		JPMemoriaRam.setBounds(12, 236, 469, 75);
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
		JPMicroprocesador.setBounds(12, 347, 469, 114);
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
		
		JButton btnNewButton = new JButton("REGISTRAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton.setBounds(351, 65, 138, 41);
		contentPane.add(btnNewButton);
		
		JPanel JPMotherboard = new JPanel();
		JPMotherboard.setBorder(new TitledBorder(null, "Motherboard", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		JPMotherboard.setBounds(12, 487, 553, 124);
		contentPane.add(JPMotherboard);
		JPMotherboard.setLayout(null);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblModelo.setBounds(89, 37, 60, 14);
		JPMotherboard.add(lblModelo);
		
		JLabel lblTipoConector = new JLabel("Tipo Conector:");
		lblTipoConector.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTipoConector.setBounds(44, 64, 109, 14);
		JPMotherboard.add(lblTipoConector);
		
		JLabel lblTipoMemoriaRam = new JLabel("Tipo Memoria Ram:");
		lblTipoMemoriaRam.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTipoMemoriaRam.setBounds(12, 91, 137, 14);
		JPMotherboard.add(lblTipoMemoriaRam);
		
		textField_4 = new JTextField();
		textField_4.setBounds(157, 35, 315, 20);
		JPMotherboard.add(textField_4);
		textField_4.setColumns(10);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"<<Seleccione>>", "DDR1", "DDR2", "DDR3", "DDR4"}));
		comboBox_3.setBounds(157, 88, 124, 22);
		JPMotherboard.add(comboBox_3);
		
		JRadioButton rdbtnIde = new JRadioButton("IDE");
		rdbtnIde.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnIde.setBounds(133, 61, 86, 23);
		JPMotherboard.add(rdbtnIde);
		
		JRadioButton rdbtnSata = new JRadioButton("SATA");
		rdbtnSata.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnSata.setBounds(193, 61, 109, 23);
		JPMotherboard.add(rdbtnSata);
		
		JRadioButton rdbtnSata_1 = new JRadioButton("SATA-2");
		rdbtnSata_1.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnSata_1.setBounds(281, 61, 109, 23);
		JPMotherboard.add(rdbtnSata_1);
		
		JRadioButton rdbtnSata_2 = new JRadioButton("SATA-3");
		rdbtnSata_2.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnSata_2.setBounds(383, 61, 109, 23);
		JPMotherboard.add(rdbtnSata_2);
		
		JPanel JPComponentes = new JPanel();
		JPComponentes.setBorder(new TitledBorder(null, "Componentes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		JPComponentes.setBounds(12, 163, 526, 60);
		contentPane.add(JPComponentes);
		JPComponentes.setLayout(null);
		
		JPanel JPDiscoDuro = new JPanel();
		JPDiscoDuro.setBorder(new TitledBorder(null, "Disco Duro", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		JPDiscoDuro.setBounds(12, 624, 469, 166);
		contentPane.add(JPDiscoDuro);
		JPDiscoDuro.setLayout(null);
		
		JLabel lblModelo_1 = new JLabel("Modelo:");
		lblModelo_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblModelo_1.setBounds(75, 29, 67, 14);
		JPDiscoDuro.add(lblModelo_1);
		
		textField_6 = new JTextField();
		textField_6.setBounds(260, 27, 86, 20);
		textField_6.setColumns(10);
		JPDiscoDuro.add(textField_6);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setBounds(179, 89, 117, 22);
		JPDiscoDuro.add(spinner_2);
		
		JLabel lblAlmacenamiento = new JLabel("Almacenamiento:");
		lblAlmacenamiento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAlmacenamiento.setBounds(20, 92, 117, 14);
		JPDiscoDuro.add(lblAlmacenamiento);
		
		JLabel lblTipoDeConexin = new JLabel("Tipo de Conexi\u00F3n:");
		lblTipoDeConexin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTipoDeConexin.setBounds(10, 61, 132, 14);
		JPDiscoDuro.add(lblTipoDeConexin);
		JRadioButton rdbtnMemoriaRam = new JRadioButton("Memoria Ram");
		rdbtnMemoriaRam.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnMemoriaRam.setBounds(6, 25, 119, 23);
		rdbtnMemoriaRam.setHorizontalAlignment(SwingConstants.CENTER);
		JPComponentes.add(rdbtnMemoriaRam);
		
		JRadioButton rdbtnMicroprocesador = new JRadioButton("Microprocesador");
		rdbtnMicroprocesador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnMicroprocesador.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnMicroprocesador.setBounds(142, 26, 143, 23);
		JPComponentes.add(rdbtnMicroprocesador);
		
		JRadioButton rdbtnMotherboard = new JRadioButton("Motherboard");
		rdbtnMotherboard.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnMotherboard.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnMotherboard.setBounds(289, 26, 126, 23);
		JPComponentes.add(rdbtnMotherboard);
		
		
		
		JRadioButton rdbtnDiscoDuro = new JRadioButton("Disco Duro");
		rdbtnDiscoDuro.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnDiscoDuro.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnDiscoDuro.setBounds(414, 25, 109, 23);
		JPComponentes.add(rdbtnDiscoDuro);
		
		textField_5 = new JTextField();
		textField_5.setBounds(520, 727, 86, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
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
