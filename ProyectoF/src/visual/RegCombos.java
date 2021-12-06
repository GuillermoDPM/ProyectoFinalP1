package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Logi.Componente;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JSpinner;

public class RegCombos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private DefaultTableModel model;
	private Object[] row;
	private Componente selected;
	private JTextField txtCodigoCombo;
	private JTextField txtNombreCombo;
	private JTextField txtCodigoArticulo;

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
		setBounds(100, 100, 544, 555);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(12, 257, 498, 217);
			contentPanel.add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			model = new DefaultTableModel();
			String[] headers = {"Codigo","Cantidad","Precio unitario","Total articulos"};
			model.setColumnIdentifiers(headers);
		}
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Informacion", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(12, 13, 498, 142);
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
				JSpinner spnDescuentoCombo = new JSpinner();
				spnDescuentoCombo.setFont(new Font("Tahoma", Font.PLAIN, 13));
				spnDescuentoCombo.setBounds(91, 98, 79, 20);
				panel.add(spnDescuentoCombo);
			}
			{
				JButton btnBuscar = new JButton("Buscar");
				btnBuscar.setBounds(257, 30, 97, 25);
				panel.add(btnBuscar);
			}
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 257, 498, 217);
		contentPanel.add(scrollPane);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		table = new JTable();
		model = new DefaultTableModel();
		String headers[] = {"Codigo","Articulo","Informacion","Precio unitario"};
		model.setColumnIdentifiers(headers);
		table.setModel(model);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		{
			JLabel lblNewLabel_3 = new JLabel("Codigo:");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblNewLabel_3.setBounds(12, 212, 56, 20);
			contentPanel.add(lblNewLabel_3);
		}
		{
			txtCodigoArticulo = new JTextField();
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
			JSpinner spnCantidadArticulo = new JSpinner();
			spnCantidadArticulo.setFont(new Font("Tahoma", Font.PLAIN, 13));
			spnCantidadArticulo.setBounds(272, 210, 79, 20);
			contentPanel.add(spnCantidadArticulo);
		}
		{
			JButton btnAgregar = new JButton("Agregar");
			btnAgregar.setBounds(378, 209, 97, 25);
			contentPanel.add(btnAgregar);
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
					JButton btnModificarCombo = new JButton("Modificar combo");
					buttonPane.add(btnModificarCombo);
				}
				btnRegistrarCombo.setActionCommand("OK");
				buttonPane.add(btnRegistrarCombo);
				getRootPane().setDefaultButton(btnRegistrarCombo);
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
}
