package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Logi.Cliente;
import Logi.Combos;
import Logi.Componente;
import Logi.Controladora;
import Logi.DiscoDuro;
import Logi.MemoriaRam;
import Logi.Microprocesador;
import Logi.Motherboard;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JSpinner;

public class RegCombos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private DefaultTableModel model;
	private Object[] row;
	private Componente selected;
	private JTextField txtCodigoCombo;
	private JTextField txtNombreCombo;
	private JTextField txtCodigoArticulo;
	private JSpinner spnCantidadArticulo;
	private JButton btnAgregar;
	private JButton btnBuscar;
	private JSpinner spnDescuentoCombo;
	int contadorFila=0;
	private ArrayList<Componente>componentesTabla = new ArrayList<Componente>();
	private JTextField txtSubtotal;
	private JTextField txtDescuento;
	private JTextField txtTotal;
	private JTable table;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegCombos dialog = new RegCombos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegCombos() {
		setModal(true);
		setResizable(false);
		setTitle("Combos");
		setBounds(100, 100, 540, 650);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(12, 257, 498, 217);
			contentPanel.add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			panel.add(scrollPane, BorderLayout.CENTER);
			
			table = new JTable();
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			model = new DefaultTableModel();
			String headers[] = {"Codigo","Cantidad","Marca","Modelo","Precio unitario"};
			scrollPane.setViewportView(table);
			model.setColumnIdentifiers(headers);
			table.setModel(model);
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Informacion", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(12, 40, 498, 142);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JLabel lblNewLabel = new JLabel("Codigo:");
				lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblNewLabel.setBounds(12, 32, 56, 19);
				panel.add(lblNewLabel);
			}
			{
				txtCodigoCombo = new JTextField();
				txtCodigoCombo.setBounds(91, 32, 154, 20);
				panel.add(txtCodigoCombo);
				txtCodigoCombo.setColumns(10);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Nombre:");
				lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblNewLabel_1.setBounds(12, 64, 69, 16);
				panel.add(lblNewLabel_1);
			}
			{
				txtNombreCombo = new JTextField();
				txtNombreCombo.setEditable(false);
				txtNombreCombo.setFont(new Font("Tahoma", Font.PLAIN, 13));
				txtNombreCombo.setBounds(90, 65, 396, 20);
				panel.add(txtNombreCombo);
				txtNombreCombo.setColumns(10);
			}
			{
				JLabel lblNewLabel_2 = new JLabel("Descuento:");
				lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblNewLabel_2.setBounds(12, 101, 79, 16);
				panel.add(lblNewLabel_2);
			}
			{
				spnDescuentoCombo = new JSpinner();
				spnDescuentoCombo.setEnabled(false);
				spnDescuentoCombo.setFont(new Font("Tahoma", Font.PLAIN, 13));
				spnDescuentoCombo.setBounds(91, 98, 79, 20);
				panel.add(spnDescuentoCombo);
			}
			{
				btnBuscar = new JButton("Buscar");
				btnBuscar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Combos aux = Controladora.getInstance().buscarCombos(txtCodigoCombo.getText());
						
						if(aux == null) {
							int option = JOptionPane.showConfirmDialog(null, "El combo no existe, desea crearlo?", "Confirmar", JOptionPane.WARNING_MESSAGE);
							if(JOptionPane.NO_OPTION == option){
								dispose();
							}else {
								txtNombreCombo.setEditable(true);
								spnDescuentoCombo.setEnabled(true);
								txtCodigoArticulo.setEditable(true);
								spnCantidadArticulo.setEnabled(true);
								btnAgregar.setEnabled(true);
							}
						}else {
							txtNombreCombo.setText(aux.getNombre());
							txtDescuento.setText(String.valueOf(aux.getDescuento()));
							txtTotal.setText(String.valueOf(aux.getPrecioCombo()));
							btnAgregar.setEnabled(true);
							
							cargarTabla();
							
						}
					}

				});
				btnBuscar.setBounds(257, 30, 97, 25);
				panel.add(btnBuscar);
			}
		}
		{
			JLabel lblNewLabel_3 = new JLabel("Codigo:");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel_3.setBounds(12, 212, 56, 20);
			contentPanel.add(lblNewLabel_3);
		}
		{
			txtCodigoArticulo = new JTextField();
			txtCodigoArticulo.setEditable(false);
			txtCodigoArticulo.setColumns(10);
			txtCodigoArticulo.setBounds(63, 210, 131, 20);
			contentPanel.add(txtCodigoArticulo);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("Cantidad:");
			lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel_4.setBounds(206, 213, 68, 16);
			contentPanel.add(lblNewLabel_4);
		}
		{
			spnCantidadArticulo = new JSpinner();
			spnCantidadArticulo.setEnabled(false);
			spnCantidadArticulo.setFont(new Font("Tahoma", Font.PLAIN, 13));
			spnCantidadArticulo.setBounds(272, 210, 79, 20);
			contentPanel.add(spnCantidadArticulo);
		}
		{
			btnAgregar = new JButton("Agregar");
			btnAgregar.setEnabled(false);
			btnAgregar.setBounds(378, 209, 97, 25);
			contentPanel.add(btnAgregar);
			{
				JLabel lblNewLabel_5 = new JLabel("Subtotal:");
				lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblNewLabel_5.setBounds(268, 487, 68, 16);
				contentPanel.add(lblNewLabel_5);
			}
			{
				JLabel lblNewLabel_6 = new JLabel("Descuento:");
				lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblNewLabel_6.setBounds(253, 517, 83, 16);
				contentPanel.add(lblNewLabel_6);
			}
			{
				JLabel lblNewLabel_7 = new JLabel("Total:");
				lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblNewLabel_7.setBounds(285, 546, 56, 16);
				contentPanel.add(lblNewLabel_7);
			}
			{
				txtSubtotal = new JTextField();
				txtSubtotal.setEditable(false);
				txtSubtotal.setBounds(332, 485, 116, 18);
				contentPanel.add(txtSubtotal);
				txtSubtotal.setColumns(10);
			}
			{
				txtDescuento = new JTextField();
				txtDescuento.setEditable(false);
				txtDescuento.setColumns(10);
				txtDescuento.setBounds(332, 516, 116, 18);
				contentPanel.add(txtDescuento);
			}
			{
				txtTotal = new JTextField();
				txtTotal.setEditable(false);
				txtTotal.setColumns(10);
				txtTotal.setBounds(332, 544, 116, 18);
				contentPanel.add(txtTotal);
			}
			
			JPanel panel = new JPanel();
			panel.setBounds(12, 257, 498, 217);
			contentPanel.add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			btnAgregar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					model.setRowCount(contadorFila);
					row = new Object[model.getColumnCount()];
					Componente aux = Controladora.getInstance().buscarComponenteByCode(txtCodigoArticulo.getText());
					
					if(aux!=null) {
						row[0] = aux.getCodigoComponente();
						row[1] = spnCantidadArticulo.getValue().toString();
						row[4] = aux.getPrecio();
						
							if(aux instanceof Motherboard) {
								row[2] = ((Motherboard) aux).getMarca();
								row[3] = ((Motherboard) aux).getModelo();
							}
							if(aux instanceof DiscoDuro) {
								row[2] = ((DiscoDuro) aux).getMarca();
								row[3] = ((DiscoDuro) aux).getModelo();
							}
							if(aux instanceof Microprocesador) {
								row[2] = ((Microprocesador) aux).getMarca();
								row[3] = ((Microprocesador) aux).getModelo();
							}
							if(aux instanceof MemoriaRam) {
								row[2] = ((MemoriaRam) aux).getMarca();
								row[3] = ((MemoriaRam) aux).getModelo();
							}
							model.addRow(row);
							componentesTabla.add(aux);
							contadorFila++;
							calcularPrecio();
					}
				}
			});
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnRegistrarCombo = new JButton("Registrar Combo");
				btnRegistrarCombo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				{
					JButton btnEliminarElemento = new JButton("Remover elemento");
					btnEliminarElemento.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Componente aux = Controladora.getInstance().buscarComponenteByCode(txtCodigoArticulo.getText());
							int seleccion = table.getSelectedRow();
                            model.removeRow(seleccion);
                            componentesTabla.remove(aux);
                            contadorFila--;
                            calcularPrecio();
						}
					});
					buttonPane.add(btnEliminarElemento);
				}
				btnRegistrarCombo.setActionCommand("OK");
				buttonPane.add(btnRegistrarCombo);
				getRootPane().setDefaultButton(btnRegistrarCombo);
				btnRegistrarCombo.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						Combos aux = Controladora.getInstance().buscarCombos(txtCodigoCombo.getText());
						
						if(aux==null) {
							Combos aux1 = new Combos(txtCodigoCombo.getText(),txtNombreCombo.getText(),Integer.valueOf(spnDescuentoCombo.getValue().toString()),componentesTabla,Float.parseFloat(txtTotal.getText()));
						    Controladora.getInstance().insertarCombos(aux1);
							JOptionPane.showMessageDialog(null, "Registro Satisfactorio", "Información", JOptionPane.INFORMATION_MESSAGE);

						}else {
							Combos aux1 = new Combos(txtCodigoCombo.getText(),txtNombreCombo.getText(),Integer.valueOf(spnDescuentoCombo.getValue().toString()),componentesTabla,Float.parseFloat(txtTotal.getText()));
                            Controladora.getInstance().modificarCombo(aux1);
							JOptionPane.showMessageDialog(null, "Modificacion Satisfactoria", "Información", JOptionPane.INFORMATION_MESSAGE);

						}
						limpiar();
						
						
					}

				});
			}
			{
				JButton btnSalir = new JButton("Salir");
				btnSalir.setActionCommand("Cancel");
				buttonPane.add(btnSalir);
				btnSalir.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						dispose();
						
					}
				});
			}
		}
	}
	
	private void calcularPrecio() {
      float subtotal=0,descuento=0,total=0;
      
      for(int i=0;i<table.getRowCount();i++) {
    	  subtotal = subtotal + (Float.parseFloat(model.getValueAt(i, 4).toString())*Float.parseFloat(model.getValueAt(i, 1).toString()));
      }
      descuento = subtotal * ((Float.parseFloat(spnDescuentoCombo.getValue().toString()))/100);
      total = subtotal-descuento;
      
      txtSubtotal.setText(String.valueOf(subtotal));
      txtDescuento.setText(String.valueOf(descuento));
      txtTotal.setText(String.valueOf(total));	
	}
	
	private void cargarTabla() {
		model.setRowCount(0);
		row = new Object[model.getColumnCount()];
		for(Componente comp:componentesTabla) {
			row[0] = comp.getCodigoComponente();
			row[1] = comp.getCantidadDisponible();
			row[4] = comp.getPrecio();
			
			if(comp instanceof Motherboard) {
				row[2] = ((Motherboard) comp).getMarca();
				row[3] = ((Motherboard) comp).getModelo();
			}
			if(comp instanceof DiscoDuro) {
				row[2] = ((DiscoDuro) comp).getMarca();
				row[3] = ((DiscoDuro) comp).getModelo();
			}
			if(comp instanceof Microprocesador) {
				row[2] = ((Microprocesador) comp).getMarca();
				row[3] = ((Microprocesador) comp).getModelo();
			}
			if(comp instanceof MemoriaRam) {
				row[2] = ((MemoriaRam) comp).getMarca();
				row[3] = ((MemoriaRam) comp).getModelo();
			}
			model.addRow(row);
		}		
		
	}
	
	private void limpiar() {
		txtCodigoCombo.setText("");
		txtNombreCombo.setText("");
		spnDescuentoCombo.setValue(0);
		txtCodigoArticulo.setText("");
		spnCantidadArticulo.setValue(0);
		table.removeAll();
		}
}
