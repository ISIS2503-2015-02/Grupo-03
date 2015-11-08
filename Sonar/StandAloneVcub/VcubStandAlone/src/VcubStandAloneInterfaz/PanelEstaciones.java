package VcubStandAloneInterfaz;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JScrollPane;

import java.awt.Dimension;

import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import VcubStandAloneMundo.EstacionVcub;
import VcubStandAloneMundo.Ubicacion;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

import javax.swing.JTextField;

public class PanelEstaciones extends JPanel implements ListSelectionListener, ActionListener
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
	public PanelEstaciones(PanelPrincipal ventana)
	{
		GridBagLayout gridBagLayoutEV = new GridBagLayout();
		gridBagLayoutEV.columnWidths = new int[]{0, 0, 0};
		gridBagLayoutEV.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayoutEV.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gridBagLayoutEV.rowWeights = new double[]{1.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayoutEV);
				
				JPanel panel_2EV = new JPanel();
				GridBagConstraints gbc_panel_2EV = new GridBagConstraints();
				gbc_panel_2EV.gridwidth = 2;
				gbc_panel_2EV.insets = new Insets(0, 0, 5, 0);
				gbc_panel_2EV.fill = GridBagConstraints.BOTH;
				gbc_panel_2EV.gridx = 0;
				gbc_panel_2EV.gridy = 1;
				add(panel_2EV, gbc_panel_2EV);
				GridBagLayout gbl_panel_2EV = new GridBagLayout();
				gbl_panel_2EV.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
				gbl_panel_2EV.rowHeights = new int[]{0, 0};
				gbl_panel_2EV.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
				gbl_panel_2EV.rowWeights = new double[]{0.0, Double.MIN_VALUE};
				panel_2EV.setLayout(gbl_panel_2EV);
		
				JPanel panelEV = new JPanel();
				GridBagConstraints gbc_panelEV = new GridBagConstraints();
				gbc_panelEV.gridheight = 3;
				gbc_panelEV.gridwidth = 2;
				gbc_panelEV.insets = new Insets(0, 0, 5, 0);
				gbc_panelEV.fill = GridBagConstraints.BOTH;
				gbc_panelEV.gridx = 0;
				gbc_panelEV.gridy = 2;
				add(panelEV, gbc_panelEV);
				
						JScrollPane scrollPaneEV = new JScrollPane();
						scrollPaneEV.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
						scrollPaneEV.setPreferredSize(new Dimension(200, 100));
						panelEV.add(scrollPaneEV);
						
								list = new JList();
								scrollPaneEV.setViewportView(list);
								
								JPanel panel_1EV = new JPanel();
								GridBagConstraints gbc_panel_1EV = new GridBagConstraints();
								gbc_panel_1EV.insets = new Insets(0, 0, 5, 0);
								gbc_panel_1EV.gridwidth = 2;
								gbc_panel_1EV.fill = GridBagConstraints.BOTH;
								gbc_panel_1EV.gridx = 0;
								gbc_panel_1EV.gridy = 5;
								add(panel_1EV, gbc_panel_1EV);
								panel_1EV.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

								JButton btnVerEnMapaEV = new JButton("Ver en mapa");
								GridBagConstraints gbc_btnReservarEV = new GridBagConstraints();
								gbc_btnReservarEV.insets = new Insets(0, 0, 0, 5);
								gbc_btnReservarEV.anchor = GridBagConstraints.NORTHEAST;
								gbc_btnReservarEV.gridx = 0;
								gbc_btnReservarEV.gridy = 5;
								panel_1EV.add(btnVerEnMapaEV, gbc_btnReservarEV);
								btnVerEnMapaEV.setActionCommand(MAPA);
								btnVerEnMapaEV.addActionListener(this);
								panel_1EV.add(btnVerEnMapaEV);

								JButton btnVerInfoEV = new JButton("Ver info");
								GridBagConstraints gbc_btnEV = new GridBagConstraints();
								gbc_btnEV.insets = new Insets(0, 0, 0, 5);
								gbc_btnEV.anchor = GridBagConstraints.NORTHEAST;
								gbc_btnEV.gridx = 2;
								gbc_btnEV.gridy = 5;
								panel_1EV.add(btnVerInfoEV, gbc_btnEV);
								btnVerInfoEV.setActionCommand("INFO");
								btnVerInfoEV.addActionListener(this);
								panel_1EV.add(btnVerEnMapaEV);

		

		label = new JLabel("");
		label.setBorder(new LineBorder(new Color(0, 0, 0)));
		label.setPreferredSize(new Dimension(200, 200));
		GridBagConstraints gbc_labelEV = new GridBagConstraints();
		gbc_labelEV.insets = new Insets(0, 0, 5, 0);
		gbc_labelEV.gridwidth = 2;
		gbc_labelEV.gridheight = 6;
		gbc_labelEV.gridx = 0;
		gbc_labelEV.gridy = 6;
		add(label, gbc_labelEV);

		JButton btnVolverAlMenuEV = new JButton("Volver al menu principal");
		btnVolverAlMenuEV.setActionCommand(MENU);
		btnVolverAlMenuEV.addActionListener(this);
		GridBagConstraints gbc_btnVolverAlMenuEV = new GridBagConstraints();
		gbc_btnVolverAlMenuEV.gridwidth = 2;
		gbc_btnVolverAlMenuEV.gridx = 0;
		gbc_btnVolverAlMenuEV.gridy = 12;
		add(btnVolverAlMenuEV, gbc_btnVolverAlMenuEV);
		principal = ventana;

	}

	// -----------------------------------------------------------------
	// Metodos
	// -----------------------------------------------------------------
	/**
	 * Actualiza la lista con los elemtnos que llegan por parametro.
	 * @param elementos resultantes de una busqueda.
	 */
	public void actualizarLista(EstacionVcub[] z) 
	{
		list.setListData(z);
	}

	/**
	 * Retorna el elemento seleccionado de la lista.
	 * @return elemento seleccionado.
	 */
	public EstacionVcub darSeleccionado()
	{
		return (EstacionVcub) list.getSelectedValue();
	}

	/**
	 * Metodo que actualiza el panel
	 */
	public void actualizar()
	{
		URL zzEV = null;
		if(darSeleccionado()!=null)
		{
			
			try
			{
				zzEV = new URL(principal.generarMapa(darSeleccionado().getUbicacion()));
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				LOGGER.log(null, "context", e);
			}
		}
		if(zzEV!=null)
		{
			ImageIcon iconoEV = new ImageIcon(zzEV);
			label.setIcon(iconoEV);
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
			principal.mostrarBotones2();
		}
		else if("INFO".equals(x))
		{
			principal.mostrarInfo(darSeleccionado());
		}
	}
}
