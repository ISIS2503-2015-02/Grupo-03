package MobibusStandAloneInterfaz;

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

import MobibusStandAloneMundo.Mobibus;
import MobibusStandAloneMundo.Ubicacion;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

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
	private transient PanelPrincipal principal;
	
	/**
	 * label mapa
	 */
	private JLabel labelIM;
	
	private Logger LOGGER;

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

		JPanel panelIM = new JPanel();
		add(panelIM);
		GridBagLayout gbl_panelIM = new GridBagLayout();
		gbl_panelIM.columnWidths = new int[]{0, 0, 0};
		gbl_panelIM.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelIM.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panelIM.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		panelIM.setLayout(gbl_panelIM);

		JLabel lblInformacinDelHotelIM = new JLabel("Informaci\u00F3n de la estacion");
		lblInformacinDelHotelIM.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblInformacinDelHotelIM = new GridBagConstraints();
		gbc_lblInformacinDelHotelIM.gridwidth = 2;
		gbc_lblInformacinDelHotelIM.insets = new Insets(0, 0, 5, 0);
		gbc_lblInformacinDelHotelIM.gridx = 0;
		gbc_lblInformacinDelHotelIM.gridy = 0;
		panelIM.add(lblInformacinDelHotelIM, gbc_lblInformacinDelHotelIM);

		JLabel lblNombreIM = new JLabel("Id:");
		lblNombreIM.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblNombreIM = new GridBagConstraints();
		gbc_lblNombreIM.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombreIM.anchor = GridBagConstraints.WEST;
		gbc_lblNombreIM.gridx = 0;
		gbc_lblNombreIM.gridy = 1;
		panelIM.add(lblNombreIM, gbc_lblNombreIM);

		textField = new JTextField();
		textField.setEditable(false);
		GridBagConstraints gbc_textFieldIM = new GridBagConstraints();
		gbc_textFieldIM.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldIM.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldIM.gridx = 1;
		gbc_textFieldIM.gridy = 1;
		panelIM.add(textField, gbc_textFieldIM);
		textField.setColumns(10);

		JLabel lblLocalidadIM = new JLabel("Estado:");
		lblLocalidadIM.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblLocalidadIM = new GridBagConstraints();
		gbc_lblLocalidadIM.anchor = GridBagConstraints.WEST;
		gbc_lblLocalidadIM.insets = new Insets(0, 0, 5, 5);
		gbc_lblLocalidadIM.gridx = 0;
		gbc_lblLocalidadIM.gridy = 3;
		panelIM.add(lblLocalidadIM, gbc_lblLocalidadIM);

		textField_1 = new JTextField();
		textField_1.setEditable(false);
		GridBagConstraints gbc_textField_1IM = new GridBagConstraints();
		gbc_textField_1IM.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1IM.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1IM.gridx = 1;
		gbc_textField_1IM.gridy = 3;
		panelIM.add(textField_1, gbc_textField_1IM);
		textField_1.setColumns(10);

		
		
		labelIM = new JLabel();
		labelIM.setBorder(new LineBorder(new Color(0, 0, 0)));
		labelIM.setPreferredSize(new Dimension(180, 180));
		GridBagConstraints gbc_labelIM = new GridBagConstraints();
		gbc_labelIM.insets = new Insets(0, 0, 5, 0);
		gbc_labelIM.gridwidth = 2;
		gbc_labelIM.gridx = 0;
		gbc_labelIM.gridy = 11;
		panelIM.add(labelIM, gbc_labelIM);
		
		JPanel panel_1IM = new JPanel();
		GridBagConstraints gbc_panel_1IM = new GridBagConstraints();
		gbc_panel_1IM.gridwidth = 2;
		gbc_panel_1IM.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1IM.fill = GridBagConstraints.BOTH;
		gbc_panel_1IM.gridx = 0;
		gbc_panel_1IM.gridy = 18;
		panelIM.add(panel_1IM, gbc_panel_1IM);
		GridBagLayout gbl_panel_1IM = new GridBagLayout();
		gbl_panel_1IM.columnWidths = new int[]{103, 0, 0, 0};
		gbl_panel_1IM.rowHeights = new int[]{23, 0};
		gbl_panel_1IM.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1IM.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1IM.setLayout(gbl_panel_1IM);

		JButton btnReservarIM = new JButton("Volver al menu principal");
		GridBagConstraints gbc_btnReservarIM = new GridBagConstraints();
		gbc_btnReservarIM.insets = new Insets(0, 0, 0, 5);
		gbc_btnReservarIM.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnReservarIM.gridx = 0;
		gbc_btnReservarIM.gridy = 0;
		panel_1IM.add(btnReservarIM, gbc_btnReservarIM);
		btnReservarIM.setActionCommand(MENU);
		btnReservarIM.addActionListener(this);
		btnReservarIM.setFont(new Font("Tahoma", Font.PLAIN, 11));

		JButton btnVolverAlMenuIM = new JButton("Ver todas las emergencias");
		GridBagConstraints gbc_btnVolverAlMenu_1IM = new GridBagConstraints();
		gbc_btnVolverAlMenu_1IM.insets = new Insets(0, 0, 0, 5);
		gbc_btnVolverAlMenu_1IM.gridx = 1;
		gbc_btnVolverAlMenu_1IM.gridy = 0;
		btnVolverAlMenuIM.setActionCommand(VOLVER);
		btnVolverAlMenuIM.addActionListener(this);
		btnVolverAlMenuIM.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel_1IM.add(btnVolverAlMenuIM, gbc_btnVolverAlMenu_1IM);
	}
	
	// -----------------------------------------------------------------
	// Metodos
	// -----------------------------------------------------------------
	/**
	 * Metodo que actualiza el panel
	 * @param pHotel
	 */
	public void actualizar(Mobibus bus)
	{
		textField.setText(String.valueOf(bus.getId()));
		textField_1.setText(String.valueOf(bus.getEstado()));
		Ubicacion xIM = bus.getUbicacion();
		URL zzIM = null;

		try
		{
			zzIM = new URL(principal.generarMapa(xIM));
		} 
		catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			LOGGER.log(null, "context", e);
		}

		if(zzIM!=null)
		{
			ImageIcon iconoIM = new ImageIcon(zzIM);
			labelIM.setIcon(iconoIM);
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		// TODO Auto-generated method stub
		String xIM = arg0.getActionCommand();
		if(xIM.equals(MENU))
		{
			principal.mostrarBotones3();
		}
		else if(xIM.equals(VOLVER))
		{
			principal.mostrarEstaciones2();
		}
	}
}
