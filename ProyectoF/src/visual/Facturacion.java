package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Logi.Cliente;
import Logi.Combos;
import Logi.Componente;
import Logi.Controladora;
import Logi.DiscoDuro;
import Logi.Factura;
import Logi.MemoriaRam;
import Logi.Microprocesador;
import Logi.Motherboard;
import Logi.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.ListSelectionModel;

public class Facturacion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private DefaultTableModel model;
	private Object row[];
	private JTextField txtFacturaNumero;
	private JTextField txtFacturaFecha;
	private JTextField txtVendedor;
	private JTextField txtCliente;
	private JTextField txtCodigoArticuloCombo;
	private JTable table;
	private JTextField txtPrecioTotal;
	private JButton btnBuscarCliente;
	private JButton btnArticulos;
	private JButton btnClientes;
	private JButton btnCombos;
	private JSpinner spnCantidadArticulos;
	private JButton btnAgregarArticulo;
	private JButton btnNewButton;
	private JButton btnPagoCredito;
	private JButton btnPago;
	private JButton btnSalir;
	private ArrayList<Componente>componentesTabla = new ArrayList<Componente>();
	private ArrayList<Combos>combosTabla = new ArrayList<Combos>();
	private JPanel panel_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Facturacion dialog = new Facturacion();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Facturacion() {
		setModal(true);
		setResizable(false);
		setTitle("Facturacion");
		setBounds(100, 100, 601, 665);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(335, 13, 224, 70);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Factura#:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(12, 13, 79, 16);
		panel.add(lblNewLabel);
		
		txtFacturaNumero = new JTextField();
		txtFacturaNumero.setEditable(false);
		txtFacturaNumero.setBounds(83, 11, 116, 18);
		txtFacturaNumero.setText("F"+Controladora.getInstance().getGenCodigoFactura());
		panel.add(txtFacturaNumero);
		txtFacturaNumero.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Fecha:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(35, 42, 56, 16);
		panel.add(lblNewLabel_1);
		
		txtFacturaFecha = new JTextField();
		txtFacturaFecha.setEditable(false);
		txtFacturaFecha.setColumns(10);
		txtFacturaFecha.setBounds(83, 42, 116, 18);
		panel.add(txtFacturaFecha);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(12, 13, 311, 70);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Vendedor:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(12, 13, 67, 16);
		panel_1.add(lblNewLabel_2);
		
		txtVendedor = new JTextField();
		txtVendedor.setColumns(10);
		txtVendedor.setBounds(12, 39, 199, 18);
		panel_1.add(txtVendedor);
		
		btnArticulos = new JButton("Articulos");
		btnArticulos.setBounds(335, 96, 112, 25);
		contentPanel.add(btnArticulos);
		
		btnCombos = new JButton("Combos");
		btnCombos.setBounds(335, 141, 112, 25);
		contentPanel.add(btnCombos);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(12, 272, 547, 310);
		contentPanel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Codigo articulo/combo:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(12, 12, 148, 20);
		panel_2.add(lblNewLabel_4);
		
		txtCodigoArticuloCombo = new JTextField();
		txtCodigoArticuloCombo.setColumns(10);
		txtCodigoArticuloCombo.setBounds(173, 14, 102, 18);
		panel_2.add(txtCodigoArticuloCombo);
		
		JLabel lblNewLabel_5 = new JLabel("Cantidad:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(287, 14, 61, 16);
		panel_2.add(lblNewLabel_5);
		
		spnCantidadArticulos = new JSpinner();
		spnCantidadArticulos.setBounds(352, 11, 61, 22);
		panel_2.add(spnCantidadArticulos);
		
		btnAgregarArticulo = new JButton("Agregar");
		btnAgregarArticulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				row = new Object[model.getColumnCount()];
				Componente aux = Controladora.getInstance().buscarComponenteByCode(txtCodigoArticuloCombo.getText());
				Combos aux1 = Controladora.getInstance().buscarCombos(txtCodigoArticuloCombo.getText());
				if(aux!=null) {
					row[0] = aux.getCodigoComponente();
					row[1] = spnCantidadArticulos.getValue().toString();
					row[2] = aux.getPrecio();
					componentesTabla.add(aux);
			    }else if(aux1!=null) {
			    	row[0] = aux1.getCodigo();
					row[1] = spnCantidadArticulos.getValue().toString();
					row[2] = aux1.getPrecioCombo();
					combosTabla.add(aux1);
			    }
				model.addRow(row);
				CalcularPrecio();
		}

			});
		btnAgregarArticulo.setBounds(425, 10, 97, 25);
		panel_2.add(btnAgregarArticulo);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(12, 50, 510, 247);
		panel_2.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel_3.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		model = new DefaultTableModel();
		String headers[] = {"Codigo","Cantidad","Precio"};
		scrollPane.setViewportView(table);
		model.setColumnIdentifiers(headers);
		table.setModel(model);
		
		btnClientes = new JButton("Clientes");
		btnClientes.setBounds(447, 96, 112, 25);
		contentPanel.add(btnClientes);
		
		JLabel lblNewLabel_6 = new JLabel("Total:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(374, 502, 78, 16);
		contentPanel.add(lblNewLabel_6);
		
		txtPrecioTotal = new JTextField();
		txtPrecioTotal.setColumns(10);
		txtPrecioTotal.setBounds(417, 500, 102, 18);
		contentPanel.add(txtPrecioTotal);
		
		panel_4 = new JPanel();
		panel_4.setBounds(12, 98, 311, 144);
		contentPanel.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Cliente:");
		lblNewLabel_3.setBounds(12, 13, 56, 16);
		panel_4.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		txtCliente = new JTextField();
		txtCliente.setBounds(12, 42, 199, 18);
		panel_4.add(txtCliente);
		txtCliente.setColumns(10);
		
		btnBuscarCliente = new JButton("Buscar");
		btnBuscarCliente.setBounds(218, 42, 81, 18);
		panel_4.add(btnBuscarCliente);
		btnBuscarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente cliente = Controladora.getInstance().buscarCliente(txtCliente.getText());
				
				if(cliente!=null) {
					
				}
			}
		});
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			btnPagoCredito = new JButton("Pagar credito");
			btnPagoCredito.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				}
			});
			
			btnNewButton = new JButton("Refrescar");
			buttonPane.add(btnNewButton);
			buttonPane.add(btnPagoCredito);
			{
				btnPago = new JButton("Pagar");
				btnPago.setActionCommand("OK");
				btnPago.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						Componente aux = Controladora.getInstance().buscarComponenteByCode(txtCodigoArticuloCombo.getText());
						Combos aux1 = Controladora.getInstance().buscarCombos(txtCodigoArticuloCombo.getText());
						if(aux!=null) {
						//	Factura fac = new Factura();
					    }else if(aux1!=null) {
					    	
					    }
					}
				});
				buttonPane.add(btnPago);
				getRootPane().setDefaultButton(btnPago);
			}
			{
				btnSalir = new JButton("Salir");
				btnSalir.setActionCommand("Cancel");
				btnSalir.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
							dispose();
					}
				});
				buttonPane.add(btnSalir);
			}
		}
	}
	
	private void CalcularPrecio() {
		float total=0;
	      
	      for(int i=0;i<table.getRowCount();i++) {
	    	  total = total + ((Float.parseFloat(model.getValueAt(i, 1).toString()))*Float.parseFloat(model.getValueAt(i, 2).toString()));
	      }	
	}
}