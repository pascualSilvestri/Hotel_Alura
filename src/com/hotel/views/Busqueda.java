package com.hotel.views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.hotel.control.ReservaControl;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Optional;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

@SuppressWarnings("serial")
public class Busqueda extends JFrame {

	private JPanel contentPane;
	private JTextField txtBuscar;
	private JTable tbHuespedes;
	private JTable tbReservas;
	private DefaultTableModel modelo;
	private DefaultTableModel modeloH;
	private JLabel labelAtras;
	private JLabel labelExit;
	int xMouse, yMouse;
	private boolean ban = false;

	private ReservaControl reservaControl;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Busqueda frame = new Busqueda();
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
	public Busqueda() {
		configuracionViews(contentPane);

		this.reservaControl = new ReservaControl();
		cargarTablaCliete();
		cargarTablaReserva();

	}

	private void configuracionViews(JPanel contentPane) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Busqueda.class.getResource("/imagenes/lupa2.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 571);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);

		txtBuscar = new JTextField();
		txtBuscar.setBounds(536, 127, 193, 31);
		txtBuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		
		JLabel lblNewLabel_4 = new JLabel("SISTEMA DE BÚSQUEDA");
		lblNewLabel_4.setForeground(new Color(12, 138, 199));
		lblNewLabel_4.setFont(new Font("Roboto Black", Font.BOLD, 24));
		lblNewLabel_4.setBounds(331, 62, 280, 42);
		contentPane.add(lblNewLabel_4);

		JTabbedPane panel = new JTabbedPane(JTabbedPane.TOP);
		panel.setBackground(new Color(12, 138, 199));
		panel.setFont(new Font("Roboto", Font.PLAIN, 16));
		panel.setBounds(20, 169, 865, 328);
		contentPane.add(panel);

		txtBuscar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				if(txtBuscar.getText().isEmpty()) {
					if(ban) {
						Clear_Table1(tbReservas, modelo);
						Clear_Table1(tbHuespedes, modeloH);
						cargarTablaReserva();
						cargarTablaCliete();
						ban = false;
					}
				}else {
					
					String txt = txtBuscar.getText().toString();
					if(panel.getSelectedIndex() == 0) {
						buscarId(txt);
					}else {
						buscarApellido(txt);
					}
					
					
					ban = true;
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				
			}
		});

		tbReservas = new JTable();
		tbReservas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbReservas.setFont(new Font("Roboto", Font.PLAIN, 16));
		

		panel.addTab("Reservas", new ImageIcon(Busqueda.class.getResource("/imagenes/reservado.png")), tbReservas,
				null);

		modelo = (DefaultTableModel) tbReservas.getModel();
		modelo.addColumn("Numero de Reserva");
		modelo.addColumn("Fecha Check In");
		modelo.addColumn("Fecha Check Out");
		modelo.addColumn("Valor");
		modelo.addColumn("Forma de Pago");

		tbHuespedes = new JTable();
		tbHuespedes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbHuespedes.setFont(new Font("Roboto", Font.PLAIN, 16));
		panel.addTab("Huéspedes", new ImageIcon(Busqueda.class.getResource("/imagenes/pessoas.png")), tbHuespedes,
				null);
		modeloH = (DefaultTableModel) tbHuespedes.getModel();
		modeloH.addColumn("Numero de Huesped");
		modeloH.addColumn("Nombre");
		modeloH.addColumn("Apellido");
		modeloH.addColumn("Fecha de Nacimiento");
		modeloH.addColumn("Nacionalidad");
		modeloH.addColumn("Telefono");
		modeloH.addColumn("Numero de Reserva");

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Busqueda.class.getResource("/imagenes/Ha-100px.png")));
		lblNewLabel_2.setBounds(56, 51, 104, 107);
		contentPane.add(lblNewLabel_2);

		JPanel header = new JPanel();
		header.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				headerMouseDragged(e);

			}
		});
		header.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				headerMousePressed(e);
			}
		});
		header.setLayout(null);
		header.setBackground(Color.WHITE);
		header.setBounds(0, 0, 910, 36);
		contentPane.add(header);

		JPanel btnAtras = new JPanel();
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnAtras.setBackground(new Color(12, 138, 199));
				labelAtras.setForeground(Color.white);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnAtras.setBackground(Color.white);
				labelAtras.setForeground(Color.black);
			}
		});
		btnAtras.setLayout(null);
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setBounds(0, 0, 53, 36);
		header.add(btnAtras);

		labelAtras = new JLabel("<");
		labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
		labelAtras.setBounds(0, 0, 53, 36);
		btnAtras.add(labelAtras);

		JPanel btnexit = new JPanel();
		btnexit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();
			}

			@Override
			public void mouseEntered(MouseEvent e) { // Al usuario pasar el mouse por el botón este cambiará de color
				btnexit.setBackground(Color.red);
				labelExit.setForeground(Color.white);
			}

			@Override
			public void mouseExited(MouseEvent e) { // Al usuario quitar el mouse por el botón este volverá al estado
													// original
				btnexit.setBackground(Color.white);
				labelExit.setForeground(Color.black);
			}
		});
		btnexit.setLayout(null);
		btnexit.setBackground(Color.WHITE);
		btnexit.setBounds(857, 0, 53, 36);
		header.add(btnexit);

		labelExit = new JLabel("X");
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setForeground(Color.BLACK);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		labelExit.setBounds(0, 0, 53, 36);
		btnexit.add(labelExit);

		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setForeground(new Color(12, 138, 199));
		separator_1_2.setBackground(new Color(12, 138, 199));
		separator_1_2.setBounds(539, 159, 193, 2);
		contentPane.add(separator_1_2);

		JPanel btnbuscar = new JPanel();
		btnbuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String txt = txtBuscar.getText().toString();
				buscarId(txt);
			}
		});
		btnbuscar.setLayout(null);
		btnbuscar.setBackground(new Color(12, 138, 199));
		btnbuscar.setBounds(748, 125, 122, 35);
		btnbuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnbuscar);

		JLabel lblBuscar = new JLabel("BUSCAR");
		lblBuscar.setBounds(0, 0, 122, 35);
		btnbuscar.add(lblBuscar);
		lblBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscar.setForeground(Color.WHITE);
		lblBuscar.setFont(new Font("Roboto", Font.PLAIN, 18));

		JPanel btnEditar = new JPanel();
		btnEditar.setLayout(null);
		btnEditar.setBackground(new Color(12, 138, 199));
		btnEditar.setBounds(635, 508, 122, 35);
		btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEditar);
		
		btnEditar.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(panel.getSelectedIndex() == 0) {
					editarReserva();
				}else {
					editarCliente();
				}	
			}
		});

		JLabel lblEditar = new JLabel("EDITAR");
		lblEditar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditar.setForeground(Color.WHITE);
		lblEditar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEditar.setBounds(0, 0, 122, 35);
		btnEditar.add(lblEditar);

		JPanel btnEliminar = new JPanel();
		btnEliminar.setLayout(null);
		btnEliminar.setBackground(new Color(12, 138, 199));
		btnEliminar.setBounds(767, 508, 122, 35);
		btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnEliminar);

		JLabel lblEliminar = new JLabel("ELIMINAR");
		lblEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminar.setForeground(Color.WHITE);
		lblEliminar.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblEliminar.setBounds(0, 0, 122, 35);
		btnEliminar.add(lblEliminar);
		setResizable(false);
		btnEliminar.addMouseListener(new MouseAdapter() {
			/**
			 * @param e
			 */
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(panel.getSelectedIndex() == 0) {
					eliminarReserva();
					Clear_Table1(tbReservas, modelo);
					cargarTablaReserva();
				}else {
					eliminarCliente();
					Clear_Table1(tbHuespedes, modeloH);
					cargarTablaCliete();
				}
			}
		});

	}

	private void cargarTablaCliete() {
		var cliente = this.reservaControl.listaCliente();

		cliente.forEach(clientes -> modeloH.addRow(
				new Object[] { clientes.getId(), clientes.getNombre(), clientes.getApellido(), clientes.getFechaNac(),
						clientes.getNacionalidad(), clientes.getNumeroReserva(), clientes.getTelefono() }));
	}

	private void cargarTablaReserva() {
		var reserva = this.reservaControl.listaReserva();

		reserva.forEach(reservas -> modelo.addRow(new Object[] { reservas.getId(), reservas.getFechaEntrada(),
				reservas.getFechaSalida(), reservas.getValor(), reservas.getFormaPago(), }));
	}

	private boolean tieneFilaElegida(JTable tabla) {
		return tabla.getSelectedRowCount() == 0 || tabla.getSelectedColumnCount() == 0;
	}

	private void eliminarReserva() {
		if (tieneFilaElegida(tbReservas)) {
			JOptionPane.showMessageDialog(this, "Por favor, elije un item");
			return;
		}

		Optional.ofNullable(modelo.getValueAt(tbReservas.getSelectedRow(), tbReservas.getSelectedColumn()))
				.ifPresentOrElse(fila -> {
					Integer id = Integer.valueOf(modelo.getValueAt(tbReservas.getSelectedRow(), 0).toString());
					System.out.println(id);
					var filasModificadas = this.reservaControl.eliminarReserva(id);

					modelo.removeRow(tbReservas.getSelectedRow());

					JOptionPane.showMessageDialog(this,
							String.format("%d item eliminado con éxito!", filasModificadas));
				}, () -> JOptionPane.showMessageDialog(this, "Por favor, elije un item"));
	}

	private void eliminarCliente() {
		if (tieneFilaElegida(tbHuespedes)) {
			JOptionPane.showMessageDialog(this, "Por favor, elije un item");
			return;
		}

		Optional.ofNullable(modeloH.getValueAt(tbHuespedes.getSelectedRow(), tbHuespedes.getSelectedColumn()))
				.ifPresentOrElse(fila -> {
					Integer id = Integer.valueOf(modeloH.getValueAt(tbHuespedes.getSelectedRow(), 0).toString());
					System.out.println(id);
					var filasModificadas = this.reservaControl.eliminarCliente(id);

					modeloH.removeRow(tbHuespedes.getSelectedRow());

					JOptionPane.showMessageDialog(this,
							String.format("%d item eliminado con éxito!", filasModificadas));
				}, () -> JOptionPane.showMessageDialog(this, "Por favor, elije un item"));
	}

	private void buscarId(String txt) {
		Clear_Table1(tbReservas, modelo);
		if(!txtBuscar.getText().isEmpty()) {
			try {
				int busqueda = Integer.parseInt(txt);
				var buscar = reservaControl.ListaId(busqueda);
				buscar.forEach(busca -> modelo.addRow(new Object[] {busca.getId(), busca.getFechaEntrada(),
						busca.getFechaSalida(), busca.getValor(), busca.getFormaPago()}));
			}catch (Exception e) {
				
			}
			
		
		}
	}
	
	private void buscarApellido(String txt) {
		Clear_Table1(tbHuespedes, modeloH);
		if(!txtBuscar.getText().isEmpty()) {
			var buscar = reservaControl.ListaApellido(txt);
			buscar.forEach(clientes -> modeloH.addRow(new Object[] {clientes.getId(), clientes.getNombre(), clientes.getApellido(), clientes.getFechaNac(),
					clientes.getNacionalidad(), clientes.getNumeroReserva(), clientes.getTelefono()}));
		}
	}
	
	private void Clear_Table1(JTable tabla, DefaultTableModel modelo ){
		for (int i = 0; i < tabla.getRowCount(); i++) {
			modelo.removeRow(i);
			i-=1;
		}
	}

	private void editarReserva() {
		 if (tieneFilaElegida(tbReservas)) {
	            JOptionPane.showMessageDialog(this, "Por favor, elije un item");
	            return;
	        }

	        Optional.ofNullable(modelo.getValueAt(tbReservas.getSelectedRow(), tbReservas.getSelectedColumn()))
	                .ifPresentOrElse(fila -> {
	                    Integer id = Integer.valueOf(modelo.getValueAt(tbReservas.getSelectedRow(), 0).toString());
	                    String fechaEntrada = (String) modelo.getValueAt(tbReservas.getSelectedRow(), 1);
	                    String fechaSalidad = (String) modelo.getValueAt(tbReservas.getSelectedRow(), 2);
	                    Integer valor = Integer.valueOf(modelo.getValueAt(tbReservas.getSelectedRow(), 3).toString());
	                    String formaPago = (String) modelo.getValueAt(tbReservas.getSelectedRow(), 2);
	                   
      
	                    var filasModificadas = this.reservaControl.modificarReserva(id,fechaEntrada, fechaSalidad, valor,formaPago);
	                    
	                    JOptionPane.showMessageDialog(this, String.format("%d item modificado con éxito!", filasModificadas));
	                }, () -> JOptionPane.showMessageDialog(this, "Por favor, elije un item"));
		
	}
	
	private void editarCliente() {
		if (tieneFilaElegida(tbHuespedes)) {
            JOptionPane.showMessageDialog(this, "Por favor, elije un item");
            return;
        }

        Optional.ofNullable(modeloH.getValueAt(tbHuespedes.getSelectedRow(), tbHuespedes.getSelectedColumn()))
                .ifPresentOrElse(fila -> {
                    Integer id = Integer.valueOf(modeloH.getValueAt(tbHuespedes.getSelectedRow(), 0).toString());
                    String nombre = (String) modeloH.getValueAt(tbHuespedes.getSelectedRow(), 1);
                    String apellido = (String) modeloH.getValueAt(tbHuespedes.getSelectedRow(), 2);
                    String telefono = (String) modeloH.getValueAt(tbHuespedes.getSelectedRow(), 3);
                    String fechaNac = (String) modeloH.getValueAt(tbHuespedes.getSelectedRow(), 4);
                    Integer reservaId = Integer.valueOf(modeloH.getValueAt(tbHuespedes.getSelectedRow(), 5).toString());
                    String nacionalidad = (String) modeloH.getValueAt(tbHuespedes.getSelectedRow(), 6);
                    
                    
                    
                    System.out.println(id);
                    System.out.println(nombre);
                    System.out.println(apellido);
                    System.out.println(fechaNac);
                    System.out.println(nacionalidad);
                    System.out.println(telefono);
                    System.out.println(reservaId);
                    
                    
                    var filasModificadas = this.reservaControl.modificarCliente(id,nombre, apellido, fechaNac,nacionalidad,telefono,reservaId);
                    
                    JOptionPane.showMessageDialog(this, String.format("%d item modificado con éxito!", filasModificadas));
                }, () -> JOptionPane.showMessageDialog(this, "Por favor, elije un item"));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//Código que permite mover la ventana por la pantalla según la posición de "x" y "y"
	private void headerMousePressed(java.awt.event.MouseEvent evt) {
		xMouse = evt.getX();
		yMouse = evt.getY();
	}

	private void headerMouseDragged(java.awt.event.MouseEvent evt) {
		int x = evt.getXOnScreen();
		int y = evt.getYOnScreen();
		this.setLocation(x - xMouse, y - yMouse);
	}
}
