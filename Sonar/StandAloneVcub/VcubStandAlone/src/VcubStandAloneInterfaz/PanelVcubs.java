package VcubStandAloneInterfaz;

import javax.swing.JPanel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import VcubStandAloneMundo.Vcub;

public class PanelVcubs extends JPanel implements ListSelectionListener, ActionListener
{
	// -----------------------------------------------------------------
	// Atributos de la Interfaz
	// -----------------------------------------------------------------
	/**
	 * Es la lista donde se muestran las peliculas que cumplen con el parametro de busqueda
	 */
	private JList list;

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------
	/**
	 * Ventana principal de la aplicación
	 */
	private transient PanelPrincipal principal;

	// -----------------------------------------------------------------
	// Constructor
	// -----------------------------------------------------------------
	/**
	 * Create the panel.
	 */
	public PanelVcubs(PanelPrincipal ventana) 
	{
		principal = ventana;
		
		GridBagLayout gridBagLayoutVCS = new GridBagLayout();
		gridBagLayoutVCS.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayoutVCS.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayoutVCS.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayoutVCS.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayoutVCS);
		
		JPanel panelVCS = new JPanel();
		GridBagConstraints gbc_panelVCS = new GridBagConstraints();
		gbc_panelVCS.gridwidth = 5;
		gbc_panelVCS.gridheight = 9;
		gbc_panelVCS.insets = new Insets(0, 0, 5, 0);
		gbc_panelVCS.fill = GridBagConstraints.BOTH;
		gbc_panelVCS.gridx = 0;
		gbc_panelVCS.gridy = 0;
		add(panelVCS, gbc_panelVCS);
		
		JScrollPane scrollPaneVCS = new JScrollPane();
		scrollPaneVCS.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneVCS.setPreferredSize(new Dimension(230, 260));
		panelVCS.add(scrollPaneVCS);
		
		list = new JList();

		list.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
		list.addListSelectionListener( this );
		scrollPaneVCS.setViewportView(list);
		
		JLabel lblReservasVCS = new JLabel("Vcubs Disponibles");
		scrollPaneVCS.setColumnHeaderView(lblReservasVCS);
		
		JPanel panel_1VCS = new JPanel();
		GridBagConstraints gbc_panel_1VCS = new GridBagConstraints();
		gbc_panel_1VCS.gridwidth = 5;
		gbc_panel_1VCS.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1VCS.fill = GridBagConstraints.BOTH;
		gbc_panel_1VCS.gridx = 0;
		gbc_panel_1VCS.gridy = 9;
		add(panel_1VCS, gbc_panel_1VCS);
		GridBagLayout gbl_panel_1VCS = new GridBagLayout();
		gbl_panel_1VCS.columnWidths = new int[]{69, 0, 0, 0, 0, 0, 0};
		gbl_panel_1VCS.rowHeights = new int[]{23, 0};
		gbl_panel_1VCS.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1VCS.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1VCS.setLayout(gbl_panel_1VCS);
		
		JButton btnVoleverVCS = new JButton("Volver");
		btnVoleverVCS.setActionCommand("Volver");
		btnVoleverVCS.addActionListener(this);
		GridBagConstraints gbc_btnVoleverVCS = new GridBagConstraints();
		gbc_btnVoleverVCS.insets = new Insets(0, 0, 0, 5);
		gbc_btnVoleverVCS.gridx = 2;
		gbc_btnVoleverVCS.gridy = 0;
		panel_1VCS.add(btnVoleverVCS, gbc_btnVoleverVCS);
	}
	
	// -----------------------------------------------------------------
	// Metodos
	// -----------------------------------------------------------------
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		String x =arg0.getActionCommand();
		if("Volver".equals(x))
		{
			principal.mostrarBotones();
		}
	}

	/**
	 * Actualiza la lista con los elemtnos que llegan por parametro.
	 * @param elementos resultantes de una busqueda.
	 */
	public void actualizarLista(Vcub[] objects) 
	{
		list.setListData(objects);
	}

	/**
	 * Retorna el elemento seleccionado de la lista.
	 * @return elemento seleccionado.
	 */
	public Vcub darObjetoSeleccionado()
	{
		return (Vcub) list.getSelectedValue();
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}
}
