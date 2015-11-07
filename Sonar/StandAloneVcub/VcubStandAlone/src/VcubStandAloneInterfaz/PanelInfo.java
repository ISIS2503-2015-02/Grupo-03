package VcubStandAloneInterfaz;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Dimension;

import javax.swing.ScrollPaneConstants;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import javax.swing.JTextField;

import java.awt.Insets;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.event.AncestorListener;

import VcubStandAloneMundo.EstacionVcub;
import VcubStandAloneMundo.Ubicacion;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

public class PanelInfo extends JPanel implements ActionListener
{
	// -----------------------------------------------------------------
	// Constantes
	// -----------------------------------------------------------------
	/**
	 * Comando MENU
	 */
	public final static String MENU = "MENU";

	/**
	 * Comando RESERVA
	 */
	public final static String VOLVER = "VOLVER";

	// -----------------------------------------------------------------
	// Atributos de la Interfaz
	// -----------------------------------------------------------------
	/**
	 * textfield nombre
	 */
	private JTextField textField;
	
	/**
	 * textfield localidad
	 */
	private JTextField textField_1;

	/**
	 * Panel principal de la interfaz
	 */
	private PanelPrincipal principal;
	
	/**
	 * textfield region
	 */
	private JTextField textField_2;
	
	/**
	 * textfield codigo postal
	 */
	private JTextField textField_3;
	
	/**
	 * textfield telefono
	 */
	private JTextField textField_4;
	
	/**
	 * label mapa
	 */
	private JLabel label;

	// -----------------------------------------------------------------
	// Constructor
	// -----------------------------------------------------------------
	/**
	 * Create the panel.
	 */
	public PanelInfo(PanelPrincipal ventana)
	{
		principal = ventana;

		setPreferredSize(new Dimension(346, 736));

		JPanel panel = new JPanel();
		add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);

		JLabel lblInformacinDelHotel = new JLabel("Informaci\u00F3n de la estacion");
		lblInformacinDelHotel.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblInformacinDelHotel = new GridBagConstraints();
		gbc_lblInformacinDelHotel.gridwidth = 2;
		gbc_lblInformacinDelHotel.insets = new Insets(0, 0, 5, 0);
		gbc_lblInformacinDelHotel.gridx = 0;
		gbc_lblInformacinDelHotel.gridy = 0;
		panel.add(lblInformacinDelHotel, gbc_lblInformacinDelHotel);

		JLabel lblNombre = new JLabel("Id:");
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.anchor = GridBagConstraints.WEST;
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 1;
		panel.add(lblNombre, gbc_lblNombre);

		textField = new JTextField();
		textField.setEditable(false);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		panel.add(textField, gbc_textField);
		textField.setColumns(10);

		JLabel lblLocalidad = new JLabel("Capacidad:");
		lblLocalidad.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblLocalidad = new GridBagConstraints();
		gbc_lblLocalidad.anchor = GridBagConstraints.WEST;
		gbc_lblLocalidad.insets = new Insets(0, 0, 5, 5);
		gbc_lblLocalidad.gridx = 0;
		gbc_lblLocalidad.gridy = 3;
		panel.add(lblLocalidad, gbc_lblLocalidad);

		textField_1 = new JTextField();
		textField_1.setEditable(false);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 3;
		panel.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);

		JLabel lblRegin = new JLabel("Vcubs disponibles:");
		lblRegin.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblRegin = new GridBagConstraints();
		gbc_lblRegin.anchor = GridBagConstraints.WEST;
		gbc_lblRegin.insets = new Insets(0, 0, 5, 5);
		gbc_lblRegin.gridx = 0;
		gbc_lblRegin.gridy = 5;
		panel.add(lblRegin, gbc_lblRegin);

		textField_2 = new JTextField();
		textField_2.setEditable(false);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 5;
		panel.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);

		JLabel lblCodigoPostal = new JLabel("Latitud:");
		lblCodigoPostal.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblCodigoPostal = new GridBagConstraints();
		gbc_lblCodigoPostal.anchor = GridBagConstraints.WEST;
		gbc_lblCodigoPostal.insets = new Insets(0, 0, 5, 5);
		gbc_lblCodigoPostal.gridx = 0;
		gbc_lblCodigoPostal.gridy = 7;
		panel.add(lblCodigoPostal, gbc_lblCodigoPostal);

		textField_3 = new JTextField();
		textField_3.setEditable(false);
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 7;
		panel.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);

		JLabel lblTelefono = new JLabel("Longitud:");
		lblTelefono.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblTelefono = new GridBagConstraints();
		gbc_lblTelefono.anchor = GridBagConstraints.WEST;
		gbc_lblTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefono.gridx = 0;
		gbc_lblTelefono.gridy = 9;
		panel.add(lblTelefono, gbc_lblTelefono);

		textField_4 = new JTextField();
		textField_4.setEditable(false);
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 0);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 1;
		gbc_textField_4.gridy = 9;
		panel.add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		
		label = new JLabel();
		label.setBorder(new LineBorder(new Color(0, 0, 0)));
		label.setPreferredSize(new Dimension(180, 180));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.gridwidth = 2;
		gbc_label.gridx = 0;
		gbc_label.gridy = 11;
		panel.add(label, gbc_label);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 2;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 18;
		panel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{103, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{23, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);

		JButton btnReservar = new JButton("Volver al menu principal");
		GridBagConstraints gbc_btnReservar = new GridBagConstraints();
		gbc_btnReservar.insets = new Insets(0, 0, 0, 5);
		gbc_btnReservar.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnReservar.gridx = 0;
		gbc_btnReservar.gridy = 0;
		panel_1.add(btnReservar, gbc_btnReservar);
		btnReservar.setActionCommand(MENU);
		btnReservar.addActionListener(this);
		btnReservar.setFont(new Font("Tahoma", Font.PLAIN, 11));

		JButton btnVolverAlMenu = new JButton("Ver todas las estaciones");
		GridBagConstraints gbc_btnVolverAlMenu_1 = new GridBagConstraints();
		gbc_btnVolverAlMenu_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnVolverAlMenu_1.gridx = 1;
		gbc_btnVolverAlMenu_1.gridy = 0;
		btnVolverAlMenu.setActionCommand(VOLVER);
		btnVolverAlMenu.addActionListener(this);
		btnVolverAlMenu.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel_1.add(btnVolverAlMenu, gbc_btnVolverAlMenu_1);
	}
	
	// -----------------------------------------------------------------
	// Metodos
	// -----------------------------------------------------------------
	/**
	 * Metodo que actualiza el panel
	 * @param pHotel
	 */
	public void actualizar(EstacionVcub pEstacion)
	{
		textField.setText(String.valueOf(pEstacion.getId()));
		textField_1.setText(String.valueOf(pEstacion.getCapacidad()));
		textField_2.setText(String.valueOf(pEstacion.getVcubs().size()));
		textField_3.setText(String.valueOf(pEstacion.getUbicacion().getLatitud()));
		textField_4.setText(String.valueOf(pEstacion.getUbicacion().getLongitud()));
		Ubicacion x = pEstacion.getUbicacion();
		URL zz = null;

		try
		{
			zz = new URL(principal.generarMapa(x));
		} 
		catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(zz!=null)
		{
			ImageIcon icono = new ImageIcon(zz);
			label.setIcon(icono);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		// TODO Auto-generated method stub
		String x = arg0.getActionCommand();
		if(x.equals(MENU))
		{
			principal.mostrarBotones3();
		}
		else if(x.equals(VOLVER))
		{
			principal.mostrarEstaciones2();;
		}
	}
}
