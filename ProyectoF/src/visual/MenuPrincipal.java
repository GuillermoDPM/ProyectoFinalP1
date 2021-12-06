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
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
public class MenuPrincipal extends JFrame {

	private JPanel contentPane;

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
			public void windowOpened(WindowEvent e) {
				 
				 
			}
			@Override
			public void windowClosing(WindowEvent e) {
				
				try {
					File fichero = new File("ZinioComputer.dat");
					FileOutputStream fileOut = new FileOutputStream(fichero);
					ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
					//objectOut.writeObject(Controladora.getInstance());
					objectOut.close();
					
					} catch (Exception ex) {
					ex.printStackTrace();
					}
			}
			 
			 @Override
			public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub
			}

			 @Override
			public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub
			}

			 @Override
			public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub
			}

			 @Override
			public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub
			}

			 @Override
			public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
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
		
		JMenu mnNewMenu = new JMenu("Registro");
		menuBar.add(mnNewMenu);
		
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Cliente");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisCliente regCliente = new RegisCliente();
				regCliente.setVisible(true);
			}
		});
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Componentes");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					RegistrarComponentes regComponentes = new RegistrarComponentes();
					regComponentes.setVisible(true);
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		mnNewMenu.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Combos");
		mnNewMenu.add(mntmNewMenuItem_3);
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				RegCombos regcombos = new RegCombos();
				regcombos.setVisible(true);
			}
		});
		
		JMenu mnNewMenu_3 = new JMenu("Facturaci\u00F3n");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Facturar");
		mnNewMenu_3.add(mntmNewMenuItem_1);
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Facturacion facturacion = new Facturacion();
				facturacion.setVisible(true);	
			}
		});
		
		JMenu mnNewMenu_1 = new JMenu("Orden de Compra");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Orden Compra");
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_2 = new JMenu("Administrador");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Usuario");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisUsuario regUsuario = new RegisUsuario();
				regUsuario.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_5);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
