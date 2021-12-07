package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListaComponentes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtBuscar;
	private JTable table;
	public static DefaultTableModel modelo;
	private int modelrow = -1;
	private int seleccion = -1;
	private Combos c = null;
	private Combos cargaCombos = null;
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
	public ListaComponentes() {
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
				txtBuscar.setBounds(110, 22, 119, 20);
				panel.add(txtBuscar);
				txtBuscar.setColumns(10);
				
				
				/*txtBusqueda = new JTextField();
			txtBusqueda.setBackground(UIManager.getColor("Button.focus"));
			txtBusqueda.setForeground(new Color(0, 0, 255));
			txtBusqueda.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					DefaultTableModel mode = (DefaultTableModel)table.getModel();
					TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(mode);
					table.setRowSorter(tr);
					tr.setRowFilter(RowFilter.regexFilter(txtBusqueda.getText().trim()));
				}
			});
			txtBusqueda.setBounds(150, 13, 236, 30);
			panel.add(txtBusqueda);
			txtBusqueda.setColumns(10);*/
			}
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 59, 531, 274);
				scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
				panel.add(scrollPane);
				
				
				modelo = new DefaultTableModel();
				String columns[] = {"Código","Tipo","Cant. en almacen","Precio Unitario","modelo","Marca"};
				modelo.setColumnIdentifiers(columns);
				table = new JTable();
				
				table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					seleccion = table.getSelectedRow();
					modelrow = table.convertRowIndexToModel(seleccion);
					if(cargaCombos==null) {
						if(seleccion!=-1 && (int)modelo.getValueAt(modelrow, 2)>0) {
							
							btnSeleccionar.setEnabled(true);
							if('C'==((String)modelo.getValueAt(modelrow, 0)).charAt(0)) {
								
								c = Controladora.getInstance().buscarCombos((String)modelo.getValueAt(modelrow, 0));
							}else {
								
							}
						}else {
							btnSeleccionar.setEnabled(false);
						}
					}else {
						btnSeleccionar.setEnabled(false);
					}
				}
			});
				
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				table.setModel(modelo);
				scrollPane.setViewportView(table);
				{
					JLabel lblNewLabel = new JLabel("Buscar");
					lblNewLabel.setBounds(40, 25, 46, 14);
					panel.add(lblNewLabel);
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
				JButton btnSeleccionar = new JButton("Seleccionar");
				btnSeleccionar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						/*if('C'==((String)modelo.getValueAt(modelrow, 0)).charAt(0)) {
							c = Controladora.getInstance().buscarCombos((String)modelo.getValueAt(modelrow, 0));
							//Ventas a = new Ventas(c.getCod(),c.getNombre(),c.calcularprecio(),1);
							dispose();
							//a.setVisible(true);
						}else {*/
							Componente c = Controladora.getInstance().buscarComponenteByCode((String)modelo.getValueAt(modelrow, 0));
							//Ventas a = new Ventas(c.getSerie(),c.getMarca()+" "+c.getModelo(),c.getPrecioVenta(),c.getCantReal());
							dispose();
							//a.setVisible(true);
						//}
					}
				});
				buttonPane.add(btnSeleccionar);
				getRootPane().setDefaultButton(btnSeleccionar);
			}
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
	}
	
/*private void loadTable(int seleccionado) {
		
		modelo.setRowCount(0);
		
		fila = new Object[modelo.getColumnCount()];
		
		if(seleccionado == 0) {
			cargarTabla();
		}
		
		if(seleccionado == 1) {
			for (Componente comp : Controladora.getInstance().getMisComponentes()) { //
				
				if(comp instanceof DiscoDuro) {
				
			    fila[0] = comp.getCodigoComponente();
			    fila[1] = "Disco Duro";
				fila[2] = comp.getPrecio();
				fila[3] = comp.getCantidadMinima();
				fila[4] = comp.getCantidadDisponible();
				fila[5] = comp.getSerial();
				fila[6] = comp.getMarca();
				fila[7] = comp.getModelo();
				fila[8] = comp.getProveedor();
				
				modelo.addRow(fila);
				
				//String codigoComponente,float precio, int cantidadMinima, int cantidadDisponible, String serial,String marca, String modelo, Proveedores proveedor,
				// String tipoConexion, float almacenamiento
			}
			}
		}else if(seleccionado == 2) {
			for (Componente comp : Controladora.getInstance().getMisComponentes()) {
				if(comp instanceof MemoriaRam) {
					
					fila[0] = comp.getSerial();
					fila[1] = "Memoria Ram";	
					fila[2] = comp.getCantReal();
					fila[3] = comp.getPrecioVenta();
					fila[4] = comp.getModelo();
					fila[5] = comp.getMarca();
					
					modelo.addRow(fila);
					
				}
			}
		}
		else if(seleccionado == 3) {
			for (Componente comp : Controladora.getInstance().getMisComponentes()) {
				if(comp instanceof Microprocesador){
				fila[0] = comp.getSerial();							
				fila[1] = "Microprocesador";							
				fila[2] = comp.getCantReal();
				fila[3] = comp.getPrecioVenta();
				fila[4] = comp.getModelo();
				fila[5] = comp.getMarca();
				
				modelo.addRow(fila);
				}
			}
		}
		else if(seleccionado == 4) {
			for (Componente comp : Controladora.getInstance().getMisComponentes()) {
				if(comp instanceof Motherboard) {
					fila[0] = comp.getSerial();
					
					fila[1] = "MotherBoard";
					
					fila[2] = comp.getCantReal();
					fila[3] = comp.getPrecioVenta();
					fila[4] = comp.getModelo();
					fila[5] = comp.getMarca();
					
					modelo.addRow(fila);
				}
			}
		}
		else if(seleccionado == 5 ) {
			for(Combos c : Controladora.getInstance().getMisCombos()) {
				fila[0] = c.getCod();
				fila[1] = "Combo";
				fila[2] = 1;
				fila[3] = c.calcularprecio();
				fila[4] = c.getNombre();
				fila[5] = "Unbranded";
				modelo.addRow(fila);
			}
		}
	}*/
}
