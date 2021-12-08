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
import java.util.Date;

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
import Logi.Factura;
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

public class ListaFactura extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtBuscar;
	private JTable table;
	public static DefaultTableModel modelo;
	private int modelrow = -1;
	private int seleccion = -1;
	private Combos c = null;
	private Combos cargaCombos = null;
	private static Cliente aux = null;
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
	public ListaFactura() {
		
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
				
			String columns[] = {"Código","Cliente","Vendedor","Total","Fecha"};

				modelo.setColumnIdentifiers(columns);
				table = new JTable();
				
				table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					
					seleccion = table.getSelectedRow();
					modelrow = table.convertRowIndexToModel(seleccion);
					
					/*
								if(seleccion!=-1){
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
							
							/*if(boton==1) {
								boton=0;
								txtBuscar.setVisible(true);
								btnBuscar.setText("");
								
							
							}else {
								boton=1;
								txtBuscar.setVisible(false);
								txtBuscar.setText("");
								btnBuscar.setText("Buscar");
							}*/
							
							
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
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
		CargarTable();
	}



private void CargarTable() {
	modelo.setRowCount(0);
	fila = new Object[modelo.getColumnCount()];
	
	for (Factura f : Controladora.getInstance().getMisFacturas()) {
		fila[0]=f.getCodigo();
		fila[1]=f.getCliente().getNombre();
		fila[2]=f.getVendedor().getNombre();
		fila[3]=f.getPrecioTotal();
		fila[4]=f.getFecha();
		modelo.addRow(fila);
	}
		
	
		//String columns[] = {"Código","Cliente","Vendedor","Total","Fecha","Tipo de Pago"};

}

public  void buscarTable(String codigo) {
	// TODO Auto-generated method stub
	
	modelo.setRowCount(0);
	fila = new Object[modelo.getColumnCount()];
	
	
	for (Factura f : Controladora.getInstance().getMisFacturas()) {
		
		if(f.getCodigo().equalsIgnoreCase(codigo)) {
			fila[0]=f.getCodigo();
			fila[1]=f.getCliente();
			fila[2]=f.getVendedor();
			fila[3]=f.getPrecioTotal();
			fila[4]=f.getFecha();
			fila[5]=f.getTipoDePago();
			modelo.addRow(fila);
		}
		
	}
	
	
	
}


}