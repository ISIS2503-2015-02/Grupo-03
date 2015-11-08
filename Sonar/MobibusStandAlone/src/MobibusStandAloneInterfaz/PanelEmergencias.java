package MobibusStandAloneInterfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import MobibusStandAloneMundo.Emergencia;
import MobibusStandAloneMundo.Mobibus;

public class PanelEmergencias extends JPanel implements ListSelectionListener, ActionListener
{
	// -----------------------------------------------------------------
	// Constantes
	// -----------------------------------------------------------------
	/**
	 * Comando MAPA
	 */
	public final static String MAPA = "MAPA";

	/**
	 * Comando MENU
	 */
	public final static String MENU = "MENU";

	/**
	 * Comando VER
	 */
	public final static String VER = "VER";

	// -----------------------------------------------------------------
	// Atributos de la Interfaz
	// -----------------------------------------------------------------	
	/**
	 * Panel principal de la aplicación
	 */
	private transient PanelPrincipal principal;

	/**
	 * Lista de ubicaciones
	 */
	private JList list;

	/**
	 * label numero de ubicaciones
	 */
	private JLabel label;
	
	private transient Logger LOGGER;

	// -----------------------------------------------------------------
	// Constructor
	// -----------------------------------------------------------------	
	/**
	 * Create the panel.
	 */
	public PanelEmergencias(PanelPrincipal ventana)
	{
		GridBagLayout gridBagLayoutE = new GridBagLayout();
		gridBagLayoutE.columnWidths = new int[]{0, 0, 0};
		gridBagLayoutE.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayoutE.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gridBagLayoutE.rowWeights = new double[]{1.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayoutE);

		JPanel panel_2E = new JPanel();
		GridBagConstraints gbc_panel_2E = new GridBagConstraints();
		gbc_panel_2E.gridwidth = 2;
		gbc_panel_2E.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2E.fill = GridBagConstraints.BOTH;
		gbc_panel_2E.gridx = 0;
		gbc_panel_2E.gridy = 1;
		add(panel_2E, gbc_panel_2E);
		GridBagLayout gbl_panel_2E = new GridBagLayout();
		gbl_panel_2E.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_2E.rowHeights = new int[]{0, 0};
		gbl_panel_2E.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2E.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_2E.setLayout(gbl_panel_2E);

		JPanel panelE = new JPanel();
		GridBagConstraints gbc_panelE = new GridBagConstraints();
		gbc_panelE.gridheight = 3;
		gbc_panelE.gridwidth = 2;
		gbc_panelE.insets = new Insets(0, 0, 5, 0);
		gbc_panelE.fill = GridBagConstraints.BOTH;
		gbc_panelE.gridx = 0;
		gbc_panelE.gridy = 2;
		add(panelE, gbc_panelE);

		JScrollPane scrollPaneE = new JScrollPane();
		scrollPaneE.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneE.setPreferredSize(new Dimension(200, 100));
		panelE.add(scrollPaneE);

		list = new JList();
		scrollPaneE.setViewportView(list);

		JPanel panel_1E = new JPanel();
		GridBagConstraints gbc_panel_1E = new GridBagConstraints();
		gbc_panel_1E.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1E.gridwidth = 2;
		gbc_panel_1E.fill = GridBagConstraints.BOTH;
		gbc_panel_1E.gridx = 0;
		gbc_panel_1E.gridy = 5;
		add(panel_1E, gbc_panel_1E);
		panel_1E.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnVerEnMapaE = new JButton("Ver en mapa");
		GridBagConstraints gbc_btnReservarE = new GridBagConstraints();
		gbc_btnReservarE.insets = new Insets(0, 0, 0, 5);
		gbc_btnReservarE.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnReservarE.gridx = 0;
		gbc_btnReservarE.gridy = 5;
		panel_1E.add(btnVerEnMapaE, gbc_btnReservarE);
		btnVerEnMapaE.setActionCommand(MAPA);
		btnVerEnMapaE.addActionListener(this);
		panel_1E.add(btnVerEnMapaE);

		JButton btnCambiarEstadoE = new JButton("Ver Mobibus Cercano");
		GridBagConstraints gbc_btnE = new GridBagConstraints();
		gbc_btnE.insets = new Insets(0, 0, 0, 5);
		gbc_btnE.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnE.gridx = 2;
		gbc_btnE.gridy = 5;
		panel_1E.add(btnCambiarEstadoE, gbc_btnE);
		btnCambiarEstadoE.setActionCommand("CERCA");
		btnCambiarEstadoE.addActionListener(this);
		panel_1E.add(btnVerEnMapaE);



		label = new JLabel("");
		label.setBorder(new LineBorder(new Color(0, 0, 0)));
		label.setPreferredSize(new Dimension(200, 200));
		GridBagConstraints gbc_labelE = new GridBagConstraints();
		gbc_labelE.insets = new Insets(0, 0, 5, 0);
		gbc_labelE.gridwidth = 2;
		gbc_labelE.gridheight = 6;
		gbc_labelE.gridx = 0;
		gbc_labelE.gridy = 6;
		add(label, gbc_labelE);

		JButton btnVolverAlMenuE = new JButton("Volver al menu principal");
		btnVolverAlMenuE.setActionCommand(MENU);
		btnVolverAlMenuE.addActionListener(this);
		GridBagConstraints gbc_btnVolverAlMenuE = new GridBagConstraints();
		gbc_btnVolverAlMenuE.gridwidth = 2;
		gbc_btnVolverAlMenuE.gridx = 0;
		gbc_btnVolverAlMenuE.gridy = 12;
		add(btnVolverAlMenuE, gbc_btnVolverAlMenuE);
		principal = ventana;

	}

	// -----------------------------------------------------------------
	// Metodos
	// -----------------------------------------------------------------
	/**
	 * Actualiza la lista con los elemtnos que llegan por parametro.
	 * @param elementos resultantes de una busqueda.
	 */
	public void actualizarLista(Emergencia[] z) 
	{
		list.setListData(z);
	}

	/**
	 * Retorna el elemento seleccionado de la lista.
	 * @return elemento seleccionado.
	 */
	public Emergencia darSeleccionado()
	{
		return (Emergencia) list.getSelectedValue();
	}

	/**
	 * Metodo que actualiza el panel
	 */
	public void actualizar()
	{
		URL zz = null;
		if(darSeleccionado()!=null)
		{

			try
			{
				zz = new URL(principal.generarMapa(darSeleccionado().darUbicacion()));
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				LOGGER.log(null, "context", e);
			}
		}
		if(zz!=null)
		{
			ImageIcon icono = new ImageIcon(zz);
			label.setIcon(icono);
		}
	}
	/**
	 * Método para manejar los eventos asociados con el cambio de la lista
	 * @param e El evento con la información del nuevo elemento seleccionado
	 */
	@Override
	public void valueChanged(ListSelectionEvent arg0) 
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		// TODO Auto-generated method stub
		String x = arg0.getActionCommand();
		if(x.equals(MAPA))
		{
			actualizar();
		}
		else if(x.equals(MENU))
		{
			principal.mostrarBotones3();
		}
		else if("CERCA".equals(x))
		{
			principal.mostrarInfo(darSeleccionado());
		}
	}
}
