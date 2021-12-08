package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import Logi.Combos;
import Logi.Componente;
import Logi.Controladora;
import Logi.DiscoDuro;
import Logi.Proveedores;
import Logi.Cliente;
import Logi.Combos;
import Logi.DiscoDuro;
import Logi.MemoriaRam;
import Logi.Microprocesador;
import Logi.Motherboard;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class ListaCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtBuscar;
	private JTable table;
	public static DefaultTableModel modelo;
	private int modelrow = -1;
	private int seleccion = -1;
	private Combos c = null;
	private Combos cargaCombos = null;
	private int mode=-1;
	private int boton = 1;
	private JButton btnSeleccionar;
	public static Object[] fila;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListaComponentes dialog = new ListaComponentes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListaCliente() {
		
		setBounds(100, 100, 587, 437);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(10, 10, 551, 344);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				txtBuscar = new JTextField();
				
				txtBuscar.addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent e) {
						DefaultTableModel mode = (DefaultTableModel)table.getModel();
						TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(mode);
						table.setRowSorter(tr);
						tr.setRowFilter(RowFilter.regexFilter(txtBuscar.getText().trim()));
						
					}
				});
				txtBuscar.setBounds(220, 22, 218, 20);
				panel.add(txtBuscar);
				txtBuscar.setColumns(10);
				
				
			}
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 59, 531, 274);
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				panel.add(scrollPane);
				
				
				modelo = new DefaultTableModel();
				String[] columns = {"Nombre","Direccion","Telefono","Tipo","Identificacion","Credito"}; 
				//(String nombre, String direccion, String telefono, String tipo, String identificacion, float limiteCredito)
				modelo.setColumnIdentifiers(columns);
				table = new JTable();
				
				table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					
					seleccion = table.getSelectedRow();
					modelrow = table.convertRowIndexToModel(seleccion);
					
					
							/*	if(seleccion!=-1){
									btnSeleccionar.setEnabled(true);
									btnCrear.setEnabled(false);
									btnPagar.setEnabled(true);
									aux = Prodacom.getInstance().buscarCliente((String)modelo.getValueAt(modelrow, 0));
									
									
								}else{	
									btnSeleccionar.setEnabled(false);
									btnPagar.setEnabled(false);
									btnCrear.setEnabled(true);
									}
								else {
									btnSeleccionar.setEnabled(false);
									btnCrear.setEnabled(false);
									btnPagar.setEnabled(true);
								}*/
				
				}
			});
				
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				table.setModel(modelo);
				scrollPane.setViewportView(table);
				{
					JButton btnBuscar = new JButton("Buscar");
					btnBuscar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							CargarTable();
							buscarTable(txtBuscar.getText());
							
							if(boton==1) {
								boton=0;
								txtBuscar.setVisible(true);
								btnBuscar.setText("");
								
							
							}else {
								boton=1;
								txtBuscar.setVisible(false);
								txtBuscar.setText("");
								btnBuscar.setText("Buscar");
							}
							
							
						}

						
					});
					btnBuscar.setBounds(121, 21, 89, 23);
					panel.add(btnBuscar);
				}
			
				{
					
					
				}
			}
			
			
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
						
					}
				});
				{
					JButton btnPagarCuenta = new JButton("Pagar Cuenta");
					btnPagarCuenta.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
								float aux1 = (Float) modelo.getValueAt(table.getSelectedRow(), 5);
							    Cliente aux = Controladora.getInstance().buscarCliente(modelo.getValueAt(table.getSelectedRow(), 4).toString());
							if(aux1 >= aux.getLimiteCredito()) {
								JOptionPane.showMessageDialog(null, "El cliente seleccionado no tiene deudas pendientes", "Información", JOptionPane.ERROR_MESSAGE);

							}else {
								int opcion = JOptionPane.showConfirmDialog(null, "Seguro que desea realizar el pago total de sus facturas");
								if(opcion==JOptionPane.OK_OPTION) {
									Controladora.getInstance().PagarDeudaCliente(aux);
									JOptionPane.showMessageDialog(null, "Pago realizado");
									CargarTable();
								}else {
									CargarTable();
								}
							}
							
						}
					});
					buttonPane.add(btnPagarCuenta);
				}
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
		CargarTable();
	}



private void CargarTable() {
	modelo.setRowCount(0);
	fila = new Object[modelo.getColumnCount()];
	
	for (Cliente c : Controladora.getInstance().getMisClientes()) {
		fila[0]=c.getNombre();
		fila[1]=c.getDireccion();
		fila[2]=c.getTelefono();
		fila[3]=c.getTipo();
		fila[4]=c.getIdentifiacion();
		fila[5]=Controladora.getInstance().CreditCliente(c);
		modelo.addRow(fila);
	}
		
	
		//(String nombre, String direccion, String telefono, String tipo, String identificacion, float limiteCredito)

}

public  void buscarTable(String codigo) {
	// TODO Auto-generated method stub
	
	modelo.setRowCount(0);
	fila = new Object[modelo.getColumnCount()];
	
	
		for (Cliente c : Controladora.getInstance().getMisClientes()) {
			
			if(c.getIdentifiacion().equalsIgnoreCase(codigo)) {
			fila[0]=c.getNombre();
			fila[1]=c.getDireccion();
			fila[2]=c.getTelefono();
			fila[3]=c.getTipo();
			fila[4]=c.getIdentifiacion();
			fila[5]=Controladora.getInstance().CreditCliente(c);
			modelo.addRow(fila);
		}
	}
	
	
}


}
