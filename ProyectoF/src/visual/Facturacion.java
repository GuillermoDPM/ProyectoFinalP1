package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
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
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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
	private JTextField txtCliente;
	private JTextField txtCodigoArticuloCombo;
	private JTable table;
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
	
	private static JComboBox cbxVendedores;
	
	private static Factura auxiliar = null;
	private JTextField txtNombreCliente;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JTextField txtTelefonoCliente;
	private JTextField txtBalanceCliente;
	private JLabel lblNewLabel_6;
	private JTextField txtTotalFactura;

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
		setBounds(100, 100, 578, 706);
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
		Calendar inicio=new GregorianCalendar();
		inicio.setTime(new Date());
		txtFacturaFecha.setText(""+inicio.get(Calendar.DAY_OF_MONTH)+"/"+(1+(inicio.get(Calendar.MONTH)))+"/"+inicio.get(Calendar.YEAR));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(12, 13, 311, 70);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Vendedor:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(12, 13, 67, 16);
		panel_1.add(lblNewLabel_2);
		
		
		cbxVendedores = new JComboBox(Controladora.getInstance().NombresVendedores().toArray());
		if(auxiliar!=null) {
			cbxVendedores.setVisible(false);
		}else {
			cbxVendedores.setVisible(true);
		}
		//JComboBox cbxVendedores = new JComboBox();
		cbxVendedores.setBounds(12, 42, 127, 20);
		panel_1.add(cbxVendedores);
		
		
		
		btnArticulos = new JButton("Articulos");
		btnArticulos.setBounds(335, 96, 112, 25);
		contentPanel.add(btnArticulos);
		
		btnCombos = new JButton("Combos");
		btnCombos.setBounds(335, 141, 112, 25);
		contentPanel.add(btnCombos);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(12, 272, 547, 338);
		contentPanel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Codigo articulo/combo:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(12, 12, 148, 20);
		panel_2.add(lblNewLabel_4);
		
		txtCodigoArticuloCombo = new JTextField();
		txtCodigoArticuloCombo.setEditable(false);
		txtCodigoArticuloCombo.setColumns(10);
		txtCodigoArticuloCombo.setBounds(161, 12, 102, 18);
		panel_2.add(txtCodigoArticuloCombo);
		
		JLabel lblNewLabel_5 = new JLabel("Cantidad:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(287, 14, 61, 16);
		panel_2.add(lblNewLabel_5);
		
		spnCantidadArticulos = new JSpinner();
		spnCantidadArticulos.setEnabled(false);
		spnCantidadArticulos.setBounds(352, 11, 61, 22);
		panel_2.add(spnCantidadArticulos);
		
		btnAgregarArticulo = new JButton("Agregar");
		btnAgregarArticulo.setEnabled(false);
		btnAgregarArticulo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				row = new Object[model.getColumnCount()];
				Componente aux = Controladora.getInstance().buscarComponenteByCode(txtCodigoArticuloCombo.getText());
				Combos aux1 = Controladora.getInstance().buscarCombos(txtCodigoArticuloCombo.getText());
				if(aux!=null) {
					row[0] = aux.getCodigoComponente();
					row[1] = spnCantidadArticulos.getValue().toString();
					row[2] = aux.getPrecio();
					model.addRow(row);
					componentesTabla.add(aux);
			    }else if(aux1!=null) {
							row[0] = aux1.getCodigo();
							row[1]= spnCantidadArticulos.getValue().toString();
							row[2] = aux1.getPrecioCombo();
							model.addRow(row);
			    	combosTabla.add(aux1);
			    }
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
		
		lblNewLabel_6 = new JLabel("Total:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(357, 310, 56, 16);
		panel_2.add(lblNewLabel_6);
		
		txtTotalFactura = new JTextField();
		txtTotalFactura.setEditable(false);
		txtTotalFactura.setBounds(395, 308, 127, 18);
		panel_2.add(txtTotalFactura);
		txtTotalFactura.setColumns(10);
		
		btnClientes = new JButton("Clientes");
		btnClientes.setBounds(447, 96, 112, 25);
		contentPanel.add(btnClientes);
		
		panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(12, 98, 311, 161);
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
		
		txtNombreCliente = new JTextField();
		txtNombreCliente.setEditable(false);
		txtNombreCliente.setBounds(12, 73, 287, 18);
		panel_4.add(txtNombreCliente);
		txtNombreCliente.setColumns(10);
		
		lblNewLabel_7 = new JLabel("Telefono:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(12, 104, 68, 16);
		panel_4.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("Balance:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_8.setBounds(166, 104, 56, 16);
		panel_4.add(lblNewLabel_8);
		
		txtTelefonoCliente = new JTextField();
		txtTelefonoCliente.setEditable(false);
		txtTelefonoCliente.setBounds(12, 126, 132, 18);
		panel_4.add(txtTelefonoCliente);
		txtTelefonoCliente.setColumns(10);
		
		txtBalanceCliente = new JTextField();
		txtBalanceCliente.setEditable(false);
		txtBalanceCliente.setBounds(166, 126, 133, 18);
		panel_4.add(txtBalanceCliente);
		txtBalanceCliente.setColumns(10);
		btnBuscarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente cliente = Controladora.getInstance().buscarCliente(txtCliente.getText());
				
				if(cliente!=null) {
					txtNombreCliente.setText(cliente.getNombre());
					txtTelefonoCliente.setText(cliente.getTelefono());
					txtBalanceCliente.setText(String.valueOf(Controladora.getInstance().CreditCliente(cliente)));
					habilitar();
				}else {
					JOptionPane.showMessageDialog(null, "El cliente introducido no existe en el sistema", "Información", JOptionPane.ERROR_MESSAGE);

				}
			}
		});
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			btnPagoCredito = new JButton("Pagar credito");
			btnPagoCredito.setEnabled(false);
			btnPagoCredito.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int ok = JOptionPane.showConfirmDialog(null, "Esta seguro que desea realizar la factura");
					Cliente cliente = Controladora.getInstance().buscarCliente(txtCliente.getText());
					
					if(cliente!=null && ok==JOptionPane.OK_OPTION) {
						float pago = Controladora.getInstance().CreditCliente(cliente);
						
						if(pago>=Float.parseFloat(txtTotalFactura.getText())) {
							Usuario user = Controladora.getInstance().BuscarUser(cbxVendedores.getSelectedItem().toString());
							Factura factura = new Factura(txtFacturaNumero.getText(),Float.parseFloat(txtTotalFactura.getText()),user,cliente,false);
							
							for(Combos combo: combosTabla) {
								factura.insertarcombos(combo);
							}
							
							for(Componente componentes:componentesTabla) {
								factura.insertarcomponentes(componentes);
							}
							
							Controladora.getInstance().insertarFacturas(factura);
							JOptionPane.showMessageDialog(null, "El credito restante para el cliente es de: "+(pago-(Float.parseFloat(txtTotalFactura.getText()))));
							decrementar();
							clear();
							deshabilitar();
						}else {
							JOptionPane.showMessageDialog(null, "Su credito disponible no es suficiente para pagar la factura");

						}
					}
					
					

				}

			});
			
			btnNewButton = new JButton("Refrescar");
			buttonPane.add(btnNewButton);
			buttonPane.add(btnPagoCredito);
			btnNewButton.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					clear();	
					deshabilitar();
				}
			});
			{
				btnPago = new JButton("Pagar");
				btnPago.setEnabled(false);
				btnPago.setActionCommand("OK");
				btnPago.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						int ok = JOptionPane.showConfirmDialog(null, "Esta seguro que desea realizar la factura");
						Cliente cliente = Controladora.getInstance().buscarCliente(txtCliente.getText());
						
						if(cliente!=null && ok==JOptionPane.OK_OPTION) {
							float pago = Float.parseFloat(JOptionPane.showInputDialog("Digite el monto de pago"));
							if(pago>=Float.parseFloat(txtTotalFactura.getText())) {
								Usuario user = Controladora.getInstance().BuscarUser(cbxVendedores.getSelectedItem().toString());
								Factura factura = new Factura(txtFacturaNumero.getText(),Float.parseFloat(txtTotalFactura.getText()),user,cliente,true);
							
								for(Combos combo: combosTabla) {
									factura.insertarcombos(combo);
								}
								
								for(Componente componentes:componentesTabla) {
									factura.insertarcomponentes(componentes);
								}
								
								Controladora.getInstance().insertarFacturas(factura);
								JOptionPane.showMessageDialog(null, "Su devuelta es: "+(pago-(Float.parseFloat(txtTotalFactura.getText()))));
								decrementar();
								clear();
								deshabilitar();
								
							}else {
								JOptionPane.showMessageDialog(null, "Ha ingresado una cantidad inferior a la requerida");
							}
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
	      txtTotalFactura.setText(String.valueOf(total));
	}
	
	private void decrementar() {
		Factura factura = Controladora.getInstance().buscarFactura(txtFacturaNumero.getText());
		for (Componente c : componentesTabla) {
			for(int i=0;i<=componentesTabla.size();i++) {
				try {
					if(c.getCodigoComponente().equalsIgnoreCase(factura.getMisComponentes().get(i).getCodigoComponente())) {
						c.setCantidadDisponible(c.getCantidadDisponible()-(Integer.valueOf(model.getValueAt(i, 1).toString())));
					}
				}
				 catch (Exception e) {
					
				}
		}}
				
		try {
			for(Combos c: combosTabla) {
				for(int i=0;i<Controladora.getInstance().getMisComponentes().size();i++) {
					if(c.getMisComponentes().get(i).getCodigoComponente().equalsIgnoreCase(factura.getMisCombos().get(i).getMisComponentes().get(i).getCodigoComponente())) {
						c.getMisComponentes().get(i).setCantidadDisponible((c.getMisComponentes().get(i).getCantidadDisponible()-(Integer.valueOf(model.getValueAt(i, 1).toString()))));
					}
				}
			}
		} catch (Exception e) {
		}
		
		
	}
	
	private void clear() {
		txtFacturaNumero.setText("F"+Controladora.getInstance().getGenCodigoFactura());
	    txtCliente.setText("");
	    txtNombreCliente.setText("");
	    txtTelefonoCliente.setText("");
	    txtBalanceCliente.setText("");
	    txtCodigoArticuloCombo.setText("");
	    spnCantidadArticulos.setValue(0);
	    txtTotalFactura.setText("");
	    model.setRowCount(0);
	    Calendar inicio=new GregorianCalendar();
		inicio.setTime(new Date());
		txtFacturaFecha.setText(""+inicio.get(Calendar.DAY_OF_MONTH)+"/"+(1+(inicio.get(Calendar.MONTH)))+"/"+inicio.get(Calendar.YEAR));
	}
	
	private void habilitar() {
		txtCodigoArticuloCombo.setEditable(true);
		spnCantidadArticulos.setEnabled(true);
        btnAgregarArticulo.setEnabled(true);
        btnPago.setEnabled(true);
        btnPagoCredito.setEnabled(true);
	}
	
	private void deshabilitar() {
		txtCodigoArticuloCombo.setEditable(false);
		spnCantidadArticulos.setEnabled(false);
		btnAgregarArticulo.setEnabled(false);
		btnPago.setEnabled(false);
		btnPagoCredito.setEnabled(false);
	}
}