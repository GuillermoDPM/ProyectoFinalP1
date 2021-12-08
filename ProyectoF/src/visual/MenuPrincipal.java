package visual;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logi.Controladora;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
public class MenuPrincipal extends JFrame {

	private JPanel contentPane;
	
	private JMenu mnComponentes;
	private JMenu mnFacturacion;
	private JMenu mnClientes;
	private JMenu mnCombos;
	private JMenu mnProveedores;
	private JMenu mnAdministrador;
	private JMenu mnRespaldo;
	private JMenu mnOrdenCompra;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
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
	public MenuPrincipal() {
		
		
	
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				FileOutputStream empresa2;
				ObjectOutputStream empresaWrite;
				try {
					
					empresa2 = new  FileOutputStream("ZinioComputer.dat");
					empresaWrite = new ObjectOutputStream(empresa2);
					empresaWrite.writeObject(Controladora.getInstance());

					File fichero = new File("ZinioComputer.dat");
					FileOutputStream fileOut = new FileOutputStream(fichero);
					ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
					objectOut.writeObject(Controladora.getInstance());
					objectOut.close();
					
					} 

				 catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
			}
		});
		
		
		
		
		setTitle("Zinio Computer");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 672, 684);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize.width, screenSize.height-30);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnOrdenCompra = new JMenu("Orden de Compra");
		menuBar.add(mnOrdenCompra);
		
		JMenu mnAdministrador = new JMenu("Administrador");
		menuBar.add(mnAdministrador);
		
		JMenu mnFacturacion = new JMenu("Facturaci\u00F3n");
		menuBar.add(mnFacturacion);
		
		JMenu mnComponentes = new JMenu("Componentes");
		menuBar.add(mnComponentes);
		
		JMenu mnCombos = new JMenu("Combos");
		menuBar.add(mnCombos);
		
		JMenu mnClientes = new JMenu("Clientes");
		menuBar.add(mnClientes);
		
		JMenu mnProveedores = new JMenu("Proveedores");
		menuBar.add(mnProveedores);
		
		JMenu mnRespaldo = new JMenu("Respaldo");
		menuBar.add(mnRespaldo);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Facturar");
		mnFacturacion.add(mntmNewMenuItem_1);
		
		
		
		JMenuItem mntmNewMenuItem_14 = new JMenuItem("Lista de Facturas");
		mntmNewMenuItem_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaFactura lisfacturacion = new ListaFactura();
				lisfacturacion.setVisible(true);	
				
			}
		});
		mnFacturacion.add(mntmNewMenuItem_14);
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Facturacion facturacion = new Facturacion();
				facturacion.setVisible(true);	
			}
		});
		
		
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Registrar componentes");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarComponentes regComponentes = new RegistrarComponentes();
				regComponentes.setVisible(true);
			}
		});
		mnComponentes.add(mntmNewMenuItem_9);
		
		JMenuItem mntmNewMenuItem_10 = new JMenuItem("Lista de Componentes");
		mntmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ListaComponentes regComponentes = new ListaComponentes();
				regComponentes.setVisible(true);
			}
		});
		mnComponentes.add(mntmNewMenuItem_10);
		
		
		JMenuItem mntmNewMenuItem_13 = new JMenuItem("Registrar Combos");
		mntmNewMenuItem_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RegCombos regcombos = new RegCombos();
				regcombos.setVisible(true);
			}
		});
		mnCombos.add(mntmNewMenuItem_13);
		
		
		
		JMenuItem mntmNewMenuItem_11 = new JMenuItem("Registrar Clientes");
		mntmNewMenuItem_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RegisCliente regCliente = new RegisCliente();
				regCliente.setVisible(true);
			}
		});
		mnClientes.add(mntmNewMenuItem_11);
		
		JMenuItem mntmNewMenuItem_12 = new JMenuItem("Lista de Clientes");
		mntmNewMenuItem_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaCliente listClientes = new ListaCliente();
				listClientes.setVisible(true);
			}
		});
		mnClientes.add(mntmNewMenuItem_12);
		
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Registrar Proveedores");
		mnProveedores.add(mntmNewMenuItem);
		
		
		
		mnRespaldo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Guardar Respaldo");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Socket elSocket = new Socket("127.0.0.1",7000);
				System.out.println("ABRE PORFA");
					ObjectOutputStream elklk = new ObjectOutputStream(elSocket.getOutputStream());
					elklk.writeObject(Controladora.getInstance());
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnRespaldo.add(mntmNewMenuItem_8);
		
		
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Orden Compra");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				OrdenCompra verOrdenCompra = new OrdenCompra();
				verOrdenCompra.setVisible(true);
			}
		});
		mnOrdenCompra.add(mntmNewMenuItem_2);
		
		
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Usuario");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisUsuario regUsuario = new RegisUsuario();
				regUsuario.setVisible(true);
			}
		});
		mnAdministrador.add(mntmNewMenuItem_5);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	
	}
	public void CargarMenu() {
		if(Controladora.getInstance().usernameUsuario().equals("Vendedor")) {
			mnFacturacion.setEnabled(true);
			mnComponentes.setEnabled(true);
			mnClientes.setEnabled(true);
			mnCombos.setEnabled(true);
			mnProveedores.setEnabled(true);
			
			mnRespaldo.setEnabled(true);
			mnOrdenCompra.setEnabled(false);
			mnAdministrador.setEnabled(false);
		}
		
		if(Controladora.getInstance().usernameUsuario().equals("Administrador")) {
			mnFacturacion.setEnabled(true);
			mnComponentes.setEnabled(true);
			mnClientes.setEnabled(true);
			mnCombos.setEnabled(true);
			mnProveedores.setEnabled(true);
			
			mnRespaldo.setEnabled(true);
			mnOrdenCompra.setEnabled(true);
			mnAdministrador.setEnabled(true);
			
		}
		
	}
	
}
