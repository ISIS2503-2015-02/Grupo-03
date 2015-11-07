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
	
	/**
	 * textfield numero de ubicaciones
	 */
	private JTextField textField;

	// -----------------------------------------------------------------
	// Constructor
	// -----------------------------------------------------------------	
	/**
	 * Create the panel.
	 */
	public PanelMobibus(PanelPrincipal ventana)
	{
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
				
				JPanel panel_2 = new JPanel();
				GridBagConstraints gbc_panel_2 = new GridBagConstraints();
				gbc_panel_2.gridwidth = 2;
				gbc_panel_2.insets = new Insets(0, 0, 5, 0);
				gbc_panel_2.fill = GridBagConstraints.BOTH;
				gbc_panel_2.gridx = 0;
				gbc_panel_2.gridy = 1;
				add(panel_2, gbc_panel_2);
				GridBagLayout gbl_panel_2 = new GridBagLayout();
				gbl_panel_2.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
				gbl_panel_2.rowHeights = new int[]{0, 0};
				gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
				gbl_panel_2.rowWeights = new double[]{0.0, Double.MIN_VALUE};
				panel_2.setLayout(gbl_panel_2);
		
				JPanel panel = new JPanel();
				GridBagConstraints gbc_panel = new GridBagConstraints();
				gbc_panel.gridheight = 3;
				gbc_panel.gridwidth = 2;
				gbc_panel.insets = new Insets(0, 0, 5, 0);
				gbc_panel.fill = GridBagConstraints.BOTH;
				gbc_panel.gridx = 0;
				gbc_panel.gridy = 2;
				add(panel, gbc_panel);
				
						JScrollPane scrollPane = new JScrollPane();
						scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
						scrollPane.setPreferredSize(new Dimension(200, 100));
						panel.add(scrollPane);
						
								list = new JList();
								scrollPane.setViewportView(list);
								
								JPanel panel_1 = new JPanel();
								GridBagConstraints gbc_panel_1 = new GridBagConstraints();
								gbc_panel_1.insets = new Insets(0, 0, 5, 0);
								gbc_panel_1.gridwidth = 2;
								gbc_panel_1.fill = GridBagConstraints.BOTH;
								gbc_panel_1.gridx = 0;
								gbc_panel_1.gridy = 5;
								add(panel_1, gbc_panel_1);
								panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

								JButton btnVerEnMapa = new JButton("Ver en mapa");
								GridBagConstraints gbc_btnReservar = new GridBagConstraints();
								gbc_btnReservar.insets = new Insets(0, 0, 0, 5);
								gbc_btnReservar.anchor = GridBagConstraints.NORTHEAST;
								gbc_btnReservar.gridx = 0;
								gbc_btnReservar.gridy = 5;
								panel_1.add(btnVerEnMapa, gbc_btnReservar);
								btnVerEnMapa.setActionCommand(MAPA);
								btnVerEnMapa.addActionListener(this);
								panel_1.add(btnVerEnMapa);

								JButton btnCambiarEstado = new JButton("Cambiar estado");
								GridBagConstraints gbc_btn = new GridBagConstraints();
								gbc_btn.insets = new Insets(0, 0, 0, 5);
								gbc_btn.anchor = GridBagConstraints.NORTHEAST;
								gbc_btn.gridx = 2;
								gbc_btn.gridy = 5;
								panel_1.add(btnCambiarEstado, gbc_btn);
								btnCambiarEstado.setActionCommand("ESTADO");
								btnCambiarEstado.addActionListener(this);
								panel_1.add(btnVerEnMapa);

		

		label = new JLabel("");
		label.setBorder(new LineBorder(new Color(0, 0, 0)));
		label.setPreferredSize(new Dimension(200, 200));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.gridwidth = 2;
		gbc_label.gridheight = 6;
		gbc_label.gridx = 0;
		gbc_label.gridy = 6;
		add(label, gbc_label);

		JButton btnVolverAlMenu = new JButton("Volver al menu principal");
		btnVolverAlMenu.setActionCommand(MENU);
		btnVolverAlMenu.addActionListener(this);
		GridBagConstraints gbc_btnVolverAlMenu = new GridBagConstraints();
		gbc_btnVolverAlMenu.gridwidth = 2;
		gbc_btnVolverAlMenu.gridx = 0;
		gbc_btnVolverAlMenu.gridy = 12;
		add(btnVolverAlMenu, gbc_btnVolverAlMenu);
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
		URL zz = null;
		if(darSeleccionado()!=null)
		{
			
			try
			{
				zz = new URL(principal.generarMapa(darSeleccionado().getUbicacion()));
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
		else if(x.equals("ESTADO"))
		{
			principal.cambiarEstadoMobi(darSeleccionado());
		}
	}
}
