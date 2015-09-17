package MobibusStandAloneInterfaz;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.net.MalformedURLException;
import java.net.URL;

public class PanelBotones extends JPanel implements ActionListener
{
	private PanelPrincipal principal;
	private JLabel label;
	private JLabel lblSuUbicacinActual;
	private JPanel panel;
	private JLabel lblLatitud;
	private JLabel lblLongitud;
	private JLabel lblCodigoPostal;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblCiudad;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public PanelBotones(PanelPrincipal ventana)
	{
		principal = ventana;

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);

		label = new JLabel("");
		label.setHorizontalAlignment( JLabel.CENTER );
		label.setBorder(new LineBorder(new Color(0, 0, 0)));
		label.setPreferredSize(new Dimension(300, 300));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 2;
		gbc_label.gridy = 1;
		add(label, gbc_label);
		
	
		
		GridBagConstraints gbc_btnCambiarUbicacionActual = new GridBagConstraints();
		gbc_btnCambiarUbicacionActual.insets = new Insets(0, 0, 5, 5);
		gbc_btnCambiarUbicacionActual.gridx = 2;
		gbc_btnCambiarUbicacionActual.gridy = 3;
		
		gbc_btnCambiarUbicacionActual.gridx = 2;
		gbc_btnCambiarUbicacionActual.gridy = 5;
		JButton btn2 = new JButton("Ver Mobibus Disponibles");
		btn2.setActionCommand("CAMBIO");
		btn2.addActionListener(this);
		add(btn2, gbc_btnCambiarUbicacionActual);

//		panel = new JPanel();
//		panel.setPreferredSize(new Dimension(200, 200));
//		GridBagConstraints gbc_panel = new GridBagConstraints();
//		gbc_panel.gridheight = 4;
//		gbc_panel.insets = new Insets(0, 0, 5, 5);
//		gbc_panel.fill = GridBagConstraints.BOTH;
//		gbc_panel.gridx = 2;
//		gbc_panel.gridy = 6;
//		add(panel, gbc_panel);
//		GridBagLayout gbl_panel = new GridBagLayout();
//		gbl_panel.columnWidths = new int[]{0, 0, 0};
//		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
//		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
//		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
//		panel.setLayout(gbl_panel);
//
//		lblLatitud = new JLabel("Latitud:");
//		GridBagConstraints gbc_lblLatitud = new GridBagConstraints();
//		gbc_lblLatitud.anchor = GridBagConstraints.WEST;
//		gbc_lblLatitud.insets = new Insets(0, 0, 5, 5);
//		gbc_lblLatitud.gridx = 0;
//		gbc_lblLatitud.gridy = 0;
//		panel.add(lblLatitud, gbc_lblLatitud);
//
//		textField = new JTextField();
//		textField.setEditable(false);
//		GridBagConstraints gbc_textField = new GridBagConstraints();
//		gbc_textField.insets = new Insets(0, 0, 5, 0);
//		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
//		gbc_textField.gridx = 1;
//		gbc_textField.gridy = 0;
//		panel.add(textField, gbc_textField);
//		textField.setColumns(10);
//
//		lblLongitud = new JLabel("Longitud:");
//		GridBagConstraints gbc_lblLongitud = new GridBagConstraints();
//		gbc_lblLongitud.anchor = GridBagConstraints.WEST;
//		gbc_lblLongitud.insets = new Insets(0, 0, 5, 5);
//		gbc_lblLongitud.gridx = 0;
//		gbc_lblLongitud.gridy = 1;
//		panel.add(lblLongitud, gbc_lblLongitud);
//
//		textField_1 = new JTextField();
//		textField_1.setEditable(false);
//		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
//		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
//		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
//		gbc_textField_1.gridx = 1;
//		gbc_textField_1.gridy = 1;
//		panel.add(textField_1, gbc_textField_1);
//		textField_1.setColumns(10);
//
//		lblCodigoPostal = new JLabel("Codigo postal:");
//		GridBagConstraints gbc_lblCodigoPostal = new GridBagConstraints();
//		gbc_lblCodigoPostal.anchor = GridBagConstraints.EAST;
//		gbc_lblCodigoPostal.insets = new Insets(0, 0, 5, 5);
//		gbc_lblCodigoPostal.gridx = 0;
//		gbc_lblCodigoPostal.gridy = 2;
//		panel.add(lblCodigoPostal, gbc_lblCodigoPostal);
//
//		textField_2 = new JTextField();
//		textField_2.setEditable(false);
//		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
//		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
//		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
//		gbc_textField_2.gridx = 1;
//		gbc_textField_2.gridy = 2;
//		panel.add(textField_2, gbc_textField_2);
//		textField_2.setColumns(10);
//
//		lblCiudad = new JLabel("Ciudad:");
//		GridBagConstraints gbc_lblCiudad = new GridBagConstraints();
//		gbc_lblCiudad.anchor = GridBagConstraints.WEST;
//		gbc_lblCiudad.insets = new Insets(0, 0, 0, 5);
//		gbc_lblCiudad.gridx = 0;
//		gbc_lblCiudad.gridy = 3;
//		panel.add(lblCiudad, gbc_lblCiudad);
//
//		textField_3 = new JTextField();
//		textField_3.setEditable(false);
//		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
//		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
//		gbc_textField_3.gridx = 1;
//		gbc_textField_3.gridy = 3;
//		panel.add(textField_3, gbc_textField_3);
//		textField_3.setColumns(10);
		actualizar();
	}

	public void actualizar()
	{
		this.revalidate();
		this.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		// TODO Auto-generated method stub
		String x = arg0.getActionCommand();
		if(x.equals("CAMBIO"))
		{
			principal.mostrarCambiar();;
		}
	}
}
