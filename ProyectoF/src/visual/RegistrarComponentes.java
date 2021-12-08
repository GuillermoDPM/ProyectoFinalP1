package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import Logi.Componente;
import Logi.Controladora;
import Logi.DiscoDuro;
import Logi.MemoriaRam;
import Logi.Microprocesador;
import Logi.Motherboard;
import Logi.Proveedores;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.naming.ldap.Rdn;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class RegistrarComponentes extends JFrame {

	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtMarca;
	private JRadioButton rdbtnMemoriaRam;
	private JRadioButton rdbtnMicroprocesador;
	private JRadioButton rdbtnMotherboard;
	private JRadioButton rdbtnDiscoDuro;
	private JButton btnRefrescar;
	private JButton btnCancelar;
	private JButton btnModificar;
	private JButton btnRegistrar;
	private JSpinner spnVelocidadProcesador;
	private JComboBox cbxConectorProcesador;
	private JComboBox cbxTipoRam;
	private JSpinner spnCapacidadRam;
	private JComboBox cbxTipoRamBoard;
	private JTextField txtSerial;
	private JSpinner spnPrecio;
	private JSpinner spnCantidadMinima;
	private JSpinner spnCantidadReal;
	private JLabel lblNewLabel_11;
	private JTextField txtProveedorComponentes;
	private JButton btnBuscarProveedor;
	private ArrayList<String> conexiones;
	private JSpinner spnAlmacenamientoDisco;
	private JRadioButton rdbtnIDE;
	private JRadioButton rdbtnSATA;
	private JRadioButton rdbtnSATA2;
	private JRadioButton rdbtnSATA3;
	
	private Componente ram;
  
	private JComboBox cbxSocket;
	private JLabel lblNewLabel_5;
	private JTextField txtModelo;
	private JComboBox cbxTipoConexionDiscos;
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
		this.conexiones = new ArrayList<String>();
		setResizable(false);
		setTitle("Componentes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 641);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel JPDiscoDuro = new JPanel();
		JPDiscoDuro.setBorder(new TitledBorder(null, "Disco Duro", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		JPDiscoDuro.setBounds(12, 249, 484, 136);
		contentPane.add(JPDiscoDuro);
		JPDiscoDuro.setLayout(null);
		
		spnAlmacenamientoDisco = new JSpinner();
		spnAlmacenamientoDisco.setEnabled(false);
		spnAlmacenamientoDisco.setBounds(179, 89, 117, 22);
		JPDiscoDuro.add(spnAlmacenamientoDisco);
		
		JLabel lblAlmacenamiento = new JLabel("Almacenamiento:");
		lblAlmacenamiento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAlmacenamiento.setBounds(20, 92, 117, 14);
		JPDiscoDuro.add(lblAlmacenamiento);
		
		JLabel lblTipoDeConexin = new JLabel("Tipo de Conexi\u00F3n:");
		lblTipoDeConexin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTipoDeConexin.setBounds(10, 61, 132, 14);
		JPDiscoDuro.add(lblTipoDeConexin);
		
		cbxTipoConexionDiscos = new JComboBox();
		cbxTipoConexionDiscos.setModel(new DefaultComboBoxModel(new String[] {"<<Seleccione>>", "IDE", "SATA", "SATA2", "SATA3"}));
		cbxTipoConexionDiscos.setEnabled(false);
		cbxTipoConexionDiscos.setBounds(179, 58, 117, 22);
		JPDiscoDuro.add(cbxTipoConexionDiscos);
		JPDiscoDuro.setVisible(false);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Introduccion articulo", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(12, 13, 360, 145);
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
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(68, 34, 166, 22);
		panel.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtMarca = new JTextField();
		txtMarca.setEditable(false);
		txtMarca.setColumns(10);
		txtMarca.setBounds(68, 76, 166, 22);
		panel.add(txtMarca);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Componente aux = null;
				aux = Controladora.getInstance().buscarComponenteByCode(txtCodigo.getText());
				
				if(aux==null) {
					int option = JOptionPane.showConfirmDialog(null, "El componente no existe, desea crearlo?", "Confirmar", JOptionPane.WARNING_MESSAGE);
					if(JOptionPane.NO_OPTION == option){
						dispose();
					}else {
						habilitar();
						btnRefrescar.setEnabled(true);
					}
				}else {
					btnRefrescar.setEnabled(true);
					txtCodigo.setText(aux.getCodigoComponente());
					txtSerial.setText(aux.getSerial());
				//	txtProveedorComponentes.setText(aux.getProveedor().getrnc());
					spnPrecio.setValue(aux.getPrecio());
					spnCantidadMinima.setValue(aux.getCantidadMinima());
					spnCantidadReal.setValue(aux.getCantidadDisponible());
					
					if(aux instanceof MemoriaRam) {
						rdbtnMemoriaRam.setSelected(true);
						rdbtnDiscoDuro.setSelected(false);
						rdbtnMicroprocesador.setSelected(false);
						rdbtnMotherboard.setSelected(false);
						txtMarca.setText(((MemoriaRam) aux).getMarca());
						spnCapacidadRam.setValue(((MemoriaRam) aux).getCapacidadMemoria());
						cbxTipoRam.setSelectedItem(((MemoriaRam) aux).getTipoMemoria());
					}
						
						if(aux instanceof Motherboard) {
							txtMarca.setText(((Motherboard) aux).getMarca());
							rdbtnMotherboard.setSelected(true);
							rdbtnMemoriaRam.setSelected(false);
							rdbtnMicroprocesador.setSelected(false);
							rdbtnDiscoDuro.setSelected(false);
							txtModelo.setText("");
							cbxTipoRamBoard.setSelectedItem(null);
							cbxSocket.setSelectedItem(null);
							int i=0;
							for(i=0;i<conexiones.size();i++) {
								if(conexiones.get(i).equalsIgnoreCase("IDE")){
									rdbtnIDE.isSelected();
								}
								if(conexiones.get(i).equalsIgnoreCase("SATA")){
									rdbtnSATA.isSelected();
								}
								if(conexiones.get(i).equalsIgnoreCase("SATA-2")){
									rdbtnSATA2.isSelected();
								}
								if(conexiones.get(i).equalsIgnoreCase("SATA-3")){
									rdbtnSATA3.isSelected();
								}
							}
						}
						if(aux instanceof DiscoDuro) {
							rdbtnDiscoDuro.setSelected(true);
							rdbtnMemoriaRam.setSelected(false);
							rdbtnMicroprocesador.setSelected(false);
							rdbtnMotherboard.setSelected(false);
							txtMarca.setText(((DiscoDuro) aux).getMarca());
							txtModelo.setText(((DiscoDuro) aux).getModelo());
							spnAlmacenamientoDisco.setValue(((DiscoDuro) aux).getAlmacenamiento());
						}
						if(aux instanceof Microprocesador) {
							rdbtnMicroprocesador.setSelected(true);
							rdbtnMemoriaRam.setSelected(false);
							rdbtnMotherboard.setSelected(false);
							rdbtnDiscoDuro.setSelected(false);
							txtModelo.setText(((Microprocesador) aux).getModelo());
							spnVelocidadProcesador.setValue(((Microprocesador) aux).getVelocidad());
							cbxConectorProcesador.setSelectedItem(((Microprocesador) aux).getTipoConector());
						}
						deshabilitar();
						btnModificar.setEnabled(true);
					
				}
			}


			
		});
		btnBuscar.setBounds(240, 34, 97, 25);
		panel.add(btnBuscar);
		
		lblNewLabel_5 = new JLabel("Modelo:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(12, 116, 56, 16);
		panel.add(lblNewLabel_5);
		
		txtModelo = new JTextField();
		txtModelo.setEditable(false);
		txtModelo.setColumns(10);
		txtModelo.setBounds(68, 111, 166, 22);
		panel.add(txtModelo);
		
		JPanel JPMemoriaRam = new JPanel();
		JPMemoriaRam.setBorder(new TitledBorder(null, "Memoria Ram", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		JPMemoriaRam.setBounds(12, 249, 484, 136);
		contentPane.add(JPMemoriaRam);
		JPMemoriaRam.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Capacidad (MB):");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(12, 66, 117, 16);
		JPMemoriaRam.add(lblNewLabel_3);
		
		spnCapacidadRam = new JSpinner();
		spnCapacidadRam.setEnabled(false);
		spnCapacidadRam.setBounds(129, 64, 117, 22);
		JPMemoriaRam.add(spnCapacidadRam);
		
		JLabel lblNewLabel_4 = new JLabel("Tipo:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(266, 68, 56, 16);
		JPMemoriaRam.add(lblNewLabel_4);
		
		cbxTipoRam = new JComboBox();
		cbxTipoRam.setEnabled(false);
		cbxTipoRam.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "DDR1", "DDR2", "DDR3", "DDR4"}));
		cbxTipoRam.setBounds(307, 66, 117, 22);
		JPMemoriaRam.add(cbxTipoRam);
		
		JPanel JPMotherboard = new JPanel();
		JPMotherboard.setBounds(12, 249, 484, 136);
		contentPane.add(JPMotherboard);
		//JPMemoriaRam.add(JPMotherboard);  // PRIMER ERROR
		JPMotherboard.setBorder(new TitledBorder(null, "Motherboard", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		JPMotherboard.setLayout(null);
		
		JLabel lblTipoConector = new JLabel("Socket:");
		lblTipoConector.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTipoConector.setBounds(89, 64, 109, 14);
		JPMotherboard.add(lblTipoConector);
		
		JLabel lblTipoMemoriaRam = new JLabel("Tipo Memoria Ram:");
		lblTipoMemoriaRam.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTipoMemoriaRam.setBounds(12, 91, 137, 14);
		JPMotherboard.add(lblTipoMemoriaRam);
		
		cbxTipoRamBoard = new JComboBox();
		cbxTipoRamBoard.setEnabled(false);
		cbxTipoRamBoard.setModel(new DefaultComboBoxModel(new String[] {"<<Seleccione>>", "DDR1", "DDR2", "DDR3", "DDR4"}));
		cbxTipoRamBoard.setBounds(157, 88, 124, 22);
		JPMotherboard.add(cbxTipoRamBoard);
		
		JLabel lblNewLabel_12 = new JLabel("Conexion discos:");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_12.setBounds(35, 118, 124, 16);
		JPMotherboard.add(lblNewLabel_12);
		
		cbxSocket = new JComboBox();
		cbxSocket.setEnabled(false);
		cbxSocket.setModel(new DefaultComboBoxModel(new String[] {"<<Seleccione>>", "mPGA478", "479", "LGS775", "AMD"}));
		cbxSocket.setBounds(157, 61, 124, 22);
		JPMotherboard.add(cbxSocket);
		
		rdbtnIDE = new JRadioButton("IDE");
		rdbtnIDE.setEnabled(false);
		rdbtnIDE.setBounds(154, 115, 47, 25);
		JPMotherboard.add(rdbtnIDE);
		
		rdbtnSATA = new JRadioButton("SATA");
		rdbtnSATA.setEnabled(false);
		rdbtnSATA.setBounds(209, 115, 73, 25);
		JPMotherboard.add(rdbtnSATA);
		
		rdbtnSATA2 = new JRadioButton("SATA-2");
		rdbtnSATA2.setEnabled(false);
		rdbtnSATA2.setBounds(284, 115, 79, 25);
		JPMotherboard.add(rdbtnSATA2);
		
		rdbtnSATA3 = new JRadioButton("SATA-3");
		rdbtnSATA3.setEnabled(false);
		rdbtnSATA3.setBounds(367, 115, 79, 25);
		JPMotherboard.add(rdbtnSATA3);
		// BORRAR
		JPMotherboard.setVisible(false);
		
		JPanel JPMicroprocesador = new JPanel();
		JPMicroprocesador.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Microprocesador", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		JPMicroprocesador.setBounds(12, 249, 484, 136);
		contentPane.add(JPMicroprocesador);
		JPMicroprocesador.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Conector:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(12, 78, 68, 16);
		JPMicroprocesador.add(lblNewLabel_6);
		
		cbxConectorProcesador = new JComboBox();
		cbxConectorProcesador.setEnabled(false);
		cbxConectorProcesador.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Intel", "AMD"}));
		cbxConectorProcesador.setBounds(75, 76, 124, 22);
		JPMicroprocesador.add(cbxConectorProcesador);
		
		JLabel lblNewLabel_7 = new JLabel("Velocidad(Mhz):");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(223, 79, 234, 16);
		JPMicroprocesador.add(lblNewLabel_7);
		
		spnVelocidadProcesador = new JSpinner();
		spnVelocidadProcesador.setEnabled(false);
		spnVelocidadProcesador.setBounds(333, 76, 124, 22);
		JPMicroprocesador.add(spnVelocidadProcesador);
		
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.setEnabled(false);
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Componente componente = Controladora.getInstance().buscarComponenteByCode(txtCodigo.getText());
				Proveedores proveedor = null;
				proveedor = Controladora.getInstance().buscarProveedor(txtProveedorComponentes.getText());
				if(componente==null) {
				if(rdbtnMotherboard.isSelected()) {
					if(rdbtnIDE.isSelected()) {
						conexiones.add(rdbtnIDE.getText());
					}
					if(rdbtnSATA.isSelected()) {
						conexiones.add(rdbtnSATA.getText());
					}
					if(rdbtnSATA2.isSelected()) {
						conexiones.add(rdbtnSATA2.getText());
					}
					if(rdbtnSATA3.isSelected()) {
						conexiones.add(rdbtnSATA3.getText());
					}
					componente = new Motherboard(txtCodigo.getText(),(float) Integer.valueOf(spnPrecio.getValue().toString()),(int) Integer.valueOf(spnCantidadMinima.getValue().toString()),(int) Integer.valueOf(spnCantidadReal.getValue().toString()),txtSerial.getText(),txtMarca.getText(),txtModelo.getText(),proveedor,cbxSocket.getSelectedItem().toString(),cbxTipoRamBoard.getSelectedItem().toString(),conexiones);
				}
				
				if(rdbtnMicroprocesador.isSelected()){
					componente = new Microprocesador(txtCodigo.getText(),(float) Integer.valueOf(spnPrecio.getValue().toString()),(int) Integer.valueOf(spnCantidadMinima.getValue().toString()),(int) Integer.valueOf(spnCantidadReal.getValue().toString()),txtSerial.getText(),txtMarca.getText(),txtModelo.getText(),proveedor,cbxConectorProcesador.getSelectedItem().toString(),Integer.valueOf(spnVelocidadProcesador.getValue().toString()));
				}
				if(rdbtnMemoriaRam.isSelected()) {
					componente = new MemoriaRam(txtCodigo.getText(),Integer.valueOf(spnPrecio.getValue().toString()),Integer.valueOf(spnCantidadMinima.getValue().toString()),Integer.valueOf(spnCantidadReal.getValue().toString()),txtSerial.getText(),txtMarca.getText(),txtModelo.getText(),proveedor,Integer.valueOf(spnCapacidadRam.getValue().toString()),cbxTipoRam.getSelectedItem().toString());
				}
				if(rdbtnDiscoDuro.isSelected()) {
					componente = new DiscoDuro(txtCodigo.getText(),(float)Integer.valueOf(spnPrecio.getValue().toString()),(int) Integer.valueOf(spnCantidadMinima.getValue().toString()),(int) Integer.valueOf(spnCantidadReal.getValue().toString()),txtSerial.getText(),txtMarca.getText(),txtModelo.getText(),proveedor,cbxTipoConexionDiscos.getSelectedItem().toString(),(float) Integer.valueOf(spnAlmacenamientoDisco.getValue().toString()));
				}
				Controladora.getInstance().insertarComponentes(componente);
				JOptionPane.showMessageDialog(null, "Registro exitoso", "Información", JOptionPane.INFORMATION_MESSAGE);
				}else {
					if(rdbtnMotherboard.isSelected()) {
						if(rdbtnIDE.isSelected()) {
							conexiones.add(rdbtnIDE.getText());
						}
						if(rdbtnSATA.isSelected()) {
							conexiones.add(rdbtnSATA.getText());
						}
						if(rdbtnSATA2.isSelected()) {
							conexiones.add(rdbtnSATA2.getText());
						}
						if(rdbtnSATA3.isSelected()) {
							conexiones.add(rdbtnSATA3.getText());
						}
						componente = new Motherboard(txtCodigo.getText(),(float) Integer.valueOf(spnPrecio.getValue().toString()),(int) Integer.valueOf(spnCantidadMinima.getValue().toString()),(int) Integer.valueOf(spnCantidadReal.getValue().toString()),txtSerial.getText(),txtMarca.getText(),txtModelo.getText(),proveedor,cbxSocket.getSelectedItem().toString(),cbxTipoRamBoard.getSelectedItem().toString(),conexiones);
					}
					
					if(rdbtnMicroprocesador.isSelected()){
						componente = new Microprocesador(txtCodigo.getText(),(float) Integer.valueOf(spnPrecio.getValue().toString()),(int) Integer.valueOf(spnCantidadMinima.getValue().toString()),(int) Integer.valueOf(spnCantidadReal.getValue().toString()),txtSerial.getText(),txtMarca.getText(),txtModelo.getText(),proveedor,cbxConectorProcesador.getSelectedItem().toString(),Integer.valueOf(spnVelocidadProcesador.getValue().toString()));
					}
					if(rdbtnMemoriaRam.isSelected()) {
						componente = new MemoriaRam(txtCodigo.getText(),Float.parseFloat(spnPrecio.getValue().toString()),Integer.valueOf(spnCantidadMinima.getValue().toString()),Integer.valueOf(spnCantidadReal.getValue().toString()),txtSerial.getText(),txtMarca.getText(),txtModelo.getText(),proveedor,Float.parseFloat(spnCapacidadRam.getValue().toString()),cbxTipoRam.getSelectedItem().toString());
					}
					if(rdbtnDiscoDuro.isSelected()) {
						componente = new DiscoDuro(txtCodigo.getText(),(float)Integer.valueOf(spnPrecio.getValue().toString()),(int) Integer.valueOf(spnCantidadMinima.getValue().toString()),(int) Integer.valueOf(spnCantidadReal.getValue().toString()),txtSerial.getText(),txtMarca.getText(),txtModelo.getText(),proveedor,cbxTipoConexionDiscos.getSelectedItem().toString(),(float) Integer.valueOf(spnAlmacenamientoDisco.getValue().toString()));
					}
					Controladora.getInstance().modificarComponente(componente);
					JOptionPane.showMessageDialog(null, "Modificacion exitosa", "Información", JOptionPane.INFORMATION_MESSAGE);
				}
				clean();
				deshabilitar();
				conexiones.clear();
			}
		});
		btnRegistrar.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnRegistrar.setBounds(384, 13, 138, 41);
		contentPane.add(btnRegistrar);
		
		JPanel JPComponentes = new JPanel();
		JPComponentes.setBorder(new TitledBorder(null, "Componentes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		JPComponentes.setBounds(12, 176, 526, 60);
		contentPane.add(JPComponentes);
		JPComponentes.setLayout(null);
		JPMicroprocesador.setVisible(false);
		JPMemoriaRam.setVisible(true);
		//BORRAR
		
		
		
		rdbtnMemoriaRam = new JRadioButton("Memoria Ram");
		rdbtnMemoriaRam.setEnabled(false);
		rdbtnMemoriaRam.setSelected(true);
		rdbtnMemoriaRam.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnMemoriaRam.setBounds(6, 25, 119, 23);
		rdbtnMemoriaRam.setHorizontalAlignment(SwingConstants.CENTER);
		JPComponentes.add(rdbtnMemoriaRam);
		
		rdbtnMicroprocesador = new JRadioButton("Microprocesador");
		rdbtnMicroprocesador.setEnabled(false);
		rdbtnMicroprocesador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnMicroprocesador.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnMicroprocesador.setBounds(142, 26, 143, 23);
		JPComponentes.add(rdbtnMicroprocesador);
		
		rdbtnMotherboard = new JRadioButton("Motherboard");
		rdbtnMotherboard.setEnabled(false);
		rdbtnMotherboard.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnMotherboard.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnMotherboard.setBounds(289, 26, 126, 23);
		JPComponentes.add(rdbtnMotherboard);
		
		
		
		rdbtnDiscoDuro = new JRadioButton("Disco Duro");
		rdbtnDiscoDuro.setEnabled(false);
		rdbtnDiscoDuro.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnDiscoDuro.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnDiscoDuro.setBounds(414, 25, 109, 23);
		JPComponentes.add(rdbtnDiscoDuro);
		
		btnCancelar = new JButton("Salir");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int option = JOptionPane.showConfirmDialog(null, "¿Realmente desea cancelar el registro del componente?","Confirmar",JOptionPane.INFORMATION_MESSAGE);
				if(JOptionPane.YES_OPTION == option) {
					dispose();
				}
			}
		});
		btnCancelar.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnCancelar.setBounds(399, 543, 138, 41);
		contentPane.add(btnCancelar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setEnabled(false);
		btnModificar.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnModificar.setBounds(384, 65, 138, 41);
		contentPane.add(btnModificar);
		btnModificar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				habilitar();
				btnRegistrar.setEnabled(true);
				
			}
		});
		
		btnRefrescar = new JButton("Refrescar");
		btnRefrescar.setEnabled(false);
		btnRefrescar.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnRefrescar.setBounds(249, 543, 138, 41);
		contentPane.add(btnRefrescar);
		btnRefrescar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				clean();
				deshabilitar();
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(12, 406, 522, 124);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Precio:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(12, 13, 56, 16);
		panel_1.add(lblNewLabel_1);
		
		spnPrecio = new JSpinner();
		spnPrecio.setEnabled(false);
		spnPrecio.setBounds(61, 11, 131, 20);
		panel_1.add(spnPrecio);
		
		JLabel lblNewLabel_8 = new JLabel("Serial:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(242, 14, 56, 16);
		panel_1.add(lblNewLabel_8);
		
		txtSerial = new JTextField();
		txtSerial.setEditable(false);
		txtSerial.setBounds(283, 11, 199, 20);
		panel_1.add(txtSerial);
		txtSerial.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Cantidad minima:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_9.setBounds(12, 51, 114, 16);
		panel_1.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Cantidad real:");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_10.setBounds(242, 51, 114, 16);
		panel_1.add(lblNewLabel_10);
		
		spnCantidadMinima = new JSpinner();
		spnCantidadMinima.setEnabled(false);
		spnCantidadMinima.setBounds(126, 49, 93, 20);
		panel_1.add(spnCantidadMinima);
		
		spnCantidadReal = new JSpinner();
		spnCantidadReal.setEnabled(false);
		spnCantidadReal.setBounds(334, 49, 93, 20);
		panel_1.add(spnCantidadReal);
		
		lblNewLabel_11 = new JLabel("Proveedor:");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_11.setBounds(12, 95, 93, 16);
		panel_1.add(lblNewLabel_11);
		
		txtProveedorComponentes = new JTextField();
		txtProveedorComponentes.setEditable(false);
		txtProveedorComponentes.setBounds(90, 93, 311, 20);
		panel_1.add(txtProveedorComponentes);
		txtProveedorComponentes.setColumns(10);
		
		btnBuscarProveedor = new JButton("Buscar");
		btnBuscarProveedor.setEnabled(false);
		btnBuscarProveedor.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnBuscarProveedor.setBounds(413, 92, 97, 25);
		panel_1.add(btnBuscarProveedor);
		btnBuscarProveedor.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Proveedores proveedor = null;
				proveedor = Controladora.getInstance().buscarProveedor(txtProveedorComponentes.getText());
				
				if(proveedor == null) {
					JOptionPane.showMessageDialog(null, "El vendedor introducido no existe, introduzca uno valido", "Información", JOptionPane.ERROR_MESSAGE);
				}else {
					btnRegistrar.setEnabled(true);
				}
				
			}
		});
		
		rdbtnDiscoDuro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JPMotherboard.setVisible(false);
				JPMicroprocesador.setVisible(false);
				JPMemoriaRam.setVisible(false);
				JPDiscoDuro.setVisible(true);
				
				if(rdbtnDiscoDuro.isSelected()) {
					rdbtnMemoriaRam.setSelected(false);
					rdbtnMicroprocesador.setSelected(false);
					rdbtnMotherboard.setSelected(false);
				}else {
					rdbtnMemoriaRam.setSelected(true);
					JPMotherboard.setVisible(false);
					JPMicroprocesador.setVisible(false);
					JPMemoriaRam.setVisible(true);
					JPDiscoDuro.setVisible(false);
					rdbtnDiscoDuro.setSelected(false);
					rdbtnMicroprocesador.setSelected(false);
					rdbtnMotherboard.setSelected(false);
				}
			}
		});
		
		
		rdbtnMotherboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JPMotherboard.setVisible(true);
				JPMicroprocesador.setVisible(false);
				JPMemoriaRam.setVisible(false);
				JPDiscoDuro.setVisible(false);
				
				if(rdbtnMotherboard.isSelected()) {
					rdbtnDiscoDuro.setSelected(false);
					rdbtnMicroprocesador.setSelected(false);
					rdbtnMemoriaRam.setSelected(false);
				}else {
					rdbtnMemoriaRam.setSelected(true);
					JPMotherboard.setVisible(false);
					JPMicroprocesador.setVisible(false);
					JPMemoriaRam.setVisible(true);
					JPDiscoDuro.setVisible(false);
					rdbtnDiscoDuro.setSelected(false);
					rdbtnMicroprocesador.setSelected(false);
					rdbtnMotherboard.setSelected(false);
				}
			}
		});
		
		
		rdbtnMicroprocesador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPMotherboard.setVisible(false);
				JPMicroprocesador.setVisible(true);
				JPMemoriaRam.setVisible(false);
				JPDiscoDuro.setVisible(false);
				if(rdbtnMicroprocesador.isSelected()) {
					rdbtnDiscoDuro.setSelected(false);
					rdbtnMemoriaRam.setSelected(false);
					rdbtnMotherboard.setSelected(false);
				}else {
					rdbtnMemoriaRam.setSelected(true);
					JPMotherboard.setVisible(false);
					JPMicroprocesador.setVisible(false);
					JPMemoriaRam.setVisible(true);
					JPDiscoDuro.setVisible(false);
					rdbtnDiscoDuro.setSelected(false);
					rdbtnMicroprocesador.setSelected(false);
					rdbtnMotherboard.setSelected(false);
				}
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
	
	private void clean() {
		txtCodigo.setText("");
		txtMarca.setText("");
		txtModelo.setText("");
		txtSerial.setText("");
		txtProveedorComponentes.setText("");
		spnPrecio.setValue(0);
		spnAlmacenamientoDisco.setValue(0);
		spnCantidadMinima.setValue(0);
		spnCantidadReal.setValue(0);
		spnCapacidadRam.setValue(0);
		spnVelocidadProcesador.setValue(0);
		cbxConectorProcesador.setSelectedItem("<<Seleccione>>");
		cbxTipoRam.setSelectedItem("<<Seleccione>>");
		cbxTipoRamBoard.setSelectedItem("<<Seleccione>>");
		cbxSocket.setSelectedItem("<<Seleccione>>");
		cbxTipoConexionDiscos.setSelectedItem("<<Seleccione>>");
        rdbtnIDE.setSelected(false);
        rdbtnSATA.setSelected(false);
        rdbtnSATA2.setSelected(false);
        rdbtnSATA3.setSelected(false);
	}
	
	private void habilitar() {
		txtCodigo.setEditable(true);
		txtMarca.setEditable(true);
		txtModelo.setEditable(true);
		txtSerial.setEditable(true);
		txtProveedorComponentes.setEditable(true);
		cbxTipoConexionDiscos.setEnabled(true);
		spnPrecio.setEnabled(true);
		spnAlmacenamientoDisco.setEnabled(true);
		spnCantidadMinima.setEnabled(true);
		spnCantidadReal.setEnabled(true);
		spnCapacidadRam.setEnabled(true);
		spnVelocidadProcesador.setEnabled(true);
		cbxConectorProcesador.setEnabled(true);
		cbxTipoRam.setEnabled(true);
		cbxTipoRamBoard.setEnabled(true);
		cbxSocket.setEnabled(true);
        rdbtnIDE.setEnabled(true);
        rdbtnSATA.setEnabled(true);
        rdbtnSATA2.setEnabled(true);
        rdbtnSATA3.setEnabled(true);
        rdbtnDiscoDuro.setEnabled(true);
        rdbtnMicroprocesador.setEnabled(true);
        rdbtnMotherboard.setEnabled(true);
     //   btnRegistrar.setEnabled(true);
        btnBuscarProveedor.setEnabled(true);
	}
	
	private void deshabilitar() {
		txtCodigo.setEditable(true);
		txtMarca.setEditable(false);
		txtModelo.setEditable(false);
		txtSerial.setEditable(false);
		txtProveedorComponentes.setEditable(false);
		spnPrecio.setEnabled(false);
		spnAlmacenamientoDisco.setEnabled(false);
		spnCantidadMinima.setEnabled(false);
		spnCantidadReal.setEnabled(false);
		spnCapacidadRam.setEnabled(false);
		spnVelocidadProcesador.setEnabled(false);
		cbxTipoConexionDiscos.setEnabled(false);
		cbxConectorProcesador.setEnabled(false);
		cbxTipoRam.setEnabled(false);
		cbxTipoRamBoard.setEnabled(false);
		cbxSocket.setEnabled(false);
        rdbtnIDE.setEnabled(false);
        rdbtnSATA.setEnabled(false);
        rdbtnSATA2.setEnabled(false);
        rdbtnSATA3.setEnabled(false);
        rdbtnDiscoDuro.setEnabled(false);
        rdbtnMemoriaRam.setEnabled(false);
        rdbtnMicroprocesador.setEnabled(false);
        rdbtnMotherboard.setEnabled(false);
        btnRegistrar.setEnabled(false);
        btnModificar.setEnabled(false);
	}
}
