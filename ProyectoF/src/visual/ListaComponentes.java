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
				//txtBuscar.setBackground(UIManager.getColor("Button.focus"));
				txtBuscar.setBounds(110, 22, 119, 20);
				
				txtBuscar.addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent e) {
						DefaultTableModel mode = (DefaultTableModel)table.getModel();
						TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(mode);
						table.setRowSorter(tr);
						tr.setRowFilter(RowFilter.regexFilter(txtBuscar.getText().trim()));
					}
				});
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
				
				/*table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					seleccion = table.getSelectedRow();
					modelrow = table.convertRowIndexToModel(seleccion);
					if(cargar==null) {
						if(seleccion!=-1 && (int)modelo.getValueAt(modelrow, 2)>0) {
							btnSeleccionar.setEnabled(true);
							if('C'==((String)modelo.getValueAt(modelrow, 0)).charAt(0)) {
								btnInformacion.setEnabled(true);
								c = Prodacom.getInstance().buscarCombo((String)modelo.getValueAt(modelrow, 0));
							}else {
								btnInformacion.setEnabled(false);
							}
						}else {
							btnInformacion.setEnabled(false);
							btnSeleccionar.setEnabled(false);
						}
					}else {
						btnSeleccionar.setEnabled(false);
						btnInformacion.setEnabled(false);
					}
				}
			});*/
				
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
						
						
					}
				});
				btnSeleccionar.setActionCommand("OK");
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
}
