package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import entidad.Proveedor;
import model.ProveedorModel;
import util.Validaciones;
import java.util.List;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings({ "serial", "unused" })
public class FrmCrudProveedor extends JFrame implements MouseListener, ActionListener {

	private JPanel contentPane;
	private JTextField txtRazon;
	private JTextField txtRUC;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JTextField txtEstado;
	private JTextField txtContacto;
	private JTextField txtCelular;
	private JTable table;
	private JButton btnRegistrar;
	private JButton btnActualizar;
	private JButton btnEliminar;
	
	int idSeleccionado=-1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCrudProveedor frame = new FrmCrudProveedor();
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
	public FrmCrudProveedor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 699, 526);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Razon Social");
		lblNewLabel.setBounds(10, 100, 106, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("RUC");
		lblNewLabel_1.setBounds(10, 140, 106, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Direccion");
		lblNewLabel_2.setBounds(10, 189, 106, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Telefono");
		lblNewLabel_3.setBounds(10, 236, 106, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Celular");
		lblNewLabel_4.setBounds(362, 100, 114, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Contacto");
		lblNewLabel_5.setBounds(362, 140, 114, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Estado");
		lblNewLabel_6.setBounds(362, 189, 114, 14);
		contentPane.add(lblNewLabel_6);
		
		txtRazon = new JTextField();
		txtRazon.setBounds(130, 97, 156, 20);
		contentPane.add(txtRazon);
		txtRazon.setColumns(10);
		
		txtRUC = new JTextField();
		txtRUC.setBounds(130, 137, 156, 20);
		contentPane.add(txtRUC);
		txtRUC.setColumns(10);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(130, 186, 156, 20);
		contentPane.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(130, 233, 156, 20);
		contentPane.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		txtEstado = new JTextField();
		txtEstado.setColumns(10);
		txtEstado.setBounds(486, 183, 156, 20);
		contentPane.add(txtEstado);
		
		txtContacto = new JTextField();
		txtContacto.setColumns(10);
		txtContacto.setBounds(486, 134, 156, 20);
		contentPane.add(txtContacto);
		
		txtCelular = new JTextField();
		txtCelular.setColumns(10);
		txtCelular.setBounds(486, 94, 156, 20);
		contentPane.add(txtCelular);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 312, 663, 164);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(this);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"idProveedor", "Razon Social", "RUC", "Direccion", "Telefono", "Celular", "Contacto", "Estado"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_7 = new JLabel("MANTENIMIENTO PROVEEDOR");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_7.setBounds(192, 28, 309, 38);
		contentPane.add(lblNewLabel_7);
		
		btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(10, 278, 106, 23);
		contentPane.add(btnRegistrar);
		
		btnActualizar = new JButton("ACTUALIZAR");
		btnActualizar.addActionListener(this);
		btnActualizar.setBounds(286, 278, 114, 23);
		contentPane.add(btnActualizar);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(559, 278, 114, 23);
		contentPane.add(btnEliminar);
		
		listaProveedor();
	}

	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == table) {
			mouseClickedTableJTable(arg0);
		}
	}
	public void mouseEntered(MouseEvent arg0) {
	}
	public void mouseExited(MouseEvent arg0) {
	}
	public void mousePressed(MouseEvent arg0) {
	}
	public void mouseReleased(MouseEvent arg0) {
	}
	protected void mouseClickedTableJTable(MouseEvent arg0)
	{
		int fila = table.getSelectedRow();

		idSeleccionado = Integer.parseInt(table.getValueAt(fila, 0).toString());
		String raz = table.getValueAt(fila, 1).toString();
		String ruc = table.getValueAt(fila, 2).toString();
		String dir = table.getValueAt(fila, 3).toString();
		String tel = table.getValueAt(fila, 4).toString();
		String cel = table.getValueAt(fila, 5).toString();
		String con = table.getValueAt(fila, 6).toString();
		String est = table.getValueAt(fila, 7).toString();

		txtRazon.setText(raz);
		txtRUC.setText(ruc);
		txtDireccion.setText(dir);
		txtTelefono.setText(tel);
		txtCelular.setText(cel);
		txtContacto.setText(con);
		txtEstado.setText(est);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminarJButton(e);
		}
		if (e.getSource() == btnActualizar) {
			actionPerformedBtnActualizarJButton(e);
		}
		if (e.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrarJButton(e);
		}
		// TODO Auto-generated method stub
		
	}	
	protected void actionPerformedBtnRegistrarJButton(ActionEvent e) 
	{
		String raz = txtRazon.getText().trim();
		String ruc = txtRUC.getText().trim();
		String dir = txtDireccion.getText().trim();
		String tel = txtTelefono.getText().trim();
		String cel = txtCelular.getText().trim();
		String con = txtContacto.getText().trim();
		String est = txtEstado.getText().trim();
		

		if (raz.matches(Validaciones.TEXTO) == false)
		{
			mensaje("El nombre de la razon social es 10 a 100 caracteres");
		}
		else if (ruc.matches(Validaciones.RUC) == false) 
		{
			mensaje("El ruc debe tener 11 dígitos");
		}
		else if (dir.matches(Validaciones.TEXTO) == false) 
		{
			mensaje("La direccion debe tener entre 10 y 100 caracteres");
		}
		else if (tel.matches(Validaciones.TELEFONO) == false) 
		{
			mensaje("El telefono debe tener 7 digitos");
		}
		else if (cel.matches(Validaciones.CELULAR) == false) 
		{
			mensaje("El celular debe tener 9 dígitos");
		}
		else if (con.matches(Validaciones.TEXTO) == false) 
		{
			mensaje("El contacto debe tener entre 10 y 100 digitos");
		}
		else if (est.matches(Validaciones.ESTADO) == false) 
		{
			mensaje("El estado debe tener entre 6 y 9 caracteres");
		}
		else
		{
			Proveedor obj = new Proveedor();
			obj.setRazonsocial(raz);
			obj.setRUC(ruc);
			obj.setDirecicon(dir);
			obj.setTelefono(tel);
			obj.setCelular(cel);
			obj.setContacto(con);
			obj.setEstado(est);
			

			ProveedorModel m = new ProveedorModel();
			int s = m.insertaProveedor(obj);
			if (s > 0)
			{
				mensaje("Se envió correctamente");
				listaProveedor();
				limpiarCajasTexto();
			} 
			else
			{
				mensaje("Error en el registro");
			}
		}
	}
	protected void actionPerformedBtnActualizarJButton(ActionEvent e) 
	{
		if(idSeleccionado== -1) 
		{
			mensaje("Seleccione una fila");
		}
		else
		{
			String raz = txtRazon.getText().trim();
			String ruc = txtRUC.getText().trim();
			String dir = txtDireccion.getText().trim();
			String tel = txtTelefono.getText().trim();
			String cel = txtCelular.getText().trim();
			String con = txtContacto.getText().trim();
			String est = txtEstado.getText().trim();
			

			if (raz.matches(Validaciones.TEXTO) == false)
			{
				mensaje("El nombre de la razon social es 10 a 100 caracteres");
			}
			else if (ruc.matches(Validaciones.RUC) == false) 
			{
				mensaje("El ruc debe tener 11 dígitos");
			}
			else if (dir.matches(Validaciones.TEXTO) == false) 
			{
				mensaje("La direccion debe tener entre 10 y 100 caracteres");
			}
			else if (tel.matches(Validaciones.TELEFONO) == false) 
			{
				mensaje("El telefono debe tener 7 digitos");
			}
			else if (cel.matches(Validaciones.CELULAR) == false) 
			{
				mensaje("El celular debe tener 9 dígitos");
			}
			else if (con.matches(Validaciones.TEXTO) == false) 
			{
				mensaje("El contacto debe tener entre 10 y 100 digitos");
			}
			else if (est.matches(Validaciones.ESTADO) == false) 
			{
				mensaje("El estado debe tener entre 6 y 9 caracteres");
			}
			else
			{
				Proveedor obj = new Proveedor();
				obj.setIdProveedor(idSeleccionado);
				obj.setRazonsocial(raz);
				obj.setRUC(ruc);
				obj.setDirecicon(dir);
				obj.setTelefono(tel);
				obj.setCelular(cel);
				obj.setContacto(con);
				obj.setEstado(est);
				

				ProveedorModel m = new ProveedorModel();
				int s = m.actualizaProveedor(obj);
				if (s > 0)
				{
					mensaje("Se actualizo correctamente");
					listaProveedor();
					limpiarCajasTexto();
				} 
				else
				{
					mensaje("Error al actualizar");
				}
			}
		}
	}
	protected void actionPerformedBtnEliminarJButton(ActionEvent e)
	{
		if (idSeleccionado == -1)
		{
			mensaje("Seleccione una fila");
		} 
		else 
		{
			ProveedorModel m = new ProveedorModel();
			int s = m.eliminaProveedor(idSeleccionado);
			if (s > 0)
			{
				mensaje("Se eliminó correctamente");
				listaProveedor();
				limpiarCajasTexto();
			} 
			else 
			{
				mensaje("Error al eliminar");
			}
		}
	}
	
	void limpiarCajasTexto() 
	{
		txtRazon.setText("");
		txtRUC.setText("");
		txtDireccion.setText("");
		txtTelefono.setText("");
		txtCelular.setText("");
		txtContacto.setText("");
		txtEstado.setText("");
		txtRazon.requestFocus();
	}

void listaProveedor() 
	{
		ProveedorModel m= new ProveedorModel();
		List<Proveedor> data=m.listaProveedor();
		
		DefaultTableModel dtm=(DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		
		for(Proveedor aux:data) 
		{
			Object[]fila=
				{
					aux.getIdProveedor(),
					aux.getRazonsocial(),
					aux.getRUC(),
					aux.getDirecicon(),
					aux.getTelefono(),
					aux.getCelular(),
					aux.getContacto(),
					aux.getEstado()
				};
			dtm.addRow(fila);
		}
	}

private void mensaje(String m) 
	{
		JOptionPane.showMessageDialog(this,m);
	}
}
