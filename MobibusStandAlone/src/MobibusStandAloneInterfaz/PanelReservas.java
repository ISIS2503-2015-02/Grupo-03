package MobibusStandAloneInterfaz;

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

import MobibusStandAloneMundo.Mobibus;

public class PanelReservas extends JPanel implements ListSelectionListener, ActionListener
{
	// -----------------------------------------------------------------
	// Atributos de la Interfaz
	// -----------------------------------------------------------------
	/**
	 * Es la lista donde se muestran las peliculas que cumplen con el parametro de busqueda
	 */
	private JList list;

	/**
	 * Es el boton que carga el elemento seleccionado en la interfaz. 
	 */
	private JButton aceptb ;

	// -----------------------------------------------------------------
	// Atributos
	// -----------------------------------------------------------------
	/**
	 * Ventana principal de la aplicación
	 */
	private PanelPrincipal principal;

	// -----------------------------------------------------------------
	// Constructor
	// -----------------------------------------------------------------
	/**
	 * Create the panel.
	 */
	public PanelReservas(PanelPrincipal ventana) 
	{
		principal = ventana;
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 5;
		gbc_panel.gridheight = 9;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setPreferredSize(new Dimension(230, 260));
		panel.add(scrollPane);
		
		list = new JList();

		list.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
		list.addListSelectionListener( this );
		scrollPane.setViewportView(list);
		
		JLabel lblReservas = new JLabel("Mobibus Disponibles");
		scrollPane.setColumnHeaderView(lblReservas);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridwidth = 5;
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 9;
		add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{69, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{23, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JButton btnVolever = new JButton("Volver");
		btnVolever.setActionCommand("Volver");
		btnVolever.addActionListener(this);
		GridBagConstraints gbc_btnVolever = new GridBagConstraints();
		gbc_btnVolever.insets = new Insets(0, 0, 0, 5);
		gbc_btnVolever.gridx = 2;
		gbc_btnVolever.gridy = 0;
		
		JButton btnGenerarReserva = new JButton("Generar reserva");
		btnGenerarReserva.setActionCommand("CAMBIO1");
		btnGenerarReserva.addActionListener(this);
		panel_1.add(btnGenerarReserva);
		panel_1.add(btnVolever, gbc_btnVolever);
	}
	
	// -----------------------------------------------------------------
	// Metodos
	// -----------------------------------------------------------------
	public void actionPerformed(ActionEvent arg0) 
	{
		String x =arg0.getActionCommand();
		if(x.equals("Volver"))
		{
			principal.mostrarBotones();
		}
		else if (x.equals("CAMBIO 1"))
		{
			
		}
	}

	/**
	 * Actualiza la lista con los elemtnos que llegan por parametro.
	 * @param elementos resultantes de una busqueda.
	 */
	public void actualizarLista(Mobibus[] objects) 
	{
		list.setListData(objects);
	}

	/**
	 * Retorna el elemento seleccionado de la lista.
	 * @return elemento seleccionado.
	 */
	public Mobibus darObjetoSeleccionado()
	{
		return (Mobibus) list.getSelectedValue();
	}

	@Override
	public void valueChanged(ListSelectionEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}
}
