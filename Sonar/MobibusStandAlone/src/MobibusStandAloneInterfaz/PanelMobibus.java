package MobibusStandAloneInterfaz;

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



import MobibusStandAloneMundo.Mobibus;
import MobibusStandAloneMundo.Ubicacion;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JTextField;

public class PanelMobibus extends JPanel implements ListSelectionListener, ActionListener
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
	private PanelPrincipal principal;

	/**
	 * Lista de ubicaciones
	 */
	private JList list;

	/**
	 * label numero de ubicaciones
	 */
	private JLabel label;

	// -----------------------------------------------------------------
	// Constructor
	// -----------------------------------------------------------------	
	/**
	 * Create the panel.
	 */
	public PanelMobibus(PanelPrincipal ventana)
	{
		GridBagLayout gridBagLayoutM = new GridBagLayout();
		gridBagLayoutM.columnWidths = new int[]{0, 0, 0};
		gridBagLayoutM.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayoutM.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gridBagLayoutM.rowWeights = new double[]{1.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayoutM);
				
				JPanel panel_2M = new JPanel();
				GridBagConstraints gbc_panel_2M = new GridBagConstraints();
				gbc_panel_2M.gridwidth = 2;
				gbc_panel_2M.insets = new Insets(0, 0, 5, 0);
				gbc_panel_2M.fill = GridBagConstraints.BOTH;
				gbc_panel_2M.gridx = 0;
				gbc_panel_2M.gridy = 1;
				add(panel_2M, gbc_panel_2M);
				GridBagLayout gbl_panel_2M = new GridBagLayout();
				gbl_panel_2M.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
				gbl_panel_2M.rowHeights = new int[]{0, 0};
				gbl_panel_2M.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
				gbl_panel_2M.rowWeights = new double[]{0.0, Double.MIN_VALUE};
				panel_2M.setLayout(gbl_panel_2M);
		
				JPanel panelM = new JPanel();
				GridBagConstraints gbc_panelM = new GridBagConstraints();
				gbc_panelM.gridheight = 3;
				gbc_panelM.gridwidth = 2;
				gbc_panelM.insets = new Insets(0, 0, 5, 0);
				gbc_panelM.fill = GridBagConstraints.BOTH;
				gbc_panelM.gridx = 0;
				gbc_panelM.gridy = 2;
				add(panelM, gbc_panelM);
				
						JScrollPane scrollPaneM = new JScrollPane();
						scrollPaneM.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
						scrollPaneM.setPreferredSize(new Dimension(200, 100));
						panelM.add(scrollPaneM);
						
								list = new JList();
								scrollPaneM.setViewportView(list);
								
								JPanel panel_1M = new JPanel();
								GridBagConstraints gbc_panel_1M = new GridBagConstraints();
								gbc_panel_1M.insets = new Insets(0, 0, 5, 0);
								gbc_panel_1M.gridwidth = 2;
								gbc_panel_1M.fill = GridBagConstraints.BOTH;
								gbc_panel_1M.gridx = 0;
								gbc_panel_1M.gridy = 5;
								add(panel_1M, gbc_panel_1M);
								panel_1M.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

								JButton btnVerEnMapaM = new JButton("Ver en mapa");
								GridBagConstraints gbc_btnReservarM = new GridBagConstraints();
								gbc_btnReservarM.insets = new Insets(0, 0, 0, 5);
								gbc_btnReservarM.anchor = GridBagConstraints.NORTHEAST;
								gbc_btnReservarM.gridx = 0;
								gbc_btnReservarM.gridy = 5;
								panel_1M.add(btnVerEnMapaM, gbc_btnReservarM);
								btnVerEnMapaM.setActionCommand(MAPA);
								btnVerEnMapaM.addActionListener(this);
								panel_1M.add(btnVerEnMapaM);

								JButton btnCambiarEstadoM = new JButton("Cambiar estado");
								GridBagConstraints gbc_btnM = new GridBagConstraints();
								gbc_btnM.insets = new Insets(0, 0, 0, 5);
								gbc_btnM.anchor = GridBagConstraints.NORTHEAST;
								gbc_btnM.gridx = 2;
								gbc_btnM.gridy = 5;
								panel_1M.add(btnCambiarEstadoM, gbc_btnM);
								btnCambiarEstadoM.setActionCommand("ESTADO");
								btnCambiarEstadoM.addActionListener(this);
								panel_1M.add(btnVerEnMapaM);

		

		label = new JLabel("");
		label.setBorder(new LineBorder(new Color(0, 0, 0)));
		label.setPreferredSize(new Dimension(200, 200));
		GridBagConstraints gbc_labelM = new GridBagConstraints();
		gbc_labelM.insets = new Insets(0, 0, 5, 0);
		gbc_labelM.gridwidth = 2;
		gbc_labelM.gridheight = 6;
		gbc_labelM.gridx = 0;
		gbc_labelM.gridy = 6;
		add(label, gbc_labelM);

		JButton btnVolverAlMenuM = new JButton("Volver al menu principal");
		btnVolverAlMenuM.setActionCommand(MENU);
		btnVolverAlMenuM.addActionListener(this);
		GridBagConstraints gbc_btnVolverAlMenuM = new GridBagConstraints();
		gbc_btnVolverAlMenuM.gridwidth = 2;
		gbc_btnVolverAlMenuM.gridx = 0;
		gbc_btnVolverAlMenuM.gridy = 12;
		add(btnVolverAlMenuM, gbc_btnVolverAlMenuM);
		principal = ventana;

	}

	// -----------------------------------------------------------------
	// Metodos
	// -----------------------------------------------------------------
	/**
	 * Actualiza la lista con los elemtnos que llegan por parametro.
	 * @param elementos resultantes de una busqueda.
	 */
	public void actualizarLista(Mobibus[] z) 
	{
		list.setListData(z);
	}

	/**
	 * Retorna el elemento seleccionado de la lista.
	 * @return elemento seleccionado.
	 */
	public Mobibus darSeleccionado()
	{
		return (Mobibus) list.getSelectedValue();
	}

	/**
	 * Metodo que actualiza el panel
	 */
	public void actualizar()
	{
		URL zzM = null;
		if(darSeleccionado()!=null)
		{
			
			try
			{
				zzM = new URL(principal.generarMapa(darSeleccionado().getUbicacion()));
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(zzM!=null)
		{
			ImageIcon iconoM = new ImageIcon(zzM);
			label.setIcon(iconoM);
		}
	}
	/**
	 * Método para manejar los eventos asociados con el cambio de la lista
	 * @param e El evento con la información del nuevo elemento seleccionado
	 */
	@Override
	public void valueChanged(ListSelectionEvent arg10) 
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		// TODO Auto-generated method stub
		String y = arg0.getActionCommand();
		if(y.equals(MAPA))
		{
			actualizar();
		}
		else if(y.equals(MENU))
		{
			principal.mostrarBotones2();
		}
		else if("ESTADO".equals(y))
		{
			principal.cambiarEstadoMobi(darSeleccionado());
		}
	}
}
